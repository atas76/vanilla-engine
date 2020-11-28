package org.openfootie.vanilla.environment;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openfootie.vanilla.domain.MatchSample;
import org.openfootie.vanilla.domain.Team;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {

    private List<MatchSample> matches = new ArrayList<>();
    private Map<String, Team> teams = new HashMap<>();

    public Team getTeam(String teamName) {
        return teams.get(teamName);
    }

    public void loadTeams(String resource) throws IOException {
        Reader rankingReader = new FileReader(resource);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(rankingReader);
        for (CSVRecord record : records) {
            String teamName = record.get(0);
            teams.put(teamName, new Team(teamName, Integer.parseInt(record.get(1))));
        }
    }

    public void loadMatchSamples(String resourceName) throws IOException {

        Reader reader = new FileReader(resourceName);
        Iterable<CSVRecord> matchRecords = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);

        for (CSVRecord record : matchRecords) {
            matches.add(new MatchSample(
                    Integer.parseInt(record.get("HomeRating")),
                    Integer.parseInt(record.get("AwayRating")),
                    Integer.parseInt(record.get("HomeScore")),
                    Integer.parseInt(record.get("AwayScore"))));
        }
    }

    public int getMatchesNumber() {
        return matches.size();
    }

    public MatchSample getMatch(int index) {
        return matches.get(index);
    }
}
