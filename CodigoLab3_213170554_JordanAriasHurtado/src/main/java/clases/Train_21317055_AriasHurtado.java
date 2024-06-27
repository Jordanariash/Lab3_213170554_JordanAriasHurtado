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


    public void addCar(int position, PassangerCar_21317055_AriasHurtado passangerCar) {
        this.carList.add(position, passangerCar);
    }

    public void removeCar(int position){
        this.carList.remove(position);
    }

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
    public boolean sameModel(){
        for(int i = 1; i < carList.size(); i++){
            if(!carList.get(i).getModel().equals(carList.get(0).getModel())){
                return false;
            }
        }
        return true;
    }

    public boolean isTrain(Train_21317055_AriasHurtado train){
        return train.validBody() && train.sameModel();
    }

    public int fetchCapacity(){
        int trainCapacity = 0;
        for(int i = 0; i < carList.size(); i++){
            trainCapacity = carList.get(i).getPassangerCapacity() + trainCapacity;
        }
        return trainCapacity;
    }

    public void showInfoTrain(){
        System.out.println("Id tren: " + idTrain + " ,Manufacturador: " + trainMaker + " ,Velocidad: " + speed + " ,tiempo de parada: "  + stationStaytime);
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).showInfoPcar();
        }
    }

    public boolean sameTrain(Train_21317055_AriasHurtado train){
        if(getIdTrain() == train.getIdTrain()){
            return true;
        }else{
            return false;
        }
    }
}