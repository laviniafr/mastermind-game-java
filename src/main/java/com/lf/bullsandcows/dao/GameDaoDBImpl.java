package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;
import com.lf.bullsandcows.service.UnknownStatusError;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GameDaoDBImpl implements GameDao {

	private static final List<Game> games = new ArrayList<>();

	@Override
	public List<Round> getRounds(int gameId) {
		return games.get(gameId).getRounds();
	}

	@Override
	public Game addGame(Game game) {
		games.add(game);
		return game;
	}

	@Override
	public Game getGameById(int id) {
		return games.get(id);
	}

	@Override
	public List<Integer> generateAnswer() {
		List<Integer> randomNums = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			int randomNumber = (int) (Math.random() * 9) + 1;
			if (randomNums.contains(randomNumber)) {
				while (randomNums.contains(randomNumber)) {
					randomNumber = (int) (Math.random() * 9) + 1;
				}
			}
			randomNums.add(randomNumber);
		}
		return randomNums;
	}

	@Override
	public void updateStatus(Status status, int gameId) {
		switch (status) {
			case IN_PROGRESS -> games.get(gameId).setInProgress(true);
			case COMPLETE -> games.get(gameId).setInProgress(false);
			default -> throw new UnknownStatusError("Game status is unknown.");
		}
	}

	@Override
	public void updateElapsedTime(Instant startTime, Instant endTime, int gameId) {
		games.get(gameId).setElapsedTime(startTime, endTime);
	}

}
