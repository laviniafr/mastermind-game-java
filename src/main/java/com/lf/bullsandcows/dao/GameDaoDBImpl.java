package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class GameDaoDBImpl extends EntityDaoHelpers implements GameDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
//	private final JdbcTemplate jdbcTemplate;

//	@Autowired
//	public GameDaoDBImpl(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public List<Game> getAllGames() {
		final String query = "SELECT * FROM game WHERE progress='COMPLETE'";
		return jdbcTemplate.query(query, new GameMapper());
	}

	@Override
	public List<Round> getRounds(int gameId) {
		final String query = "SELECT ro.* FROM round ro" +
				" JOIN game g ON (ro.gameId = g.id) WHERE g.id = ?";
		return jdbcTemplate.query(query, new RoundMapper(), gameId);
	}

//	@Override
//	public Game newGame(List<Integer> answer, Status status) {
//		Game game = new Game();
//		game.setAnswer(arrToInt(answer));
//		game.setStatus(Status.IN_PROGRESS);
//		return game;
//	}

	@Override
	public Game newGame(List<Integer> generatedAnswer, Game game) {
		final String query = "INSERT INTO game(progress, answer) VALUES(?,?);";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = connection.prepareStatement(
					query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, Status.IN_PROGRESS.name());
			preparedStatement.setInt(2, EntityDaoHelpers.arrToInt(generatedAnswer));
			return preparedStatement;
		}, keyHolder);
		game.setId(keyHolder.getKey().intValue());
		return game;
	}

	@Override
	public void completeGame(Game game) {
		final String query = "UPDATE game SET " +
				"progress = ?, " +
				"elapsedTime = ? " +
				"WHERE id = ?;";
		jdbcTemplate.update(query,
				game.getStatus().name(),
				game.getElapsedTime(),
				game.getId());
	}


//	@Override
//	public Game addGame(Game game) {
//		final String query = "INSERT INTO game(progress, elapsedTime, answer) VALUES(?,?,?);";
//		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//
//		jdbcTemplate.update((Connection connection) -> {
//			PreparedStatement preparedStatement = connection.prepareStatement(
//					query,
//					Statement.RETURN_GENERATED_KEYS
//			);
//			preparedStatement.setString(1, game.getStatus().name());
//			preparedStatement.setString(2, game.getElapsedTime());
//			preparedStatement.setInt(3, game.getAnswer());
//			return preparedStatement;
//		}, keyHolder);
//		return game;
//	}

	@Override
	public Game getGameById(int id) {
		final String query = "SELECT * FROM game WHERE id=? AND progress='COMPLETE'";
		return jdbcTemplate.queryForObject(query, new GameMapper(), id);
	}

//	@Override
//	public List<Integer> generateAnswer() {
//		return null;
//	}

//	@Override
//	public void updateStatus(Status status, int gameId) {
//
//	}
//
//	@Override
//	public void updateElapsedTime(Instant startTime, Instant endTime, int gameId) {
//
//	}


}
