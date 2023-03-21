package com.example.myapplication.Controllers;

import com.example.myapplication.Helper.JsonHelper;
import com.example.myapplication.Models.competition.Competition;
import com.example.myapplication.Models.competition.CompetitionList;
import com.example.myapplication.Models.match.Match;
import com.example.myapplication.Models.match.MatchList;
import com.example.myapplication.Models.player.Player;
import com.example.myapplication.Models.standing.Standing;
import com.example.myapplication.Models.team.Team;
import com.example.myapplication.Models.team.TeamList;

public class CompetitionController {

    public static String TOKEN;
    private static final String URI = "https://api.football-data.org/v2/";

    @SuppressWarnings("static-access")

    public CompetitionController(String token) {
        super();
        this.TOKEN = token;
    }

    public CompetitionList getAllCompetitions() {
        JsonHelper<CompetitionList> utilJson = new JsonHelper<CompetitionList>();
        return utilJson.getObjectFromJson(URI + "competitions/", CompetitionList.class);
    }

    public Competition getCompetition(int IdCompetition) {
        JsonHelper<Competition> utilJson = new JsonHelper<Competition>();
        return utilJson.getObjectFromJson(URI + "competitions/" + IdCompetition, Competition.class);
    }

    public TeamList getTeamsByCompetition(int idCompetition) {
        JsonHelper<TeamList> utilJson = new JsonHelper<TeamList>();
        return utilJson.getObjectFromJson(URI + "competitions/"+ idCompetition +"/teams", TeamList.class);
    }

    public Team getTeam(int idTeam) {
        JsonHelper<Team> utilJson = new JsonHelper<Team>();
        return utilJson.getObjectFromJson(URI + "teams/"+ idTeam, Team.class);
    }

    public Player getPlayer(int idPlayer) {
        JsonHelper<Player> utilJson = new JsonHelper<Player>();
        return utilJson.getObjectFromJson(URI + "players/"+ idPlayer, Player.class);
    }

    public Standing getStanding(int idCompetition) {
        JsonHelper<Standing> utilJson = new JsonHelper<Standing>();
        return utilJson.getObjectFromJson(URI + "competitions/"+ idCompetition + "/standings", Standing.class);
    }

    public Match getMatch(int idMatch ) {
        JsonHelper<Match> utilJson = new JsonHelper<Match>();
        return utilJson.getObjectFromJson(URI + "matches/"+ idMatch, Match.class);
    }

    public MatchList getMatchesByCompetition(int idCompetition ) {
        JsonHelper<MatchList> utilJson = new JsonHelper<MatchList>();
        return utilJson.getObjectFromJson(URI + "competitions/"+ idCompetition + "/matches", MatchList.class);
    }

    public MatchList getMatchesByTeam(int idTeam) {
        JsonHelper<MatchList> utilJson = new JsonHelper<MatchList>();
        return utilJson.getObjectFromJson(URI + "teams/"+ idTeam + "/matches", MatchList.class);
    }
}
