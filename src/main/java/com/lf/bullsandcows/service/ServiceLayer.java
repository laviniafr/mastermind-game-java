package com.lf.bullsandcows.service;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;

import java.util.List;

public interface ServiceLayer {

	/**
	 * Method to get a list of all the completed games.
	 * @return - The list of games.
	 */
	List<Game> getGames();

	/**
	 * Method to get a game given its id.
	 * @param gameId - The game id.
	 * @return - The game object.
	 */
	Game getGame(int gameId);

	/**
	 * Method that starts a new game.
	 * @return - The new Game.
	 */
	Game startGame();

	/**
	 * Method that plays one round of a game.
	 * @param gameId - The game to play a new round of
	 * @param guesses - The user's choice of numbers.
	 * @return - The round object.
	 */
	Round playRound(int gameId, List<Integer> guesses);

	/**
	 * Method that gets one round object.
	 * @param gameId - The id of the game containing the round.
	 * @param roundId - The round id.
	 * @return - The round object.
	 */
	Round getRound(int gameId, int roundId);

	/**
	 * Method that returns a list of all the rounds of a game.
	 * @param gameId
	 * @return
	 */
	List<Round> getRounds(int gameId);

}
