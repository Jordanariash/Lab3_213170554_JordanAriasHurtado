package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

import java.util.InputMismatchException; //para que al ingresar algo que no es, reintentar


//cambiar estructura de allLines, y separarlo de subway
public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;
    private ArrayList<Line_21317055_AriasHurtado> allLines = new ArrayList<Line_21317055_AriasHurtado>();
    private ArrayList<Train_21317055_AriasHurtado> allTrains = new ArrayList<Train_21317055_AriasHurtado>();
    private ArrayList<Station_213170554_AriasHurtado> allStations = new ArrayList<Station_213170554_AriasHurtado>();
    private ArrayList<PassangerCar_21317055_AriasHurtado> reservePcars = new ArrayList<PassangerCar_21317055_AriasHurtado>();

    public Menu_21317055_AriasHurtado() {
        menuLoad();
    }

    //listo
    public void menuLoad() {
        scanner = new Scanner(System.in);
        subway = new Subway_21317055_AriasHurtado(1, "Metro de santiago");
        int option = 0;
        do{
            System.out.println("------------------- Sistema Metro - Cargar informacion del sistema de metro -------------------");
            System.out.println("Opciones: ");
            System.out.println("1. Creacion de una linea de metro basica (cargar archivo lineas.txt)");
            System.out.println("2. Definicion de trenes con distintos numero de carros (cargar archivo trenes.txt)");
            System.out.println("3. Conductores asignados a una Linea (cargar archivo conductores.txt)");
            System.out.println("4. Acceder al Subway");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }

            switch (option) {
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
                        subway.addDriver(drivers);
                        System.out.println("Conductores cargados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 4:
                    menuView();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(option != 5);
    }

    //listo
    public void menuView(){
        int option = 0;
        do {
            System.out.println("------------------- Sistema Metro - Visualización del estado actual del sistema de metros  -------------------");
            System.out.println("1. Consultar el estado actual de la red de metro.");
            System.out.println("2. Modificar la red de metro.");
            System.out.println("3. Retorno al menú de Inicio");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    menuConsult();
                    break;
                case 2:
                    menuModify();
                    break;
                case 3:
                    break;
                default:
            }
        }while (option != 3) ;
    }

    //listo no probado
    public void menuConsult() {
        int option = 0;
        int select;
        int subselect1;
        int subselect2;
        long time;
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
            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                //listo
                case 1:
                    if(!subway.getLines().isEmpty()) {
                        System.out.println("Seleccione la linea que quiere obtener el largo");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < subway.getLines().size(); i++) {
                            System.out.println(i + 1 + ".Linea " + subway.getLines().get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getLines().size()) {
                                    System.out.println("La línea " + select + " tiene un largo de: " + subway.getLines().get(aux).lineLenght());
                                    break;
                                } else {
                                    System.out.println("Línea no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas disponibles en el metro");
                    }
                    break;
                case 2:
                    //listo
                    if(!subway.getLines().isEmpty()) {
                        System.out.println("Seleccione la linea que quiere obtener el largo entre 2 estaciones");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < subway.getLines().size(); i++) {
                            System.out.println(i + 1 + ".Linea " + subway.getLines().get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getLines().size()) {
                                    while (true) {
                                        System.out.println("Indique la primera estacion");
                                        System.out.println("Estaciones disponibles:");
                                        subway.getLines().get(aux).showStations();
                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                        try {
                                            subselect1 = scanner.nextInt();
                                            int aux2 = subselect1 - 1;
                                            if (aux2 >= 0 && aux2 <= subway.getLines().get(aux).getSections().size()) {
                                                while (true) {
                                                    System.out.println("Indique la segunda estacion");
                                                    System.out.println("Estaciones disponibles:");
                                                    subway.getLines().get(aux).showStations();
                                                    System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                                    try {
                                                        subselect2 = scanner.nextInt();
                                                        int aux3 = subselect2 - 1;
                                                        if (aux3 >= 0 && aux3 <= subway.getLines().get(aux).getSections().size()) {
                                                            System.out.println("El largo entre " + subway.getLines().get(aux).getStationByPosition(aux2).getNameStation() + " y " + subway.getLines().get(aux).getStationByPosition(aux3).getNameStation() + " es de: " + subway.getLines().get(aux).lineSectionLenght(subway.getLines().get(aux).getStationByPosition(aux2), subway.getLines().get(aux).getStationByPosition(aux3)));
                                                            break;
                                                        } else {
                                                            System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                        scanner.nextLine();
                                                    }

                                                }
                                                break;
                                            } else {
                                                System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Línea no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas disponibles en el metro");
                    }
                    break;
                case 3:
                    //listo
                    if(!subway.getLines().isEmpty()) {
                        System.out.println("Seleccione la linea que quiere obtener el costo");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < subway.getLines().size(); i++) {
                            System.out.println(i + 1 + ".Linea " + subway.getLines().get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getLines().size()) {
                                    System.out.println("La línea " + select + " tiene un largo de: " + subway.getLines().get(aux).lineCost());
                                    break;
                                } else {
                                    System.out.println("Línea no disponible. Intente nuevamente:");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                            System.out.println("No hay lineas disponibles en el metro");
                        }
                    break;
                case 4:
                    //listo
                    if(!subway.getLines().isEmpty()) {
                        System.out.println("Seleccione la linea que quiere obtener el costo entre 2 estaciones");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < subway.getLines().size(); i++) {
                            System.out.println(i+1 +".Linea " + subway.getLines().get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getLines().size()) {
                                    while (true) {
                                        System.out.println("Indique la primera estacion");
                                        System.out.println("Estaciones disponibles:");
                                        subway.getLines().get(aux).showStations();
                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                        try {
                                            subselect1 = scanner.nextInt();
                                            int aux2 = subselect1 - 1;
                                            if (aux2 >= 0 && aux2 <= subway.getLines().get(aux).getSections().size()) {
                                                while (true){
                                                    System.out.println("Indique la segunda estacion");
                                                    System.out.println("Estaciones disponibles:");
                                                    subway.getLines().get(aux).showStations();
                                                    System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                                    try {
                                                        subselect2 = scanner.nextInt();
                                                        int aux3 = subselect2 - 1;
                                                        if (aux3 >= 0 && aux3 <= subway.getLines().get(aux).getSections().size()) {
                                                            System.out.println("El largo entre " + subway.getLines().get(aux).getStationByPosition(aux2).getNameStation() + " y " +subway.getLines().get(aux).getStationByPosition(aux3).getNameStation() + " es de: " + subway.getLines().get(aux).lineSectionCost(subway.getLines().get(aux).getStationByPosition(aux2), subway.getLines().get(aux).getStationByPosition(aux3)));
                                                            break;
                                                        }else{
                                                            System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }catch (InputMismatchException e){
                                                        System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                        scanner.nextLine();
                                                    }

                                                }
                                                break;
                                            }else{
                                                System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Línea no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas disponibles en el metro");
                    }
                    break;
                case 5:
                    if(!subway.getTrains().isEmpty()) {
                        System.out.println("Indique el id del tren que quiere obtener la capacidad maxima de pasajeros");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren marca " + subway.getTrains().get(i).getTrainMaker());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getTrains().size()) {
                                    System.out.println("El tren tiene una capacidad maxima de " + subway.getTrains().get(aux).fetchCapacity() + " pasajeros");
                                    break;
                                } else {
                                    System.out.println("Tren no disponible. Intente nuevamente:");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay trenes disponibles en el metro");
                    }
                    break;
                case 6:
                    if(!subway.getTrains().isEmpty()) {
                        System.out.println("Seleccione el tren del que quiere saber su ubicacion");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren marca " + subway.getTrains().get(i).getTrainMaker());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if(subway.getTrains().get(aux).getArriveStation() != null && subway.getTrains().get(aux).getDepartureStation() != null && subway.getTrains().get(aux).getDepartureTime() != null) {
                                    if (aux >= 0 && aux < subway.getTrains().size()) {
                                        System.out.println("Ingrese una hora en formato UNIX y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                time = scanner.nextLong();
                                                Date date = new Date(time);
                                                System.out.println("El tren " + subway.getTrainById(select).getTrainMaker() + " esta en la estacion: " + subway.whereIsTrain(subway.getTrainById(aux), date).getNameStation());
                                                break;
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es una fecha en formato UNIX. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                    } else {
                                        System.out.println("Tren no disponible. Intente nuevamente:");
                                    }
                                    break;
                                }else {
                                    System.out.println("El Tren no tiene las condiciones necesarias, elija otro :");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay trenes disponibles en el metro");
                    }
                    break;
                case 7:
                    if(!subway.getTrains().isEmpty()) {
                        System.out.println("Seleccione el tren del que quiere saber su recorrido");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren marca " + subway.getTrains().get(i).getTrainMaker());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if(subway.getTrains().get(aux).getArriveStation() != null && subway.getTrains().get(aux).getDepartureStation() != null && subway.getTrains().get(aux).getDepartureTime() != null) {
                                    if (aux >= 0 && aux < subway.getTrains().size()) {
                                        System.out.println("Ingrese una hora en formato UNIX y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                time = scanner.nextLong();
                                                Date date = new Date(time);
                                                for(int i =0; i<subway.trainPath(subway.getTrainById(aux), date).size(); i++){
                                                    System.out.println(subway.trainPath(subway.getTrainById(aux), date).get(i).getNameStation());
                                                }
                                                break;
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es una fecha en formato UNIX. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                    } else {
                                        System.out.println("Tren no disponible. Intente nuevamente:");
                                    }
                                    break;
                                }else {
                                    System.out.println("El Tren no tiene las condiciones necesarias, elija otro porfavor:");

                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay trenes disponibles en el metro");
                    }
                    break;
                case 8:
                    subway.myToString();
                    break;
                case 9:
                    System.out.println("Ha salido");
                    break;
                default:
                    break;
            }
        } while (option != 9);
    }


    public void menuModify(){
        int option = 0;
        int select;
        int suboption;
        do{
            System.out.println("1. Crear una linea nueva");
            System.out.println("2. Crear una estacion nueva");

            //problemas, cuando se cambia de allLines, se cambia de subway
            System.out.println("3. Añadir estacion a una linea");
            System.out.println("4. Consultar si una linea es valida para ingresar a la red de metro");
            System.out.println("5. Añadir lineas a la red de metro");
            System.out.println("6. Crear tren nuevo");
            System.out.println("7. Crear vagon nuevo");
            System.out.println("8. Añadir vagones a un tren");
            System.out.println("9. Quitar vagones a un tren");
            System.out.println("10. Consultar si un tren es valido para ingresar a la red de metro");
            System.out.println("11. Añadir trenes a la red de metro");
            System.out.println("12. Ingresar nuevo conductor");
            System.out.println("13. Asignar tren a linea");
            System.out.println("14. Asignar conductor a tren");
            System.out.println("15. Volver");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }
            switch (option) {
                case 1:
                    int userIdLine;
                    while (true) {
                        System.out.println("Ingrese el id de la nueva linea");
                        try {
                            userIdLine = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userNameLine = "";
                    System.out.println("Ingrese el nombre de la nueva linea");
                    while (userNameLine.isEmpty()) {
                        userNameLine = scanner.nextLine();
                        if (userNameLine.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
                        }
                    }

                    String userRail = "";
                    System.out.println("Ingrese el tipo de riel de la nueva linea");
                    while (userRail.isEmpty()) {
                        userRail = scanner.nextLine();
                        if (userRail.isEmpty()) {
                            System.out.println("El tipo de riel no puede estar vacio, intente nuevamente");
                        }
                    }

                    ArrayList<Section_21317055_AriasHurtado> userSections = new ArrayList<>();
                    Line_21317055_AriasHurtado userLine = new Line_21317055_AriasHurtado(userIdLine, userNameLine, userRail, userSections);
                    System.out.println("Se ha creado una nueva linea con exito");
                    allLines.add(userLine);
                    break;
                case 2:
                    System.out.println("Indique el id de la nueva estacion");
                    int userIdStation;
                    while (true) {
                        try {
                            userIdStation = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userNameStation = "";
                    System.out.println("Ingrese el nombre de la nueva estacion");
                    while (userNameStation.isEmpty()) {
                        userNameStation = scanner.nextLine();
                        if (userNameStation.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
                        }
                    }

                    System.out.println("Indique el tiempo de parada de la nueva estacion");
                    int userStationStopTime;
                    while (true) {
                        try {
                            userStationStopTime = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    char userStationType;
                    System.out.println("Seleccione el tipo de la nueva estacion");
                    System.out.println("r.Recorrido");
                    System.out.println("c.Combinacion");
                    System.out.println("m.Mantencion");
                    System.out.println("t.Terminal");
                    while (true) {
                        String input = scanner.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("El valor ingresado no puede estar vacío. Intente nuevamente: ");
                        } else {
                            userStationType = input.charAt(0);
                            if (userStationType == 'r' || userStationType == 'c' || userStationType == 'm' || userStationType == 't') {
                                break;
                            } else {
                                System.out.println("El valor ingresado no es un caracter válido. Intente nuevamente: ");
                            }
                        }
                    }
                    Station_213170554_AriasHurtado userStation = new Station_213170554_AriasHurtado(userIdStation, userNameStation, userStationType, userStationStopTime);
                    allStations.add(userStation);
                    System.out.println("Se ha creado la estacion");
                    break;
                case 3:
                    if (!allLines.isEmpty() && !allStations.isEmpty()) {
                        System.out.println("Seleccione la linea a la que quiere añadir estaciones");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + 1 + ".Linea " + allLines.get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allLines.size()) {
                                    //si la linea no tiene estaciones
                                    if (allLines.get(aux).getSections().isEmpty()) {
                                        if (allStations.size() < 2) {
                                            System.out.println("Se necesitan almenos 2 estaciones para formar una linea");
                                            break;
                                        } else {
                                            System.out.println("Estaciones disponibles");
                                            for (int i = 0; i < allStations.size(); i++) {
                                                System.out.println(i + 1 + ". " + allStations.get(i).getNameStation());
                                            }
                                            System.out.println("Ingrese la primera estacion y presione ENTER para continuar: ");
                                            while (true) {
                                                try {
                                                    suboption = scanner.nextInt();
                                                    int aux2 = suboption - 1;
                                                    if (aux2 >= 0 && aux2 < allStations.size()) {
                                                        Station_213170554_AriasHurtado station1 = allStations.get(aux2);
                                                        allStations.remove(aux2);
                                                        for (int i = 0; i < allStations.size(); i++) {
                                                            System.out.println(i + 1 + ". " + allStations.get(i).getNameStation());
                                                        }
                                                        System.out.println("Ingrese la segunda estacion y presione ENTER para continuar: ");
                                                        while (true) {
                                                            try {
                                                                suboption = scanner.nextInt();
                                                                int aux3 = suboption - 1;
                                                                if (aux3 >= 0 && aux2 < allStations.size()) {
                                                                    Station_213170554_AriasHurtado station2 = allStations.get(aux3);
                                                                    allStations.remove(aux3);
                                                                    System.out.println("Ingrese la distancia entre estaciones y presione ENTER para continuar: ");
                                                                    int distance;
                                                                    while (true) {
                                                                        try {
                                                                            select = scanner.nextInt();
                                                                            distance = select;
                                                                            break;
                                                                        } catch (InputMismatchException e) {
                                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                            scanner.nextLine();
                                                                        }
                                                                    }
                                                                    System.out.println("Ingrese el costo entre estacions y presione ENTER para continuar: ");
                                                                    int cost;
                                                                    while (true) {
                                                                        try {
                                                                            select = scanner.nextInt();
                                                                            cost = select;
                                                                            break;
                                                                        } catch (InputMismatchException e) {
                                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                            scanner.nextLine();
                                                                        }
                                                                    }
                                                                    try {
                                                                        Section_21317055_AriasHurtado newSection = new Section_21317055_AriasHurtado(station1, station2, distance, cost);
                                                                        subway.getLines().get(aux).showInfoLine();
                                                                        System.out.println("Se añadio la estacion con exito");
                                                                        break;
                                                                    } catch (IllegalArgumentException e) {
                                                                        System.out.println("Las estaciones no pueden tener mismo id o nombre");
                                                                        allStations.add(station1);
                                                                        allStations.add(station2);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                                }
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        break;
                                                    } else {
                                                        System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                    scanner.nextLine();
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        //si tiene almenos 2
                                        System.out.println("Estaciones disponibles");
                                        for (int i = 0; i < allStations.size(); i++) {
                                            System.out.println(i + 1 + ". " + allStations.get(i).getNameStation());
                                        }
                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                suboption = scanner.nextInt();
                                                int aux2 = suboption - 1;
                                                if (aux2 >= 0 && aux2 < allStations.size()) {
                                                    Station_213170554_AriasHurtado station1 = allStations.get(aux2);
                                                    allStations.remove(aux2);
                                                    System.out.println("Ingrese la distancia entre estacions y presione ENTER para continuar: ");
                                                    int distance;
                                                    while (true) {
                                                        try {
                                                            select = scanner.nextInt();
                                                            distance = select;
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Ingrese el costo entre estaciones y presione ENTER para continuar: ");
                                                    int cost;
                                                    while (true) {
                                                        try {
                                                            select = scanner.nextInt();
                                                            cost = select;
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    try {
                                                        Section_21317055_AriasHurtado newSection = new Section_21317055_AriasHurtado(allLines.get(aux).getSections().get(allLines.get(aux).getSections().size() - 1).getStation2(), station1, distance, cost);
                                                        allLines.get(aux).addSection(newSection);
                                                        System.out.println("Se añadio la estacion con exito");
                                                        break;
                                                    } catch (IllegalArgumentException e) {
                                                        System.out.println("Las estaciones no pueden tener mismo id o nombre");
                                                        allStations.add(station1);
                                                        break;
                                                    }
                                                } else {
                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                } else {
                                    System.out.println("Linea no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay lineas o estaciones disponibles");
                    }

                    break;
                case 4:
                    if (!allLines.isEmpty()) {
                        System.out.println("Indique el id de la linea que quiere validar");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + 1 + ".Linea " + allLines.get(i).getIdLine());
                        }
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allLines.size()) {
                                    if (allLines.get(aux).isLine()) {
                                        System.out.println("La linea se puede añadir");
                                        break;
                                    } else {
                                        System.out.println("La linea no se puede añadir");
                                        break;
                                    }
                                }else{
                                    System.out.println("Opcion no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay lineas disponibles");
                    }
                    break;
                case 5:
                    if (!allLines.isEmpty()) {
                        System.out.println("Lineas disponibles para añadir/actualizar");
                        for (int i = 0; i < allLines.size(); i++) {
                            System.out.println(i + ".Linea " + allLines.get(i).getIdLine());
                        }
                        select = scanner.nextInt();
                        scanner.nextLine();
                        if (allLines.get(select).isLine()) {
                            ArrayList<Line_21317055_AriasHurtado> auxAllLine = new ArrayList<>();
                            auxAllLine.add(allLines.get(select));
                            subway.addLine(auxAllLine);
                            System.out.println("La linea se añadio");
                        } else {
                            System.out.println("La linea no se pudo añadir");
                        }
                    } else {
                        System.out.println("No hay lineas disponibles");
                    }
                    break;
                case 6:
                    System.out.println("Indique el id del nuevo tren");
                    int userIdTrain;
                    while (true) {
                        try {
                            userIdTrain = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userTrainMaker = "";
                    System.out.println("Ingrese la manufacturadora del nuevo tren");
                    while (userTrainMaker.isEmpty()) {
                        userTrainMaker = scanner.nextLine();
                        if (userTrainMaker.isEmpty()) {
                            System.out.println("La manufacturadora no puede estar vacía. Inténtalo de nuevo.");
                        }
                    }

                    System.out.println("Indique la velocidad del nuevo tren");
                    int userSpeed;
                    while (true) {
                        try {
                            userSpeed = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Ingrese el tiempo de parada por estacion del nuevo tren");
                    int userStationStayTime;
                    while (true) {
                        try {
                            userStationStayTime = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    ArrayList<PassangerCar_21317055_AriasHurtado> userPcars = new ArrayList<>();
                    Train_21317055_AriasHurtado userTrain = new Train_21317055_AriasHurtado(userIdTrain, userTrainMaker, userSpeed, userStationStayTime, userPcars);
                    System.out.println("Se ha creado el tren con exito");
                    allTrains.add(userTrain);
                    break;
                case 7:
                    System.out.println("Indique el id del nuevo vagon");
                    int userIdPcar;
                    while (true) {
                        try {
                            userIdPcar = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Indique la capacidad del nuevo vagon");
                    int userCapacity;
                    while (true) {
                        try {
                            userCapacity = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    String userModel = "";
                    System.out.println("Ingrese el modelo del nuevo vagon");
                    while (userModel.isEmpty()) {
                        userModel = scanner.nextLine();
                        if (userModel.isEmpty()) {
                            System.out.println("El modelo no puede estar vacio. Inténtalo de nuevo.");
                        }
                    }
                    String userTrainMakerPcar = "";
                    System.out.println("Ingrese la manufacturadora del nuevo vagon");
                    while (userTrainMakerPcar.isEmpty()) {
                        userTrainMakerPcar = scanner.nextLine();
                        if (userTrainMakerPcar.isEmpty()) {
                            System.out.println("La manufacturadora no puede estar vacio. Inténtalo de nuevo.");
                        }
                    }
                    char userPcarType;
                    System.out.println("Ingrese el tipo de vagon");
                    System.out.println("c.Combinacion");
                    System.out.println("t.Terminal");
                    while (true) {
                        String input = scanner.nextLine();
                        if (input.isEmpty()) {
                            System.out.println("El valor ingresado no puede estar vacío. Intente nuevamente: ");
                        } else {
                            userPcarType = input.charAt(0);
                            if (userPcarType == 't' || userPcarType == 'c') {
                                break;
                            } else {
                                System.out.println("El valor ingresado no es un caracter valido. Intente nuevamente: ");
                            }
                        }
                    }
                    PassangerCar_21317055_AriasHurtado userPcar = new PassangerCar_21317055_AriasHurtado(userIdPcar, userCapacity, userModel, userTrainMakerPcar, userPcarType);
                    reservePcars.add(userPcar);
                    System.out.println("Se ha creado el vagon con exito");
                    break;
                case 8:
                    if (!allTrains.isEmpty() || !reservePcars.isEmpty()) {
                        System.out.println("Indique el tren del que quiere linea que quiere añadir un carro");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    if (allTrains.get(aux).getCarList().isEmpty()) {
                                        System.out.println("Indique el vagon que desea añadir");
                                        System.out.println("Vagones disponibles");
                                        for (int i = 0; i < reservePcars.size(); i++) {
                                            System.out.println(i + 1 + ".vagon de " + reservePcars.get(i).getTrainMaker() + " modelo " + reservePcars.get(i).getModel() + " tipo " + reservePcars.get(i).getCarType());
                                        }
                                        while (true) {
                                            try {
                                                select = scanner.nextInt();
                                                int aux2 = select - 1;
                                                if (aux2 >= 0 && aux2 < allTrains.size()) {
                                                    allTrains.get(aux).addCar(0, reservePcars.get(aux2));
                                                    System.out.println("Se ha añadido el vagon con exito");
                                                    break;
                                                } else {
                                                    System.out.println("Vagon no dispponible");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    } else {
                                        System.out.println("Indique el vagon que desea añadir");
                                        System.out.println("Vagones disponibles");
                                        for (int i = 0; i < reservePcars.size(); i++) {
                                            System.out.println(i + 1 + ".vagon de " + reservePcars.get(i).getTrainMaker() + " modelo " + reservePcars.get(i).getModel() + " tipo " + reservePcars.get(i).getCarType());
                                        }
                                        while (true) {
                                            try {
                                                select = scanner.nextInt();
                                                int aux2 = select - 1;
                                                if (aux2 >= 0 && aux2 < allTrains.size()) {
                                                    System.out.println("Indique la posicion para añadir el vagon");
                                                    for (int i = 0; i < allTrains.get(aux).getCarList().size(); i++) {
                                                        System.out.println(i + 1 + ".vagon de " + allTrains.get(aux).getCarList().get(i).getTrainMaker() + " modelo " + allTrains.get(aux).getCarList().get(i).getModel() + " tipo " + allTrains.get(aux).getCarList().get(i).getCarType());
                                                    }
                                                    while (true) {
                                                        try {
                                                            select = scanner.nextInt();
                                                            int aux3 = select - 1;
                                                            if (aux3 >= 0 && aux3 < allTrains.get(aux).getCarList().size()) {
                                                                allTrains.get(aux).addCar(aux3, reservePcars.get(aux2));
                                                                reservePcars.remove(aux2);
                                                                System.out.println("Se ha añadido el vagon con exito");
                                                                break;
                                                            } else {
                                                                System.out.println("La posicion ingresada no es valida");
                                                            }
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    break;
                                                } else {
                                                    System.out.println("Vagon no dispponible");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                } else {
                                    System.out.println("Tren no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes o vagones disponibles");
                    }
                    break;
                case 9:
                    if (!allTrains.isEmpty()) {
                        System.out.println("Indique el tren del que quiere linea que quiere remover un carro");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    if (allTrains.get(aux).getCarList().isEmpty()) {
                                        System.out.println("El tren seleccionado no tiene vagones");
                                        break;
                                    } else {
                                        System.out.println("Indique la posicion del vagon que desea remover");
                                        System.out.println("Vagones disponibles");
                                        for (int i = 0; i < allTrains.get(aux).getCarList().size(); i++) {
                                            System.out.println(i + 1 + ".vagon de " + allTrains.get(aux).getCarList().get(i).getTrainMaker() + " modelo " + allTrains.get(aux).getCarList().get(i).getModel() + " tipo " + allTrains.get(aux).getCarList().get(i).getCarType());
                                        }
                                        while (true) {
                                            try {
                                                select = scanner.nextInt();
                                                int aux2 = select - 1;
                                                if (aux2 >= 0 && aux2 < allTrains.get(aux).getCarList().size()) {
                                                    reservePcars.add(allTrains.get(aux).getCarList().get(aux2));
                                                    allTrains.get(aux).removeCar(aux2);
                                                    System.out.println("El vagon se ha quitado del tren y guardado en reserva");
                                                    break;
                                                } else {
                                                    System.out.println("Vagon no dispponible");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                } else {
                                    System.out.println("Tren no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                case 10:
                    if (!allTrains.isEmpty()) {
                        System.out.println("Indique el id del tren que quiere validar");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    if (allTrains.get(aux).isTrain(allTrains.get(aux))) {
                                        System.out.println("El tren se puede añadir");
                                        break;
                                    } else {
                                        System.out.println("El tren no se puede añadir");
                                        break;
                                    }
                                } else {
                                    System.out.println("Tren no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                case 11:
                    if (!allTrains.isEmpty()) {
                        System.out.println("Trenes disponibles para añadir/actualizar");
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    if (allTrains.get(aux).isTrain(allTrains.get(aux))) {
                                        ArrayList<Train_21317055_AriasHurtado> auxTrain = new ArrayList<>();
                                        auxTrain.add(allTrains.get(aux));
                                        subway.addTrain(auxTrain);
                                        System.out.println("El tren se añadio");
                                        break;
                                    } else {
                                        System.out.println("El tren no se pudo añadir");
                                        break;
                                    }
                                } else {
                                    System.out.println("El tren no se pudo añadir");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                case 12:
                    int userIdDriver;
                    while (true) {
                        System.out.println("Ingrese el id del nuevo conductor");
                        try {
                            userIdDriver = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userNameDriver = "";
                    System.out.println("Ingrese el nombre del nuevo conductor");
                    while (userNameDriver.isEmpty()) {
                        userNameDriver = scanner.nextLine();
                        if (userNameDriver.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío. Inténtalo de nuevo.");
                        }
                    }

                    String userTrainMakerDriver = "";
                    System.out.println("Ingrese que tipo de tren puede manejar el conductor (Manufacturadora de tren)");
                    while (userTrainMakerDriver.isEmpty()) {
                        userTrainMakerDriver = scanner.nextLine();
                        if (userTrainMakerDriver.isEmpty()) {
                            System.out.println("La manufacturadora no puede estar vacia. Inténtalo de nuevo.");
                        }
                    }
                    Driver_21317055_AriasHurtado userDriver = new Driver_21317055_AriasHurtado(userIdDriver, userNameDriver, userTrainMakerDriver);
                    subway.getDrivers().add(userDriver);
                    break;
                case 13:
                    if(!allTrains.isEmpty() || !allLines.isEmpty()){
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < allTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    System.out.println("Lineas disponibles");
                                    for (int i = 0; i < allLines.size(); i++) {
                                        System.out.println(i+1 + ".Linea " + allLines.get(i).getNameLine());
                                    }
                                    while(true){
                                        try{
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if(aux2 >= 0 && aux2 < allLines.size()){
                                                allTrains.get(aux).setAssignedLine(allLines.get(aux2).getIdLine());
                                                allLines.get(aux2).getAssignedTrains().add(allTrains.get(aux).getIdTrain());
                                                System.out.println("Se ha asignado el tren con exito");
                                                break;
                                            }else{
                                                System.out.println("Linea no disponible");
                                            }
                                        }catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                break;
                                }else{
                                    System.out.println("Tren no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }

                    }else{
                        System.out.println("No hay trenes o lineas disponibles");
                    }
                    break;
                case 14:
                    if(!allTrains.isEmpty() || !subway.getDrivers().isEmpty()){
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren " + allTrains.get(i).getTrainMaker() + " " + allTrains.get(i).getIdTrain());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < allTrains.size()) {
                                    System.out.println("Conductores disponibles");
                                    for (int i = 0; i < subway.getDrivers().size(); i++) {
                                        System.out.println(i+1 + ".Conductor " + subway.getDrivers().get(i).getNameDriver());
                                    }
                                    while(true){
                                        try{
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if(aux2 >= 0 && aux2 < subway.getDrivers().size()){
                                                allTrains.get(aux).setAssignedDriver(subway.getDrivers().get(aux2).getIdDriver());
                                                subway.getDrivers().get(aux2).setAssignedTrain(allTrains.get(aux).getIdTrain());
                                                System.out.println("Se ha asignado el tren con exito");
                                                break;
                                            }else{
                                                System.out.println("Conductor no disponible");
                                            }
                                        }catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                }else{
                                    System.out.println("Tren no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }

                    }System.out.println("No hay trenes o conductores disponibles");
                    break;
                case 15:
                    menuView();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 15);
    }
}