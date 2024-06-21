package clases;

import java.util.ArrayList;
import java.util.List;

public class pairTrainLine<Train_21317055_AriasHurtado, Line_21317055_AriasHurtado> {
    private Train_21317055_AriasHurtado train;
    private Line_21317055_AriasHurtado line;

    public pairTrainLine(Train_21317055_AriasHurtado train, Line_21317055_AriasHurtado line) {
        this.train = train;
        this.line = line;
    }

    public Train_21317055_AriasHurtado getTrain() {
        return train;
    }

    public void setTrain(Train_21317055_AriasHurtado train) {
        this.train = train;
    }

    public Line_21317055_AriasHurtado getLine() {
        return line;
    }

    public void setLine(Line_21317055_AriasHurtado line) {
        this.line = line;
    }
}
