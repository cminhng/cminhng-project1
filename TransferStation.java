import java.util.ArrayList;

public class TransferStation extends Station {

    public TransferStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void addNext(Station other){
        this.addTransferStationNext(other);
    }

    public void addPrev(Station other){
        this.addTransferStationPrev(other);
    }

    public void addTransferStationPrev(Station prev){
        otherStations.add(prev);
    }

    public void addTransferStationNext(Station next){
        otherStations.add(next);
    }

    /*public void connect(Station other){
        this.addNext(other);
        other.addPrev(this);
    }*/ //or other method 

    public String toString(){
        return "TRANSFER" + super.toString();//what do you do with the other next and prev
        //loop thru array and call those toStrings()
    }
}
