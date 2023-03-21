package com.example.myapplication.Helper;

import android.os.AsyncTask;

import com.example.myapplication.Controllers.CompetitionController;
import com.example.myapplication.Models.match.MatchList;
import com.example.myapplication.Models.standing.Standing;

import java.util.Arrays;

public class LeaguesAsyncTask<T> extends AsyncTask<String, Integer, T> {
    @Override
    protected T doInBackground(String... strings) {
        CompetitionController competitionController = new CompetitionController("f78fa0221ad34a74b22c291b09d72cf2");

        if (Arrays.asList(strings).contains("matches")) {
            MatchList listOfResultsAndFutureMatches = null;

            for (String league : strings) {
                switch (league) {
                    case "serie_a": {
                        listOfResultsAndFutureMatches = competitionController.getMatchesByCompetition(2019);
                        break;
                    }
                    case "premier_league": {
                        listOfResultsAndFutureMatches = competitionController.getMatchesByCompetition(2021);
                        break;
                    }
                    case "ligue_une": {
                        listOfResultsAndFutureMatches = competitionController.getMatchesByCompetition(2015);
                        break;
                    }
                    case "la_liga": {
                        listOfResultsAndFutureMatches = competitionController.getMatchesByCompetition(2014);
                        break;
                    }
                    case "bundesliga":{
                        listOfResultsAndFutureMatches = competitionController.getMatchesByCompetition(2002);
                        break;
                    }
                    default:{
                        listOfResultsAndFutureMatches=null;
                    }
                }
            }
            return (T) listOfResultsAndFutureMatches;

        } else if (Arrays.asList(strings).contains("standing")) {
            Standing leagueStanding = null;

            for (String league : strings) {
                switch (league) {
                    case "serie_a": {
                        leagueStanding = competitionController.getStanding(2019);
                        break;
                    }
                    case "premier_league": {
                        leagueStanding = competitionController.getStanding(2021);
                        break;
                    }
                    case "ligue_une": {
                        leagueStanding = competitionController.getStanding(2015);
                        break;
                    }
                    case "la_liga": {
                        leagueStanding = competitionController.getStanding(2014);
                        break;
                    }
                    case "bundesliga":{
                        leagueStanding = competitionController.getStanding(2002);
                        break;
                    }
                    default:{
                        leagueStanding=null;
                    }
                }
            }
            return (T) leagueStanding;
        }
        return null;
    }

}