//import java.util.ArrayList;

public class TransferStation extends Station {

    public TransferStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void addTransferStationPrev(Station prev){
        otherStations.add(prev);
    }

    public void addTransferStationNext(Station next){
        otherStations.add(next);
    }

    public void connect(Station other){
        if(this.next == null){
            this.addNext(other);
        }else{
            this.addTransferStationNext(other);
        }
        other.addPrev(this);
    }

    public String toString(){
        String ret = "TRANSFER" + super.toString();
        
        if(this.getOtherStations().size() > 0){
            ret += "\n\tTransfers: \n";
            for(int i = 0; i < this.getOtherStations().size(); i++){
                ret += "\t" + this.getOtherStations().get(i) + "\n";
            }
        }

        return ret;
    }
}
