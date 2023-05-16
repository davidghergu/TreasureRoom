public class Catalog {
    private static Catalog instance;

    private Catalog(){}

    public static synchronized Catalog getInstance(){
        if(instance== null)
        {
            instance= new Catalog();
        }
        return instance;
    }

    public synchronized void note(String msg){
        System.out.println(msg);
    }


}
