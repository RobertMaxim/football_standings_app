package com.example.myapplication.Models.team;

import com.example.myapplication.Models.competition.Competition;
import com.example.myapplication.Models.competition.CompetitionSeason;

import java.util.List;

public class TeamList {
	
	private String count;
	private Competition competition;
	private CompetitionSeason season;
	private List<Team> teams;
	
	public TeamList() {
		super();
	}
	
	public TeamList(String count, Competition competition, CompetitionSeason season,
			List<Team> teams) {
		super();
		this.count = count;
		this.competition = competition;
		this.season = season;
		this.teams = teams;
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

	public CompetitionSeason getSeason() {
		return season;
	}

	public void setSeason(CompetitionSeason season) {
		this.season = season;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
