//import java.util.ArrayList;

public class TransferStation extends Station {

    public TransferStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void addTransferStationPrev(Station prev){
        otherStations.add(prev);
        prev.next = this;
    }

    public void addTransferStationNext(Station next){
        otherStations.add(next);
        next.prev = this;
    }

    /*public void connect(Station other){
        System.out.println("TRASNFER STATION CONNECT BEING CALLED ON METRO CENTER.");
        if(this.next != null){
            //System.out.println("\n**TRASNFER STATION ALREADY HAS NEXT: " + next.name);

        }
        if(this.next == null){
            this.addNext(other);
        }else{
            System.out.println("\n**TRASNFER STATION ALREADY HAS NEXT: " + next.name);

            this.addTransferStationNext(other);
        }
        other.addPrev(this);
    }*/

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
