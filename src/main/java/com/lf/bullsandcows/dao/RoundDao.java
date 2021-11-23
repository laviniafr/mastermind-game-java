package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Round;

import java.util.List;

public interface RoundDao {

	/**
	 * Method to get the list of guesses based on a round id.
	 *
	 * @param roundId
	 * @return
	 */
	Round addGuess(Round round);

	/**
	 * Method to return a Round object by its id.
	 *
	 * @param roundId
	 * @return
	 */
	Round getRoundById(int roundId);

	/**
	 * Method to update the number of partial and exact guesses.
	 *
	 * @param partialGuesses
	 * @param exactGuesses
	 */
	void updateSolutions(Round round);

}
