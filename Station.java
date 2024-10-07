public class Station {
    protected String name;
    protected String lineColor;
    protected boolean inService;
    protected Station prevStation;
    protected Station nextStation;

    public Station(String name, String lineColor){
        this.name = name;
        this.lineColor = lineColor;
    }

    int tripLength(Station dest){
        return 0;
    }
}
