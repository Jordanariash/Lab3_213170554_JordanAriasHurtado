package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;
    private ArrayList<Line_21317055_AriasHurtado> allLines = new ArrayList<Line_21317055_AriasHurtado>();
    private ArrayList<Train_21317055_AriasHurtado> allTrains = new ArrayList<Train_21317055_AriasHurtado>();
    private ArrayList<Driver_21317055_AriasHurtado> allDrivers = new ArrayList<Driver_21317055_AriasHurtado>();

    public Menu_21317055_AriasHurtado() {
        menuLoad();
    }

    //listo
    public void menuLoad() {
        scanner = new Scanner(System.in);
        subway = new Subway_21317055_AriasHurtado(1, "Metro de santiago");
        int option;
        do{
            System.out.println("------------------- Sistema Metro - Cargar informacion del sistema de metro -------------------");
            System.out.println("Opciones: ");
            System.out.println("1. Creacion de una linea de metro basica (cargar archivo lineas.txt)");
            System.out.println("2. Definicion de trenes con distintos numero de carros (cargar archivo trenes.txt)");
            System.out.println("3. Conductores asignados a una Linea (cargar archivo conductores.txt)");
            System.out.println("4. Acceder al Subway");
            System.out.println("5. Retorno al menu de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    try {
                        ArrayList<Line_21317055_AriasHurtado> lines = LineReader.readLines("ExampleLines.txt");
                        allLines = lines;
                        subway.addLine(lines);
                        System.out.println("Lineas cargadas correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<Train_21317055_AriasHurtado> trains = TrainReader.readTrains("ExampleTrains.txt");
                        allTrains = trains;
                        subway.addTrain(trains);
                        System.out.println("Trenes cargados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ArrayList<Driver_21317055_AriasHurtado> drivers = DriverReader.readDrivers("ExampleDrivers.txt");
                        allDrivers = drivers;
                        subway.addDriver(drivers);
                        System.out.println("Conductores cargados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 4:
                    menuView();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 5);
    }

    //listo
    public void menuView(){
        int option;
        do {
            System.out.println("------------------- Sistema Metro - Visualización del estado actual del sistema de metros  -------------------");
            System.out.println("1. Consultar el estado actual de la red de metro.");
            System.out.println("2. Modificar la red de metro.");
            System.out.println("3. Retorno al menú de Inicio");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    menuConsult();
                    break;
                case 2:
                    menuModify();
                    break;
                default:
                    break;
            }
        }while (option != 3) ;
    }

    //listo (pendientes ultimas funciones subway)
    public void menuConsult() {
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
            System.out.println("5. Train - fetchCapacity: entrega la capacidad máxima de pasajeros de un tren.");
            System.out.println("6. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del día.");
            System.out.println("7. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
            System.out.println("8. Visualizar metro");
            System.out.println("9. Volver");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Indique el id de la linea que quiere obtener el largo");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < subway.getLines().size(); i++) {
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("La linea " + select + " tiene un largo de: " + subway.getLineById(select).lineLenght());
                    break;
                case 2:
                    System.out.println("Indique el id de la linea de la que quiere obtener el largo entre 2 estaciones");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < subway.getLines().size(); i++) {
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
                    System.out.println("El largo entre " + subway.getLineById(select).getStationById(subselect1).getNameStation() + " y " + subway.getLineById(select).getStationById(subselect2).getNameStation() + " es de: " + subway.getLineById(select).lineSectionLenght(subway.getLineById(select).getStationById(subselect1), subway.getLineById(select).getStationById(subselect2)));
                    break;
                case 3:
                    System.out.println("Indique el id de la linea que quiere obtener el costo");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < subway.getLines().size(); i++) {
                        System.out.println("Linea " + subway.getLines().get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("La linea " + select + " tiene un largo de: " + subway.getLineById(select).lineCost());
                    break;
                case 4:
                    System.out.println("Indique el id de la linea de la que quiere obtener el costo entre 2 estaciones");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < subway.getLines().size(); i++) {
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
                    System.out.println("El costo entre " + subway.getLineById(select).getStationById(subselect1).getNameStation() + " y " + subway.getLineById(select).getStationById(subselect2).getNameStation() + " es de: " + subway.getLineById(select).lineSectionCost(subway.getLineById(select).getStationById(subselect1), subway.getLineById(select).getStationById(subselect2)));
                    break;
                case 5:
                    System.out.println("Indique el id del tren que quiere obtener la capacidad maxima de pasajeros");
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < subway.getTrains().size(); i++) {
                        System.out.println(subway.getTrains().get(i).getIdTrain() + ".Tren con vagones modelo " + subway.getTrains().get(i).getCarList().get(0).getModel());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("El tren " + select + " tiene una capacidad maxima de " + subway.getTrainById(select).fetchCapacity() + " pasajeros");
                    break;
                case 6:
                    System.out.println("where is train pendiente");
                    break;
                case 7:
                    System.out.println("train path pendiente");
                    break;
                case 8:
                    subway.myToString();
                    break;
                default:
                    break;
            }
        } while (option != 9);
    }


    public void menuModify(){
        int option;
        int select;
        int suboption;
        long time;
        do{
            //funciona
            System.out.println("1. Crear linea nueva");

            //funciona
            System.out.println("2. Añadir estacion a una linea");

            //funciona
            System.out.println("3. Consultar si una linea es valida para ingresar a la red de metro");

            //funciona
            System.out.println("4. Añadir lineas a la red de metro");

            //listo no probado
            System.out.println("5. Crear tren nuevo");

            //listo no probado
            System.out.println("6. Añadir vagones a un tren");

            //listo no probado
            System.out.println("7. Quitar vagones a un tren");

            //listo no probado
            System.out.println("8. Consultar si un tren es valido para ingresar a la red de metro");

            //listo no probado
            System.out.println("9. Añadir trenes a la red de metro");

            //listo no probado
            System.out.println("10. Ingresar nuevo conductor");

            System.out.println("11. Asignar tren a linea");

            System.out.println("12. Asignar conductor a tren");

            System.out.println("13. Volver");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    int userIdLine;
                    System.out.println("Ingrese el id de la nueva linea");
                    userIdLine = scanner.nextInt();
                    scanner.nextLine();

                    String userNameLine;
                    System.out.println("Ingrese el nombre de la nueva linea");
                    userNameLine = scanner.nextLine();

                    String userRail;
                    System.out.println("Ingrese el tipo de riel de la nueva linea");
                    userRail = scanner.nextLine();

                    ArrayList<Section_21317055_AriasHurtado> userSections = new ArrayList<>();
                    Line_21317055_AriasHurtado userLine = new Line_21317055_AriasHurtado(userIdLine, userNameLine, userRail, userSections);
                    System.out.println("Se ha creado una nueva linea con exito");
                    allLines.add(userLine);
                    break;
                case 2:
                    System.out.println("Indique la linea a la que quiere añadir estaciones");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < allLines.size(); i++) {
                        System.out.println(i+1 +".Linea " + allLines.get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();

                    int userIdStation;
                    String userNameStation;
                    int userStopTime;
                    char userStationType;

                    int userDistance;
                    int userCost;

                    do{
                        System.out.println("1.Añadir estacion a la linea");
                        System.out.println("2.Volver");
                        suboption = scanner.nextInt();
                        scanner.nextLine();
                        switch (suboption) {
                            case 1:
                                //test
                                if(allLines.get(select).getSections().isEmpty()){
                                    System.out.println("Ingrese el id");
                                    userIdStation = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el nombre");
                                    userNameStation = scanner.nextLine();

                                    System.out.println("Ingrese el tiempo de parada");
                                    userStopTime = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el tipo de parada");
                                    System.out.println("r.Recorrido");
                                    System.out.println("c.Combinacion");
                                    System.out.println("m.Mantencion");
                                    System.out.println("t.Terminal");
                                    userStationType = scanner.nextLine().charAt(0);

                                    Station_213170554_AriasHurtado userStation = new Station_213170554_AriasHurtado(userIdStation, userNameStation, userStationType, userStopTime);

                                    System.out.println("Ingrese el id de la siguiente");
                                    userIdStation = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el nombre de la siguiente estacion");
                                    userNameStation = scanner.nextLine();

                                    System.out.println("Ingrese el tiempo de parada de la siguiente");
                                    userStopTime = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el tipo de parada de la siguiente");
                                    System.out.println("Ingrese el tipo de parada");
                                    System.out.println("r.Recorrido");
                                    System.out.println("c.Combinacion");
                                    System.out.println("m.Mantencion");
                                    System.out.println("t.Terminal");
                                    userStationType = scanner.nextLine().charAt(0);

                                    Station_213170554_AriasHurtado userStation2 = new Station_213170554_AriasHurtado(userIdStation, userNameStation, userStationType, userStopTime);

                                    System.out.println("Ingrese la distancia entre las estaciones");
                                    userDistance = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el costo entre las estaciones");
                                    userCost = scanner.nextInt();
                                    scanner.nextLine();

                                    Section_21317055_AriasHurtado userSection = new Section_21317055_AriasHurtado(userStation, userStation2, userDistance, userCost);
                                    allLines.get(select).getSections().add(userSection);

                                }else{
                                    System.out.println("Ingrese el id de la siguiente estacion");
                                    userIdStation = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el nombre de la siguiente estacion");
                                    userNameStation = scanner.nextLine();

                                    System.out.println("Ingrese el tiempo de parada de la siguiente estacion");
                                    userStopTime = scanner.nextInt();
                                    scanner.nextLine();


                                    System.out.println("Ingrese el tipo de parada de la siguiente estacion");
                                    System.out.println("r.Recorrido");
                                    System.out.println("c.Combinacion");
                                    System.out.println("m.Mantencion");
                                    System.out.println("t.Terminal");
                                    userStationType = scanner.nextLine().charAt(0);

                                    Station_213170554_AriasHurtado userStation = new Station_213170554_AriasHurtado(userIdStation, userNameStation, userStationType, userStopTime);

                                    System.out.println("Ingrese la distancia entre las estaciones");
                                    userDistance = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.println("Ingrese el costo entre las estaciones");
                                    userCost = scanner.nextInt();
                                    scanner.nextLine();

                                    Section_21317055_AriasHurtado userSection = new Section_21317055_AriasHurtado(allLines.get(select).getSections().get(allLines.get(select).getSections().size()-1).getStation2(),userStation,userDistance,userCost);
                                    //test
                                    allLines.get(select).getSections().add(userSection);
                                }
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida");
                        }
                    }while(suboption != 2);
                    break;
                case 3:
                    System.out.println("Indique el id de la linea que quiere validar");
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < allLines.size(); i++) {
                        System.out.println(i+".Linea " + allLines.get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();

                    if(allLines.get(select).isLine()){
                        System.out.println("La linea se puede añadir");
                    }else{
                        System.out.println("La linea no se puede añadir");
                    }
                    break;
                case 4:
                    System.out.println("Lineas disponibles para añadir/actualizar");
                    for (int i = 0; i < allLines.size(); i++) {
                        System.out.println(i+".Linea " + allLines.get(i).getIdLine());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(allLines.get(select).isLine()){
                        ArrayList<Line_21317055_AriasHurtado> auxAllLine = new ArrayList<>();
                        auxAllLine.add(allLines.get(select));
                        subway.addLine(auxAllLine);
                        System.out.println("La linea se añadio");
                    }else{
                        System.out.println("La linea no se pudo añadir");
                    }
                    break;
                case 5:
                    int userIdTrain;
                    System.out.println("Ingrese el id del nuevo tren");
                    userIdTrain = scanner.nextInt();
                    scanner.nextLine();

                    String userTrainMaker;
                    System.out.println("Ingrese la manufacturadora del nuevo tren");
                    userTrainMaker = scanner.nextLine();

                    int userSpeed;
                    System.out.println("Ingrese la velocidad del nuevo tren");
                    userSpeed = scanner.nextInt();

                    int userStationStayTime;
                    System.out.println("Ingrese el tiempo de parada por estacion del nuevo tren");
                    userStationStayTime = scanner.nextInt();

                    ArrayList<PassangerCar_21317055_AriasHurtado> userPcars = new ArrayList<>();

                    Train_21317055_AriasHurtado userTrain = new Train_21317055_AriasHurtado(userIdTrain, userTrainMaker, userSpeed, userStationStayTime, userPcars);
                    System.out.println("Se ha creado el tren con exito");
                    allTrains.add(userTrain);
                    break;
                case 6:
                    System.out.println("Indique el tren del que quiere linea que quiere añadir un carro");
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Indique el id del nuevo vagon:");
                    int userId;
                    userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Indique capacidad del nuevo vagon:");
                    int userCapacity;
                    userCapacity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Indique el modelo del nuevo vagon:");
                    String userModel;
                    userModel = scanner.nextLine();

                    System.out.println("Indique si el nuevo vagon es de tipo central (c), o terminal (t):");
                    char userCarType;
                    userCarType = scanner.nextLine().charAt(0);

                    PassangerCar_21317055_AriasHurtado userPcar = new PassangerCar_21317055_AriasHurtado(userId, userCapacity, userModel, allTrains.get(select).getTrainMaker(),userCarType);

                    if(allTrains.get(select).getCarList().isEmpty()){
                        allTrains.get(select).addCar(0, userPcar);
                        System.out.println("Se ha añadido el vagon al tren");
                    }else{
                        System.out.println("Indique la posicion en la que quiere agregar el vagon:");
                        for (int i = 0; i < allTrains.get(select).getCarList().size(); i++) {
                            System.out.println(i+".Vagon "+ allTrains.get(select).getCarList().get(i).getIdPassangerCar()+ " modelo " +allTrains.get(select).getCarList().get(i).getModel());
                        }
                        suboption = scanner.nextInt();
                        scanner.nextLine();
                        allTrains.get(select).addCar(suboption, userPcar);
                        allTrains.get(select).showInfoTrain();
                        System.out.println("Se ha añadido el vagon al tren");
                    }



                    break;
                case 7:
                    System.out.println("Indique el tren del que quiere linea que quiere eliminar un carro");
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(allTrains.get(select).getCarList().isEmpty()){
                        System.out.println("No hay vagones disponibles");
                    }else{
                        System.out.println("Indique la posicion en la que quiere remover el vagon:");
                        for (int i = 0; i < allTrains.get(select).getCarList().size(); i++) {
                            System.out.println(i+"."+ allTrains.get(select).getCarList().get(i).getIdPassangerCar());
                        }
                        suboption = scanner.nextInt();
                        scanner.nextLine();
                        allTrains.get(select).removeCar(suboption);
                        System.out.println("Se ha removido el vagon con exito");
                    }
                    break;
                case 8:
                    System.out.println("Indique el id del tren que quiere validar");
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();

                    if(allTrains.get(select).isTrain(allTrains.get(select))){
                        System.out.println("El tren se puede añadir");
                    }else{
                        System.out.println("El tren no se puede añadir");
                    }
                    break;
                case 9:
                    System.out.println("Trenes disponibles para añadir/actualizar");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    if(allTrains.get(select).isTrain(allTrains.get(select))){
                        ArrayList<Train_21317055_AriasHurtado> auxAllTrain = new ArrayList<>();
                        auxAllTrain.add(allTrains.get(select));
                        subway.addTrain(auxAllTrain);
                        System.out.println("El tren se añadio");
                    }else{
                        System.out.println("El tren no se pudo añadir");
                    }
                    break;
                case 10:
                    int userIdDriver;
                    System.out.println("Ingrese el id del nuevo conductor");
                    userIdDriver = scanner.nextInt();
                    scanner.nextLine();

                    String userNameDriver;
                    System.out.println("Ingrese el nombre del nuevo conductor");
                    userNameDriver = scanner.nextLine();

                    String userTrainMakerDriver;
                    System.out.println("Ingrese que tipo de tren puede manejar el conductor (Manufacturadora de tren)");
                    userTrainMakerDriver = scanner.nextLine();

                    Driver_21317055_AriasHurtado userDriver = new Driver_21317055_AriasHurtado(userIdDriver, userNameDriver, userTrainMakerDriver);
                    allDrivers.add(userDriver);
                    break;
                case 11:
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la hora en formato UNIX para consultar donde esta el tren");
                    time = scanner.nextLong();
                    scanner.nextLine();
                    Date date = new Date(time);
                    System.out.println("El tren a las "+" esta en " + subway.whereIsTrain(subway.getTrainById(select), date).getNameStation());
                    break;
                case 12:
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese la hora en formato UNIX para consultar las estaciones restantes por recorrer del tren");
                    time = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Las estaciones que le quedan por recorrer al tren");
                    Date date2 = new Date(time);
                    for(int i =0; i<subway.trainPath(subway.getTrainById(select), date2).size(); i++){
                        System.out.println(subway.trainPath(subway.getTrainById(select), date2).get(i).getNameStation());
                    }
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 13);
    }

}



