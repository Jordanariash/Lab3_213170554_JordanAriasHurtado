package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase Train que representa un tren en un sistema de metro
 * Cada tren tiene un id unico a nivel de metro, una manufacturadora, velocidad maxima, tiempo de estancia por parada, lista de vagones,
 * asociado el id de la linea a la que esta asignado, asociado el id del conductor al que esta asignado, la estacion de la que parte el recorrido,
 * la ultima estacion de este recorrido, y la fecha de partida del recorrido
 */
public class Train_21317055_AriasHurtado {
    private int idTrain;
    private String trainMaker;
    private int speed;
    private int stationStaytime;
    private ArrayList<PassangerCar_21317055_AriasHurtado> carList;

    private int assignedLine;
    private int assignedDriver;
    private Station_213170554_AriasHurtado departureStation;
    private Station_213170554_AriasHurtado arriveStation;
    private Date departureTime;

    /**
     * Constructor de Train con el id, manufacturadora, velocidad maxima, tiempo de estancia, y lista de vagones
     * @param idTrain id
     * @param trainMaker manufacturadora
     * @param speed velocidad
     * @param stationStaytime tiempo de estancia
     * @param carList lista de vagones
     */
    public Train_21317055_AriasHurtado(int idTrain, String trainMaker, int speed, int stationStaytime, ArrayList<PassangerCar_21317055_AriasHurtado> carList) {
        this.idTrain = idTrain;
        this.trainMaker = trainMaker;
        if (speed < 0) {
            throw new IllegalArgumentException("La velocidad debe ser mayor que 0");
        } else {
            this.speed = speed;
        }
        this.stationStaytime = stationStaytime;
        if (carList == null || carList.isEmpty()) {
            this.carList = new ArrayList<>();
        } else {
            this.carList = carList;
        }


        this.assignedDriver = assignedDriver;
        this.departureStation = departureStation;
        this.arriveStation = arriveStation;
        this.departureTime = departureTime;
        this.assignedLine = assignedLine;
    }

    /**
     * Consigue el id de un tren
     * @return id de un tren
     */
    public int getIdTrain() {
        return idTrain;
    }

    /**
     * Consigue la manufacturadora de un tren
     * @return manufacturadora de un tren
     */
    public String getTrainMaker() {
        return trainMaker;
    }

    /**
     * Consigue la velocidad maxima de un tren
     * @return velocidad
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Consigue el tiempo de estancia por estacion de un tren
     * @return tiempo de estancia
     */
    public int getStationStaytime() {
        return stationStaytime;
    }

    /**
     * Consigue la lista de vagones de un tren
     * @return lista de vagones
     */
    public ArrayList<PassangerCar_21317055_AriasHurtado> getCarList() {
        return carList;
    }

    /**
     * Consigue el id del conductor asociado al conductor de un tren
     * @return id driver
     */
    public int getAssignedDriver() {
        return assignedDriver;
    }

    /**
     * Consigue el id de la linea asigada de un tren
     * @return id line
     */
    public int getAssignedLine() {
        return assignedLine;
    }

    /**
     * Consigue la estacion de partida del recorrido de un tren
     * @return departure station
     */
    public Station_213170554_AriasHurtado getDepartureStation() {
        return departureStation;
    }

    /**
     * Consigue la estacion final del recorrido de un tren
     * @return arrive station
     */
    public Station_213170554_AriasHurtado getArriveStation() {
        return arriveStation;
    }

    /**
     * Consigue la hora de partida de un tren
     * @return Date
     */
    public Date getDepartureTime() {
        return departureTime;
    }

    /**
     * Establece el id de un tren
     * @param idTrain id
     */
    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    /**
     * Establece la manufacturadora de un tren
     * @param trainMaker manufacturadora
     */
    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    /**
     * Establece la velocidad maxima de un tren
     * @param speed velocidad
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Establece el tiempo de estancia por estacion de un tren
     * @param stationStaytime tiempo de parada
     */
    public void setStationStaytime(int stationStaytime) {
        this.stationStaytime = stationStaytime;
    }

    /**
     * Establece la lista de vagones completa de un tren
     * @param carList lista de vagones
     */
    public void setCarList(ArrayList<PassangerCar_21317055_AriasHurtado> carList) {
        this.carList = carList;
    }

    /**
     * Establece el id de un conductor asignado de un tren
     * @param assignedDriver id driver
     */
    public void setAssignedDriver(int assignedDriver) {
        this.assignedDriver = assignedDriver;
    }

    /**
     * Establece el id de una linea asignada de un tren
     * @param assignedLine id line
     */
    public void setAssignedLine(int assignedLine) {
        this.assignedLine = assignedLine;
    }

    /**
     * Establece la estacion de partida de un tren
     * @param departureStation departure station
     */
    public void setDepartureStation(Station_213170554_AriasHurtado departureStation) {
        this.departureStation = departureStation;
    }

    /**
     * Establece la estacion final del recorrido de un tren
     * @param arriveStation arrive station
     */
    public void setArriveStation(Station_213170554_AriasHurtado arriveStation) {
        this.arriveStation = arriveStation;
    }

    /**
     * Establece la hora de partida de un tren
     * @param departureTime Date
     */
    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Añade un vagon a una posicion especifica del tren
     * @param position posicion
     * @param passangerCar vagon
     */
    public void addCar(int position, PassangerCar_21317055_AriasHurtado passangerCar) {
        this.carList.add(position, passangerCar);
    }

    /**
     * Remueve un vagon especifico de un tren
     * @param position posicion
     */
    public void removeCar(int position) {
        this.carList.remove(position);
    }

    /**
     * Verifica la consistencia en los tipos de vagones del tren, osea
     * -Comienza y termina con vagones tipo terminal
     * -El cuerpo del tren solo lo componen vagones tipo central
     * @return verdadero o falso
     */
    public boolean validBody(){
        if(carList.isEmpty()){
            return true;
        }
        if(carList.size() == 1){
            return true;
        }
        if (carList.get(0).getCarType() != 't'){
            return false;
        }
        int i = 1;
        while (i < carList.size() - 1){
            if (carList.get(i).getCarType() != 'c') {
                return false;
            }
            i++;
        }
        if(carList.get(i).getCarType() != 't'){
            return false;}
        return true;
    }

    /**
     * Verifica la consistencia en el modelo de los vagones, en base al primer vagon del tren
     * @return verdadero o falso
     */
    public boolean sameModel(){
        for(int i = 1; i < carList.size(); i++){
            if(!carList.get(i).getModel().equals(carList.get(0).getModel())){
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si el tren cumple las caracteristicas necesarias para poder ser ingresado al sistema de metro
     * @param train tren
     * @return verdadero o falso
     */
    public boolean isTrain(Train_21317055_AriasHurtado train){
        return train.validBody() && train.sameModel() && train.unrepeatedPcars();
    }

    /**
     * Calcula la capacidad total del tren, sumando la capacidad individual de cada vagon
     * @return capacidad
     */
    public int fetchCapacity(){
        int trainCapacity = 0;
        for(int i = 0; i < carList.size(); i++){
            trainCapacity = carList.get(i).getPassangerCapacity() + trainCapacity;
        }
        return trainCapacity;
    }

    /**
     * Muestra la informacion del tren
     */
    public void showInfoTrain(){
        System.out.println("Id tren: " + idTrain + " ,Manufacturador: " + trainMaker + " ,Velocidad: " + speed + " ,tiempo de parada: "  + stationStaytime);
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).showInfoPcar();
        }
    }

    /**
     * Guarda la informacion de un tren en un String
     * @return infoTrain
     */
    public String getInfoTrain(){
        StringBuilder infoTrain;
        infoTrain = new StringBuilder("Id tren: " + getIdTrain() + " ,Manufacturador: " + getTrainMaker() + " ,Velocidad: " + getSpeed() + " ,Tiempo de parada: " + getStationStaytime() + "\n");
        if(carList.isEmpty()){
            infoTrain.append("El tren no tiene vagones asignados\n");
        }else{
            for(int i = 0; i < carList.size(); i++){
                infoTrain.append(getCarList().get(i).getInfoPcar());
            }
        }
        return infoTrain.toString();
    }

    /**
     * Compara 2 trenes, a traves del id para verificar si son el mismo
     * @param train tren a comparar
     * @return verdadero o falso
     */
    public boolean sameTrain(Train_21317055_AriasHurtado train){
        if(getIdTrain() == train.getIdTrain()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Verifica si un tren tiene todos sus vagones sin id's repetidos
     * @return verdadero o falso
     */
    public boolean unrepeatedPcars(){
        if(carList.isEmpty()){
            return true;
        }
        for(int i = 0; i < carList.size(); i++){
            for (int j = i+1; j < carList.size(); j++){
                if(carList.get(i).samePcar(carList.get(j))){
                    return false;
                }
            }
        }
        return true;
    }
}