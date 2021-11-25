package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * The database implementation of the RoundDao interface.
 */
@Repository
public class RoundDaoDBImpl extends EntityDaoHelpers implements RoundDao{

	/**
	 * The Jdbc template.
	 */
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * Adds a new round with the answer and gameId to the database, as well as an auto-incremented round id.
	 * @param round - The round.
	 * @return
	 */
	@Override
	public Round addRound(Round round) {
		final String query = "INSERT INTO round(answer, gameId) VALUES (?,?);";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update((Connection connection) ->{
			PreparedStatement preparedStatement = connection.prepareStatement(
					query,
					Statement.RETURN_GENERATED_KEYS	);
			preparedStatement.setInt(1, round.getGuess());
			preparedStatement.setInt(2, round.getGameId());
			return preparedStatement;
		},keyHolder);

		round.setRoundId(keyHolder.getKey().intValue());
		return round;
	}


	/**
	 * Updates the partial and exact matches of a round.
	 * @param round The updated Round object.
	 */
	@Override
	public void updateSolutions(Round round) {
		final String query = "UPDATE round SET " +
				"partialMatches = ?, " +
				"exactMatches = ? " +
				"WHERE id = ?;";
		jdbcTemplate.update(query,
				round.getPartial(),
				round.getExact(),
				round.getRoundId());
	}
}
