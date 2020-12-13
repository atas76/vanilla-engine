package org.openfootie.vanilla.engine;

import org.openfootie.vanilla.domain.Match;

public class MatchEngine {

    private ScoreGenerator scoreGenerator;

    public MatchEngine(ScoreGenerator scoreGenerator) {
        this.scoreGenerator = scoreGenerator;
    }

    public void play(Match match) {
        scoreGenerator.generate(match);
    }
}
