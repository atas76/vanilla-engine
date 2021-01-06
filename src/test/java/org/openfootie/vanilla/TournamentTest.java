package org.openfootie.vanilla;

import org.junit.Test;
import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.Round;
import org.openfootie.vanilla.domain.Team;
import org.openfootie.vanilla.domain.Tournament;
import org.openfootie.vanilla.environment.Environment;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TournamentTest {

    private static Environment environment;

    @Test
    public void testRoundElimination() throws IOException {
        environment = new Environment();
        environment.loadTeams("src/test/resources/teams.csv");

        Tournament tournament = new Tournament(environment.getTeams());

        Round round = tournament.setupNextRound();
        round.draw();
        tournament.setRemainingTeams(round.play());

        assertEquals(16, tournament.getRemainingTeamsNum());
        assertEquals(32, tournament.getParticipantsNum());
    }

    @Test
    public void testRoundDrawTestData() throws IOException {
        environment = new Environment();
        environment.loadTeams("src/test/resources/teams.csv");

        Round round = new Round(environment.getTeams());
        round.draw();

        assertEquals(16, round.getFixtures().size());

        round.getFixtures().stream().map(Match::toString).forEach(System.out::println);
    }

    @Test
    public void testRoundDrawDummyData() {
        Round round = new Round(Arrays.asList(
                new Team("A", 0),
                new Team("B", 0),
                new Team("C", 0),
                new Team("D", 0)
        ));
        round.draw();

        assertEquals(2, round.getFixtures().size());

        round.getFixtures().stream().map(Match::toString).forEach(System.out::println);
    }
}
