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

    public boolean validLine(Line_21317055_AriasHurtado line){
        return line.circular() || line.lineal();
    }

}
