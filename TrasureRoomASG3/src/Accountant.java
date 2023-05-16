import java.util.ArrayList;

public class Accountant implements Runnable{
    private TreasureRoom lock;
    private int name;

    public Accountant(Room lock,int name) {
        this.lock = lock;
        this.name = name;
        Catalog.getInstance().note("Accountant "+name+" is now ready.");
    }

    public void run(){
        while(true){
            wait(5000, 11000);
            Catalog.getInstance().note("Accountant "+name+" says: I will go and calculate the sum.");
            wait(1000,3000);
            ArrayList<Valuable> values=lock.acquireRead();
            int sum=countValue(values);
            Catalog.getInstance().note("Accountant "+name+" says: The total sum of valuables is : "+sum);
            wait(2000,5000);
            lock.releaseRead();
        }}

    private void wait(int min, int max){
        long time = (long)(Math.random() * (max -min) + min);
        try{Thread.sleep(time);
        }catch(InterruptedException e)
        {e.printStackTrace();
        }}

private int countValue(ArrayList<Valuable> values){
        int sum=0;
        for(int i= 0;i<values.size();i++){
            wait(5000, 1000);
            sum+=values.get(i).getValue();
        }
        return sum;
}
}
