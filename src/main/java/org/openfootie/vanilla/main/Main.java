package org.openfootie.vanilla.main;

import org.openfootie.vanilla.environment.Environment;

import java.io.IOException;

public class Friendly {

    private static Environment environment;

    public static void main(String [] args) throws IOException {
        environment = new Environment();
        environment.loadTeams("src/main/resources/teams.csv");
        environment.loadMatchSamples("src/main/resources/sample_scores.csv");

        // Friendly friendly = new Friendly();

    }
}
