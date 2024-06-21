package clases;

public class Driver_21317055_AriasHurtado {
    private int idDriver;
    private String nameDriver;
    private String trainMaker;


    public Driver_21317055_AriasHurtado(int idDriver, String nameDriver, String trainMaker){
        this.idDriver = idDriver;
        this.nameDriver = nameDriver;
        this.trainMaker = trainMaker;
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

    public void showInfoDriver(){
        System.out.println("ID driver: " + idDriver + "Name driver: " + nameDriver + "Train Maker: " + trainMaker);
    }
}
