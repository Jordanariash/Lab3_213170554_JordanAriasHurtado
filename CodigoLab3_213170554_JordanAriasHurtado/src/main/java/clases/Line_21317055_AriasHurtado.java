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


}
