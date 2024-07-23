package clases;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Clase Menu que representa un menu para interactuar con un sistema de metro
 */
public class Menu_21317055_AriasHurtado {
    private Subway_21317055_AriasHurtado subway;
    private Scanner scanner;
    private ArrayList<Line_21317055_AriasHurtado> reserveLines = new ArrayList<Line_21317055_AriasHurtado>();
    private ArrayList<Train_21317055_AriasHurtado> reserveTrains = new ArrayList<Train_21317055_AriasHurtado>();
    private ArrayList<Station_213170554_AriasHurtado> reserveStations = new ArrayList<Station_213170554_AriasHurtado>();
    private ArrayList<PassangerCar_21317055_AriasHurtado> reservePcars = new ArrayList<PassangerCar_21317055_AriasHurtado>();

    /**
     * Constructor de menu, vacio ya que solo inicializa la clase
     */
    public Menu_21317055_AriasHurtado() {}

    /**
     * Inicio de menu, carga de opciones
     */
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
                        subway.addLine(lines);
                        System.out.println("Lineas cargadas correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error al leer el archivo: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        ArrayList<Train_21317055_AriasHurtado> trains = TrainReader.readTrains("ExampleTrains.txt");
                        subway.addTrain(trains);
                        if(!subway.getLines().isEmpty()){
                            for(int i = 0; i<subway.getTrains().size(); i++){
                                for(int j = 0; j < subway.getLines().size(); j++){
                                    for (int k = 0; k < subway.getLines().get(j).getSections().size(); k++){
                                        if(subway.getLines().get(j).getSections().get(k).getStation1().getIdStation() == subway.getTrains().get(i).getDepartureStation().getIdStation()){
                                            subway.getTrains().get(i).setDepartureStation(subway.getLines().get(j).getSections().get(k).getStation1());
                                        } else if ((subway.getLines().get(j).getSections().get(k).getStation2().getIdStation() == subway.getTrains().get(i).getDepartureStation().getIdStation())) {
                                            subway.getTrains().get(i).setDepartureStation(subway.getLines().get(j).getSections().get(k).getStation2());
                                        } else if(subway.getLines().get(j).getSections().get(k).getStation1().getIdStation() == subway.getTrains().get(i).getArriveStation().getIdStation()){
                                            subway.getTrains().get(i).setArriveStation(subway.getLines().get(j).getSections().get(k).getStation1());
                                        } else if((subway.getLines().get(j).getSections().get(k).getStation2().getIdStation() == subway.getTrains().get(i).getArriveStation().getIdStation())){
                                            subway.getTrains().get(i).setArriveStation(subway.getLines().get(j).getSections().get(k).getStation2());
                                        }
                                    }
                                }
                            }
                        }
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

    /**
     * Intermedio entre consultar o modificar el metro
     */
    public void menuView(){
        int option = 0;
        do {
            System.out.println("------------------- Sistema Metro - Visualizacion del estado actual del sistema de metros  -------------------");
            System.out.println("1. Consultar el estado actual de la red de metro.");
            System.out.println("2. Modificar la red de metro.");
            System.out.println("3. Retorno al menú de Inicio");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
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

    /**
     * Seccion para consultar alguna informacion referente al metro
     */
    public void menuConsult() {
        int option = 0;
        int select;
        long time;
        do {
            System.out.println("------------------- Sistema Metro - Interactuar con el sistema de metros -------------------");
            System.out.println("1. lineLength: obtener el largo total de una linea.");
            System.out.println("2. lineSectionLength: determinar el tracto entre una estacion origen y final.");
            System.out.println("3. lineCost: determinar el costo total de recorrer una linea.");
            System.out.println("4. lineSectionCost: determinar el costo de un trayecto entre estacion origen y final.");
            System.out.println("5. Train - fetchCapacity: entrega la capacidad maxima de pasajeros de un tren.");
            System.out.println("6. Subway - whereIsTrain: determina la ubicación de un tren a partir de una hora indicada del dia.");
            System.out.println("7. Subway - trainPath: armar el recorrido del tren a partir de una hora especificada y que retorna la lista de estaciones futuras por recorrer.");
            System.out.println("8. Visualizar metro");
            System.out.println("9. Volver");
            System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }

            switch (option) {
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
                                    System.out.println("La linea " + subway.getLines().get(aux).getNameLine() + " tiene un largo de: " + subway.getLines().get(aux).lineLenght());
                                    break;
                                } else {
                                    System.out.println("Linea no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas disponibles en el metro");
                    }
                    break;
                case 2:
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
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if (aux2 >= 0 && aux2 <= subway.getLines().get(aux).getSections().size()) {
                                                while (true) {
                                                    System.out.println("Indique la segunda estacion");
                                                    System.out.println("Estaciones disponibles:");
                                                    subway.getLines().get(aux).showStations();
                                                    System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                                    try {
                                                        select = scanner.nextInt();
                                                        int aux3 = select - 1;
                                                        if (aux3 >= 0 && aux3 <= subway.getLines().get(aux).getSections().size()) {
                                                            System.out.println("El largo entre " + subway.getLines().get(aux).getStationByPosition(aux2).getNameStation() + " y " + subway.getLines().get(aux).getStationByPosition(aux3).getNameStation() + " es de: " + subway.getLines().get(aux).lineSectionLenght(subway.getLines().get(aux).getStationByPosition(aux2), subway.getLines().get(aux).getStationByPosition(aux3)));
                                                            break;
                                                        } else {
                                                            System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    } catch (InputMismatchException e) {
                                                        System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
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
                                    System.out.println("Linea no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay lineas disponibles en el metro");
                    }
                    break;
                case 3:
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
                                    System.out.println("La linea " + select + " tiene un largo de: " + subway.getLines().get(aux).lineCost());
                                    break;
                                } else {
                                    System.out.println("Linea no disponible. Intente nuevamente:");
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
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if (aux2 >= 0 && aux2 <= subway.getLines().get(aux).getSections().size()) {
                                                while (true){
                                                    System.out.println("Indique la segunda estacion");
                                                    System.out.println("Estaciones disponibles:");
                                                    subway.getLines().get(aux).showStations();
                                                    System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                                    try {
                                                        select = scanner.nextInt();
                                                        int aux3 = select - 1;
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
                                if(aux >= 0 && aux < subway.getTrains().size()) {
                                    if (subway.getTrains().get(aux).getArriveStation() != null && subway.getTrains().get(aux).getDepartureStation() != null && subway.getTrains().get(aux).getDepartureTime() != null) {
                                        System.out.println("Ingrese una hora en formato UNIX y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                time = scanner.nextLong();
                                                Date date = new Date(time);
                                                try{
                                                    System.out.println("El tren " + subway.getTrains().get(aux).getTrainMaker() + " esta en la estacion: " + subway.whereIsTrain(subway.getTrains().get(aux), date).getNameStation());
                                                    break;
                                                }catch (NullPointerException e) {
                                                    System.out.println("Ha ocurrido un error con el tren");
                                                }
                                                break;
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es una fecha en formato UNIX. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                    } else {
                                        System.out.println("El Tren no tiene las condiciones necesarias, elija otro:");
                                    }
                                    break;
                                }else {
                                    System.out.println("Tren no disponible. Intente nuevamente :");

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
                    if(!subway.getTrains().isEmpty() || !subway.getLines().isEmpty()) {
                        System.out.println("Seleccione el tren del que quiere saber su recorrido");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren marca " + subway.getTrains().get(i).getTrainMaker());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if(aux >= 0 && aux < subway.getTrains().size()) {
                                    if (subway.getTrains().get(aux).getArriveStation() != null && subway.getTrains().get(aux).getDepartureStation() != null && subway.getTrains().get(aux).getDepartureTime() != null) {
                                        System.out.println("Ingrese una hora en formato UNIX y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                time = scanner.nextLong();
                                                Date date = new Date(time);

                                                if(!subway.trainPath(subway.getTrains().get(aux), date).isEmpty()){
                                                    try {
                                                        System.out.println("Estaciones pendientes:");
                                                        for (int i = 0; i < subway.trainPath(subway.getTrains().get(aux), date).size(); i++) {
                                                            System.out.println(i+1 + ". " + subway.trainPath(subway.getTrains().get(aux), date).get(i).getNameStation());
                                                        }
                                                    }catch (NullPointerException e) {
                                                        System.out.println("Ha ocurrido un error con el tren");
                                                    }
                                                }else{
                                                    System.out.println("El tren no tiene mas estaciones que recorrer");
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
                    System.out.println(subway.toString());
                    break;
                case 9:
                    System.out.println("Ha salido");
                    break;
                default:
                    break;
            }
        } while (option != 9);
    }

    /**
     * Seccion para modificar aspectos del metro
     */
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
            System.out.println("6. Quitar lineas de la red de metro");
            System.out.println("7. Crear tren nuevo");
            System.out.println("8. Crear vagon nuevo");
            System.out.println("9. Añadir vagones a un tren");
            System.out.println("10. Quitar vagones a un tren");
            System.out.println("11. Consultar si un tren es valido para ingresar a la red de metro");
            System.out.println("12. Añadir trenes a la red de metro");
            System.out.println("13. Quitar trenes de la red de metro");
            System.out.println("14. Ingresar nuevo conductor");
            System.out.println("15. Quitar conductor del metro");
            System.out.println("16. Asignar tren a linea");
            System.out.println("17. Asignar conductor a tren");
            System.out.println("18. Volver");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                scanner.nextLine();
                continue;
            }
            switch (option) {
                //Crear una linea nueva
                case 1:
                    int userIdLine;
                    while (true) {
                        System.out.println("Ingrese el id de la nueva linea");
                        try {
                            userIdLine = scanner.nextInt();
                            if(userIdLine > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    String userNameLine = "";
                    System.out.println("Ingrese el nombre de la nueva linea");
                    while (userNameLine.isEmpty()) {
                        userNameLine = scanner.nextLine();
                    }
                    String userRail = "";
                    System.out.println("Ingrese el tipo de riel de la nueva linea");
                    while (userRail.isEmpty()) {
                        userRail = scanner.nextLine();
                    }

                    ArrayList<Section_21317055_AriasHurtado> userSections = new ArrayList<>();
                    Line_21317055_AriasHurtado userLine = new Line_21317055_AriasHurtado(userIdLine, userNameLine, userRail, userSections);
                    System.out.println("Se ha creado una nueva linea con exito");
                    reserveLines.add(userLine);
                    break;
                //Crear una estacion nueva
                case 2:
                    System.out.println("Indique el id de la nueva estacion");
                    int userIdStation;
                    while (true) {
                        try {
                            userIdStation = scanner.nextInt();
                            if(userIdStation > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userNameStation = "";
                    System.out.println("Ingrese el nombre de la nueva estacion");
                    while (userNameStation.isEmpty()) {
                        userNameStation = scanner.nextLine();
                    }

                    System.out.println("Indique el tiempo de parada de la nueva estacion");
                    int userStationStopTime;
                    while (true) {
                        try {
                            userStationStopTime = scanner.nextInt();
                            if(userStationStopTime >= 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
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
                    reserveStations.add(userStation);
                    System.out.println("Se ha creado la estacion");
                    break;
                case 3:
                    if (!reserveLines.isEmpty() || !reserveStations.isEmpty()) {
                        System.out.println("Seleccione la linea a la que quiere añadir estaciones");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < reserveLines.size(); i++) {
                            System.out.println(i + 1 + ".Linea " + reserveLines.get(i).getNameLine());
                        }
                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveLines.size()) {
                                    //si la linea no tiene estaciones
                                    if (reserveLines.get(aux).getSections().isEmpty()) {
                                        if (reserveStations.size() < 2) {
                                            System.out.println("Se necesitan almenos 2 estaciones para formar una linea");
                                            break;
                                        } else {
                                            System.out.println("Estaciones disponibles");
                                            for (int i = 0; i < reserveStations.size(); i++) {
                                                System.out.println(i + 1 + ". " + reserveStations.get(i).getNameStation());
                                            }
                                            System.out.println("Ingrese la primera estacion y presione ENTER para continuar: ");
                                            while (true) {
                                                try {
                                                    suboption = scanner.nextInt();
                                                    int aux2 = suboption - 1;
                                                    if (aux2 >= 0 && aux2 < reserveStations.size()) {
                                                        Station_213170554_AriasHurtado station1 = reserveStations.get(aux2);
                                                        reserveStations.remove(aux2);
                                                        for (int i = 0; i < reserveStations.size(); i++) {
                                                            System.out.println(i + 1 + ". " + reserveStations.get(i).getNameStation());
                                                        }
                                                        System.out.println("Ingrese la segunda estacion y presione ENTER para continuar: ");
                                                        while (true) {
                                                            try {
                                                                suboption = scanner.nextInt();
                                                                int aux3 = suboption - 1;
                                                                if (aux3 >= 0 && aux3 < reserveStations.size()) {
                                                                    Station_213170554_AriasHurtado station2 = reserveStations.get(aux3);
                                                                    reserveStations.remove(aux3);
                                                                    System.out.println("Ingrese la distancia entre estaciones y presione ENTER para continuar: ");
                                                                    int distance;
                                                                    while (true) {
                                                                        try {
                                                                            select = scanner.nextInt();
                                                                            distance = select;
                                                                            break;
                                                                        } catch (InputMismatchException e) {
                                                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
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
                                                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                                            scanner.nextLine();
                                                                        }
                                                                    }
                                                                    try {
                                                                        Section_21317055_AriasHurtado newSection = new Section_21317055_AriasHurtado(station1, station2, distance, cost);
                                                                        reserveLines.get(aux).getSections().add(newSection);
                                                                        System.out.println("Se agrego la estacion con exito");
                                                                        break;
                                                                    } catch (IndexOutOfBoundsException e) {
                                                                        System.out.println("Ocurrio un error");
                                                                        reserveStations.add(station1);
                                                                        reserveStations.add(station2);
                                                                        break;
                                                                    }
                                                                } else {
                                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                                }
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                                scanner.nextLine();
                                                            }
                                                        }
                                                        break;
                                                    } else {
                                                        System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                    scanner.nextLine();
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        //si tiene almenos 2
                                        System.out.println("Estaciones disponibles");
                                        for (int i = 0; i < reserveStations.size(); i++) {
                                            System.out.println(i + 1 + ". " + reserveStations.get(i).getNameStation());
                                        }
                                        System.out.println("Ingrese una opcion y presione ENTER para continuar: ");
                                        while (true) {
                                            try {
                                                suboption = scanner.nextInt();
                                                int aux2 = suboption - 1;
                                                if (aux2 >= 0 && aux2 < reserveStations.size()) {
                                                    Station_213170554_AriasHurtado station1 = reserveStations.get(aux2);
                                                    reserveStations.remove(aux2);
                                                    System.out.println("Ingrese la distancia entre estacions y presione ENTER para continuar: ");
                                                    int distance;
                                                    while (true) {
                                                        try {
                                                            select = scanner.nextInt();
                                                            distance = select;
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    System.out.println("Ingrese el costo entre la ultima estacion del metro, y la ahora agregada y presione ENTER para continuar: ");
                                                    int cost;
                                                    while (true) {
                                                        try {
                                                            select = scanner.nextInt();
                                                            cost = select;
                                                            break;
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                    try {
                                                        Section_21317055_AriasHurtado newSection = new Section_21317055_AriasHurtado(reserveLines.get(aux).getSections().get(reserveLines.get(aux).getSections().size() - 1).getStation2(), station1, distance, cost);
                                                        reserveLines.get(aux).addSection(newSection);
                                                        System.out.println("Se agrego la estacion con exito");
                                                        break;
                                                    } catch (IllegalArgumentException e) {
                                                        System.out.println("Las estaciones no pueden tener mismo id o nombre");
                                                        reserveStations.add(station1);
                                                        break;
                                                    }
                                                } else {
                                                    System.out.println("Estacion no disponible. Intente nuevamente: ");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                } else {
                                    System.out.println("Linea no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay lineas o estaciones disponibles");
                    }

                    break;
                case 4:
                    if (!reserveLines.isEmpty()) {
                        System.out.println("Indique el id de la linea que quiere validar");
                        System.out.println("Lineas disponibles");
                        for (int i = 0; i < reserveLines.size(); i++) {
                            System.out.println(i + 1 + ".Linea " + reserveLines.get(i).getNameLine());
                        }
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveLines.size()) {
                                    if (reserveLines.get(aux).isLine()) {
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
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay lineas disponibles");
                    }
                    break;
                //Añadir lineas a la red de metro
                case 5:
                    if (!reserveLines.isEmpty()) {
                        System.out.println("Lineas disponibles para ingresar");
                        for (int i = 0; i < reserveLines.size(); i++) {
                            System.out.println(i+1 + ".Linea " + reserveLines.get(i).getNameLine());
                        }

                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select -1;
                                if(aux >= 0 && aux < reserveLines.size()){
                                    if (reserveLines.get(aux).isLine()) {
                                        ArrayList<Line_21317055_AriasHurtado> auxAllLine = new ArrayList<>();
                                        auxAllLine.add(reserveLines.get(aux));
                                        reserveLines.remove(aux);
                                        subway.addLine(auxAllLine);
                                        System.out.println("La linea se ingreso con exito");
                                        break;
                                    } else {
                                        System.out.println("La linea no se pudo ingresaer");
                                        break;
                                    }
                                }else{
                                    System.out.println("Opcion no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay lineas disponibles");
                    }
                    break;
                //Quitar lineas de la red de metro
                case 6:
                    if (!subway.getLines().isEmpty()) {
                        System.out.println("Seleccione la linea a quitar");
                        for (int i = 0; i < subway.getLines().size(); i++) {
                            System.out.println(i + 1 + ".Linea " + subway.getLines().get(i).getNameLine());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select -1;
                                if(aux >= 0 && aux < subway.getLines().size()){
                                    reserveLines.add(subway.getLines().get(aux));
                                    subway.getLines().remove(aux);
                                    System.out.println("Se ha retirado la linea con exito");
                                    break;
                                }else{
                                    System.out.println("Opcion no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("El metro no tiene lineas disponibles");
                    }
                    break;
                //Crear tren nuevo
                case 7:
                    System.out.println("Indique el id del nuevo tren");
                    int userIdTrain;
                    while (true) {
                        try {
                            userIdTrain = scanner.nextInt();
                            if(userIdTrain > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    String userTrainMaker = "";
                    System.out.println("Ingrese la manufacturadora del nuevo tren");
                    while (userTrainMaker.isEmpty()) {
                        userTrainMaker = scanner.nextLine();
                    }

                    System.out.println("Indique la velocidad del nuevo tren");
                    int userSpeed;
                    while (true) {
                        try {
                            userSpeed = scanner.nextInt();
                            if(userSpeed > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Ingrese el tiempo de parada por estacion del nuevo tren");
                    int userStationStayTime;
                    while (true) {
                        try {
                            userStationStayTime = scanner.nextInt();
                            if(userStationStayTime > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    ArrayList<PassangerCar_21317055_AriasHurtado> userPcars = new ArrayList<>();
                    Train_21317055_AriasHurtado userTrain = new Train_21317055_AriasHurtado(userIdTrain, userTrainMaker, userSpeed, userStationStayTime, userPcars);
                    System.out.println("Se ha creado el tren con exito");
                    reserveTrains.add(userTrain);
                    break;
                //Crear vagon nuevo
                case 8:
                    System.out.println("Indique el id del nuevo vagon");
                    int userIdPcar;
                    while (true) {
                        try {
                            userIdPcar = scanner.nextInt();
                            if(userIdPcar > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    System.out.println("Indique la capacidad del nuevo vagon");
                    int userCapacity;
                    while (true) {
                        try {
                            userCapacity = scanner.nextInt();
                            if(userCapacity > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                    String userModel = "";
                    System.out.println("Ingrese el modelo del nuevo vagon");
                    while (userModel.isEmpty()) {
                        userModel = scanner.nextLine();
                    }
                    String userTrainMakerPcar = "";
                    System.out.println("Ingrese la manufacturadora del nuevo vagon");
                    while (userTrainMakerPcar.isEmpty()) {
                        userTrainMakerPcar = scanner.nextLine();
                    }
                    char userPcarType;
                    System.out.println("Ingrese el tipo de vagon");
                    System.out.println("c.Central");
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
                //Añadir vagones a un tren
                case 9:
                    if (!reserveTrains.isEmpty() && !reservePcars.isEmpty()) {
                        System.out.println("Indique el tren del que quiere linea que quiere agregar un carro");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < reserveTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + reserveTrains.get(i).getTrainMaker() + " " + reserveTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveTrains.size()) {

                                    System.out.println("Indique el vagon que desea agregar");
                                    System.out.println("Vagones disponibles");
                                    for (int i = 0; i < reservePcars.size(); i++) {
                                        System.out.println(i + 1 + ".vagon " +reservePcars.get(i).getIdPassangerCar()+ " de " + reservePcars.get(i).getTrainMaker() + " modelo " + reservePcars.get(i).getModel() + " tipo " + reservePcars.get(i).getCarType());
                                    }

                                    while (true) {
                                        try {
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if (aux2 >= 0 && aux2 < reservePcars.size()) {

                                                if (reserveTrains.get(aux).getCarList().isEmpty()) {
                                                    reserveTrains.get(aux).addCar(0, reservePcars.get(aux2));
                                                    System.out.println("Se ha añadido el vagon con exito");
                                                    reservePcars.remove(aux2);
                                                    break;
                                                }else{
                                                    System.out.println("Ingrese la posicion del vagon");
                                                    System.out.println("Posiciones disponibles: ");
                                                    for(int i = 0; i < reserveTrains.get(aux).getCarList().size(); i++){
                                                        System.out.println(i + 1 + ".Vagon modelo " + reserveTrains.get(aux).getCarList().get(i).getModel() + " tipo " + reserveTrains.get(aux).getCarList().get(i).getCarType());
                                                    }
                                                    while(true){
                                                        try{
                                                            select = scanner.nextInt();
                                                            int aux3 = select - 1;
                                                            if(aux3 >= 0 && aux3 < reserveTrains.get(aux).getCarList().size()){
                                                                reserveTrains.get(aux).addCar(aux3, reservePcars.get(aux2));
                                                                reservePcars.remove(aux2);
                                                                break;
                                                            }else{
                                                                System.out.println("Posicion no disponible");
                                                            }
                                                        }catch (InputMismatchException e) {
                                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                            scanner.nextLine();
                                                        }
                                                    }
                                                }
                                                break;

                                            } else {
                                                System.out.println("Vagon no dispponible");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;

                                } else {
                                    System.out.println("Tren no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes o vagones disponibles");
                    }
                    break;
                //Quitar vagones a un tren
                case 10:
                    if (!reserveTrains.isEmpty()) {
                        System.out.println("Indique el tren del que quiere linea que quiere remover un carro");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < reserveTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + reserveTrains.get(i).getTrainMaker() + " " + reserveTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveTrains.size()) {
                                    if (reserveTrains.get(aux).getCarList().isEmpty()) {
                                        System.out.println("El tren seleccionado no tiene vagones");
                                        break;
                                    } else {
                                        System.out.println("Indique la posicion del vagon que desea remover");
                                        System.out.println("Vagones disponibles");
                                        for (int i = 0; i < reserveTrains.get(aux).getCarList().size(); i++) {
                                            System.out.println(i + 1 + ".Vagon de " + reserveTrains.get(aux).getCarList().get(i).getTrainMaker() + " modelo " + reserveTrains.get(aux).getCarList().get(i).getModel() + " tipo " + reserveTrains.get(aux).getCarList().get(i).getCarType());
                                        }
                                        while (true) {
                                            try {
                                                select = scanner.nextInt();
                                                int aux2 = select - 1;
                                                if (aux2 >= 0 && aux2 < reserveTrains.get(aux).getCarList().size()) {
                                                    reservePcars.add(reserveTrains.get(aux).getCarList().get(aux2));
                                                    reserveTrains.get(aux).removeCar(aux2);
                                                    System.out.println("El vagon se ha quitado del tren y guardado en reserva");
                                                    break;
                                                } else {
                                                    System.out.println("Vagon no disponible");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                } else {
                                    System.out.println("Tren no disponible. Intente nuevamente: ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                //Consultar si un tren es valido para ingresar a la red de metro
                case 11:
                    if (!reserveTrains.isEmpty()) {
                        System.out.println("Indique el id del tren que quiere validar");
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < reserveTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + reserveTrains.get(i).getTrainMaker() + " " + reserveTrains.get(i).getIdTrain());
                        }
                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveTrains.size()) {
                                    if (reserveTrains.get(aux).isTrain()) {
                                        System.out.println("El tren se puede ingresar");
                                        break;
                                    } else {
                                        System.out.println("El tren no se puede ingresar");
                                        break;
                                    }
                                } else {
                                    System.out.println("Tren no disponible");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                //Añadir trenes a la red de metro
                case 12:
                    if (!reserveTrains.isEmpty()) {
                        System.out.println("Trenes disponibles para ingresar");
                        for (int i = 0; i < reserveTrains.size(); i++) {
                            System.out.println(i + 1 + ".Tren " + reserveTrains.get(i).getTrainMaker() + " " + reserveTrains.get(i).getIdTrain());
                        }

                        while (true) {
                            try {
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < reserveTrains.size()) {
                                    if (reserveTrains.get(aux).isTrain()) {
                                        ArrayList<Train_21317055_AriasHurtado> auxTrain = new ArrayList<>();
                                        auxTrain.add(reserveTrains.get(aux));
                                        subway.addTrain(auxTrain);
                                        reserveTrains.remove(aux);
                                        System.out.println("El tren se ingreso con exito");
                                        break;
                                    } else {
                                        System.out.println("El tren no se pudo ingresar");
                                        break;
                                    }
                                } else {
                                    System.out.println("El tren no se pudo ingresar");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                //Quitar trenes de la red de metro
                case 13:
                    if(!subway.getTrains().isEmpty()){
                        System.out.println("Indique el tren a retirar");
                        for(int i = 0; i< subway.getTrains().size(); i++){
                            System.out.println(i+1 +".Tren modelo: " + subway.getTrains().get(i).getTrainMaker() + ", ID: " + subway.getTrains().get(i).getIdTrain());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select -1;
                                if (aux >= 0 && aux < subway.getTrains().size()) {
                                    reserveTrains.add(subway.getTrains().get(aux));
                                    subway.getTrains().remove(aux);
                                    System.out.println("Se ha removido el tren con exito");
                                    break;
                                }else{
                                    System.out.println("Tren no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }
                    }else{
                        System.out.println("No hay trenes disponibles");
                    }
                    break;
                //Ingresar nuevo conductor
                case 14:
                    int userIdDriver;
                    while (true) {
                        System.out.println("Ingrese el id del nuevo conductor");
                        try {
                            userIdDriver = scanner.nextInt();
                            if(userIdDriver > 0){
                                break;
                            }else{
                                System.out.println("Ingrese un valor positivo");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }

                    String userNameDriver = "";
                    System.out.println("Ingrese el nombre del nuevo conductor");
                    while (userNameDriver.isEmpty()) {
                        userNameDriver = scanner.nextLine();
                    }

                    String userTrainMakerDriver = "";
                    System.out.println("Ingrese que tipo de tren puede manejar el conductor (Manufacturadora de tren)");
                    while (userTrainMakerDriver.isEmpty()) {
                        userTrainMakerDriver = scanner.nextLine();
                    }
                    Driver_21317055_AriasHurtado userDriver = new Driver_21317055_AriasHurtado(userIdDriver, userNameDriver, userTrainMakerDriver);
                    subway.getDrivers().add(userDriver);
                    break;

                //Quitar conductor del metro
                case 15:
                if(!subway.getDrivers().isEmpty()){
                    System.out.println("Conductores disponibles: ");
                    for(int i = 0; i < subway.getDrivers().size(); i++){
                        System.out.println(i + 1 + ". " + subway.getDrivers().get(i).getNameDriver() + ", ID: " + subway.getDrivers().get(i).getIdDriver());
                    }
                    while(true){
                        try{
                            select = scanner.nextInt();
                            int aux = select - 1;
                            if (aux >= 0 && aux < subway.getDrivers().size()) {
                                subway.getDrivers().remove(subway.getDrivers().get(aux));
                                System.out.println("Se ha retirado el conductor");
                                break;
                            }else{
                                System.out.println("Conductor no disponible");
                            }
                        }catch (InputMismatchException e) {
                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                            scanner.nextLine();
                        }
                    }
                }
                    break;
                //Asignar tren a linea
                case 16:
                    if(!subway.getLines().isEmpty() && !subway.getTrains().isEmpty()){
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren " + subway.getTrains().get(i).getTrainMaker() + " " + subway.getTrains().get(i).getIdTrain());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getTrains().size()) {
                                    System.out.println("Lineas disponibles");
                                    for (int i = 0; i < subway.getLines().size(); i++) {
                                        System.out.println(i+1 + ".Linea " + subway.getLines().get(i).getNameLine());
                                    }
                                    while(true){
                                        try{
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if(aux2 >= 0 && aux2 < subway.getLines().size()){
                                                subway.assignTrainToLine(subway.getTrains().get(aux),  subway.getLines().get(aux2));
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
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }

                    }else{
                        System.out.println("No hay trenes o lineas disponibles");
                    }
                    break;
                //Asignar conductor a tren
                case 17:
                    if(!subway.getLines().isEmpty() && !subway.getDrivers().isEmpty()){
                        System.out.println("Trenes disponibles");
                        for (int i = 0; i < subway.getTrains().size(); i++) {
                            System.out.println(i + 1 + ".Tren " + subway.getTrains().get(i).getTrainMaker() + " " + subway.getTrains().get(i).getIdTrain());
                        }
                        while(true){
                            try{
                                select = scanner.nextInt();
                                int aux = select - 1;
                                if (aux >= 0 && aux < subway.getTrains().size()) {
                                    System.out.println("Conductores disponibles");
                                    for (int i = 0; i < subway.getDrivers().size(); i++) {
                                        System.out.println(i+1 + ".Conductor " + subway.getDrivers().get(i).getNameDriver());
                                    }
                                    while(true){
                                        try{
                                            select = scanner.nextInt();
                                            int aux2 = select - 1;
                                            if(aux2 >= 0 && aux2 < subway.getDrivers().size()){
                                                Date newDate = new Date();
                                                long newDateData;
                                                System.out.println("Ingrese la hora de partida del tren");
                                                while(true){
                                                    newDateData = scanner.nextLong();
                                                    try{
                                                        newDate.setTime(newDateData);
                                                        break;
                                                    }catch (InputMismatchException e) {
                                                        System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                        scanner.nextLine();
                                                    }
                                                }
                                                System.out.println("Ingrese la estacion inicial del recorrido");
                                                subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).showStations();

                                                while(true){

                                                    try{
                                                        select = scanner.nextInt();
                                                        int aux3 = select - 1;
                                                        if(aux3 >= 0 && aux3 <= subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).getSections().size()) {
                                                            subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).showStations();
                                                            while(true){
                                                                System.out.println("Ingrese la estacion final del recorrido");
                                                                try{
                                                                    select = scanner.nextInt();
                                                                    int aux4 = select - 1;
                                                                    if(aux4 >= 0 && aux4 <= subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).getSections().size()){
                                                                        if(aux3 == aux4){
                                                                            System.out.println("las estaciones no pueden ser la misma");
                                                                        }else{
                                                                            subway.assignDriverToTrain(subway.getTrains().get(aux), subway.getDrivers().get(aux2),newDate, subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).getStationByPosition(aux3) , subway.getLineById(subway.getTrains().get(aux).getAssignedLine()).getStationByPosition(aux4));
                                                                            break;
                                                                        }
                                                                    }else{
                                                                        System.out.println("Estacion no disponible");
                                                                    }
                                                                }catch (InputMismatchException e) {
                                                                    System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                                    scanner.nextLine();
                                                                }
                                                            }
                                                            break;
                                                        }else{
                                                            System.out.println("Estacion no disponible");
                                                        }
                                                    }catch (InputMismatchException e) {
                                                        System.out.println("El valor ingresado no es un número entero. Intente nuevamente: ");
                                                        scanner.nextLine();
                                                    }

                                                }
                                                break;
                                            }else{
                                                System.out.println("Conductor no disponible");
                                            }
                                        }catch (InputMismatchException e) {
                                            System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                }else{
                                    System.out.println("Tren no disponible");
                                }
                            }catch (InputMismatchException e) {
                                System.out.println("El valor ingresado no es un numero entero. Intente nuevamente: ");
                                scanner.nextLine();
                            }
                        }

                    }else {
                        System.out.println("No hay trenes o conductores disponibles");
                    }
                    break;
                //volver
                case 18:
                    menuView();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 18);
    }
}