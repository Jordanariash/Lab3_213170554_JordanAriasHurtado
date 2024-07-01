package clases;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Subway_21317055_AriasHurtado {
    private int idSubway;
    private String nameSubway;
    private ArrayList<Line_21317055_AriasHurtado> lines;
    private ArrayList<Train_21317055_AriasHurtado> trains;
    private ArrayList<Driver_21317055_AriasHurtado> drivers;



    public Subway_21317055_AriasHurtado(int idSubway, String nameSubway){
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


    public Line_21317055_AriasHurtado getLineById(int idLine){
        for (Line_21317055_AriasHurtado line : lines) {
            if (line.getIdLine() == idLine) {
                return line;
            }
        }
        return null;
    }

    public Train_21317055_AriasHurtado getTrainById(int idTrain){
        for (Train_21317055_AriasHurtado train : trains) {
            if (train.getIdTrain() == idTrain) {
                return train;
            }
        }
        return null;
    }

    public boolean areInTheSameLine(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2){
        //en cada linea
        for(int i = 0; i < lines.size(); i++){
            for (int j = 0; j < lines.get(i).getSections().size(); j++){
                //si esta la primera estacion en la linea
                if (lines.get(i).getSections().get(j).getStation1().sameStation(station1) || lines.get(i).getSections().get(j).getStation2().sameStation(station1)) {
                    if (lines.get(i).getSections().get(j).getStation1().sameStation(station2) || lines.get(i).getSections().get(j).getStation2().sameStation(station2)) {
                        return true;
                }
                }
            }
        }
        return false;
    }



    //añadir la verificacion de elementos unicos
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
                //falta añadir esto
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
                //falta añadir esto
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
        line.getAssignedTrains().add(train.getIdTrain());
        train.setAssignedLine(line.getIdLine());
    }

    public void assignDriverToTrain(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver, Date departureTime,Station_213170554_AriasHurtado departureStation, Station_213170554_AriasHurtado arriveStation){
        train.setAssignedDriver(driver.getIdDriver());
        driver.setAssignedTrain(train.getIdTrain());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = sdf.format(departureTime);

        if (areInTheSameLine(departureStation, arriveStation)){
            train.setDepartureStation(departureStation);
            train.setArriveStation(arriveStation);
        }else{
            throw new IllegalArgumentException("las estaciones deben pertenecer a la misma linea");
        }

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

        Station_213170554_AriasHurtado station7 = new Station_213170554_AriasHurtado(7, "a", 't', 5);
        Station_213170554_AriasHurtado station8 = new Station_213170554_AriasHurtado(8, "b", 'r', 10);
        Station_213170554_AriasHurtado station9 = new Station_213170554_AriasHurtado(9, "c", 'r', 15);
        Station_213170554_AriasHurtado station10 = new Station_213170554_AriasHurtado(10, "d", 'c', 5);
        Station_213170554_AriasHurtado station11 = new Station_213170554_AriasHurtado(11, "e", 'r', 10);
        Station_213170554_AriasHurtado station12 = new Station_213170554_AriasHurtado(12, "f", 't', 15);

        Section_21317055_AriasHurtado section6 = new Section_21317055_AriasHurtado(station7, station8, 3, 8);
        Section_21317055_AriasHurtado section7 = new Section_21317055_AriasHurtado(station8, station9, 4, 9);
        Section_21317055_AriasHurtado section8 = new Section_21317055_AriasHurtado(station9, station10, 5, 10);
        Section_21317055_AriasHurtado section9 = new Section_21317055_AriasHurtado(station10, station11, 6, 11);
        Section_21317055_AriasHurtado section10 = new Section_21317055_AriasHurtado(station11, station12, 7, 12);

        ArrayList<Section_21317055_AriasHurtado> secciones2 = new ArrayList<>();
        Line_21317055_AriasHurtado line2 = new Line_21317055_AriasHurtado(2, "L2", "UIC-60", secciones2);
        line2.addSection(section6);
        line2.addSection(section7);
        line2.addSection(section8);
        line2.addSection(section9);
        line2.addSection(section10);




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
        lines.add(line2);
        trains.add(train1);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        subway1.addLine(lines);
        subway1.addTrain(trains);
        subway1.addDriver(drivers);
        System.out.println(subway1.areInTheSameLine(station1,station7));
        //subway1.assignTrainToLine(train1, line1);
        //subway1.assignDriverToTrain(train1, driver1, departureTime, station1 ,station6);
        //subway1.myToString();
    }
}