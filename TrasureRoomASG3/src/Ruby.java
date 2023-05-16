public class Ruby implements Valuable {

    private String name;
    public Ruby(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return 17;
    }
}
