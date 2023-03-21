package com.example.myapplication.Models.competition;

public class CompetitionSeason {

	private String id;
	private String startDate;
	private String endDate;
	private String currentMatchday;
	
	public CompetitionSeason() {
		super();
	}
	
	public CompetitionSeason(String id, String startDate, String endDate, String currentMatchday) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentMatchday = currentMatchday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCurrentMatchday() {
		return currentMatchday;
	}

	public void setCurrentMatchday(String currentMatchday) {
		this.currentMatchday = currentMatchday;
	}

}
