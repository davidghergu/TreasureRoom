public class GoldCoin implements Valuable {

    private String name;
    public GoldCoin(String name){
        this.name=name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return 5;
    }
}
