package org.openfootie.vanilla;

import org.junit.Test;
import org.openfootie.vanilla.domain.Tournament;
import org.openfootie.vanilla.environment.Environment;
import org.openfootie.vanilla.scoresim.TournamentGenerator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TournamentGeneratorTest {

    private static Environment environment;
    private static TournamentGenerator tournamentGenerator;

    @Test
    public void testLoadTournamentTeams() throws IOException {
        environment = new Environment();
        environment.loadTeams("src/test/resources/teams.csv");
        tournamentGenerator = new TournamentGenerator(environment);

        Tournament tournament = tournamentGenerator.generate();

        assertEquals(32, tournament.getParticipantsNum());
    }
}
