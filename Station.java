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

        return (this.recursiveTripLength(visited, dist, dest) == -1 ? -1 : 
                dist + this.recursiveTripLength(visited, dist, dest));
    }

    private int recursiveTripLength(ArrayList<Station> visited, int dist, Station dest){
        if(this.equals(dest)){
            return 0;
        }
        for(int i = 0; i < visited.size(); i++){
            if(this.equals(visited.get(i))){
                return -1; 
                //????? if it does this do i want it to just . 
                //exit or is it possible there are other paths to explore
            }
        }

        visited.add(this);
        dist += 1;
        int other = 0;
        
            if(this.getOtherStations().size() > 0){//not empty
                for(int i = 0; i < this.getOtherStations().size(); i++){
                    other += this.getOtherStations().get(i).recursiveTripLength(visited, dist, dest);
                }
            }

        return dist + other+ this.next.recursiveTripLength(visited, dist, dest);
    }

    public void addNext(Station next){
        this.next = next;
    }

    public void addPrev(Station prev){
        this.prev = prev;
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
        + inService + ", previous station: " + (prev == null ? "none" : next) 
        + ", next station: " + (next == null ? "none" : next);
    }
}   
