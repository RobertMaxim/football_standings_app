package com.example.myapplication.Models.match;

import com.example.myapplication.Models.competition.Competition;

import java.util.List;

public class MatchList {

	private String count;
	private Competition competition;
	private List<Match> matches;
	
	public MatchList(String count, Competition competition, List<Match> matches) {
		super();
		this.count = count;
		this.competition = competition;
		this.matches = matches;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}
