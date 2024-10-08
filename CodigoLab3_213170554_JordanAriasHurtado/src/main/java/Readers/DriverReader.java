package Readers;

import clases.Driver_21317055_AriasHurtado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase para leer un archivo de ejemplo para construir Conductores
 */
public class DriverReader {
    /**
     * Separa un archivo seleccionado por nombre
     * @param fileName Nombre archivo
     * @return Driver List
     * @throws IOException Error al leer el archivo
     */
    public static ArrayList<Driver_21317055_AriasHurtado> readDrivers(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        ArrayList<Driver_21317055_AriasHurtado> drivers = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if ("Driver".equals(parts[0])) {
                int driverId = Integer.parseInt(parts[1]);
                String driverName = parts[2];
                String trainMaker = parts[3];
                int assignedTrain = Integer.parseInt(parts[4]);
                Driver_21317055_AriasHurtado newDriver = new Driver_21317055_AriasHurtado(driverId, driverName, trainMaker);
                newDriver.setAssignedTrain(assignedTrain);
                drivers.add(newDriver);

            }
        }
        reader.close();
        return drivers;
    }
}