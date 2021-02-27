package org.openfootie.vanilla.scoresim;

import org.openfootie.vanilla.domain.Tournament;
import org.openfootie.vanilla.environment.Environment;

public class TournamentGenerator {

    private final Environment environment;

    // TODO to be used in the future for different tournament setup options
    // private final Random rnd = new Random();

    public TournamentGenerator(Environment environment) {
        this.environment = environment;
    }

    // Keep it simple: load all environment teams in the tournament
    public Tournament generate() {
        return new Tournament(environment.getTeams());
    }
}
