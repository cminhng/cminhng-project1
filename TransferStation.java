import java.util.ArrayList;

public class TransferStation extends Station {
    static ArrayList<Station> transfers = new ArrayList<Station>();

    public TransferStation(String name, String lineColor){
        super(name, lineColor);
    }

    public void addTransferStationPrev(Station prev){
        transfers.add(prev);
    }

    public String toString(){
        return "TRANSFER" + super.toString();
    }
}
