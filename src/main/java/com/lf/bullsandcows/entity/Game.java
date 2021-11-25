package com.lf.bullsandcows.entity;

/**
 * The type Game.
 */
public class Game {

	private int id;
	private Status status;
	private int answer;

	/**
	 * Instantiates a new Game.
	 */
	public Game() {
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets answer.
	 *
	 * @return the answer
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * Sets answer.
	 *
	 * @param answer the answer
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}