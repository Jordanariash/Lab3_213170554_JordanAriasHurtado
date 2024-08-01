package clases;
import java.util.ArrayList;

/**
 * Clase Line que representa una linea dentro de una red de metro
 * Cada linea tiene un id unico a nivel de metro, un nombre unico a nivel de metro, un tipo de riel, una lista de secciones, las cuales deben estar conectadas entre si
 * y una lista de id's de trenes asignados a la linea
 */
public class Line_21317055_AriasHurtado {
    private int idLine;
    private String nameLine;
    private String railType;
    private ArrayList<Section_21317055_AriasHurtado> sections;
    private ArrayList<Integer> assignedTrains;

    /**
     * Constructor de Line
     * Crea una linea con un id, nombre, tipo de riel, y secciones, y sin ningun tren asociado
     *
     * @param idLine identificador unico de la linea
     * @param nameLine nombre propio de la linea
     * @param railType tipo de riel
     * @param sections lista de secciones que conforma la linea
     */
    public Line_21317055_AriasHurtado(int idLine, String nameLine, String railType, ArrayList<Section_21317055_AriasHurtado> sections) {
        this.idLine = idLine;
        if (nameLine == null || nameLine.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío.");
        }
        this.nameLine = nameLine;

        if (railType == null || railType.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de riel no puede ser nulo ni vacío.");
        }
        this.railType = railType;

        if (sections == null || sections.isEmpty()) {
            this.sections = new ArrayList<>();
        }else{
            this.sections = sections;
        }

        this.assignedTrains = new ArrayList<>();
    }

    /**
     * Consigue el id de una linea
     * @return id de una linea
     */
    public int getIdLine() {
        return idLine;
    }

    /**
     * Consigue el nombre de una linea
     * @return el nombre de una linea
     */
    public String getNameLine() {
        return nameLine;
    }

    /**
     * Consigue el tipo de riel de la linea
     * @return tipo de riel de la linea
     */
    public String getRailType() {
        return railType;
    }

    /**
     * Consigue la lista de secciones que compone la linea
     * @return lista de secciones
     */
    public ArrayList<Section_21317055_AriasHurtado> getSections() {
        return sections;
    }

    /**
     * Consigue la lista de id's de trenes asignados
     * @return lista de id's de trenes asignados
     */
    public ArrayList<Integer> getAssignedTrains() {
        return assignedTrains;
    }

    /**
     * Consigue una estacion por el id
     * @param idStation id de la estacion
     * @return la estacion con el id
     */
    public Station_213170554_AriasHurtado getStationById(int idStation){
        for (int i = 0; i<sections.size(); i++) {
            if(sections.get(i).getStation1().getIdStation() == idStation){
                return sections.get(i).getStation1();
            }
            if(sections.get(i).getStation2().getIdStation() == idStation){
                return sections.get(i).getStation2();
            }
        }
        return null;
    }

    /**
     * Consigue una estacion por su posicion dentro del arreglo en la lista de secciones
     * @param position posicion de la estacion
     * @return estacion
     */
    public Station_213170554_AriasHurtado getStationByPosition(int position) {
        if (position <= getSections().size() && position >= 0){
            if(position == getSections().size()){
                return getSections().get(getSections().size()-1).getStation2();
            }else{
                return getSections().get(position).getStation1();
            }
        }
        return null;
    }

    /**
     * Establece los trenes asignados a la linea
     * @param assignedTrains lista de id's de trenes
     */
    public void setAssignedTrains(ArrayList<Integer> assignedTrains) {
        this.assignedTrains = assignedTrains;
    }

    /**
     * Calcula la distancia de la linea
     * @return distancia total
     */
    public int lineLenght(){
        int totalLenght = 0;
        if(sections == null){
            return 0;
        }else{
            for (Section_21317055_AriasHurtado section : sections) {
                totalLenght = section.getDistance() + totalLenght;
            }
            return totalLenght;
        }
    }

    /**
     * Calcula la distancia entre 2 estaciones de una linea
     * @param station1 estacion de origen
     * @param station2 estacion de destino
     * @return distancia
     */
    public int lineSectionLenght(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2){
        if(station1.sameStation(station2)){
            return 0;
        }else {
            int sectionLenght = 0;
            int i = 0;
            while (i < sections.size()) {
                if (!station1.sameStation(sections.get(i).getStation1()) && !station2.sameStation(sections.get(i).getStation1())) {
                    i++;
                }
                while (i < sections.size()) {
                    sectionLenght = sections.get(i).getDistance() + sectionLenght;
                    if (station1.sameStation(sections.get(i).getStation2()) || station2.sameStation(sections.get(i).getStation2())) {
                        return sectionLenght;
                    }
                    i++;
                }

            }
            return sectionLenght;
        }
    }

    /**
     * Calcula el costo de una linea
     * @return costo total
     */
    public int lineCost(){
        int totalCost = 0;
        if(sections == null){
            return 0;
        }else{
            for(int i = 0; i < sections.size(); i++){
                totalCost  = sections.get(i).getCost() + totalCost;
            }
            return totalCost;
        }
    }

    /**
     * Calcula el costo entre 2 estaciones de una linea
     * @param station1 estacion de origen
     * @param station2 estacion de destino
     * @return distancia
     */
    public int lineSectionCost(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2) {
        if(station1.sameStation(station2)){
            return 0;
        }else {
            int sectionCost = 0;
            int i = 0;
            while (i < sections.size()) {
                if (!station1.sameStation(sections.get(i).getStation1()) && !station2.sameStation(sections.get(i).getStation1())) {
                    i++;
                }
                while (i < sections.size()) {
                    sectionCost = sections.get(i).getCost() + sectionCost;
                    if (station1.sameStation(sections.get(i).getStation2()) || station2.sameStation(sections.get(i).getStation2())) {
                        return sectionCost;
                    }
                    i++;
                }

            }
            return sectionCost;
        }
    }

    /**
     * Añade una seccion al final de la linea
     * @param section nueva seccion
     */
    public void lineAddSection(Section_21317055_AriasHurtado section){
        if(getSections().get(getSections().size()-1).getStation2().sameStation(section.getStation1()) || getSections().isEmpty()){
            sections.add(section);
        }else{
            System.out.println("No concuerda la ultima estacion de la linea con la primera de la seccion");
        }
    }

    /**
     * Verifica si las secciones de la linea estan conectadas entre si
     * @return verdadero o falso
     */
    public boolean isConnected(){
        if(sections.isEmpty()){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            for(int i = 0; i < sections.size()-1; i++){
                if(!sections.get(i).getStation2().sameStation(sections.get(i+1).getStation1())){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Verifica si la linea es circular, osea la primera estacion de la primera seccion, es la misma que la segunda estacion de la ultima seccion
     * @return verdadero o falso
     */
    public boolean circular(){

        if(sections.isEmpty()){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return sections.get(0).getStation1().sameStation(sections.get(sections.size()-1).getStation2());
        }
    }

    /**
     * Verifica si la linea es lineal, osea la estacion inicial y final de la linea son de tipo terminal
     * @return verdadero o falso
     */
    public boolean lineal(){
        if(sections.isEmpty()){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return (sections.get(0).getStation1().getStationType() == 't') && (sections.get(sections.size() - 1).getStation2().getStationType() == 't');
        }

    }

    /**
     * Verifica que
     * @return verdadero o falso
     */
    public boolean unrepeatedStationsInLine(){
        if(sections.isEmpty()){
            return true;
        }
        for (int i = 0; i < sections.size(); i++) {
            for ( int j = i+1; j < sections.size(); j++) {
                if(sections.get(i).getStation1().sameStation(sections.get(j).getStation1())){
                    return false;
                }
                if(sections.get(i).getStation2().sameStation(sections.get(j).getStation2())){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica si la linea solo contiene 2 terminales
     * @return verdadero o falso
     */
    public boolean onlyTwoTerminal() {
        if (sections.isEmpty()) {
            return true;
        }
        if (sections.size() == 1) {
            if(sections.get(0).getStation1().getStationType() == 't' && sections.get(0).getStation2().getStationType() == 't'){
                return true;
            }else{
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getStation1().getStationType() == 't') {
                count = count + 1;
            }
            if (sections.get(i).getStation2().getStationType() == 't') {
                count = count + 1;
            }
        }
        if (count == 2) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * Verifica si la linea tiene todas las caracteristicas necesarias para ser valida, y poder ingresar a la red de metro
     * @return verdadero o falso
     */
    public boolean isLine(){
        return isConnected() && (circular() || lineal()) && onlyTwoTerminal() && unrepeatedStationsInLine();
    }

    /**
     * Guarda la informacion de una linea en un String
     * @return infoLine
     */
    public String getInfoLine(){
        StringBuilder infoLine;
        infoLine = new StringBuilder("ID linea: " + getIdLine() + ", Nombre Linea: " + getNameLine() + " , Tipo rieles: " + getRailType() + "\n");
        if(sections.isEmpty()){
            infoLine.append("No hay estaciones en la linea\n");
        }else{
            for (Section_21317055_AriasHurtado section : sections){
                infoLine.append(section.getStation1().getInfoStation());
                infoLine.append("Distancia: ").append(section.getDistance()).append(", Costo: ").append(section.getCost()).append("\n");
            }
            infoLine.append(sections.get(sections.size()-1).getStation2().getInfoStation());
        }
        return infoLine.toString();
    }

    /**
     * Compara 2 estaciones por nombre o id, para ver si son la misma
     * @param line linea a comparar
     * @return verdadero o falso
     */
    public boolean sameLine(Line_21317055_AriasHurtado line){
        if(getIdLine() == line.getIdLine() || getNameLine().equals(line.getNameLine())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Muestra todas las estaciones de la linea en orden
     */
    public void showStations(){
       for (int i = 0; i < sections.size(); i++) {
           System.out.println(i+1 + ". "+ sections.get(i).getStation1().getNameStation());
            }
       System.out.println(sections.size()+1 + ". "+ sections.get(sections.size()-1).getStation2().getNameStation());
    }
}
