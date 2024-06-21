package clases;

import java.util.ArrayList;
import java.util.List;

public class pairTrainDriver<Train_21317055_AriasHurtado, Driver_21317055_AriasHurtado> {
    private Train_21317055_AriasHurtado train;
    private Driver_21317055_AriasHurtado driver;

    public pairTrainDriver(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver) {
        this.train = train;
        this.driver = driver;
    }

    public Train_21317055_AriasHurtado getTrain() {
        return train;
    }

    public void setTrain(Train_21317055_AriasHurtado train) {
        this.train = train;
    }

    public Driver_21317055_AriasHurtado getDriver() {
        return driver;
    }

    public void setDriver(Driver_21317055_AriasHurtado driver) {
        this.driver = driver;
    }
}
