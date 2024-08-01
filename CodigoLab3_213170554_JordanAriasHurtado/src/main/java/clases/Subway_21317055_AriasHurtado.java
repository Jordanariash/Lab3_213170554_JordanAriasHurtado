package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Subway que representa un sistema de metro operativo
 * Cada metro tiene un conjunto de lineas, trenes, y conductores
 */
public class Subway_21317055_AriasHurtado {
    private int idSubway;
    private String nameSubway;
    private ArrayList<Line_21317055_AriasHurtado> lines;
    private ArrayList<Train_21317055_AriasHurtado> trains;
    private ArrayList<Driver_21317055_AriasHurtado> drivers;

    /**
     * Constructor de Subway
     * Crea un metro con id, y nombre especificados
     *
     * @param idSubway identificador unico del metro
     * @param nameSubway nombre propio del metro
     */
    public Subway_21317055_AriasHurtado(int idSubway, String nameSubway) {
        this.idSubway = idSubway;
        this.nameSubway = nameSubway;

        this.lines = new ArrayList<>();
        this.trains = new ArrayList<>();
        this.drivers = new ArrayList<>();

    }

    /**
     * Consigue el id de un subway
     * @return id de un subway
     */
    public int getIdSubway() {
        return idSubway;
    }

    /**
     * Consigue el nombre de un subway
     * @return nombre de un subway
     */
    public String getNameSubway() {
        return nameSubway;
    }

    /**
     * Consigue la lista de lineas de un subway
     * @return lista de lineas
     */
    public ArrayList<Line_21317055_AriasHurtado> getLines() {
        return lines;
    }

    /**
     * Consigue la lista de trenes de un subway
     * @return lista de trenes
     */
    public ArrayList<Train_21317055_AriasHurtado> getTrains() {
        return trains;
    }

    /**
     * Consigue la lista de conductores de un subway
     * @return lista de conductores de un subway
     */
    public ArrayList<Driver_21317055_AriasHurtado> getDrivers() {
        return drivers;
    }

    /**
     * Consigue una linea dado un id especificado
     * @return linea con el id especificado
     */
    public Line_21317055_AriasHurtado getLineById(int idLine) {
        for (Line_21317055_AriasHurtado line : lines) {
            if (line.getIdLine() == idLine) {
                return line;
            }
        }
        return null;
    }

    /**
     * Consigue un tren dado un id especificado
     * @return tren con el id especificado
     */
    public Train_21317055_AriasHurtado getTrainById(int idTrain) {
        for (Train_21317055_AriasHurtado train : trains) {
            if (train.getIdTrain() == idTrain) {
                return train;
            }
        }
        return null;
    }

    /**
     * Consigue un conductor dado un id especificado
     * @return conductor con el id especificado
     */
    public Driver_21317055_AriasHurtado getDriverById(int idDriver) {
        for (Driver_21317055_AriasHurtado driver : drivers) {
            if (driver.getIdDriver() == idDriver) {
                return driver;
            }
        }
        return null;
    }

    /**
     * Verifica si 2 estaciones estan en la misma linea dentro del metro
     * @param station1 estacion
     * @param station2 estacion
     * @return verdadero o falso
     */
    public boolean areInTheSameLine(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2) {
        //en cada linea
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).getSections().size(); j++) {
                if (lines.get(i).getSections().get(j).getStation1().sameStation(station1) || lines.get(i).getSections().get(j).getStation2().sameStation(station1)) {
                    for (int k = j; k < lines.get(i).getSections().size(); k++) {
                        if (lines.get(i).getSections().get(k).getStation1().sameStation(station2) || lines.get(i).getSections().get(k).getStation2().sameStation(station2)) {
                            return true;
                        }
                    }
                }
            }
            for (int j = 0; j < lines.get(i).getSections().size(); j++) {
                if (lines.get(i).getSections().get(j).getStation1().sameStation(station2) || lines.get(i).getSections().get(j).getStation2().sameStation(station2)) {
                    for (int k = j; k < lines.get(i).getSections().size(); k++) {
                        if (lines.get(i).getSections().get(k).getStation1().sameStation(station1) || lines.get(i).getSections().get(k).getStation2().sameStation(station1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Calcula el tiempo que demora en llegar un tren de una estacion a otra dentro de una seccion
     * @param section seccion
     * @param train tren
     * @return tiempo
     */
    public long calcTime(Section_21317055_AriasHurtado section,Train_21317055_AriasHurtado train){
        return (section.getDistance()/train.getSpeed()) + section.getStation1().getStopTime()+ train.getStationStaytime() + section.getStation2().getStopTime() + train.getStationStaytime();
    }

    /**
     * Verifica si 2 estaciones estan en orden dentro de la linea
     * @param station1 estacion de partida
     * @param station2 estacion de llegada
     * @param line linea de la que pertenecen ambas lineas
     * @return verdadero o falso
     */
    public boolean areInOrder(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2, Line_21317055_AriasHurtado line){
        for(int i = 0; i < line.getSections().size(); i++){
            if(line.getSections().get(i).getStation1().sameStation(station1)){
                return true;
            }
            if(line.getSections().get(i).getStation1().sameStation(station2)){
                return false;
            }
        }
        return false;
    }

    /**
     * Añade unao mas linea al subway si cumple con los requerimientos necesarios
     * verificando ademas, si al momento de ingresar al metro, tienen id, nombre, o alguna estacion repetida a nivel de linea y metro
     * @param lines line list
     */
    public void addLine(ArrayList<Line_21317055_AriasHurtado> lines) {
        // Crear una lista auxiliar para almacenar secciones
        ArrayList<Section_21317055_AriasHurtado> auxSections = new ArrayList<>();

        int preSize = getLines().size();

        // Rellenar la linea auxiliar existentes
        for (int i = 0; i < getLines().size(); i++) {
            auxSections.addAll(getLines().get(i).getSections());
        }

        // Crear una línea auxiliar para la verificación de secciones repetidas
        Line_21317055_AriasHurtado auxLine = new Line_21317055_AriasHurtado(-1, "-", "-", auxSections);

        // Si la lista de líneas está vacia, añadir la primera línea válida
        if (getLines().isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).isLine()) {
                    this.lines.add(lines.get(i));
                    break;
                }
            }
        }

        // Verificar y añadir nuevas líneas
        for (int i = 0; i < lines.size(); i++) {
            boolean isDuplicate = false;

            // Verificar duplicados en las líneas existentes
            for (int j = 0; j < getLines().size(); j++) {
                if (getLines().get(j).sameLine(lines.get(i))) {
                    //System.out.println("La línea ingresada tiene el mismo ID o nombre y no se puede añadir");
                    isDuplicate = true;
                    break;
                }
            }
            // Solo proceder si no se encontró un duplicado
            if (!isDuplicate) {
                if (!lines.get(i).isLine()) {
                    System.out.println("La línea " + lines.get(i).getNameLine() + " es inválida");
                } else if (lines.get(i).getSections().isEmpty()) {
                    this.lines.add(lines.get(i));
                } else {
                    auxSections.addAll(lines.get(i).getSections());
                    if (auxLine.unrepeatedStationsInLine()) {
                        this.lines.add(lines.get(i));
                    } else {
                        System.out.println("Una de las estaciones de la línea ingresada tiene una estación repetida con las ya ingresadas en el sistema, no se pudo añadir al metro");
                    }
                }
            }
        }

        if (preSize == getLines().size()){
            System.out.println("La linea ingresada tiene el mismo ID o nombre y no se puede añadir");
        }else{
            System.out.println("Las lineas se añadieron con exito");
        }
    }

    /**
     * Añade uno o mas trenes al subway si cumple con los requerimientos necesarios
     * verificando ademas, si al momento de ingresar al metro, tienen id, o algun vagon con id repetido a nivel de tren y metro
     * @param trains train list
     */
    public void addTrain(ArrayList<Train_21317055_AriasHurtado> trains) {
        // Crear una lista auxiliar para almacenar los vagones
        ArrayList<PassangerCar_21317055_AriasHurtado> auxPcars = new ArrayList<>();

        int preSize = getLines().size();

        // Rellenar con los vagones de los trenes existentes
        for (int i = 0; i < getTrains().size(); i++) {
            auxPcars.addAll(getTrains().get(i).getCarList());
        }

        // Crear un tren auxiliar para la verificación de vagones repetidos
        Train_21317055_AriasHurtado auxTrain = new Train_21317055_AriasHurtado(0, "auxTrain", 0, 0, auxPcars);

        // Si la lista de trenes está vacía, añadir el primer tren válido
        if (getTrains().isEmpty()) {
            for (int i = 0; i < trains.size(); i++) {
                if (trains.get(i).isTrain()) {
                    this.trains.add(trains.get(i));
                    break;
                }
            }
        }

        // Verificar y añadir nuevos trenes
        for (int i = 0; i < trains.size(); i++) {
            boolean isDuplicate = false;

            // Verificar duplicados en los trenes existentes
            for (int j = 0; j < getTrains().size(); j++) {
                if (getTrains().get(j).sameTrain(trains.get(i))) {
                    isDuplicate = true;
                    break;
                }
            }

            // Solo proceder si no se encontró un duplicado
            if (!isDuplicate) {
                if (!trains.get(i).isTrain()) {
                    System.out.println("El tren modelo " + trains.get(i).getTrainMaker() + " id " + trains.get(i).getIdTrain() + " es inválido");
                } else if (trains.get(i).getCarList().isEmpty()) {
                    this.trains.add(trains.get(i));
                } else {
                    auxPcars.addAll(trains.get(i).getCarList());
                    if (auxTrain.unrepeatedPcars()) {
                        this.trains.add(trains.get(i));
                    } else {
                        System.out.println("Uno de los trenes ingresados tiene un vagón repetido con los ya ingresados en el sistema, no se pudo añadir al metro");
                    }
                }
            }
        }

        if (preSize == getTrains().size()){
            System.out.println("El tren ingresado tiene el mismo ID y no se puede añadir");
        }else{
            System.out.println("Los trenes se añadieron con exito");
        }
    }

    /**
     * Añade uno o mas conductores al subway
     * verificando ademas, si al momento de ingresar al metro, tienen id repetido a nivel de metro
     * @param drivers driver list
     */
    public void addDriver(ArrayList<Driver_21317055_AriasHurtado> drivers) {
        int preSize = getLines().size();

        if(getDrivers().isEmpty()){
            this.drivers.add(drivers.get(0));
        }
        for (int i = 0; i < drivers.size(); i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < getDrivers().size(); j++) {
                if (getDrivers().get(j).sameDriver(drivers.get(i))) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                this.drivers.add(drivers.get(i));
            }
        }

        if (preSize == getDrivers().size()){
            System.out.println("El conductor ingresado tiene el mismo ID y no se puede añadir");
        }else{
            System.out.println("Los conductores se añadieron con exito");
        }
    }

    /**
     * Permite expresar la red de metro en formato String
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*********************************************\n");
        sb.append("id subway: ").append(getIdSubway()).append("\n");
        sb.append("nombre subway: ").append(getNameSubway()).append("\n");
        sb.append("-----------------lineas----------------------\n");

        if (lines != null && !lines.isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                sb.append(lines.get(i).getInfoLine()).append("\n");
                if (lines.get(i).getAssignedTrains().isEmpty()) {
                    sb.append("la linea no tiene asignado ningun tren\n");
                } else {
                    sb.append("la linea tiene asignado el/los trenes: \n");
                    for (int j = 0; j < lines.get(i).getAssignedTrains().size(); j++) {
                        int aux = 0;
                        for (int k = 0; k < trains.size(); k++) {
                            if (getLines().get(i).getAssignedTrains().get(j) == trains.get(k).getIdTrain()) {
                                sb.append("Tren modelo ").append(getTrainById(getLines().get(i).getAssignedTrains().get(j)).getTrainMaker())
                                        .append("; ID: ").append(getLines().get(i).getAssignedTrains().get(j)).append("\n");
                                aux++;
                                break;
                            }
                        }
                        if (aux == 0) {
                            sb.append("El tren con ID: ").append(getLines().get(i).getAssignedTrains().get(j)).append(" ,no se encuentra disponible\n");
                        }
                    }
                }
                sb.append("---------------------------------------------\n");
            }
        } else {
            sb.append("No hay lineas\n");
        }

        sb.append("-----------------trenes----------------------\n");
        if (trains != null && !trains.isEmpty()) {
            for (int i = 0; i < trains.size(); i++) {
                sb.append(trains.get(i).getInfoTrain()).append("\n");
                if (trains.get(i).getAssignedLine() == 0) {
                    sb.append("El tren no esta asignado a ninguna linea\n");
                } else {
                    if (!lines.isEmpty()) {
                        for (int j = 0; j < lines.size(); j++) {
                            if (trains.get(i).getAssignedLine() == lines.get(j).getIdLine()) {
                                sb.append("El tren esta asignado a la linea: ").append(getLineById(trains.get(i).getAssignedLine()).getNameLine()).append("\n");
                                sb.append("Parte su recorrido ").append(trains.get(i).getDepartureStation().getNameStation())
                                        .append(" y termina en ").append(trains.get(i).getArriveStation().getNameStation()).append("\n");
                                sb.append("Y comienza el recorrido a las: ").append(trains.get(i).getDepartureTime()).append("\n");
                                break;
                            }
                        }
                    } else {
                        sb.append("La linea a la que se le asigno el tren no se encuentra disponible\n");
                    }
                }
                if (trains.get(i).getAssignedDriver() == 0) {
                    sb.append("El tren no tiene asignado a ningun conductor\n");
                } else {
                    if (!drivers.isEmpty()) {
                        for (int j = 0; j < drivers.size(); j++) {
                            if (trains.get(i).getAssignedDriver() == drivers.get(j).getIdDriver()) {
                                sb.append("el tren tiene asignado al conductor: ").append(getDriverById(trains.get(i).getAssignedDriver()).getNameDriver()).append("\n");
                                break;
                            }
                        }
                    } else {
                        sb.append("El conductor que se le asigno al tren no se encuentra disponible\n");
                    }
                }
                sb.append("---------------------------------------------\n");
            }
        } else {
            sb.append("no hay trenes\n");
            sb.append("---------------------------------------------\n");
        }

        sb.append("-----------------conductores-----------------\n");
        if (drivers != null && !drivers.isEmpty()) {
            for (int i = 0; i < drivers.size(); i++) {
                sb.append(drivers.get(i).getInfoDriver()).append("\n");
                if (drivers.get(i).getAssignedTrain() == 0) {
                    sb.append("El conductor no tiene asignado ningun tren\n");
                } else {
                    if (!trains.isEmpty()) {
                        for (int j = 0; j < trains.size(); j++) {
                            if (drivers.get(i).getAssignedTrain() == trains.get(j).getIdTrain()) {
                                sb.append("El conductor tiene asignado el tren modelo: ").append(trains.get(j).getTrainMaker())
                                        .append("; ID:").append(trains.get(j).getIdTrain()).append("\n");
                                break;
                            }
                        }
                    } else {
                        sb.append("El tren que se le asigno al conductor no se encuentra disponible\n");
                    }
                }
                sb.append("---------------------------------------------\n");
            }
        } else {
            sb.append("no hay conductores\n");
            sb.append("---------------------------------------------\n");
        }
        sb.append("*********************************************\n");

        return sb.toString();
    }

    /**
     * Permite asignar un tren a una linea dentro del metro
     * @param train tren a asignar
     * @param line linea a la cual asignar tren
     */
    public void assignTrainToLine(Train_21317055_AriasHurtado train, Line_21317055_AriasHurtado line) {
        line.getAssignedTrains().add(train.getIdTrain());
        train.setAssignedLine(line.getIdLine());
    }

    /**
     * Permite asignar a un tren, un conductor, una hora de partida, una estacion de partida, y final
     * @param train tren
     * @param driver conductor a asignar
     * @param departureTime hora de partida en UNIX
     * @param departureStation estacion de partida
     * @param arriveStation estacion de llegada
     */
    public void assignDriverToTrain(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver, Date departureTime, Station_213170554_AriasHurtado departureStation, Station_213170554_AriasHurtado arriveStation) {
        train.setAssignedDriver(driver.getIdDriver());
        driver.setAssignedTrain(train.getIdTrain());

        train.setDepartureTime(departureTime);

        if (areInTheSameLine(departureStation, arriveStation) && !departureStation.sameStation(arriveStation)) {
            train.setDepartureStation(departureStation);
            train.setArriveStation(arriveStation);
        } else {
            throw new IllegalArgumentException("las estaciones deben pertenecer a la misma linea, y ser distintas entre si");
        }

    }

    /**
     * Permite saber la estacion mas proxima a un tren dada una fecha
     * @param train tren a consultar
     * @param time Fecha en UNIX
     * @return Station
     */
    public Station_213170554_AriasHurtado whereIsTrain(Train_21317055_AriasHurtado train, Date time) {
        if (train.getDepartureTime() == null) {
            System.out.println("El tren no tiene una hora de salida");
        } else {
            //dada una estacion, empezar a calcular desde el inicio:
            //si es estacion 1, empezar a contar desde esa estacion

            //hora de partida del tren
            long departure = train.getDepartureTime().getTime();

            //hora ingresada por el usuario
            long auxTime = time.getTime();
            //Departure y arrive estan en orden A-b-C


            if(areInOrder(train.getDepartureStation(),train.getArriveStation(),getLineById(train.getAssignedLine()))){
                //Recorra la linea
                for(int i = 0; i < getLineById(train.getAssignedLine()).getSections().size() ; i++){
                    //y si encuentra la estacion
                    if(getLineById(train.getAssignedLine()).getSections().get(i).getStation1().sameStation(train.getDepartureStation())){
                        //empieza a acumular
                        for(int j = i; j < getLineById(train.getAssignedLine()).getSections().size() ; j++) {
                            long departureAux = departure;
                            departure = departure + calcTime(getLineById(train.getAssignedLine()).getSections().get(j), train);
                            if(time.getTime() < departure){
                                if(Math.abs(time.getTime()-departure)< Math.abs(time.getTime()-departureAux)){
                                    return getLineById(train.getAssignedLine()).getSections().get(j).getStation2();
                                }else{
                                    return getLineById(train.getAssignedLine()).getSections().get(j).getStation1();
                                }
                            }

                            //pero si sigue y llega hasta el final, y se pasa la hora, retorna la ultima estacion
                            if(getLineById(train.getAssignedLine()).getSections().get(j).getStation2().sameStation(train.getArriveStation())){
                                System.out.println("La hora ingresada, supera al recorrido del tren, y su ultima estacion es: ");
                                return train.getArriveStation();
                            }
                        }
                    }
                }
            }else{

                for(int i = getLineById(train.getAssignedLine()).getSections().size()-1; i > 0  ; i--){
                    //y si encuentra la estacion

                    if(getLineById(train.getAssignedLine()).getSections().get(i).getStation2().sameStation(train.getDepartureStation())){
                        //empieza a acumular
                        for(int j = i; j >= 0 ; j--) {
                            long departureAux = departure;
                            departure = departure + calcTime(getLineById(train.getAssignedLine()).getSections().get(j), train);
                            if(time.getTime() < departure){
                                if(Math.abs(time.getTime()-departure)< Math.abs(time.getTime()-departureAux)){
                                    return getLineById(train.getAssignedLine()).getSections().get(j).getStation1();
                                }else{
                                    return getLineById(train.getAssignedLine()).getSections().get(j).getStation2();
                                }
                            }

                            //pero si sigue y llega hasta el final, y se pasa la hora, retorna la ultima estacion
                            if(getLineById(train.getAssignedLine()).getSections().get(j).getStation1().sameStation(train.getArriveStation())){
                                System.out.println("La hora ingresada, supera al recorrido del tren, y su ultima estacion es: ");
                                return train.getArriveStation();
                            }
                        }
                    }
                }
            }
            //Departure y arriver estan invertidas C-b-A
        }
        return null;
    }

    /**
     * Permite saber el recorrido restante que queda a un tren dada una fecha en unix
     * @param train tren a consultar
     * @param time fecha en UNIX
     * @return Station list
     */
    public ArrayList <Station_213170554_AriasHurtado> trainPath(Train_21317055_AriasHurtado train, Date time) {
        ArrayList<Station_213170554_AriasHurtado> path = new ArrayList<>();
        if (train.getDepartureTime() == null) {
            System.out.println("El tren no esta asignado a ninguna linea");
        } else {
            //dada una estacion, empezar a calcular desde el inicio:
            //si es estacion 1, empezar a contar desde esa estacion

            //hora de partida del tren
            long departure = train.getDepartureTime().getTime();

            //hora ingresada por el usuario
            long auxTime = time.getTime();
            //Departure y arrive estan en orden A-b-C


            if(areInOrder(train.getDepartureStation(),train.getArriveStation(),getLineById(train.getAssignedLine()))){
                //Recorra la linea
                for(int i = 0; i < getLineById(train.getAssignedLine()).getSections().size() ; i++){
                    //y si encuentra la estacion
                    if(getLineById(train.getAssignedLine()).getSections().get(i).getStation1().sameStation(train.getDepartureStation())){
                        //empieza a acumular
                        for(int j = i; j < getLineById(train.getAssignedLine()).getSections().size() ; j++) {
                            long departureAux = departure;
                            departure = departure + calcTime(getLineById(train.getAssignedLine()).getSections().get(j), train);
                            if(time.getTime() < departure){
                                if(Math.abs(time.getTime()-departure)< Math.abs(time.getTime()-departureAux)){
                                    for(int k = j; k < getLineById(train.getAssignedLine()).getSections().size();k++){
                                        path.add(getLineById(train.getAssignedLine()).getSections().get(k).getStation2());
                                        if(getLineById(train.getAssignedLine()).getSections().get(k).getStation2().sameStation(train.getArriveStation())){
                                            return path;
                                        }
                                    }
                                }
                                //retorno un, no quedan estaciones por la hora
                                for(int k = j; k < getLineById(train.getAssignedLine()).getSections().size();k++){
                                    path.add(getLineById(train.getAssignedLine()).getSections().get(k).getStation2());
                                    if(getLineById(train.getAssignedLine()).getSections().get(k).getStation2().sameStation(train.getArriveStation())){
                                        return path;
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                //Departure y arriver estan invertidas C-b-A
                for(int i = getLineById(train.getAssignedLine()).getSections().size()-1; i > 0  ; i--) {
                    //y si encuentra la estacion
                    if (getLineById(train.getAssignedLine()).getSections().get(i).getStation2().sameStation(train.getDepartureStation())) {
                        //empieza a acumular
                        for (int j = i; j >= 0; j--) {
                            long departureAux = departure;
                            departure = departure + calcTime(getLineById(train.getAssignedLine()).getSections().get(j), train);
                            if (time.getTime() < departure) {
                                if (Math.abs(time.getTime() - departure) < Math.abs(time.getTime() - departureAux)) {
                                    for (int k = j ; k >= 0; k--) {
                                        path.add(getLineById(train.getAssignedLine()).getSections().get(k).getStation1());
                                        if (getLineById(train.getAssignedLine()).getSections().get(k).getStation1().sameStation(train.getArriveStation())) {
                                            return path;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return null;
    }
}