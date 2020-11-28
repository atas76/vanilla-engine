package org.openfootie.vanilla.domain;

public class Team {

    private String name;
    private int eloRanking;

    public Team(String name, int eloRanking) {
        this.name = name;
        this.eloRanking = eloRanking;
    }

    public String getName() {
        return this.name;
    }

    public int getEloRanking() {
        return this.eloRanking;
    }
}
