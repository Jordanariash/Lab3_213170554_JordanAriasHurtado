package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

import java.util.InputMismatchException; //para que al ingresar algo que no es, reintentar

public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;
    private ArrayList<Line_21317055_AriasHurtado> allLines = new ArrayList<Line_21317055_AriasHurtado>();
    private ArrayList<Train_21317055_AriasHurtado> allTrains = new ArrayList<Train_21317055_AriasHurtado>();
    private ArrayList<Driver_21317055_AriasHurtado> allDrivers = new ArrayList<Driver_21317055_AriasHurtado>();
    private ArrayList<Station_213170554_AriasHurtado> allStations = new ArrayList<Station_213170554_AriasHurtado>();

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
            System.out.println("4. Asignaciones y horarios (cargar archivo asignaciones.txt)");
            System.out.println("5. Acceder al Subway");
            System.out.println("6. Salir");
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
                        allDrivers = drivers;
                        subway.addDriver(drivers);
                        System.out.println("Conductores cargados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        DriverReader.readDrivers("ExampleAssignments.txt");
                        System.out.println("Asignaciones cargadas correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 5:
                    menuView();
                    break;
                default:
                    System.out.println("Opcion no valida");


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
                default:
                    break;
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
            System.out.println("3. Añadir estacion a una linea");
            System.out.println("4. Consultar si una linea es valida para ingresar a la red de metro");
            System.out.println("5. Añadir lineas a la red de metro");
            System.out.println("6. Crear tren nuevo");
            System.out.println("7. Añadir vagones a un tren");
            System.out.println("8. Quitar vagones a un tren");
            System.out.println("9. Consultar si un tren es valido para ingresar a la red de metro");
            System.out.println("10. Añadir trenes a la red de metro");
            System.out.println("11. Ingresar nuevo conductor");
            System.out.println("12. Asignar tren a linea");
            System.out.println("13. Asignar conductor a tren");
            System.out.println("14. Volver");
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
                        try {
                            userStationType = scanner.nextLine().charAt(0);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un caracter en minusculas. Intente nuevamente: ");
                            scanner.nextLine();
                        }

                    }
                    Station_213170554_AriasHurtado userStation = new Station_213170554_AriasHurtado(userIdStation,userNameStation,userStationType,userStationStopTime);
                    allStations.add(userStation);
                    System.out.println("Se ha creado la estacion");
                    break;
                case 3:
                    if(!allLines.isEmpty() && !allStations.isEmpty()){
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
                                    if(allLines.get(aux).getSections().isEmpty()){
                                        if(allStations.size() < 2){
                                            System.out.println("Se necesitan almenos 2 estaciones para formar una linea");
                                            break;
                                        }else{
                                            System.out.println("Estaciones disponibles");
                                            for (int i = 0; i < allStations.size(); i++) {
                                                System.out.println(i+1 +". " + allStations.get(i).getNameStation());
                                            }
                                            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                            while (true) {
                                                try{
                                                    suboption = scanner.nextInt();
                                                    int aux2 = suboption - 1;
                                                    if (aux2 >= 0 && aux2 < allStations.size()) {
                                                        Station_213170554_AriasHurtado station1 = allStations.get(aux2);
                                                        for (int i = 0; i < allStations.size(); i++) {
                                                            System.out.println(i+1 +". " + allStations.get(i).getNameStation());
                                                        }
                                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                                        while (true) {
                                                            try{
                                                                suboption = scanner.nextInt();
                                                                int aux3 = suboption - 1;
                                                                if (aux3 >= 0 && aux2 < allStations.size()) {
                                                                    Station_213170554_AriasHurtado station2 = allStations.get(aux3);
                                                                    System.out.println("Ingrese la distancia entre estacions y presione ENTER para continuar: ");
                                                                    int distance;
                                                                    while (true) {
                                                                        try{
                                                                            select = scanner.nextInt();
                                                                            distance = select;
                                                                            break;
                                                                        }catch(InputMismatchException e){
                                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                            scanner.nextLine();
                                                                        }
                                                                    }
                                                                    System.out.println("Ingrese el costo entre estacions y presione ENTER para continuar: ");
                                                                    int cost;
                                                                    while (true) {
                                                                        try{
                                                                            select = scanner.nextInt();
                                                                            cost = select;
                                                                            break;
                                                                        }catch(InputMismatchException e){
                                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                            scanner.nextLine();
                                                                        }
                                                                    }
                                                                    Section_21317055_AriasHurtado section = new Section_21317055_AriasHurtado(station1,station2,distance,cost);
                                                                    allLines.get(aux).getSections().add(section);
                                                                    break;
                                                                }else{
                                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                                }
                                                            }catch(InputMismatchException e){
                                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        break;
                                                    }else{
                                                        System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                    }
                                                }catch(InputMismatchException e){
                                                    System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                    scanner.nextLine();
                                                }
                                            }
                                        }
                                    }else{
                                        //si tiene almenos 2
                                        System.out.println("Estaciones disponibles");
                                        for (int i = 0; i < allStations.size(); i++) {
                                            System.out.println(i+1 +". " + allStations.get(i).getNameStation());
                                        }
                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                        while (true) {
                                            try{
                                                suboption = scanner.nextInt();
                                                int aux2 = suboption - 1;
                                                if (aux2 >= 0 && aux2 < allStations.size()) {
                                                    Station_213170554_AriasHurtado station1 = allStations.get(aux2);
                                                    System.out.println("Ingrese la distancia entre estacions y presione ENTER para continuar: ");
                                                    int distance;
                                                    while (true) {
                                                        try{
                                                            select = scanner.nextInt();
                                                            distance = select;
                                                            break;
                                                        }catch(InputMismatchException e){
                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Ingrese el costo entre estaciones y presione ENTER para continuar: ");
                                                    int cost;
                                                    while (true) {
                                                        try{
                                                            select = scanner.nextInt();
                                                            cost = select;
                                                            break;
                                                        }catch(InputMismatchException e){
                                                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    Section_21317055_AriasHurtado section = new Section_21317055_AriasHurtado(allLines.get(aux).getSections().get(allLines.get(aux).getSections().size()-1).getStation2(),station1,distance,cost);
                                                    allLines.get(aux).getSections().add(section);
                                                    break;
                                                }else {
                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                }
                                            }catch(InputMismatchException e){
                                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Linea no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas o estaciones disponibles");
                    }

                    break;
                case 4:
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
                case 5:
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
                case 6:
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
                case 7:
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
                case 8:
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
                case 9:
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
                case 10:
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
                case 11:
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
                case 12:
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Lineas disponibles");
                    for (int i = 0; i < allLines.size(); i++) {
                        System.out.println(i+".Linea " + allLines.get(i).getIdLine());
                    }
                    suboption = scanner.nextInt();
                    scanner.nextLine();
                    allTrains.get(select).setAssignedLine(allLines.get(suboption).getIdLine());
                    allLines.get(suboption).getAssignedTrains().add(allTrains.get(select).getIdTrain());
                    break;
                case 13:
                    System.out.println("Trenes disponibles");
                    for (int i = 0; i < allTrains.size(); i++) {
                        System.out.println(i+".Tren " + allTrains.get(i).getIdTrain());
                    }
                    select = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Conductores disponibles");
                    for (int i = 0; i < allDrivers.size(); i++) {
                        System.out.println(i+"." + allDrivers.get(i).getNameDriver());
                    }
                    suboption = scanner.nextInt();

                    break;
                case 14:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 13);
    }
}