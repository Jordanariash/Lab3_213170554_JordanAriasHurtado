package clases;

/**
 * Clase Station que representa una estacion en un sistema de metro
 * Cada estacion tiene un id unico a nivel de metro, un nombre unico a nivel de metro, puede ser de tipo terminal,
 * recorrido, combinacion o mantencion, y un tiempo de parada
 */
public class Station_213170554_AriasHurtado{

    private int idStation;
    private String nameStation;
    private int stopTime;
    private char stationType;

    /**
     * Constructor de Station
     * Crea una estacion con el ID, nombre,tipo de estacion, y tiempo de parada especificados
     *
     * @param idStation identidicador unico de la estacion
     * @param nameStation nombre propio de la estacion
     * @param stationType tipo de la estacion
     * @param stopTime tiempo de parada de la estacion
     */
    public Station_213170554_AriasHurtado(int idStation, String nameStation,char stationType, int stopTime) {

        this.idStation = idStation;

        if (nameStation == null || nameStation.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nameStation = nameStation;

        validStationType(stationType);

        if (stopTime < 0) {
            throw new IllegalArgumentException("El tiempo de parada debe ser un número positivo.");

        }
        this.stopTime = stopTime;

    }

    /**
     * Verifica si el caracter ingresado  es un r,m,c,t. Para que la estacion se pueda construir correctamente
     * @param stationType r,m,c,t
     */
    private void validStationType(char stationType){
        if (stationType == 'r' || stationType == 'm' || stationType == 'c' || stationType == 't') {
            this.stationType = stationType;
        } else {
            throw new IllegalArgumentException("El tipo de estacion debe ser r,m,c,t");
        }
    }

    /**
     * Consigue el id de una estacion
     * @return id de una estacion
     */
    public int getIdStation () {
        return idStation;
    }

    /**
     * Consigue el nombre de una estacion
     * @return el nombre de una estacion
     */
    public String getNameStation () {
        return nameStation;
    }

    /**
     * Consigue el tiempo de para del tiempo
     * @return el tiempo de para del tiempo
     */
    public int getStopTime () {
        return stopTime;
    }

    /**
     * Consigue el tipo de estacion de una estacion
     * @return el tipo de estacion de una estacion
     */
    public char getStationType() {
        return stationType;
    }

    /**
     * Compara 2 estaciones, si tienen el nombre o id igual, es la misma estacion
     * @param station estacion a comparar
     * @return verdadero o falso
     */
    public boolean sameStation(Station_213170554_AriasHurtado station){
        return (getIdStation() == station.getIdStation()) || (getNameStation().equals(station.getNameStation()));
    }

    /**
     * Muestra la información de la estacion
     */
    public void showInfoStation() {
        System.out.println("ID: " + idStation + ", Nombre: " + nameStation + ", Tipo: " + stationType + ", Tiempo parada: " + stopTime);
    }

    /**
     * Guarda la informacion de la estacion es un String
     * @return Info
     */
    public String getInfoStation() {
        return "ID estación: " + getIdStation() + " , Nombre: " + getNameStation() + ", Tipo: " + getStationType() + ", Tiempo parada: " + getStopTime() + "\n";
    }
}