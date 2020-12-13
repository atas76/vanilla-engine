package org.openfootie.vanilla.main;

import org.openfootie.vanilla.environment.Environment;

import java.io.IOException;

public class Main {


    public static void main(String [] args) throws IOException {
        Environment environment = new Environment();
        environment.loadTeams("src/main/resources/teams.csv");
        environment.loadMatchSamples("src/main/resources/sample_scores.csv");

        Friendly friendly = new Friendly(environment);
        friendly.play();
    }
}
