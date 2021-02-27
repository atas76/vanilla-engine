package org.openfootie.vanilla.scoresim;

import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.environment.Environment;

import java.util.List;
import java.util.Random;

public class FriendlyMatchGenerator {

    private final Environment environment;

    private final Random rnd = new Random();

    public FriendlyMatchGenerator(Environment environment) {
        this.environment = environment;
    }

    public Match generate() {
        List<String> teamNames = environment.getTeamNames();
        int homeTeamIndex = rnd.nextInt(teamNames.size());
        int awayTeamIndex = homeTeamIndex;
        while (awayTeamIndex == homeTeamIndex) {
            awayTeamIndex = rnd.nextInt(teamNames.size());
        }

        return new Match(
                environment.getTeam(teamNames.get(homeTeamIndex)),
                environment.getTeam(teamNames.get(awayTeamIndex))
        );
    }
}
