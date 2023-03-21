package com.example.myapplication.Models.competition;

import java.util.List;

public class CompetitionList{
	
	private String count;
	private List<Competition> competitions;
	
	public CompetitionList(String id, List<Competition> competitions) {
		super();
		this.count = id;
		this.competitions = competitions;
	}

	public String getId() {
		return count;
	}

	public void setId(String id) {
		this.count = id;
	}

	public List<Competition> getCompetitions() {
		return competitions;
	}

	public void setCompetitions(List<Competition> competitions) {
		this.competitions = competitions;
	}
}