package com.example.myapplication.Models.match;

public class MatchScore {
	
	private String winner;
	private String duration;
	private MatchTime fullTime;
	private MatchTime halfTime;

	public MatchScore(String winner, String duration, MatchTime fullTime, MatchTime halfTime) {
		super();
		this.winner = winner;
		this.duration = duration;
		this.fullTime = fullTime;
		this.halfTime = halfTime;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public MatchTime getFullTime() {
		return fullTime;
	}

	public void setFullTime(MatchTime fullTime) {
		this.fullTime = fullTime;
	}

	public MatchTime getHalfTime() {
		return halfTime;
	}

	public void setHalfTime(MatchTime halfTime) {
		this.halfTime = halfTime;
	}

}
