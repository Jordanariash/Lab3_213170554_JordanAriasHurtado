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


    public void addCar(PassangerCar_21317055_AriasHurtado passangerCar) {
        this.carList.add(passangerCar);
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
        System.out.println("primer carro");
        if (carList.get(0).getCarType() != 't'){
            return false;
        }
        int i = 1;
        while (i < carList.size() - 1){
            System.out.println("del medio");
            if (carList.get(i).getCarType() != 'c') {
                return false;
            }
            i++;
        }
        System.out.println("ultimo carro");
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

    public static void main(String[] args) {
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

        System.out.println("capacidad: " + train1.fetchCapacity());
        System.out.println("cuerpo valido: " + train1.validBody());
        System.out.println("mismo modelo: " + train1.sameModel());
    }
}

