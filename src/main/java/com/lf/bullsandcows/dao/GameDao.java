package com.lf.bullsandcows.dao;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;

import java.time.Instant;
import java.util.List;

public interface GameDao {

	/**
	 * Method to get all the games played so far.
	 * @return
	 */
	List<Game> getAllGames();

	/**
	 * Method to get all the rounds of a game ID.
	 * @return
	 */
	List<Round> getRounds(int gameId);

	/**
	 * Method to create a new game.
	 * @param answer - The generated sequence of numbers.
	 * @param status - The status of the game.
	 * @return -The new game object.
	 */
	public Game newGame(List<Integer> answer, Game game);

//	public Game addGame(Game game);

	public void completeGame(Game game);

	/**
	 * Method to get a game's stats by id.
	 * @param id
	 * @return
	 */
	Game getGameById(int id);

//	/**
//	 * Method to update the status of the game.
//	 */
//	void updateStatus(Status status, int gameId);
//
//	/**
//	 * Method to update the elapsed time of a game.
//	 */
//	void updateElapsedTime(Instant startTime, Instant endTime, int gameId);


}
