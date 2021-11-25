package com.lf.bullsandcows.service;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;

import java.util.List;

/**
 * The interface Service layer.
 */
public interface ServiceLayer {

	/**
	 * Method to get a list of all the completed games.
	 *
	 * @return - The list of games.
	 */
	List<Game> getGames();

	/**
	 * Method to get a game given its id.
	 *
	 * @param gameId - The game id.
	 * @return - The game object.
	 */
	Game getGame(int gameId);

	/**
	 * Method that starts a new game.
	 *
	 * @return - The new Game.
	 */
	Game startGame();

	/**
	 * Method that plays one round of a game.
	 *
	 * @param round - The current game round.
	 * @return - The round object.
	 */
	Round playRound(Round round);

	/**
	 * Method that returns a list of all the rounds of a game.
	 *
	 * @param gameId the game id
	 * @return rounds
	 */
	List<Round> getRounds(int gameId);

	/**
	 * Method that completes a game.
	 *
	 * @param game the game
	 */
	void completeGame(Game game);

}
