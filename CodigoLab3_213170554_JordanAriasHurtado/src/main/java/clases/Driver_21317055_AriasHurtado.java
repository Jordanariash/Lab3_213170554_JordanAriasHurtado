package clases;

/**
 * Clase Driver que representa un conductor en un sistema de metro
 * Cada conductor tiene un id unico a nivel de metro, un nombre, la licencia de que tren puede conducir el conductor
 * y un id del tren que tiene asignado
 */
public class Driver_21317055_AriasHurtado {
    private int idDriver;
    private String nameDriver;
    private String trainMaker;

    private int assignedTrain;

    /**
     * Constructor de Driver
     * Crea un conductor con un id, nombre, y licencia de tren
     *
     * @param idDriver identificador unico del conductor
     * @param nameDriver nombre del conductor
     * @param trainMaker licencia del tren
     */
    public Driver_21317055_AriasHurtado(int idDriver, String nameDriver, String trainMaker){
        this.idDriver = idDriver;
        this.nameDriver = nameDriver;
        this.trainMaker = trainMaker;
        this.assignedTrain = 0;
    }

    /**
     * Consigue el id de un conductor
     * @return id
     */
    public int getIdDriver() {
        return idDriver;
    }

    /**
     * Consigue el nombre de un conductor
     * @return nombre
     */
    public String getNameDriver() {
        return nameDriver;
    }

    /**
     * Consigue la licencia de un conductor
     * @return nombre manufacturadora de un tren
     */
    public String getTrainMaker() {
        return trainMaker;
    }

    /**
     * Consigue el id del tren de un conductor
     * @return id train
     */
    public int getAssignedTrain() {
        return assignedTrain;
    }

    /**
     * Establece el de un conductor
     * @param idDriver id
     */
    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    /**
     * Establece el nombre de un conductor
     * @param nameDriver name
     */
    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    /**
     * Establece la licencia de manejo de un conductor
     * @param trainMaker manufacturadora tren
     */
    public void setTrainMaker(String trainMaker) {
        this.trainMaker = trainMaker;
    }

    /**
     * Establece el id del tren asignado de un conductor
     * @param assignedTrain id train
     */
    public void setAssignedTrain(int assignedTrain) {
        this.assignedTrain = assignedTrain;
    }

    /**
     * Muestra la informacion del conductor
     */
    public void showInfoDriver(){
        System.out.println("ID driver: " + idDriver + " , Nombre conductor: " + nameDriver + " ,Manufacturador: " + trainMaker);
    }

    /**
     * Compara 2 conductores a traves del id
     * @param driver conductor a comparar
     * @return verdadero o falso
     */
    public boolean sameDriver(Driver_21317055_AriasHurtado driver){
        if(getIdDriver() == driver.getIdDriver()){
            return true;
        }else{
            return false;
        }
    }
}
