package com.lf.bullsandcows.entity;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Game {

	private int id;
	private Status status;
	private String elapsedTime;
	private int answer;
	private List<Round> rounds;

	public Game() {
		this.rounds = new ArrayList<>();
	}

//	private static List<Integer> generateAnswer() {
//		List<Integer> randomNums = new ArrayList<>();
//		for (int i = 0; i < 4; i++) {
//			int randomNumber = (int) (Math.random() * 9) + 1;
//			if (randomNums.contains(randomNumber)) {
//				while (randomNums.contains(randomNumber)) {
//					randomNumber = (int) (Math.random() * 9) + 1;
//				}
//			}
//			randomNums.add(randomNumber);
//		}
//		return randomNums;
//	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

//	public void setElapsedTime(Instant startTime, Instant endTime) {
//		Duration timeElapsed = Duration.between(startTime, endTime);
//		this.elapsedTime = timeElapsed.toMinutes() + ":" + timeElapsed.toSecondsPart();
//	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public int getNoOfRounds() {
		return this.rounds.size();
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	//	public List<Integer> getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(List<Integer> answer) {
//		this.answer = answer;
//	}

}