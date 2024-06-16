package clases;


import javax.swing.*;
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


    int totalLenghtLine = 0;
    public int lineLenght(){
        if(sections == null){
            return 0;
    }else{
        for(int i = 0; i < sections.size(); i++){
            totalLenghtLine  = sections.get(i).getDistance() + totalLenghtLine;
            }
        return totalLenghtLine;
        }
    }

    /*
    *int lenghtLine = 0;
    *public int lineSectionLenght(Station_213170554_AriasHurtado Station){
    *}
    */

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

    /*
    *int Cost = 0;
    *public int lineSectionCost(Station_213170554_AriasHurtado Station){
    *}
    */

    // pero añadir al inicio o final?
    // o que se añada automaticamente a cualquier lado en que sea posible?
    // public void addSection(Section_21317055_AriasHurtado section){}


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
}
