import java.util.ArrayList;

public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    protected Station prev;
    protected Station next;
    public static ArrayList<Station> otherStations = new ArrayList<Station>();


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
        //System.out.println("tripLength "+ recurse);
        if(recurse == -1){
            //System.out.println("\nTRIP LENGTH IS -1");
            return -1;
        }
        return recurse;
    }

    private int recursiveTripLength(ArrayList<Station> visited, int dist, Station dest){
        //null checks
        //System.out.println(this.name + " -> " + dest.name + " " + dist);
        if(this.equals(dest)){
            //System.out.println("at "+ dest.name + " " + dist);
            return dist;
        }
        for(int i = 0; i < visited.size(); i++){
            if(this.equals(visited.get(i))){
                //System.out.println("\n\nSTATION: " + this.name + " ALREADY VISITED\n\n");
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
        this.next = next;
        this.next.prev = this;
    }

    public void addPrev(Station prev){
        this.prev = prev;
        this.prev.next = this;
    }

    public void connect(Station other){
        this.addNext(other);
        other.addPrev(this);
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
