package clases;


/**
 * Clase Passanger Car que representa un vagon del sistema de metro
 * Cada vagon tiene un id unico a nivel de metro, capacidad, modelo, manufacturadora, y si es de tipo terminal o central
 */
public class PassangerCar_21317055_AriasHurtado {

    private int idPassangerCar;
    private int passangerCapacity;
    private String model;
    private String trainMaker;
    private char carType;

    /**
     * Constructor de un vagon de pasajeros
     * Crea un vagon de pasajeros con id, capacidad, modelo, manufacturadora, y tipo de vagon especificados
     * @param idPassangerCar identificador del vagon
     * @param passangerCapacity capacidad del vagon
     * @param model modelo del vagon
     * @param trainMaker manufacturaadora del vafon
     * @param carType tipo del vagon
     */
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

    /**
     * Consigue el id de un vagon de pasajeros
     * @return id de un vagon
     */
    public int getIdPassangerCar() {
        return idPassangerCar;
    }

    /**
     * Consigue la capacidad de un vagon de pasajeros
     * @return capacidad de pasajeros
     */
    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    /**
     * Consigue el modelo de un vagon de pasajeros
     * @return modelo de un vagon
     */
    public String getModel() {
        return model;
    }

    /**
     * Consigue la manufacturadora del vagon de pasajeros
     * @return manufacturadora del vagon
     */
    public String getTrainMaker() {
        return trainMaker;
    }

    /**
     * Consigue el tipo del vagon de pasajeros
     * @return tipo del vagon
     */
    public char getCarType() {
        return carType;
    }

    /**
     * Verifica si el caracter ingresado  es un t o c. Para que el vagon se pueda construir correctamente
     * @param carType t,c
     */
    private void validCarType(char carType){
        if (carType == 't' || carType == 'c') {
            this.carType = carType;
        } else {
            throw new IllegalArgumentException("El tipo de vagon debe ser t o c");
        }
    }

    /**
     * Muesta la informacion de un vagon en especifico
     */
    public void showInfoPcar(){
        System.out.println("Id pcar: " + idPassangerCar + " ,capacidad: " + passangerCapacity + " ,modelo: "+ model + " ,manufacturador: "+ trainMaker + " ,tipo del carro: "+ carType);
    }

    /**
     * Guarda la informacion de un vagon en un String
     * @return infoPcar
     */
    public String getInfoPcar(){
        String infoPcar;
        infoPcar = "Id pcar: " + getIdPassangerCar() + " ,Capacidad: " + getPassangerCapacity() + " ,Modelo: "+ getModel() + " ,Manufacturadora: "+ getTrainMaker() + " ,Tipo del carro: "+ getCarType() + "\n";
        return infoPcar;
    }

    /**
     * Compara 2 vagones, si tienen el mismo id, se refiere al mismo vagon
     * @param pcar vagon a comparar
     * @return verdadero o falso
     */
    public boolean samePcar(PassangerCar_21317055_AriasHurtado pcar){
        if(getIdPassangerCar() == pcar.getIdPassangerCar()){
            return true;
        }else{
            return false;
        }
    }
}
