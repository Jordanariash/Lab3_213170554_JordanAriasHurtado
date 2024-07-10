package clases;

import java.util.ArrayList;
import java.util.Date;


public class Subway_21317055_AriasHurtado {
    private int idSubway;
    private String nameSubway;
    private ArrayList<Line_21317055_AriasHurtado> lines;
    private ArrayList<Train_21317055_AriasHurtado> trains;
    private ArrayList<Driver_21317055_AriasHurtado> drivers;


    public Subway_21317055_AriasHurtado(int idSubway, String nameSubway) {
        this.idSubway = idSubway;
        this.nameSubway = nameSubway;

        this.lines = new ArrayList<>();
        this.trains = new ArrayList<>();
        this.drivers = new ArrayList<>();

    }


    public int getIdSubway() {
        return idSubway;
    }

    public void setIdSubway(int idSubway) {
        this.idSubway = idSubway;
    }

    public String getNameSubway() {
        return nameSubway;
    }

    public void setNameSubway(String nameSubway) {
        this.nameSubway = nameSubway;
    }

    public ArrayList<Line_21317055_AriasHurtado> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line_21317055_AriasHurtado> lines) {
        this.lines = lines;
    }

    public ArrayList<Train_21317055_AriasHurtado> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train_21317055_AriasHurtado> trains) {
        this.trains = trains;
    }

    public ArrayList<Driver_21317055_AriasHurtado> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver_21317055_AriasHurtado> drivers) {
        this.drivers = drivers;
    }


    public Line_21317055_AriasHurtado getLineById(int idLine) {
        for (Line_21317055_AriasHurtado line : lines) {
            if (line.getIdLine() == idLine) {
                return line;
            }
        }
        return null;
    }

    public Train_21317055_AriasHurtado getTrainById(int idTrain) {
        for (Train_21317055_AriasHurtado train : trains) {
            if (train.getIdTrain() == idTrain) {
                return train;
            }
        }
        return null;
    }

    public Driver_21317055_AriasHurtado getDriverById(int idDriver) {
        for (Driver_21317055_AriasHurtado driver : drivers) {
            if (driver.getIdDriver() == idDriver) {
                return driver;
            }
        }
        return null;
    }

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

    public Line_21317055_AriasHurtado getLineByStation(int idStation) {
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).getSections().size(); j++) {
                if (idStation == lines.get(i).getSections().get(j).getStation1().getIdStation() || idStation == lines.get(i).getSections().get(j).getStation2().getIdStation()) {
                    return lines.get(i);
                }
            }
        }
        return null;
    }



    //añadir la verificacion de elementos unicos
    public void addLine(ArrayList<Line_21317055_AriasHurtado> lines) {
        ArrayList<Line_21317055_AriasHurtado> linesUnrepeated = new ArrayList<Line_21317055_AriasHurtado>();
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).isLine()) {
                System.out.println("La linea " + lines.get(i).getNameLine() + " es invalida");
                break;
            }
            if (!linesUnrepeated.contains(lines.get(i))) {
                linesUnrepeated.add(lines.get(i));
            }
        }
        this.lines.addAll(linesUnrepeated);
    }

    public void addTrain(ArrayList<Train_21317055_AriasHurtado> trains) {
        ArrayList<Train_21317055_AriasHurtado> trainsUnrepeated = new ArrayList<Train_21317055_AriasHurtado>();
        for (int i = 0; i < trains.size(); i++) {
            if (!trains.get(i).isTrain(trains.get(i))) {
                System.out.println("El tren N° " + trains.get(i).getIdTrain() + " es invalido");
            }
            if (!trainsUnrepeated.contains(trains.get(i))) {
                trainsUnrepeated.add(trains.get(i));
            }
        }
        this.trains.addAll(trainsUnrepeated);
    }

    public void addDriver(ArrayList<Driver_21317055_AriasHurtado> drivers) {
        ArrayList<Driver_21317055_AriasHurtado> driversUnrepeated = new ArrayList<Driver_21317055_AriasHurtado>();
        for (int i = 0; i < drivers.size() - 1; i++) {
            if (!driversUnrepeated.contains(drivers.get(i))) {
                driversUnrepeated.add(drivers.get(i));
            }
        }
        this.drivers.addAll(drivers);
    }

    public void myToString() {
        System.out.println("*********************************************");
        System.out.println("id subway: " + getIdSubway());
        System.out.println("nombre subway: " + getNameSubway());
        System.out.println("-----------------lineas----------------------");
        if (lines != null && !lines.isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                lines.get(i).showInfoLine();
                if (lines.get(i).getAssignedTrains().isEmpty()) {
                    System.out.println("la linea no tiene asignado ningun tren");
                } else {
                    System.out.println("la linea tiene asignado el/los trenes: ");
                    System.out.println(getLines().get(i).getAssignedTrains());
                }
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("No hay lineas");
        }
        System.out.println("-----------------trenes----------------------");
        if (trains != null && !trains.isEmpty()) {
            for (int i = 0; i < trains.size(); i++) {
                trains.get(i).showInfoTrain();
                if (trains.get(i).getArriveStation() == null) {
                    System.out.println("El tren no esta asignado a ninguna linea");
                } else {
                    System.out.println("El tren esta asignado a la linea: " + getLineById(trains.get(i).getAssignedLine()).getNameLine());
                    System.out.println("Parte su recorrido en la estacion " + trains.get(i).getDepartureStation().getNameStation() + " y termina en " + trains.get(i).getArriveStation().getNameStation());
                    System.out.println("Y comienza el recorrido a las: " + trains.get(i).getDepartureTime());
                }
                if (trains.get(i).getAssignedDriver() == 0) {
                    System.out.println("El tren no tiene asignado a ningun conductor");
                } else {
                    System.out.println("el tren tiene asignado al conductor: " + getDriverById(trains.get(i).getAssignedDriver()).getNameDriver());


                    System.out.println("---------------------------------------------");
                }
            }
        } else {
            System.out.println("no hay trenes");
            System.out.println("---------------------------------------------");
        }
        System.out.println("-----------------conductores-----------------");
        if (drivers != null && !drivers.isEmpty()) {
            for (int i = 0; i < drivers.size(); i++) {
                drivers.get(i).showInfoDriver();
                if (drivers.get(i).getAssignedTrain() == 0) {
                    System.out.println("El conductor no esta asignado a ningun tren");
                } else {
                    System.out.println("El conductor esta asignado al tren: " + drivers.get(i).getAssignedTrain());
                }
            }
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("no hay conductores");
            System.out.println("---------------------------------------------");
        }
        System.out.println("*********************************************");
    }

    public void assignTrainToLine(Train_21317055_AriasHurtado train, Line_21317055_AriasHurtado line) {
        line.getAssignedTrains().add(train.getIdTrain());
        train.setAssignedLine(line.getIdLine());
    }

    public void assignDriverToTrain(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver, Date departureTime, Station_213170554_AriasHurtado departureStation, Station_213170554_AriasHurtado arriveStation) {
        train.setAssignedDriver(driver.getIdDriver());
        driver.setAssignedTrain(train.getIdTrain());

        train.setDepartureTime(departureTime);
        driver.setDepartureTime(departureTime);

        if (areInTheSameLine(departureStation, arriveStation) && !departureStation.sameStation(arriveStation)) {
            train.setDepartureStation(departureStation);
            train.setArriveStation(arriveStation);
        } else {
            throw new IllegalArgumentException("las estaciones deben pertenecer a la misma linea, y ser distintas entre si");
        }

    }

    public long calcTime(Section_21317055_AriasHurtado section,Train_21317055_AriasHurtado train){
        return (section.getDistance()/train.getSpeed()) + section.getStation1().getStopTime()+ train.getStationStaytime() + section.getStation2().getStopTime() + train.getStationStaytime();
    }

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

    public Station_213170554_AriasHurtado whereIsTrain(Train_21317055_AriasHurtado train, Date time) {
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