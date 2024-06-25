package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TrainReader {
    public static ArrayList<Train_21317055_AriasHurtado> readTrains(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<Train_21317055_AriasHurtado> trains = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if ("Train".equals(parts[0])) {
                int trainId = Integer.parseInt(parts[1]);
                String model = parts[2];
                int capacity = Integer.parseInt(parts[3]);
                int numCars = Integer.parseInt(parts[4]);
                trains.add(new Train_21317055_AriasHurtado(trainId, model, capacity, numCars, new ArrayList<>()));
            }
        }
        reader.close();
        return trains;
    }
}