package clases;

import java.util.ArrayList;

public class Train_21317055_AriasHurtado {
    private int idTrain;
    private String trainMaker;
    private int speed;
    private int stationStaytime;
    private ArrayList<PassangerCar_21317055_AriasHurtado> carList;

    public Train_21317055_AriasHurtado(int idTrain, String trainMaker, int speed, int stationStaytime, ArrayList<PassangerCar_21317055_AriasHurtado> carList) {
        this.idTrain = idTrain;
        this.trainMaker = trainMaker;
        if(speed < 0){
            throw new IllegalArgumentException("La velocidad debe ser mayor que 0");
        }else{
            this.speed = speed;
            }
        this.stationStaytime = stationStaytime;
        if (carList == null || carList.isEmpty()) {
            this.carList = new ArrayList<>();
        }else{
            this.carList = carList;
        }
    }

    public int getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(int idTrain) {
        this.idTrain = idTrain;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStationStaytime() {
        return stationStaytime;
    }

    public void setStationStaytime(int stationStaytime) {
        this.stationStaytime = stationStaytime;
    }

    public ArrayList<PassangerCar_21317055_AriasHurtado> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<PassangerCar_21317055_AriasHurtado> carList) {
        this.carList = carList;
    }
}

