public class Section_21317055_AriasHurtado{

    //constructor
    Station_213170554_AriasHurtado station1;
    Station_213170554_AriasHurtado station2;

    int distance;
    int cost;

    public Section_21317055_AriasHurtado(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2,
                                         int distance, int cost){

        this.station1 = station1;
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

        System.out.println("distancia: " + distance + ",costo: " + cost);
    }

    public static void main (String[]args){
        try {
            Station_213170554_AriasHurtado station1 = new Station_213170554_AriasHurtado(1, "USACH", 'r', 0);
            Station_213170554_AriasHurtado station2 = new Station_213170554_AriasHurtado(2, "Estacion central", 'r', 1);
            Section_21317055_AriasHurtado section = new Section_21317055_AriasHurtado(station1, station2, 3, 4);
            station1.mostrarInfoStation();
            station2.mostrarInfoStation();
            section.mostrarInfoSection();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
