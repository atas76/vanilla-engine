package org.openfootie.vanilla.environment;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openfootie.vanilla.domain.MatchSample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Environment {

    private List<MatchSample> matches = new ArrayList<>();

    public void load(String resourceName) throws IOException {

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
