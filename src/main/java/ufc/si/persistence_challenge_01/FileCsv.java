package ufc.si.persistence_challenge_01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * FIleCsv
 */
public class FileCsv {

    private String filePath;
    private String line;
    private String separatorField;

    public FileCsv(String filePath, String line, String separatorField) {
        this.filePath = filePath;
        this.line = line;
        this.separatorField = separatorField;
    }

    public void readCsv() {

        BufferedReader csvReader;
        String row;
        String[] data;

        try {
            csvReader = new BufferedReader(new FileReader(this.filePath));

            while ((row = csvReader.readLine()) != null) {
                data = row.split(this.separatorField);
            }

            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}