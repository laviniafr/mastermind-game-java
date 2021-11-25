package com.lf.bullsandcows.controller;

import com.lf.bullsandcows.entity.Game;
import com.lf.bullsandcows.entity.Round;
import com.lf.bullsandcows.entity.Status;
import com.lf.bullsandcows.service.ServiceLayer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Game controller.
 */
@RestController
@RequestMapping("/api")
public class GameController {
	private final ServiceLayer serviceLayer;
	private static int currentGameId;

	/**
	 * Instantiates a new Game controller with a service layer.
	 *
	 * @param serviceLayer - The service layer
	 */
	public GameController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}

	/**
	 * Gets all games.
	 *
	 * @return - List of type Game, containing all the games.
	 */
	@GetMapping("/game")
	public List<Game> getAllGames() {
		return serviceLayer.getGames();
	}

	/**
	 * Gets game by id.
	 *
	 * @param id - The game id.
	 * @return - The game object.
	 */
	@GetMapping("/game/{id}")
	public Game getGame(@PathVariable int id) {
		return serviceLayer.getGame(id);
	}

	/**
	 * Gets all rounds of a game based on its id..
	 *
	 * @param id - The id passed in as a path variable.
	 * @return - All the rounds associated with the game.
	 */
	@GetMapping("/rounds/{id}")
	public List<Round> getAllRounds(@PathVariable int id) {
		return serviceLayer.getRounds(id);
	}

	/**
	 * Creates a new Game.
	 *
	 * @return - The id of the new game.
	 */
	@PostMapping("/begin")
	@ResponseStatus(HttpStatus.CREATED)
	public int create() {
		currentGameId = serviceLayer.startGame().getId();
		return currentGameId;
	}

	/**
	 * Makes a new guess given a Round object retrieved from JSON data.
	 *
	 * @param round - The retrieved Round object.
	 * @return - The resulting Round object with updated stats.
	 * @throws Exception - A general exception that is thrown when the user attempts to make a guess for a game that's
	 * already been completed.
	 */
	@PostMapping("/guess")
	@ResponseStatus(HttpStatus.CREATED)
	public Round makeAGuess(@RequestBody Round round) throws Exception {
		if (serviceLayer.getGame(round.getGameId()).getStatus().equals(Status.COMPLETE)) {
			throw new Exception("Game is already complete!");
		} else {
			round = serviceLayer.playRound(round);
			if (round.getExact() == 4) { // If the user guesses all the 4 digits, the game is marked as complete.
				serviceLayer.completeGame(serviceLayer.getGame(round.getGameId()));
			}
		}
		return round;
	}


}
