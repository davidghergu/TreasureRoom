public class Diamond implements Valuable {
    private String name;
    public Diamond(String name){
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return 25;
    }
}
