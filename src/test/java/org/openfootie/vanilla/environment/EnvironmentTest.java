package org.openfootie.vanilla.environment;

import org.junit.Test;
import org.openfootie.vanilla.domain.Match;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EnvironmentTest {

    private static Environment environment;

    @Test
    public void testLoad() throws IOException {

        environment = new Environment();
        environment.loadMatchSamples("src/test/resources/sample.csv");

        assertEquals(55, environment.getMatchesNumber());
        assertEquals(0, environment.getMatch(49).getAwayTeamScore());
        assertEquals(1, environment.getMatch(17).getHomeTeamScore());
        assertEquals(1806, environment.getMatch(28).getAwayTeamRating());
        assertEquals(1823, environment.getMatch(28).getHomeTeamRating());
    }

    @Test
    public void testExpectedScore() throws IOException {

        environment = new Environment();
        environment.loadMatchSamples("src/test/resources/sample.csv");

        // TODO
        environment.loadTeams("src/test/resources/teams.csv");

        Match match = new Match(environment.getTeam("Atletico Madrid"), environment.getTeam("Barcelona"));
    }
}
