import java.util.ArrayList;

public class TransferStation extends Station {
    static ArrayList<Station> transfers = new ArrayList<Station>();

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
        transfers.add(prev);
    }

    public void addTransferStationNext(Station next){
        transfers.add(next);
    }

    public String toString(){
        return "TRANSFER" + super.toString();//what do you do with the other next and prev
        //loop thru array and call those toStrings()
    }
}
