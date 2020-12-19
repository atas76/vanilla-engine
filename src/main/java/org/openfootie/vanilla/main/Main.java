package org.openfootie.vanilla.main;

import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.MatchSample;
import org.openfootie.vanilla.engine.ScoreGenerator;
import org.openfootie.vanilla.environment.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int SEED_SIZE = 3;

    private static Random rnd = new Random();

    private static Environment environment = new Environment();

    public static void main(String [] args) throws IOException {

        environment.loadTeams("src/main/resources/teams.csv");
        environment.loadMatchSamples("src/main/resources/sample_scores.csv");

        playRandomFriendly();
    }

    private static void playRandomFriendly() {
        FriendlyMatchGenerator friendlyMatchGenerator = new FriendlyMatchGenerator(environment);
        Match match = friendlyMatchGenerator.generate();

        List<MatchSample> seed = new ArrayList<>();
        for (int i = 0; i < SEED_SIZE; i++) {
            seed.add(environment.getMatchSample().get(rnd.nextInt(environment.getMatchSample().size())));
        }

        ScoreGenerator scoreGenerator = new ScoreGenerator(seed);
        match.play(scoreGenerator);

        System.out.println(match);
    }
}
