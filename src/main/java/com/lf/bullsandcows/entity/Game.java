package com.lf.bullsandcows.entity;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Game {

	private int id;
	private boolean inProgress;
	private String elapsedTime;
	private List<Integer> answer;
	private List<Round> rounds;

	public Game() {
		this.rounds = new ArrayList<>();
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public int getId() {
		return id;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Instant startTime, Instant endTime) {
		Duration timeElapsed = Duration.between(startTime, endTime);
		this.elapsedTime = timeElapsed.toMinutes() + ":" + timeElapsed.toSecondsPart();
	}

	public int getNoOfRounds() {
		return this.rounds.size();
	}


	public List<Integer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Integer> answer) {
		this.answer = answer;
	}

}