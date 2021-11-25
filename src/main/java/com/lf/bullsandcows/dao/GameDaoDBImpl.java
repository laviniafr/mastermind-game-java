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

import static com.lf.bullsandcows.entity.Status.COMPLETE;

/**
 * The database implementation of the GameDao interface.
 */
@Repository
public class GameDaoDBImpl extends EntityDaoHelpers implements GameDao {

	/**
	 * The Jdbc template.
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Game> getAllGames() {
		final String query = "SELECT * FROM game WHERE progress='COMPLETE';";
		return jdbcTemplate.query(query, new GameMapper());
	}

	@Override
	public List<Round> getRounds(int gameId) {
		final String query = "SELECT ro.* FROM round ro" +
				" JOIN game g ON (ro.gameId = g.id) WHERE g.id = ?";
		return jdbcTemplate.query(query, new RoundMapper(), gameId);
	}


	@Override
	public Game newGame(List<Integer> generatedAnswer, Game game) {
		final String query = "INSERT INTO game(progress, answer) VALUES(?,?);";
		/**
		 * Using a generated keyholder to store and retrieve auto incremented ids.
		 */
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((Connection connection) -> {
			PreparedStatement preparedStatement = connection.prepareStatement(
					query,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, Status.IN_PROGRESS.name());
			preparedStatement.setInt(2, arrToInt(generatedAnswer));
			return preparedStatement;
		}, keyHolder);
		game.setId(keyHolder.getKey().intValue());
		return game;
	}


	@Override
	public void completeGame(Game game) {
		final String query = "UPDATE game SET " +
				"progress = ? " +
				"WHERE id = ?;";
		jdbcTemplate.update(query,
				COMPLETE.name(),
				game.getId());
	}

	@Override
	public Game getGameById(int id) {
		final String query = "SELECT * FROM game WHERE id=?;";
		return jdbcTemplate.queryForObject(query, new GameMapper(), id);
	}


}
