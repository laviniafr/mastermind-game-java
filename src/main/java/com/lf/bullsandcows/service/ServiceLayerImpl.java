package com.lf.bullsandcows.service;

import com.lf.bullsandcows.dao.EntityDaoHelpers;
import com.lf.bullsandcows.dao.GameDao;
import com.lf.bullsandcows.dao.RoundDao;
import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceLayerImpl implements ServiceLayer {
	private final GameDao gameDao;
	private final RoundDao roundDao;
	private int partials;
	private int exacts;

	public ServiceLayerImpl(GameDao gameDao, RoundDao roundDao) {
		this.gameDao = gameDao;
		this.roundDao = roundDao;
		this.partials = 0;
		this.exacts = 0;
	}

	@Override
	public Game startGame() {
		List<Integer> answer = generateNewAnswer();
		Game game = new Game();
		return this.gameDao.newGame(answer, game);
	}

	@Override
	public Round playRound(int gameId, Round round) {
		Game game = gameDao.getGameById(gameId);
		calculateResults(EntityDaoHelpers.intToArr(round.getGuess()),EntityDaoHelpers.intToArr(game.getAnswer()));
		round.setPartial(partials);
		round.setExact(exacts);
		return round;
	}

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

	private void calculateResults(List<Integer> guess, List<Integer> answer) {
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
