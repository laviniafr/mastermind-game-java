package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;

import java.time.Instant;
import java.util.List;

/**
 * The interface Game dao.
 */
public interface GameDao {

	/**
	 * Method to get all the games played so far.
	 *
	 * @return - A list of type Game.
	 */
	List<Game> getAllGames();

	/**
	 * Method to get all the rounds of a game based on its id.
	 *
	 * @param gameId - The game id.
	 * @return - A list of type Round containing all the rounds with the given game id.
	 */
	List<Round> getRounds(int gameId);

	/**
	 * Method to initialise a new game.
	 *
	 * @param answer - The generated sequence of numbers.
	 * @param game   - The game.
	 * @return -The new game object.
	 */
	public Game newGame(List<Integer> answer, Game game);

	/**
	 * Method to complete a game.
	 *
	 * @param game - The game object.
	 */
	public void completeGame(Game game);

	/**
	 * Method to get a game's stats by id.
	 *
	 * @param id The id.
	 * @return - The game object.
	 */
	Game getGameById(int id);

}
