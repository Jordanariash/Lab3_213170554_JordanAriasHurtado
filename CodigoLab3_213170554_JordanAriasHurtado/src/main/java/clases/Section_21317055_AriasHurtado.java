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




    public void showInfoSection() {
        station1.showInfoStation();
        station2.showInfoStation();
        System.out.println("distancia: " + distance + ",costo: " + cost);
    }


    //si 2 secciones tienen las mismas 2 estaciones
    public boolean sameSection(Section_21317055_AriasHurtado section){
        if(station1.sameStation(section.getStation1()) && station2.sameStation(section.getStation2())){
            if(station1.sameStation(section.getStation2()) && station2.sameStation(section.getStation1())){
                return true;
            }
        }
        return false;
    }
}
