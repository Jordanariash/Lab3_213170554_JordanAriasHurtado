package clases;

import java.util.ArrayList;
import java.util.Date;


public class Subway_21317055_AriasHurtado {
    private int idSubway;
    private String nameSubway;
    private ArrayList<Line_21317055_AriasHurtado> lines;
    private ArrayList<Train_21317055_AriasHurtado> trains;
    private ArrayList<Driver_21317055_AriasHurtado> drivers;
    private ArrayList<pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado>> assignedTrains;
    private ArrayList<pairTrainDriver> assignedDrivers;

    public Subway_21317055_AriasHurtado(int idSubway, String nameSubway){
        this.idSubway = idSubway;
        this.nameSubway = nameSubway;

        this.lines = new ArrayList<>();

        this.trains = new ArrayList<>();
        this.drivers = new ArrayList<>();
        this.assignedTrains = new ArrayList<>();
        this.assignedDrivers = new ArrayList<>();

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

    public ArrayList<pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado>> getAssignedTrains() {
        return assignedTrains;
    }

    public void setAssignedTrains(ArrayList<pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado>> assignedTrains) {
        this.assignedTrains = assignedTrains;
    }

    public ArrayList<pairTrainDriver> getAssignedDrivers() {
        return assignedDrivers;
    }

    public void setAssignedDrivers(ArrayList<pairTrainDriver> assignedDrivers) {
        this.assignedDrivers = assignedDrivers;
    }



    public Line_21317055_AriasHurtado getLineById(int idLine){
        for (Line_21317055_AriasHurtado line : lines) {
            if (line.getIdLine() == idLine) {
                return line;
            }
        }
        return null;
    }




    public void addLine(ArrayList<Line_21317055_AriasHurtado> lines){
        ArrayList<Line_21317055_AriasHurtado> linesUnrepeated= new ArrayList<Line_21317055_AriasHurtado>();
        for(int i = 0; i < lines.size(); i++){
            if(!lines.get(i).isLine()){
                System.out.println("La linea "+ lines.get(i).getNameLine() +" es invalida");
                break;
            }
            if(!linesUnrepeated.contains(lines.get(i))){
                linesUnrepeated.add(lines.get(i));
            }
        }
        this.lines.addAll(linesUnrepeated);
    }

    public void addTrain(ArrayList<Train_21317055_AriasHurtado> trains){
        ArrayList<Train_21317055_AriasHurtado> trainsUnrepeated= new ArrayList<Train_21317055_AriasHurtado>();
        for(int i = 0; i < trains.size(); i++){
            if(!trains.get(i).sameModel() || !trains.get(i).validBody()){
                System.out.println("El tren N° "+ trains.get(i).getIdTrain() + " es invalido");
                break;
            }
            if(!trainsUnrepeated.contains(trains.get(i))){
                trainsUnrepeated.add(trains.get(i));
            }
        }
        this.trains.addAll(trainsUnrepeated);
    }

    public void addDriver(ArrayList<Driver_21317055_AriasHurtado> drivers){
        ArrayList<Driver_21317055_AriasHurtado> driversUnrepeated = new ArrayList<Driver_21317055_AriasHurtado>();
        for(int i = 0; i < drivers.size()-1; i++){
            if(!driversUnrepeated.contains(drivers.get(i))){
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
                System.out.println("la linea tiene asignado el/los trenes: ");
                for(int j = 0; j < assignedTrains.size(); j++){
                    if(assignedTrains.get(j).getLine().getIdLine() == lines.get(i).getIdLine()){
                        System.out.println(assignedTrains.get(j).getTrain().getIdTrain());
                    }
                }
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("no hay lineas");
            System.out.println("---------------------------------------------");
        }
        System.out.println("-----------------trenes----------------------");
        if (trains != null && !trains.isEmpty()) {
            for (int i = 0; i < trains.size(); i++) {
                trains.get(i).showInfoTrain();
                System.out.println("---------------------------------------------");
                System.out.println("el tren tiene asignados a los conductores: ");
                for(int j = 0; j < assignedDrivers.size(); j++){
                    if(assignedDrivers.get(j).getDriver().getIdDriver() == trains.get(i).getIdTrain()){
                        System.out.println(assignedDrivers.get(j).getDriver().getIdDriver());
                    }

                }
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("no hay trenes");
            System.out.println("---------------------------------------------");
        }
        System.out.println("-----------------conductores-----------------");
        if(drivers != null && !drivers.isEmpty()) {
            for (int i = 0; i < drivers.size(); i++) {
               drivers.get(i).showInfoDriver();
            }
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("no hay conductores");
            System.out.println("---------------------------------------------");
        }
        System.out.println("*********************************************");
    }

    public void assignTrainToLine(Train_21317055_AriasHurtado train, Line_21317055_AriasHurtado line) {
        pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado> pair = new pairTrainLine<>(train, line);
        assignedTrains.add(pair);
    }

    public void assignDriverToTrain(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver, Date departureTime,Station_213170554_AriasHurtado departureStation, Station_213170554_AriasHurtado arriveStation){
        pairTrainDriver pair = new pairTrainDriver(train, driver, departureTime ,departureStation, arriveStation);
        assignedDrivers.add(pair);
    }

    public static void main(String[] args){
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

        train1.addCar(0,pcar1);
        train1.addCar(1,pcar2);
        train1.addCar(2,pcar3);
        train1.addCar(3,pcar4);
        train1.addCar(4,pcar5);

        Driver_21317055_AriasHurtado driver1 = new Driver_21317055_AriasHurtado(1, "charmander", "atom");
        Driver_21317055_AriasHurtado driver2= new Driver_21317055_AriasHurtado(2, "squirtle", "atom");
        Driver_21317055_AriasHurtado driver3 = new Driver_21317055_AriasHurtado(3, "bulbasaur", "atom");

        ArrayList<Line_21317055_AriasHurtado> lines = new ArrayList<>();
        ArrayList<Train_21317055_AriasHurtado> trains = new ArrayList<>();
        ArrayList<Driver_21317055_AriasHurtado> drivers = new ArrayList<>();
        ArrayList<pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado>> assignedTrains = new ArrayList<>();
        ArrayList<pairTrainDriver> assignedDrivers = new ArrayList<>();

        Subway_21317055_AriasHurtado subway1= new Subway_21317055_AriasHurtado(1, "metro");
        lines.add(line1);
        trains.add(train1);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        subway1.addLine(lines);
        subway1.addTrain(trains);
        subway1.addDriver(drivers);
        subway1.assignTrainToLine(train1, line1);
        Date departureTime = new Date();
        subway1.assignDriverToTrain(train1, driver1, departureTime, station1 ,station6);
        subway1.myToString();
    }
}