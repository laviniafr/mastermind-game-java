package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Round;

import java.util.List;

public class RoundDaoDBImpl implements RoundDao{
	@Override
	public List<Integer> getRoundGuesses(int roundId) {
		return null;
	}

	@Override
	public Round getRoundById(int roundId) {
		return null;
	}

	@Override
	public void updateRoundGuesses(List<Integer> guesses) {

	}

	@Override
	public void updateSolutions(int partialGuesses, int exactGuesses) {

	}

}
