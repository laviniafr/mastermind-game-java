package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;

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
	public void updateStatus(String status, int gameId) {
		Game game = games.get(gameId);

	}

	@Override
	public void updateElapsedTime(Instant startTime, Instant endTime) {

	}

	@Override
	public void playRound(int roundId) {

	}
}
