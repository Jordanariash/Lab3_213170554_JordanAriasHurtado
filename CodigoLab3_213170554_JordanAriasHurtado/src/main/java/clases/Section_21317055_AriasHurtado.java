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

}
