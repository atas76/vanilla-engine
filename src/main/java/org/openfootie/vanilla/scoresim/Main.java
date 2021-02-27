package org.openfootie.vanilla.scoresim;

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

        playRandomFriendlies(5, 5);
    }

    private static void playRandomFriendlies(int friendliesNum) {
        for (int i = 0; i < friendliesNum; i++) {
            playRandomFriendly();
        }
    }

    private static void playRandomFriendlies(int friendliesNum, int repeat) {
        for (int i = 0; i < friendliesNum; i++) {
            playRandomFriendly(repeat);
            System.out.println();
        }
    }

    private static void playRandomFriendly(int repeat) {

        Match match = generateFriendlyMatch();

        for (int i = 0; i < repeat; i++) {
            ScoreGenerator scoreGenerator = setupMatchData();
            match.play(scoreGenerator);
            System.out.println(match);
        }
    }

    private static void playRandomFriendly() {

        Match match = generateFriendlyMatch();

        ScoreGenerator scoreGenerator = setupMatchData();
        match.play(scoreGenerator);
        System.out.println(match);
    }

    private static ScoreGenerator setupMatchData() {
        List<MatchSample> seed = seedMatchSamples();
        return new ScoreGenerator(seed);
    }

    private static List<MatchSample> seedMatchSamples() {
        List<MatchSample> seed = new ArrayList<>();
        for (int i = 0; i < SEED_SIZE; i++) {
            seed.add(environment.getMatchSample().get(rnd.nextInt(environment.getMatchSample().size())));
        }
        return seed;
    }

    private static Match generateFriendlyMatch() {
        return new FriendlyMatchGenerator(environment).generate();
    }
}
