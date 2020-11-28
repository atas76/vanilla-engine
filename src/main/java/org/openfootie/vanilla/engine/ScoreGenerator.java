package org.openfootie.vanilla.engine;

import org.openfootie.vanilla.domain.Match;
import org.openfootie.vanilla.domain.MatchSample;

import java.util.List;

public class ScoreGenerator {

    private Match match;
    private List<MatchSample> seedSamples;

    public ScoreGenerator(Match match, List<MatchSample> seedSamples) {
        this.match = match;
        this.seedSamples = seedSamples;
    }
}
