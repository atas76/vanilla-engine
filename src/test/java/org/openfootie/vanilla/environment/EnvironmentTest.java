package org.openfootie.vanilla.environment;

import org.junit.Test;
import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.MatchSample;
import org.openfootie.vanilla.domain.Team;
import org.openfootie.vanilla.engine.ScoreGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    public void testLoadTeams() throws IOException {

        environment = new Environment();
        environment.loadTeams("src/test/resources/teams.csv");

        Team team = environment.getTeam("Southampton");

        assertEquals(1766, team.getEloRanking());
    }

    @Test
    public void testExpectedScore() throws IOException {

        environment = new Environment();
        environment.loadMatchSamples("src/test/resources/sample.csv");

        environment.loadTeams("src/test/resources/teams.csv");

        Match match = new Match(environment.getTeam("Atletico Madrid"), environment.getTeam("Barcelona"));
        List<MatchSample> seedSamples = Arrays.asList(
                new MatchSample(1743,1806,0,6),
                new MatchSample(1668,1696,0,0),
                new MatchSample(1851,1546,3,2)
        );

        ScoreGenerator scoreGenerator = new ScoreGenerator(match, seedSamples);
    }
}
