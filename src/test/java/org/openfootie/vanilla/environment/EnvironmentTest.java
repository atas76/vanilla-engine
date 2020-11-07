package org.openfootie.vanilla.environment;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EnvironmentTest {

    private static Environment environment;

    @Test
    public void testLoad() throws IOException {

        environment = new Environment();
        environment.load("src/test/resources/sample.csv");

        assertEquals(143, environment.getMatchesNumber());
        assertEquals(1, environment.getMatch(73).getAwayTeamScore());
        assertEquals(0, environment.getMatch(54).getHomeTeamScore());
        assertEquals(17, environment.getMatch(108).getAwayTeamPosition());
    }
}
