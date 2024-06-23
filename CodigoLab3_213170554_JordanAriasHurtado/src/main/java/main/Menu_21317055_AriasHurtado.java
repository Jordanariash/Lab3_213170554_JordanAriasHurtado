package main;

import java.util.Scanner;
import clases.*;
import java.util.ArrayList;
import java.util.Date;

public class Menu_21317055_AriasHurtado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainOption;
        System.out.println("Bienvenido");
        System.out.println("Opciones");
        do {
            System.out.println("1-Cargar metro");
            System.out.println("2-Modificar metro") ;
            System.out.println("3-Visualizar metro");
            System.out.println("4-Salir");
            System.out.print("Seleccione una opción:\n");
            mainOption = scanner.nextInt();
            switch (mainOption) {
                case 1:
                    optionLoad();
                    System.out.println("Se ha cargado el metro de santiago");
                    break;
                case 2:
                    optionModify(scanner);
                    break;
                case 3:
                    System.out.println("VISUALIZAR METRO");
                    optionView();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (mainOption != 4);

        scanner.close();
    }

    public static void optionLoad(){
        Station_213170554_AriasHurtado station1 = new Station_213170554_AriasHurtado(1, "Usach", 't', 5);
        Station_213170554_AriasHurtado station2 = new Station_213170554_AriasHurtado(2, "Estacion Central", 'r', 10);
        Station_213170554_AriasHurtado station3 = new Station_213170554_AriasHurtado(3, "ULA", 'r', 15);
        Station_213170554_AriasHurtado station4 = new Station_213170554_AriasHurtado(4, "republica", 'c', 5);
        Station_213170554_AriasHurtado station5 = new Station_213170554_AriasHurtado(5, "los heroes", 'r', 10);
        Station_213170554_AriasHurtado station6 = new Station_213170554_AriasHurtado(6, "la moneda", 't', 15);

        Section_21317055_AriasHurtado section1 = new Section_21317055_AriasHurtado(station1, station2, 3, 8);
        Section_21317055_AriasHurtado section2 = new Section_21317055_AriasHurtado(station2, station3, 4, 9);
        Section_21317055_AriasHurtado section3 = new Section_21317055_AriasHurtado(station3, station4, 5, 10);
        Section_21317055_AriasHurtado section4 = new Section_21317055_AriasHurtado(station4, station5, 6, 11);
        Section_21317055_AriasHurtado section5 = new Section_21317055_AriasHurtado(station5, station6, 7, 12);

        ArrayList<Section_21317055_AriasHurtado> secciones = new ArrayList<>();
        Line_21317055_AriasHurtado line1 = new Line_21317055_AriasHurtado(1, "L1", "UIC-60", secciones);
        line1.addSection(section1);
        line1.addSection(section2);
        line1.addSection(section3);
        line1.addSection(section4);
        line1.addSection(section5);

        PassangerCar_21317055_AriasHurtado pcar1 = new PassangerCar_21317055_AriasHurtado(1, 6, "atom", "creator", 't');
        PassangerCar_21317055_AriasHurtado pcar2 = new PassangerCar_21317055_AriasHurtado(2, 7, "atom", "creator", 'c');
        PassangerCar_21317055_AriasHurtado pcar3 = new PassangerCar_21317055_AriasHurtado(3, 8, "atom", "creator", 'c');
        PassangerCar_21317055_AriasHurtado pcar4 = new PassangerCar_21317055_AriasHurtado(4, 9, "atom", "creator", 'c');
        PassangerCar_21317055_AriasHurtado pcar5 = new PassangerCar_21317055_AriasHurtado(5, 10, "atom", "creator", 't');

        ArrayList<PassangerCar_21317055_AriasHurtado> carList = new ArrayList<>();
        Train_21317055_AriasHurtado train1 = new Train_21317055_AriasHurtado(1, "atom",  10, 5, carList);

        train1.addCar(pcar1);
        train1.addCar(pcar2);
        train1.addCar(pcar3);
        train1.addCar(pcar4);
        train1.addCar(pcar5);

        Driver_21317055_AriasHurtado driver1 = new Driver_21317055_AriasHurtado(1, "charmander", "atom");
        Driver_21317055_AriasHurtado driver2= new Driver_21317055_AriasHurtado(2, "squirtle", "atom");
        Driver_21317055_AriasHurtado driver3 = new Driver_21317055_AriasHurtado(3, "bulbasaur", "atom");

        ArrayList<Line_21317055_AriasHurtado> lines = new ArrayList<>();
        ArrayList<Train_21317055_AriasHurtado> trains = new ArrayList<>();
        ArrayList<Driver_21317055_AriasHurtado> drivers = new ArrayList<>();
        ArrayList<pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado>> assignedTrains = new ArrayList<>();
        ArrayList<pairTrainDriver> assignedDrivers = new ArrayList<>();

        Subway_21317055_AriasHurtado subway1= new Subway_21317055_AriasHurtado(1, "metro", lines, trains, drivers, assignedTrains, assignedDrivers);
        lines.add(line1);
        trains.add(train1);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        subway1.addLine(lines);
        subway1.addTrains(trains);
        subway1.addDrivers(drivers);
        subway1.assignTrainToLine(train1, line1);
    }

    public static void optionModify(Scanner scanner) {
        int optionModify;
        do {
            System.out.println("MODIFICAR METRO");
            System.out.println("1-Acceder al metro");
            System.out.println("2-Acceder a las lineas");
            System.out.println("3-Acceder a los trenes");
            System.out.println("4-Acceder a los conductores");
            System.out.println("5-Volver");
            optionModify = scanner.nextInt();
            switch (optionModify) {
                case 1:
                    optionModifySubway(scanner);
                    break;
                case 2:
                    optionModifyLines(scanner);
                    break;
                case 3:
                    optionModifyTrains(scanner);
                    break;
                case 4:
                    optionModifyDrivers(scanner);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (optionModify != 5);
    }

    public static void optionModifySubway(Scanner scanner){
        int optionModifySubway;
        optionModifySubway = scanner.nextInt();
        do {
            System.out.println("MODIFICAR subway");
            System.out.println("1-Añadir lineas");
            System.out.println("2-Añadir trenes");
            System.out.println("3-Añadir a conductores");
            System.out.println("4-Asignar tren a lineas");
            System.out.println("5-Asignar conductores a trenes");
            System.out.println("6-Donde esta el tren");
            System.out.println("7-Ruta restante");
            System.out.println("8-Volver");
            System.out.println("Porfavor, ingrese una de las opciones");
            switch (optionModifySubway){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    break;

            }
        }while(optionModifySubway != 0);
    }

    public static void optionModifyLines(Scanner scanner){}

    public static void optionModifyTrains(Scanner scanner){}

    public static void optionModifyDrivers(Scanner scanner){}


    public static void optionView(){}
}



