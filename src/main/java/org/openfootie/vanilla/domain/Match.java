package org.openfootie.vanilla.domain;

import static org.openfootie.vanilla.domain.MatchStatus.*;

public class Match {

    private Team homeTeam;
    private Team awayTeam;
    private int homeScore = 0;
    private int awayScore = 0;
    private MatchStatus status = FIXTURE;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam =  homeTeam;
        this.awayTeam = awayTeam;
    }
}
