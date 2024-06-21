package clases;


import java.util.ArrayList;


public class Line_21317055_AriasHurtado {
    private int idLine;
    private String nameLine;
    private String railType;
    private ArrayList<Section_21317055_AriasHurtado> sections;

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


    int totalLenght = 0;
    public int lineLenght(){
        if(sections == null){
            return 0;
        }else{
            for(int i = 0; i < sections.size(); i++){
                totalLenght  = sections.get(i).getDistance() + totalLenght;
            }
            return totalLenght;
        }
    }


    int sectionLenght = 0;
    public int lineSectionLenght(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2){
        int i = 0;
        while(i < sections.size()) {
            if (!station1.compareStation(sections.get(i).getStation1()) && !station2.compareStation(sections.get(i).getStation1())) {
                i++;
            }
        while(i < sections.size()){
            sectionLenght = sections.get(i).getDistance() + sectionLenght;
            if(station1.compareStation(sections.get(i).getStation2()) || station2.compareStation(sections.get(i).getStation2())){
                return sectionLenght;
                }
            i++;
            }

        }
        return sectionLenght;
    }

    int totalCost = 0;
    public int lineCost(){
        if(sections == null){
            return 0;
        }else{
            for(int i = 0; i < sections.size(); i++){
                totalCost  = sections.get(i).getCost() + totalCost;
            }
            return totalCost;
        }
    }


    int sectionCost = 0;
    public int lineSectionCost(Station_213170554_AriasHurtado station1, Station_213170554_AriasHurtado station2) {
        int i = 0;
        while(i < sections.size()) {
            if (!station1.compareStation(sections.get(i).getStation1()) && !station2.compareStation(sections.get(i).getStation1())) {
                i++;
            }
            while(i < sections.size()){
                sectionCost = sections.get(i).getCost() + sectionCost;
                if(station1.compareStation(sections.get(i).getStation2()) || station2.compareStation(sections.get(i).getStation2())){
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
        if(sections == null){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            for(int i = 0; i < sections.size()-1; i++){
                if(!sections.get(i).getStation2().compareStation(sections.get(i+1).getStation1())){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean circular(){

        if(sections == null){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return sections.get(0).getStation1().compareStation(sections.get(sections.size()-1).getStation2());
        }
    }

    public boolean lineal(){
        if(sections == null){
            return true;
        } else if (sections.size() == 1){
            return true;
        }else{
            return (sections.get(0).getStation1().getStationType() == 't') && (sections.get(sections.size() - 1).getStation2().getStationType() == 't');
        }

    }

    //esta es "line?" pero no se puede ocupar "?" por error de tipeo
    public boolean validLine(){
        return this.isConnected() && (this.circular() || this.lineal());
    }

    public void showInfoLine(){
        System.out.println("ID linea: "+ idLine + " ,Nombre Linea: " + nameLine + " ,tipo rieles: " + railType);
        for (int i = 0; i < sections.size(); i++) {
            sections.get(i).showInfoSection();
        }
    }
}
