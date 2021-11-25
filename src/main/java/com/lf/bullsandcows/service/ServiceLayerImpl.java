package com.lf.bullsandcows.service;

import com.lf.bullsandcows.dao.EntityDaoHelpers;
import com.lf.bullsandcows.dao.GameDao;
import com.lf.bullsandcows.dao.RoundDao;
import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the ServiceLayer interface.
 */
@Repository
public class ServiceLayerImpl implements ServiceLayer {
	private final GameDao gameDao;
	private final RoundDao roundDao;
	private int partials;
	private int exacts;

	/**
	 * Instantiates a new Service layer.
	 *
	 * @param gameDao  the game dao
	 * @param roundDao the round dao
	 */
	public ServiceLayerImpl(GameDao gameDao, RoundDao roundDao) {
		this.gameDao = gameDao;
		this.roundDao = roundDao;
		this.partials = 0;
		this.exacts = 0;
	}

	@Override
	public List<Game> getGames() {
		return gameDao.getAllGames();
	}

	@Override
	public Game getGame(int gameId) {
		return gameDao.getGameById(gameId);
	}

	@Override
	public Game startGame() {
		List<Integer> answer = generateNewAnswer();
		Game game = new Game();
		return this.gameDao.newGame(answer, game);
	}

	@Override
	public Round playRound(Round round) {
		/*
			Add new round with gameId and answer to database.
		 */
		round = roundDao.addRound(round);
		/*
			Calculate the matches between the round guess and the actual game answer.
		 */
		calculateResults(EntityDaoHelpers.intToArr(round.getGuess()),
				EntityDaoHelpers.intToArr(gameDao.getGameById(round.getGameId()).getAnswer()));
		/*
			Update matches.
		 */
		round.setExact(this.exacts);
		round.setPartial(this.partials);
		/*
			Update matches in the database.
		 */
		roundDao.updateSolutions(round);
		return round;

	}

	@Override
	public List<Round> getRounds(int gameId) {
		return gameDao.getRounds(gameId);
	}

	@Override
	public void completeGame(Game game) {
		gameDao.completeGame(game);
	}

	/**
	 * Method to generate a new array of 4 random different digits.
	 * @return - The List object of type Integer.
	 */
	private List<Integer> generateNewAnswer() {
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

	/**
	 * Method to calculate the number of partial and exact matches between a guess and an answer.
	 * @param guess - The guessed digits.
	 * @param answer - The actual digits.
	 */
	private void calculateResults(List<Integer> guess, List<Integer> answer) {
		this.exacts = 0;
		this.partials = 0;
		for (int i = 0; i < 4; i++){
			if(answer.contains(guess.get(i))){
				if(answer.get(i) == guess.get(i)){
					this.exacts++;
				}
				else {
					this.partials ++;
				}
			}
		}
	}
}
