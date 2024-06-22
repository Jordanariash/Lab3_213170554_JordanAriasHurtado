package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class pairTrainDriver{
    private Train_21317055_AriasHurtado train;
    private Driver_21317055_AriasHurtado driver;
    private Date departureTime;
    private Station_213170554_AriasHurtado departureStation;
    private Station_213170554_AriasHurtado arriveStation;


    public pairTrainDriver(Train_21317055_AriasHurtado train, Driver_21317055_AriasHurtado driver, Date departureTime,Station_213170554_AriasHurtado departureStation, Station_213170554_AriasHurtado arriveStation) {
        this.train = train;
        this.driver = driver;
        this.departureTime = departureTime;
        this.departureStation = departureStation;
        this.arriveStation = arriveStation;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Station_213170554_AriasHurtado getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station_213170554_AriasHurtado departureStation) {
        this.departureStation = departureStation;
    }

    public Station_213170554_AriasHurtado getArriveStation() {
        return arriveStation;
    }

    public void setArriveStation(Station_213170554_AriasHurtado arriveStation) {
        this.arriveStation = arriveStation;
    }
}
