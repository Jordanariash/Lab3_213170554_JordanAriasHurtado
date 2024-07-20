package clases;

/**
 * Clase Section que representa una seccion de una linea
 * Cada seccion tiene 2 estaciones distintas, una distancia y un costo
 */
public class Section_21317055_AriasHurtado{

    Station_213170554_AriasHurtado station1;
    Station_213170554_AriasHurtado station2;
    private int distance;
    private int cost;

    /**
     * Constructor de Section
     * Crea una seccion, con 2 estaciones, una distancia, y un costo
     *
     * @param station1 primera estacion que compone la seccion
     * @param station2 segunda estacion que compone la seccion
     * @param distance distancia asociada entre las 2 estaciones
     * @param cost costo asociado entre las 2 estaciones
     */
    public Section_21317055_AriasHurtado(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2, int distance, int cost){

        this.station1 = station1;

        if (station1.sameStation(station2)){
            throw new IllegalArgumentException("las estaciones no pueden tener el mismo id, o nombre");
        }
        this.station2 = station2;

        if (distance <= 0) {
            throw new IllegalArgumentException("La distancia debe ser un número positivo mayor que 0.");

        }
        this.distance = distance;

        if (cost < 0) {
            throw new IllegalArgumentException("El coste debe ser un número positivo.");

        }
        this.cost = cost;



    }

    /**
     * Consigue la primera estacion de una seccion
     * @return la primera estacion de una seccion
     */
    public Station_213170554_AriasHurtado getStation1() {
        return station1;
    }

    /**
     * Consigue la segunda estacion de una seccion
     * @return la segunda estacion de una seccion
     */
    public Station_213170554_AriasHurtado getStation2() {
        return station2;
    }

    /**
     * Consigue la distancia de una seccion
     * @return la distancia de una seccion
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Consigue el costo de una seccion
     * @return el costo de una seccion
     */
    public int getCost() {
        return cost;
    }

    /**
     * Establece la primera estacion de una seccion
     * @param station1 estacion
     */
    public void setStation1(Station_213170554_AriasHurtado station1) {
        this.station1 = station1;
    }

    /**
     * Establece la segunda estacion de una seccion
     * @param station2 estacion
     */
    public void setStation2(Station_213170554_AriasHurtado station2) {
        this.station2 = station2;
    }

    /**
     * Establece la distancia de una seccion
     * @param distance distancia
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Establece el costo de una seccion
     * @param cost costo
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Verifica si una seccion, respecto a otra, no es la misma, o es la misma con las estaciones invertidas
     * @param section seccion a comparar
     * @return verdadero o falso
     */
    public boolean sameSection(Section_21317055_AriasHurtado section){
        if(station1.sameStation(section.getStation1()) && station2.sameStation(section.getStation2())){
            return station1.sameStation(section.getStation2()) && station2.sameStation(section.getStation1());
        }
        return false;
    }

    /**
     * Muestra la informacion de una seccion
     */
    public void showInfoSection() {
        station1.showInfoStation();
        System.out.println("distancia: " + distance + " ,costo: " + cost);
        station2.showInfoStation();

    }

    /**
     * Guarda la informacion de la seccion en String
     * @return infoSection
     */
    public String getInfoSection() {
        String infoSection;
        infoSection = station1.getInfoStation();
        infoSection = infoSection + "Distancia: " + getDistance() + " , Costo: " + getCost() + "\n";
        infoSection = infoSection + station2.getInfoStation();
        return infoSection;
    }

}
