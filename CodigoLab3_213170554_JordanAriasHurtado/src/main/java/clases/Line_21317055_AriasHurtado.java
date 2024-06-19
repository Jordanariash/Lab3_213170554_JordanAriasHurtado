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
            if (!station1.equals(sections.get(i).getStation1()) && !station2.equals(sections.get(i).getStation1())) {
                i++;
            }
        while(i < sections.size()){
            sectionLenght = sections.get(i).getDistance() + sectionLenght;
            if(station1.equals(sections.get(i).getStation2()) || station2.equals(sections.get(i).getStation2())){
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
            if (!station1.equals(sections.get(i).getStation1()) && !station2.equals(sections.get(i).getStation1())) {
                i++;
            }
            while(i < sections.size()){
                sectionCost = sections.get(i).getCost() + sectionCost;
                if(station1.equals(sections.get(i).getStation2()) || station2.equals(sections.get(i).getStation2())){
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
                if(!sections.get(i).getStation2().equals(sections.get(i+1).getStation1())){
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
            return sections.get(0).getStation1().equals(sections.get(sections.size()-1).getStation2());
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


    public static void main(String[] args) {
        Station_213170554_AriasHurtado station1 = new Station_213170554_AriasHurtado(1, "Usach", 't', 5);
        Station_213170554_AriasHurtado station2 = new Station_213170554_AriasHurtado(2, "Estacion Central", 'r', 10);
        Station_213170554_AriasHurtado station3 = new Station_213170554_AriasHurtado(3, "ULA", 'r', 15);
        Station_213170554_AriasHurtado station4 = new Station_213170554_AriasHurtado(4, "republica", 'c', 5);
        Station_213170554_AriasHurtado station5 = new Station_213170554_AriasHurtado(5, "los heroes", 'r', 10);
        Station_213170554_AriasHurtado station6 = new Station_213170554_AriasHurtado(6, "la moneda", 't', 15);
        Section_21317055_AriasHurtado section1 = new Section_21317055_AriasHurtado(station1, station2, 3, 8);
        Section_21317055_AriasHurtado section2 = new Section_21317055_AriasHurtado(station2, station3, 4, 9);
        Section_21317055_AriasHurtado section3 = new Section_21317055_AriasHurtado(station3, station4, 5, 10);
        Section_21317055_AriasHurtado section4 = new Section_21317055_AriasHurtado(station4, station5, 6, 11);
        Section_21317055_AriasHurtado section5 = new Section_21317055_AriasHurtado(station5, station6, 7, 12);

        ArrayList<Section_21317055_AriasHurtado> secciones = new ArrayList<>();
        Line_21317055_AriasHurtado line1 = new Line_21317055_AriasHurtado(1, "L1", "UIC-60", secciones);
        line1.addSection(section1);
        line1.addSection(section2);
        line1.addSection(section3);
        line1.addSection(section4);
        line1.addSection(section5);
        System.out.println("largo total: " + line1.lineLenght());
        System.out.println("costo total: " + line1.lineCost());
        System.out.println("esta conectada: " + line1.isConnected());
        System.out.println("es circular: " + line1.circular());
        System.out.println("es lineal: " + line1.lineal());
        System.out.println("es lineal o circular: " + line1.validLine());
        System.out.println("distancia entre estacion y los heroes: " + line1.lineSectionLenght(station2, station5));
        System.out.println("costo entre estacion y los heroes: " + line1.lineSectionCost(station2, station5));
    }
}
