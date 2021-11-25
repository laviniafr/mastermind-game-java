package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store helper methods to be shared by different daos.
 */
public class EntityDaoHelpers {

	/**
	 * The type Game mapper.
	 */
	public class GameMapper implements RowMapper<Game> {

		@Override
		public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
			Game game = new Game();
			game.setId(rs.getInt("id"));
			game.setStatus(Status.valueOf(rs.getString("progress")));
			game.setAnswer(rs.getInt("answer"));
			return game;
		}
	}

	/**
	 * The type Round mapper.
	 */
	public class RoundMapper implements RowMapper<Round> {

		@Override
		public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
			Round round = new Round();
			round.setRoundId(rs.getInt("id"));
			round.setGuess(rs.getInt("answer"));
			round.setPartial(rs.getInt("partialMatches"));
			round.setExact(rs.getInt("exactMatches"));
			round.setGameId(rs.getInt("gameId"));
			return round;
		}
	}

	/**
	 * Method to turn an array into an integer.
	 *
	 * @param arr - The array.
	 * @return - The resulting integer.
	 */
	public static int arrToInt(List<Integer> arr) {
		int number = 0;
		int counter = 1;
		for (int i = arr.size() - 1; i >= 0; i--) {
			number += arr.get(i) * counter;
			counter *= 10;
		}
		return number;
	}

	/**
	 * Method to turn an integer into a list of digits.
	 *
	 * @param number - The integer to be turned into a list.
	 * @return - The list of digits.
	 */
	public static List<Integer> intToArr(int number) {
		List<Integer> digits = new ArrayList<>();
		int aux = 1000;
		while (aux > 0) {
			digits.add(number / aux % 10);
			aux /= 10;
		}
		return digits;
	}
}
