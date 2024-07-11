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
                int idLine = Integer.parseInt(parts[1].trim());
                String nameLine = parts[2].trim();
                String railType = parts[3].trim();
                ArrayList<Section_21317055_AriasHurtado> sections = new ArrayList<>();
                String[] sectionDetails = parts[4].trim().split(";");
                for (String sectionDetail : sectionDetails) {
                    String[] sectionParts = sectionDetail.trim().split(":");
                    // Obtener detalles de las estaciones
                    int idStation1 = Integer.parseInt(sectionParts[0].trim());
                    String nameStation1 = sectionParts[1].trim();
                    char stationType1 = sectionParts[2].trim().charAt(0);
                    int stopTime1 = Integer.parseInt(sectionParts[3].trim());

                    int idStation2 = Integer.parseInt(sectionParts[4].trim());
                    String nameStation2 = sectionParts[5].trim();
                    char stationType2 = sectionParts[6].trim().charAt(0);
                    int stopTime2 = Integer.parseInt(sectionParts[7].trim());

                    // Obtener distancia y costo de la sección
                    int distance = Integer.parseInt(sectionParts[8].trim());
                    int cost = Integer.parseInt(sectionParts[9].trim());

                    // Crear objetos Station_213170554_AriasHurtado
                    Station_213170554_AriasHurtado station1 = new Station_213170554_AriasHurtado(idStation1, nameStation1, stationType1, stopTime1);
                    Station_213170554_AriasHurtado station2 = new Station_213170554_AriasHurtado(idStation2, nameStation2, stationType2, stopTime2);

                    // Crear objeto Section_21317055_AriasHurtado y agregarlo a la lista de secciones
                    Section_21317055_AriasHurtado section = new Section_21317055_AriasHurtado(station1, station2, distance, cost);
                    sections.add(section);

                    }

                ArrayList<Integer> assignedTrains = new ArrayList<>();
                if (parts.length > 5) {
                    String[] trainDetails = parts[5].trim().split(";");
                    for (String trainDetail : trainDetails) {
                        assignedTrains.add(Integer.parseInt(trainDetail.trim()));
                    }
                }

                Line_21317055_AriasHurtado newLine = new Line_21317055_AriasHurtado(idLine, nameLine, railType, sections);
                newLine.setAssignedTrains(assignedTrains);
                lines.add(newLine);
                }
            }
            reader.close();
            return lines;
    }
}