import java.util.ArrayList;

public class TransferStation extends Station {
    static ArrayList<Station> transfers = new ArrayList<Station>();

    public TransferStation(String name, String lineColor){
        super(name, lineColor);
    }

    public void addTransferStationPrev(Station prev){
        transfers.add(prev);
    }

    public void addTransferStationNext(Station next){
        transfers.add(next);
    }

    public String toString(){
        return "TRANSFER" + super.toString();//what do you do with the other next and prev
    }
}
