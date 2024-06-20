package clases;

import java.util.ArrayList;

public class Subway_21317055_AriasHurtado {
    private int idSubway;
    private String nameSubway;
    private ArrayList<Line_21317055_AriasHurtado> lines;
    private ArrayList<Train_21317055_AriasHurtado> trains;
    private ArrayList<Driver_21317055_AriasHurtado> drivers;
    public Subway_21317055_AriasHurtado(int idSubway, String nameSubway, ArrayList<Line_21317055_AriasHurtado> lines, ArrayList<Train_21317055_AriasHurtado> trains, ArrayList<Driver_21317055_AriasHurtado> drivers){
        this.idSubway = idSubway;
        this.nameSubway = nameSubway;
        if(lines == null || lines.isEmpty()){
            this.lines = new ArrayList<>();
        }else{
            this.lines = lines;
        }
        if(trains == null || trains.isEmpty()){
            this.trains = new ArrayList<>();
        }else{
            this.trains = trains;
        }
        if(drivers == null || drivers.isEmpty()){
            this.drivers = new ArrayList<>();
        }else{
            this.drivers = drivers;
        }
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


    public void addLine(ArrayList<Line_21317055_AriasHurtado> lines){
        this.lines.addAll(lines);
    }

    public void addTrains(ArrayList<Train_21317055_AriasHurtado> trains){
        this.trains.addAll(trains);
    }

    public void addDrivers(ArrayList<Driver_21317055_AriasHurtado> drivers){
        this.drivers.addAll(drivers);
    }

    public void myToString() {
        System.out.println("id subway: " + getIdSubway());
        System.out.println("nombre subway: " + getNameSubway());
        if (lines != null && !lines.isEmpty()) {
            for (int i = 0; i < lines.size(); i++) {
                lines.get(i).showInfoLine();
            }
        } else {
            System.out.println("no hay lineas");
        }
        if (trains != null && !trains.isEmpty()) {
            for (int i = 0; i < trains.size(); i++) {
                trains.get(i).showInfoTrain();
            }
        } else {
            System.out.println("no hay trenes");
        }
        if (drivers != null && !drivers.isEmpty()) {
            for (int i = 0; i < drivers.size(); i++) {
               drivers.get(i).showInfoDriver();
            }
        } else {
            System.out.println("no hay conductores");
        }
    }



    public static void main(String[] args) {
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

        Subway_21317055_AriasHurtado subway1= new Subway_21317055_AriasHurtado(1, "metro", lines, trains, drivers);

        lines.add(line1);
        trains.add(train1);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        subway1.addLine(lines);
        subway1.addTrains(trains);
        subway1.addDrivers(drivers);

        subway1.myToString();
    }
}
