package com.lf.bullsandcows.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Round {

	private int roundId;
	private int partial;
	private int exact;
	private LocalDateTime roundPlayTime;
	private List<Integer> guessedDigits;

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
	}

	public int getPartial() {
		return partial;
	}

	public void setPartial(int partial) {
		this.partial = partial;
	}

	public int getExact() {
		return exact;
	}

	public void setExact(int exact) {
		this.exact = exact;
	}

	public List<Integer> getGuessedDigits() {
		return guessedDigits;
	}

	public void setGuessedDigits(List<Integer> guessedDigits) {
		this.guessedDigits = guessedDigits;
	}

	public String getRoundPlayTime() {
		return roundPlayTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	public void setRoundPlayTime(Date roundPlayTime) {
		this.roundPlayTime = LocalDateTime.now();
	}
}
