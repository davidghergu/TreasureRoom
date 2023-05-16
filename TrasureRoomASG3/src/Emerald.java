public class Emerald implements Valuable {

    private String name;
    public Emerald(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return 11;
    }
}
