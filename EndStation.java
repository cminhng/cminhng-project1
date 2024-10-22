public class EndStation extends Station {

    public EndStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void makeEnd(){
        if(this.next != null){
            this.prev = this.next;
        }else if(this.prev != null){
            this.next = this.prev;
        }
    };

    public String toString(){
        return "END" + super.toString();
    }
}
