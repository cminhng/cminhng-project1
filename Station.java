import java.util.ArrayList;

public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    protected Station prev;
    protected Station next;
    public ArrayList<Station> otherStations = new ArrayList<Station>();


    public Station(String lineColor, String name){
        this.name = name;
        this.lineColor = lineColor;
        this.inService = true;
    }

    public ArrayList<Station> getOtherStations(){
        return otherStations;
    }

    public boolean equals(Station other){
        if(this.lineColor.equals(other.lineColor) && this.name.equals(other.name)){
            return true;
        }
        return false;
    }

    public int tripLength(Station dest){
        int dist = 0; 

        if(this.equals(dest)){
            return 0;
        }

        ArrayList<Station> visited = new ArrayList<Station>();

        int recurse = this.recursiveTripLength(visited, dist, dest);
        if(recurse == -1){
            return -1;
        }
        return recurse;
    }

    private int recursiveTripLength(ArrayList<Station> visited, int dist, Station dest){
        //null checks
        if(this.equals(dest)){
            return dist;
        }
        for(int i = 0; i < visited.size(); i++){
            if(this.equals(visited.get(i))){
                return -1; 
            }
        }

        visited.add(this);
        dist += 1;
        
        
        if(this.getOtherStations().size() > 0){//not empty
            for(int i = 0; i < this.getOtherStations().size(); i++){
                int other = this.getOtherStations().get(i).recursiveTripLength(visited, dist, dest);
                if(other > -1){
                    return other;

                }
            }
        }

        int next = 0; 
        if(this.next != null){
            next = this.next.recursiveTripLength(visited, dist, dest);
        }
        return next;
    }

    public void addNext(Station next){
        this.connect(next);
    }

    public void addPrev(Station prev){
        prev.connect(this);
    }

    public void connect(Station other){
        if (this instanceof TransferStation) {
            TransferStation t = (TransferStation) this;
            if (t.next == null) {
                t.next = other; 
            } else {
                t.addTransferStationNext(other); 
            }
            other.prev = t;
        } else if (other instanceof TransferStation) {
            TransferStation o = (TransferStation) other;
            if (o.prev == null) {
                o.prev = this;
            } else {
                o.addTransferStationPrev(this); 
            }
            this.next = o;
        } else {
            this.next = other;
            other.prev = this;
        }

    }

    public void switchAvailable(){
        this.inService = !this.inService;
    }

    public boolean isAvailable(){
        return this.inService;
    }

    public String toString(){
        return "STATION " + name + ": " + lineColor + " line, in service: "
        + inService + ", previous station: " + (prev == null ? "none" : prev.name) 
        + ", next station: " + (next == null ? "none" : next.name);
    }
}   
