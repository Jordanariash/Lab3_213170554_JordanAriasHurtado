package clases;

import java.util.Date;

public class Driver_21317055_AriasHurtado {
    private int idDriver;
    private String nameDriver;
    private String trainMaker;

    private int assignedTrain;

    public Driver_21317055_AriasHurtado(int idDriver, String nameDriver, String trainMaker){
        this.idDriver = idDriver;
        this.nameDriver = nameDriver;
        this.trainMaker = trainMaker;
        this.assignedTrain = 0;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    public int getAssignedTrain() {
        return assignedTrain;
    }

    public void setAssignedTrain(int assignedTrain) {
        this.assignedTrain = assignedTrain;
    }

    public void showInfoDriver(){
        System.out.println("ID driver: " + idDriver + " , Nombre conductor: " + nameDriver + " ,Manufacturador: " + trainMaker);
    }

    public boolean sameDriver(Driver_21317055_AriasHurtado driver){
        if(getIdDriver() == driver.getIdDriver()){
            return true;
        }else{
            return false;
        }
    }
}
