package clases;


import java.util.ArrayList;


public class Line_21317055_AriasHurtado {
    private int idLine;
    private String nameLine;
    private String railType;
    private ArrayList<Section_21317055_AriasHurtado> sections;
    private ArrayList<Integer> assignedTrains;

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

    public int getIdLine() {
        return idLine;
    }

    public void setIdLine(int idLine) {
        this.idLine = idLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public String getRailType() {
        return railType;
    }

    public void setRailType(String railType) {
        this.railType = railType;
    }

    public ArrayList<Section_21317055_AriasHurtado> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section_21317055_AriasHurtado> sections) {
        this.sections = sections;
    }

    public ArrayList<Integer> getAssignedTrains() {
        return assignedTrains;
    }

    public void setAssignedTrains(ArrayList<Integer> assignedTrains) {
        this.assignedTrains = assignedTrains;
    }

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



    public int lineLenght(){
        int totalLenght = 0;
        if(sections == null){
            return 0;
        }else{
            for(int i = 0; i < sections.size(); i++){
                totalLenght  = sections.get(i).getDistance() + totalLenght;
            }
            return totalLenght;
        }
    }


    public int lineSectionLenght(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2){
        int sectionLenght = 0;
        int i = 0;
        while(i < sections.size()) {
            if (!station1.sameStation(sections.get(i).getStation1()) && !station2.sameStation(sections.get(i).getStation1())) {
                i++;
            }
        while(i < sections.size()){
            sectionLenght = sections.get(i).getDistance() + sectionLenght;
            if(station1.sameStation(sections.get(i).getStation2()) || station2.sameStation(sections.get(i).getStation2())){
                return sectionLenght;
                }
            i++;
            }

        }
        return sectionLenght;
    }


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


    public int lineSectionCost(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2) {
        int sectionCost = 0;
        int i = 0;
        while(i < sections.size()) {
            if (!station1.sameStation(sections.get(i).getStation1()) && !station2.sameStation(sections.get(i).getStation1())) {
                i++;
            }
            while(i < sections.size()){
                sectionCost = sections.get(i).getCost() + sectionCost;
                if(station1.sameStation(sections.get(i).getStation2()) || station2.sameStation(sections.get(i).getStation2())){
                    return sectionCost;
                }
                i++;
            }

        }
        return sectionCost;
    }


    // pero añadir al inicio o final?
    // o que se añada automaticamente a cualquier lado en que sea posible?
    public void addSection(Section_21317055_AriasHurtado section){
        sections.add(section);
    }

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

    public boolean circular(){

        if(sections.isEmpty()){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return sections.get(0).getStation1().sameStation(sections.get(sections.size()-1).getStation2());
        }
    }

    public boolean lineal(){
        if(sections.isEmpty()){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return (sections.get(0).getStation1().getStationType() == 't') && (sections.get(sections.size() - 1).getStation2().getStationType() == 't');
        }

    }

    public boolean unrepeteadSections(){
        ArrayList<Section_21317055_AriasHurtado> auxSections = new ArrayList<>();
        for (int i = 0; i < sections.size()-1; i++) {
            //si hay una seccion que sea la misma, osea st1-st2 != st2-st1
            if(sections.get(i).sameSection(sections.get(i+1))){
                return false;
            }
        }
        //verificar si alguna secccion esta repetida
        for (int j = 0; j < sections.size(); j++) {
            if(!auxSections.contains(sections.get(j))){
                auxSections.add(sections.get(j));
            }
        }
        if (auxSections.size() == sections.size()){
            return true;
        }else{
            return false;
        }

    }

    public boolean onlyTwoTerminal(){
        if(sections.isEmpty()) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < sections.size(); i++) {
            if((sections.get(i).getStation1().getStationType() == 't')||(sections.get(i).getStation2().getStationType() == 't')){
                count++;
            }
        }
        if(count == 2){
            return true;
        }else{
            return false;
        }
    }


    //esta es "line?" pero no se puede ocupar "?" por error de tipeo
    public boolean isLine(){
        return isConnected() && (circular() || lineal()) && unrepeteadSections() && onlyTwoTerminal();
    }

    public void showInfoLine(){
        System.out.println("ID linea: "+ idLine + " , Nombre Linea: " + nameLine + " , tipo rieles: " + railType);
        if(sections.isEmpty()){
            System.out.println("No hay estaciones en la linea");
        }else {
            for (int i = 0; i < sections.size(); i++) {
                sections.get(i).getStation1().showInfoStation();
                System.out.println("distancia: " + sections.get(i).getDistance() + " costo: " + sections.get(i).getCost());
            }
            sections.get(sections.size()-1).getStation2().showInfoStation();
        }
    }


    public boolean sameLine(Line_21317055_AriasHurtado line){
        if(getIdLine() == line.getIdLine() && getNameLine().equals(line.getNameLine())){
            return true;
        }else{
            return false;
        }
    }

    public void showStations(){
       for (int i = 0; i < sections.size(); i++) {
           System.out.println(sections.get(i).getStation1().getIdStation() + ". "+ sections.get(i).getStation1().getNameStation());
            }
       System.out.println(sections.get(sections.size()-1).getStation2().getIdStation() + ". "+ sections.get(sections.size()-1).getStation2().getNameStation());
    }
}
