package clases;

public class Section_21317055_AriasHurtado{

    //constructor
    Station_213170554_AriasHurtado station1;
    Station_213170554_AriasHurtado station2;
    private int distance;
    private int cost;

    public Section_21317055_AriasHurtado(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2,
                                         int distance, int cost){

        this.station1 = station1;

        if (station1.getIdStation() == station2.getIdStation()){
            throw new IllegalArgumentException("las estaciones no pueden ser la misma");
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
    //getter y setters

    public Station_213170554_AriasHurtado getStation1() {
        return station1;
    }

    public void setStation1(Station_213170554_AriasHurtado station1) {
        this.station1 = station1;
    }

    public Station_213170554_AriasHurtado getStation2() {
        return station2;
    }

    public void setStation2(Station_213170554_AriasHurtado station2) {
        this.station2 = station2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    // Método para mostrar la información de la seccion
    public void mostrarInfoSection() {
        System.out.println(" " +
                "distancia: " + distance + ",costo: " + cost);
    }

}
