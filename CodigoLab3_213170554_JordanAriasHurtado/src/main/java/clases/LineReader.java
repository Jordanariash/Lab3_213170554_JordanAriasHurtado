package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LineReader {
    public static ArrayList<Line_21317055_AriasHurtado> readLines(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<Line_21317055_AriasHurtado> lines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if ("Line".equals(parts[0])) {
                int lineId = Integer.parseInt(parts[1]);
                String lineName = parts[2];
                String railType = parts[3];
                lines.add(new Line_21317055_AriasHurtado(lineId, lineName, railType, new ArrayList<>()));
            }
        }
        reader.close();
        return lines;
    }
}
