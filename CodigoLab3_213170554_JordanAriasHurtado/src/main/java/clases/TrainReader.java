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
                int idTrain = Integer.parseInt(parts[1]);
                String trainMaker = parts[2];
                int speed = Integer.parseInt(parts[3]);
                int stationStaytime = Integer.parseInt(parts[4]);

                ArrayList<PassangerCar_21317055_AriasHurtado> carlist = new ArrayList<>();
                String[] pcars = parts[5].trim().split(":");

                for (int i = 4; i < parts.length ; i += 4) {
                    int idPassangerCar = Integer.parseInt(parts[i].trim());
                    int passangerCapacity = Integer.parseInt(parts[i+1].trim());
                    String model = parts[i+2].trim();
                    String pcarTrainMaker = parts[i+3].trim();
                    char carType = parts[i+4].trim().charAt(0);

                    PassangerCar_21317055_AriasHurtado pcar = new PassangerCar_21317055_AriasHurtado(idPassangerCar, passangerCapacity, model, pcarTrainMaker, carType);
                    carlist.add(pcar);
                }

                // Crear el objeto Line_21317055_AriasHurtado y agregarlo a la lista
                Train_21317055_AriasHurtado train = new Train_21317055_AriasHurtado(idTrain, trainMaker, speed, stationStaytime, carlist);
                trains.add(train);
            }
        }
        reader.close();
        return trains;
    }
}


/*
public class TrainReader {


    public static ArrayList<Train_21317055_AriasHurtado> readTrains(String filename) throws IOException {
        ArrayList<Train_21317055_AriasHurtado> trains = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 5) {
                    throw new IOException("Problema con las comas id,trainmaker,speed,staytime,carlist");
                }

                int idTrain = Integer.parseInt(parts[0]);
                String trainMaker = parts[1];
                int speed = Integer.parseInt(parts[2]);
                int stationStaytime = Integer.parseInt(parts[3]);

                // Procesar vagones
                ArrayList<PassangerCar_21317055_AriasHurtado> carlist = new ArrayList<>();
                String[] sectionDetails = parts[4].trim().split(":");
                for (int i = 4; i < parts.length; i += 4) {
                    int idPassangerCar = Integer.parseInt(parts[i].trim());
                    int passangerCapacity = Integer.parseInt(parts[i+1].trim());
                    String model = parts[i+2].trim();
                    char carType = parts[i+3].trim().charAt(0);

                    PassangerCar_21317055_AriasHurtado pcar = new PassangerCar_21317055_AriasHurtado(idPassangerCar, passangerCapacity, model, trainMaker, carType);
                    carlist.add(pcar);
                }

                // Crear el objeto Line_21317055_AriasHurtado y agregarlo a la lista
                Train_21317055_AriasHurtado train = new Train_21317055_AriasHurtado(idTrain, trainMaker, speed, stationStaytime, carlist);
                trains.add(train);
            }
            return trains;
        }
    }
}

 */