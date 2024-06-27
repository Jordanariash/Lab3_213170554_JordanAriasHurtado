package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;

    public Menu_21317055_AriasHurtado() {
        scanner = new Scanner(System.in);
    }

    public void menuLoad() {
        subway = new Subway_21317055_AriasHurtado(1, "Metro de santiago");
        int option;
        do{
            System.out.println("------------------- Sistema Metro - Cargar informacion del sistema de metro -------------------");
            System.out.println("Opciones: ");
            System.out.println("1. Creacion de una linea de metro basica (cargar archivo lineas.txt)");
            System.out.println("2. Definicion de trenes con distintos numero de carros (cargar archivo trenes.txt)");
            System.out.println("3. Conductores asignados a una Linea (cargar archivo conductores.txt)");
            System.out.println("4. Modificar Subway");
            System.out.println("5. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    try {
                        ArrayList<Line_21317055_AriasHurtado> lines = LineReader.readLines("ExampleLines.txt");
                        subway.addLine(lines);
                        System.out.println("Lineas cargadas correctamente.");
                        subway.myToString();
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<Train_21317055_AriasHurtado> trains = TrainReader.readTrains("ExampleTrains.txt");
                        subway.addTrain(trains);
                        System.out.println("Trenes cargados correctamente.");
                        subway.myToString();
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ArrayList<Driver_21317055_AriasHurtado> drivers = DriverReader.readDrivers("ExampleDrivers.txt");
                        subway.addDriver(drivers);
                        System.out.println("Conductores cargados correctamente.");
                        subway.myToString();
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 4:
                    menuView();
                    break;
                default:
                    break;
            }
        }while(option != 5);
    }




    public void menuView(){
        int option;
        do {
            System.out.println("------------------- Sistema Metro - Visualización del estado actual del sistema de metros  -------------------");
            System.out.println("1. Desplegar en pantalla el estado actual de la red de metros.");
            System.out.println("2. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    menuInteract();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while (option != 2) ;
    }





    public void menuInteract() {
        int option;
        int select;
        int subselect1;
        int subselect2;
        do {
            System.out.println("------------------- Sistema Metro - Interactuar con el sistema de metros -------------------");
            System.out.println("1. lineLength: obtener el largo total de una línea.");
            System.out.println("2. lineSectionLength: determinar el tracto entre una estación origen y final.");
            System.out.println("3. lineCost: determinar el costo total de recorrer una línea.");
            System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estación origen y final.");
            System.out.println("5. isLine: verificar si una línea cumple con las restricciones especificadas.");
            System.out.println("6. Train - addCar: añade un carro de pasajeros a un tren en la posición establecida.");
            System.out.println("7. Train - removeCar: remueve un carro de pasajeros de un tren en la posición establecida");
            System.out.println("8. Train - isTrain: verifica si un tren cumple con las especificaciones de los carros de pasajeros.");
            System.out.println("9. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
            System.out.println("10. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
            System.out.println("11. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
            System.out.println("12. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Indique el id de la linea que quiere obtener el largo");
                    System.out.println("Lineas disponibles");
                    for (int i=0; i<subway.getLines().size(); i++){
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("La linea "+ select + " tiene un largo de: " + subway.getLineById(select).lineLenght());
                    break;
                case 2:
                    System.out.println("Indique el id de la linea de la que quiere obtener el largo entre 2 estaciones");
                    System.out.println("Lineas disponibles");
                    for (int i=0; i<subway.getLines().size(); i++){
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Indique el id de la primera estacion");
                    System.out.println("Estaciones disponibles:");
                    subway.getLineById(select).showStations();
                    subselect1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Indique el id de la segunda estacion");
                    System.out.println("Estaciones disponibles:");
                    subway.getLineById(select).showStations();
                    subselect2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entre " + subway.getLineById(select).getStationById(subselect1).getNameStation() + " y " + subway.getLineById(select).getStationById(subselect2).getNameStation()+ " hay un largo de: " + subway.getLineById(select).lineSectionCost(subway.getLineById(select).getStationById(subselect1), subway.getLineById(select).getStationById(subselect2)));
                    break;
                case 3:
                    System.out.println("Indique el id de la linea que quiere obtener el costo");
                    System.out.println("Lineas disponibles");
                    for (int i=0; i<subway.getLines().size(); i++){
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("La linea "+ select + " tiene un largo de: " + subway.getLineById(select).lineCost());
                    break;
                case 4:
                    System.out.println("Indique el id de la linea de la que quiere obtener el costo entre 2 estaciones");
                    System.out.println("Lineas disponibles");
                    for (int i=0; i<subway.getLines().size(); i++){
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Indique el id de la primera estacion");
                    System.out.println("Estaciones disponibles:");
                    subway.getLineById(select).showStations();
                    subselect1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Indique el id de la segunda estacion");
                    System.out.println("Estaciones disponibles:");
                    subway.getLineById(select).showStations();
                    subselect2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entre " + subway.getLineById(select).getStationById(subselect1).getNameStation() + " y " + subway.getLineById(select).getStationById(subselect2).getNameStation()+ " hay un costo de: " + subway.getLineById(select).lineSectionCost(subway.getLineById(select).getStationById(subselect1), subway.getLineById(select).getStationById(subselect2)));
                    break;
                case 5:
                    System.out.println("Indique el id de la linea que quiere validar");
                    System.out.println("Lineas disponibles");
                    for (int i=0; i<subway.getLines().size(); i++){
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(subway.getLineById(select).isLine()){
                        System.out.println("la linea " + subway.getLineById(select) + "es valida");
                    }else{
                        System.out.println("la linea " + subway.getLineById(select) + "no es valida");
                    }
                    break;
                case 6:
                    System.out.println("Indique el id del tren al que quiere añadir un vagon");
                    System.out.println("Trenes disponibles");
                    for (int i=0; i<subway.getTrains().size(); i++){
                        System.out.println("Tren " + subway.getTrains().get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Procedera a ingresar los datos del vagon que quiere añadir");

                    int idPassangerCar;
                    System.out.println("Ingrese el id del vagon");
                    idPassangerCar = scanner.nextInt();
                    scanner.nextLine();

                    int passangerCapacity;
                    System.out.println("Ingrese la capacidad del vagon");
                    passangerCapacity = scanner.nextInt();
                    scanner.nextLine();

                    String model;
                    System.out.println("Ingrese el modelo del vagon");
                    model = scanner.nextLine();
                    scanner.nextLine();

                    String trainMaker;
                    System.out.println("Ingrese la manufacturadora del vagon");
                    trainMaker = scanner.nextLine();
                    scanner.nextLine();

                    char carType;
                    System.out.println("Ingrese si el vagon es de tipo terminal (t), o central(c)");
                    carType = scanner.nextLine().charAt(0);
                    scanner.nextLine();
                    PassangerCar_21317055_AriasHurtado userPcar = new PassangerCar_21317055_AriasHurtado(idPassangerCar, passangerCapacity, model, trainMaker, carType);
                    System.out.println("Ahora ingrese la posicion en la que quiere ingresar el vagon");
                    System.out.println("Posiciones disponibles");
                    for (int i=0; i<subway.getTrains().get(select).getCarList().size(); i++){
                        System.out.println("Posicion" + subway.getTrains().get(select).getCarList().get(i).getIdPassangerCar());
                    }
                    subselect1 = scanner.nextInt();
                    scanner.nextLine();
                    subway.getTrains().get(select).addCar(subselect1, userPcar);


                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default:
                    break;
            }
        } while (option != 12);
    }

    public static void main(String[] args) {
        Main_21317055_AriasHurtado.main(new String[0]);
    }
}



