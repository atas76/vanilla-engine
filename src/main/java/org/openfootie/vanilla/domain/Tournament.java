package org.openfootie.vanilla.domain;

import java.util.List;

public class Tournament {

    private final List<Team> teams;

    public Tournament(List<Team> teams) {
        this.teams = teams;
    }

    public int getParticipantsNum() {
        return teams.size();
    }
}
