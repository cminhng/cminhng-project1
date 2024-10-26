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

    public String toString(){
        String ret = "TRANSFER" + super.toString();
        ret += "\n\tTransfers: \n";

        if(this.getOtherStations().size() > 0){
            for(int i = 0; i < this.getOtherStations().size(); i++){
                ret += "\t" + this.getOtherStations().get(i) + "\n";
            }
        }

        return ret;
    }
}
