public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    protected Station prev;
    protected Station next;

    public Station(String lineColor, String name){
        this.name = name;
        this.lineColor = lineColor;
    }

    public int tripLength(Station dest){
        int dist = 0; 
        if(this.equals(dest)){
            return 0;
        }
        //return this.recursiveTripLength(dist, dest);
        //return this.next.tripLength(dest);
        return 0
    }

    /*private int recursiveTripLength(int dist, Station dest){
        if(this.equals(dest)){
            return 0;
        }
        return this.next.recursiveTripLength(dest);
    }*/

    public void addNext(Station next){
        this.next = next;
        //next.prev = this;
    }

    public void addPrev(Station prev){
        this.prev = prev;
        //prev.next = this;
    }

    public void connect(Station other){
        this.addNext(other);
        other.addPrev(this);
    }

    public void switchAvailable(){
        this.inService = !this.inService;
    }

    public boolean equals(Station other){
        if(this.lineColor.equals(other.lineColor) && this.name.equals(other.name)){
            return true;
        }
        return false;
    }

    public String toString(){
        return "STATION " + name + ": " + lineColor + " line, in service: "
        + inService + ", previous station: " + (prev == null ? "none" : next) 
        + ", next station: " + (next == null ? "none" : next);
    }
}   
