package org.openfootie.vanilla.main;

import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.MatchSample;
import org.openfootie.vanilla.engine.ScoreGenerator;
import org.openfootie.vanilla.environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Friendly {

    private final Environment environment;

    private final int SEED_SIZE = 3;
    private final Random rnd = new Random();

    public Friendly(Environment environment) {
        this.environment = environment;
    }

    public void play() {
        List<String> teamNames = environment.getTeamNames();
        int homeTeamIndex = rnd.nextInt(teamNames.size());
        int awayTeamIndex = homeTeamIndex;
        while (awayTeamIndex == homeTeamIndex) {
            awayTeamIndex = rnd.nextInt(teamNames.size());
        }

        List<MatchSample> seed = new ArrayList<>();
        for (int i = 0; i < SEED_SIZE; i++) {
            seed.add(environment.getMatchSample().get(rnd.nextInt(environment.getMatchSample().size())));
        }

        Match match = new Match(
                environment.getTeam(teamNames.get(homeTeamIndex)),
                environment.getTeam(teamNames.get(awayTeamIndex))
        );

        ScoreGenerator scoreGenerator = new ScoreGenerator(seed);
        scoreGenerator.generate(match);

        System.out.println(match);
    }
}
