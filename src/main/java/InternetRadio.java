public class InternetRadio implements IConnect {

    private Station currentStation;

    public InternetRadio(Station station){
        this.currentStation = station;
    }

    public Station getCurrentStation() {
        return currentStation;
    }

    public void tune(Station newstation){
        currentStation = newstation;
    }

    public String connect(String data) {
        return "Connecting to " + data + " network.";
    }

}
