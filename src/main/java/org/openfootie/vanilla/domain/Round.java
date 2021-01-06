package org.openfootie.vanilla.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Round {

    private List<Team> teams;
    private List<Match> fixtures = new ArrayList<>();

    public Round(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getFixtures() {
        return this.fixtures;
    }

    public void draw() {
        Collections.shuffle(this.teams);
        for (int i = 0; i < this.teams.size(); i+=2) {
            this.fixtures.add(new Match(this.teams.get(i), this.teams.get(i + 1)));
        }
    }

    // TODO currently a prototype to satisfy tests
    public List<Team> play() {
        return this.teams.subList(0, this.teams.size() / 2);
    }

    public void display() {

    }
}
