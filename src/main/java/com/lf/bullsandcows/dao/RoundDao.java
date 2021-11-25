package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Round;

/**
 * The interface Round dao.
 */
public interface RoundDao {


	/**
	 * Method to add a new round.
	 *
	 * @param round - The round.
	 * @return - The round.
	 */
	Round addRound(Round round);

	/**
	 * Method to update the number of partial and exact guesses of a round.
	 *
	 * @param round The updated Round object.
	 */
	void updateSolutions(Round round);

}
