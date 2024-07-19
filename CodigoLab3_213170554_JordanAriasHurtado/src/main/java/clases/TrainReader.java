package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para leer un archivo de ejemplo para construir Trenes
 */
public class TrainReader {
    /**
     * Separa un archivo seleccionado por nombre
     * @param fileName Nombre archivo
     * @return Train list
     * @throws IOException Error al leer el archivo
     */
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

                int i;
                for (i = 5; i < parts.length - 7 ; i = i + 5) {
                    int idPassangerCar = Integer.parseInt(parts[i].trim());
                    int passangerCapacity = Integer.parseInt(parts[i+1].trim());
                    String model = parts[i+2].trim();
                    String pcarTrainMaker = parts[i+3].trim();
                    char carType = parts[i+4].trim().charAt(0);

                    PassangerCar_21317055_AriasHurtado newPcar = new PassangerCar_21317055_AriasHurtado(idPassangerCar, passangerCapacity, model, pcarTrainMaker, carType);
                    carlist.add(newPcar);
                }

                int assignedLine = Integer.parseInt(parts[i].trim());
                int assignedDriver = Integer.parseInt(parts[i + 1].trim());
                int departureStation = Integer.parseInt(parts[i + 2].trim());
                int arriveStation = Integer.parseInt(parts[i + 3].trim());
                long departureTimeUnix = Long.parseLong(parts[i + 4].trim());
                Date departureTime = new Date(departureTimeUnix);

                Train_21317055_AriasHurtado newTrain = new Train_21317055_AriasHurtado(idTrain, trainMaker, speed, stationStaytime, carlist);

                newTrain.setAssignedLine(assignedLine);
                newTrain.setAssignedDriver(assignedDriver);

                Station_213170554_AriasHurtado auxStation1 = new Station_213170554_AriasHurtado(departureStation, "Test1", 'm', 0);
                Station_213170554_AriasHurtado auxStation2 = new Station_213170554_AriasHurtado(arriveStation, "Test2", 'm', 0);

                newTrain.setDepartureStation(auxStation1);
                newTrain.setArriveStation(auxStation2);
                newTrain.setDepartureTime(departureTime);
                // Crear el objeto Line y agregarlo a la lista

                trains.add(newTrain);
            }
        }
        reader.close();
        return trains;
    }
}