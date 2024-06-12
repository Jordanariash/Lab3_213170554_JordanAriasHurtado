public class Station_213170554_AriasHurtado {


    //constructor

    int idStation;
    String nameStation;
    int stopTime;
    char stationType;


    public Station_213170554_AriasHurtado(int idStation, String nameStation,char stationType, int stopTime) {

        this.idStation = idStation;

        if (nameStation == null || nameStation.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nameStation = nameStation;

        setStationType(stationType);

        if (stopTime < 0) {
            throw new IllegalArgumentException("El tiempo de parada debe ser un número positivo.");

        }
        this.stopTime = stopTime;

    }
    //getter y setters

    public int getIdStation () {
        return idStation;
            }

            public void setIdStation ( int idStation){
                this.idStation = idStation;
            }

            public String getNameStation () {
                return nameStation;
            }

            public void setNameStation (String nameStation){
                this.nameStation = nameStation;
            }

            public int getStopTime () {
                return stopTime;
            }

            public void setStopTime ( int stopTime){
                this.stopTime = stopTime;
            }

            private void setStationType(char stationType){
                if (stationType == 'r' || stationType == 'm' || stationType == 'c' || stationType == 't') {
                    this.stationType = stationType;
                } else {
                    throw new IllegalArgumentException("El tipo de estacion debe ser r,m,c,t");
                }
            }

    // Método para mostrar la información de la persona
    public void mostrarInfo() {
        System.out.println("ID: " + idStation + ", Nombre: " + nameStation + ", Tipo: " + stationType + ", Tiempo parada: " + stopTime);
    }


    public static void main (String[]args){
                try {
                    Station_213170554_AriasHurtado station = new Station_213170554_AriasHurtado(1, "USACH", 'r', 0);
                    station.mostrarInfo();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

}