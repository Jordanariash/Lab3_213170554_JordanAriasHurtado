package clases;

import java.util.ArrayList;


public class PassangerCar_21317055_AriasHurtado {

    private int idPassangerCar;
    private int passangerCapacity;
    private String model;
    private String trainMaker;
    private char carType;

    public PassangerCar_21317055_AriasHurtado(int idPassangerCar, int passangerCapacity, String model, String trainMaker, char carType) {
        this.idPassangerCar = idPassangerCar;

        if(passangerCapacity <= 0){
            throw new IllegalArgumentException("La capacidad debe ser un entero positivo");
        }else{
            this.passangerCapacity = passangerCapacity;
        }
        this.model = model;
        this.trainMaker = trainMaker;
        validCarType(carType);
    }

    public int getIdPassangerCar() {
        return idPassangerCar;
    }

    public void setIdPassangerCar(int idPassangerCar) {
        this.idPassangerCar = idPassangerCar;
    }

    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    public void setPassangerCapacity(int passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    public char getCarType() {
        return carType;
    }

    public void setCarType(char carType) {
        this.carType = carType;
    }

    private void validCarType(char carType){
        if (carType == 't' || carType == 'c') {
            this.carType = carType;
        } else {
            throw new IllegalArgumentException("El tipo de vagon debe ser t o c");
        }
    }

    public void showInfoPcar(){
        System.out.println("Id pcar: " + idPassangerCar + " ,capacidad: " + passangerCapacity + " ,modelo: "+ model + " ,manufacturador: "+ trainMaker + " ,tipo del carro: "+ carType);
    }
}
