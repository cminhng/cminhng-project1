public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    protected Station prev;
    protected Station next;

    public Station(String name, String lineColor){
        this.name = name;
        this.lineColor = lineColor;
    }

    public int tripLength(Station dest){
        return 0;
    }

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
