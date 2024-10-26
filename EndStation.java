public class EndStation extends Station {

    public EndStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void makeEnd(){
        //System.out.println("\n\n\n############MAKE END CALLED FOR : " + this.name + "\n\n");
        if(this.next == null && this.prev != null){
            //System.out.println("STATION " + prev.name + "BEING ADDED AS STATION" + this.name + "'S NEXT");
            this.next = this.prev;
            //System.out.println("STATION " + this.name + "NOW HAS NEXT" + next.name + "AND PREV " + prev.name);

        }
        if(this.prev == null && this.next != null){
            //System.out.println("STATION " + next.name + "BEING ADDED AS STATION" + this.prev + "'S NEXT");
            this.prev = this.next;
            //System.out.println("STATION " + this.name + "NOW HAS NEXT" + next.name + "AND PREV " + prev.name);

        }
    };

    public String toString(){
        return "END" + super.toString();
    }
}
