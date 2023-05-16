import java.util.HashMap;

public class ValuableFactory {

    private static HashMap<String, Valuable> values= new HashMap<String, Valuable>();


    public static synchronized Valuable get(String name){

        Valuable item = values.get(name);
        if (item == null){
            switch (name){
                case "Diamond": item = new Diamond(name);break;
                case"Ruby": item = new Ruby(name);break;
                case"GoldCoin":item= new GoldCoin(name);break;
                case"Emerald":item = new Emerald(name);break;
        }
            values.put(name, item);
        }
        return item;
}
}
