package com.lf.bullsandcows.entity;

/**
 * The type Round.
 */
public class Round {

	private int roundId;
	private int partial;
	private int exact;
	private int guess;
	private int gameId;

	/**
	 * Instantiates a new Round.
	 */
	public Round() {

	}

	/**
	 * Gets guess.
	 *
	 * @return the guess
	 */
	public int getGuess() {
		return guess;
	}

	/**
	 * Sets guess.
	 *
	 * @param guess the guess
	 */
	public void setGuess(int guess) {
		this.guess = guess;
	}

	/**
	 * Gets round id.
	 *
	 * @return the round id
	 */
	public int getRoundId() {
		return roundId;
	}

	/**
	 * Sets round id.
	 *
	 * @param roundId the round id
	 */
	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	/**
	 * Gets partial matches.
	 *
	 * @return the partial
	 */
	public int getPartial() {
		return partial;
	}

	/**
	 * Sets partial matches.
	 *
	 * @param partial the partial
	 */
	public void setPartial(int partial) {
		this.partial = partial;
	}

	/**
	 * Gets exact matches.
	 *
	 * @return the exact
	 */
	public int getExact() {
		return exact;
	}

	/**
	 * Sets exact matches.
	 *
	 * @param exact the exact
	 */
	public void setExact(int exact) {
		this.exact = exact;
	}

	/**
	 * Gets game id.
	 *
	 * @return the game id
	 */
	public int getGameId() {
		return gameId;
	}

	/**
	 * Sets game id.
	 *
	 * @param gameId the game id
	 */
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

}
