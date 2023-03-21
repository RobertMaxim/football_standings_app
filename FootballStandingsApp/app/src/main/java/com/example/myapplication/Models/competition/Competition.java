package com.example.myapplication.Models.competition;

import java.util.List;

public class Competition {
	
	private String id;
	private String name;
	private String code;
	private String plan;
	private CompetitionSeason currentSeason;
	private List<CompetitionSeason> seasons;
	private String lastUpdated;
	

	public Competition() {
		super();
	}
	
	public Competition(String id, String name, String code, String plan,
			CompetitionSeason currentSeason, List<CompetitionSeason> seasons, String lastUpdated) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.plan = plan;
		this.currentSeason = currentSeason;
		this.seasons = seasons;
		this.lastUpdated = lastUpdated;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public CompetitionSeason getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(CompetitionSeason currentSeason) {
		this.currentSeason = currentSeason;
	}

	public List<CompetitionSeason> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<CompetitionSeason> seasons) {
		this.seasons = seasons;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
