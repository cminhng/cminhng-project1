public class EndStation extends Station {

    public EndStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void makeEnd(){
        if(this.next == null && this.prev != null){
            this.next = this.prev;
        }
        if(this.prev == null && this.next != null){
            this.prev = this.next;
        }
    };

    public String toString(){
        return "END" + super.toString();
    }
}
