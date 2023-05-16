import java.util.ArrayList;

public class TaxCollector implements Runnable{
    private TreasureRoom lock;
    private ArrayList<Valuable> valuables;
    private ValuableFactory factory;
    private int name;
    private Valuable d;
    private Valuable r;
    private Valuable e;
    private Valuable g;

    public TaxCollector(Room lock,ValuableFactory factory,int name) {
        this.name=name;
        this.lock = lock;
        this.factory=factory;
        this.valuables=new ArrayList<>();
         this.d= factory.get("Diamond");
         this.r= factory.get("Ruby");
         this.e= factory.get("Emerald");
         this.g=  factory.get("GoldCoin");
        Catalog.getInstance().note("TaxCollector "+name+" is now ready.");
    }

    public void run(){
        while(true){
            Catalog.getInstance().note("TaxCollector "+name+" says: I will go and collect taxes now.");
            random(6000, 9000);
            int tax=getTaxes();
            Catalog.getInstance().note("TaxCollector "+name+" says: I got "+ tax+ ". I will go to the factory now.");
                getValuables(tax);
            Catalog.getInstance().note("TaxCollector "+name+" says: I got the valuables, now i will go to the treasure room.");
            ArrayList<Valuable> room=lock.acquireWrite();
            for(int i=0;i<valuables.size();i++){
                room.add(valuables.get(i));
            }
            random(3000, 7000);
            int max=value(room);
            lock.releaseWrite(room);
            Catalog.getInstance().note("TaxCollector "+name+" says: I have added "+ value(valuables)+" and the total is: "+max+". I finished work for today.");
            valuables=new ArrayList<>();
            random(8000, 12000);
        }}

    private void random(int min, int max){
        long time = (long)(Math.random() * (max -min) + min);
        try{Thread.sleep(time);
        }catch(InterruptedException e)
        {e.printStackTrace();
        }}

        private int getTaxes(){
        return (int)(Math.random() * (151 -25) + 25);
    }

        private void getValuables(int i){
        while(i>=0){
            if(i>=25){
                valuables.add(d);
                i-=25;
            }
            if(i>=17){
                valuables.add(r);
                i-=17;
            }
            if(i>=11){
                valuables.add(e);
                i-=11;
            }
            if(i>0){
                valuables.add(g);
                i-=5;
            }
        }
    }

    private int value(ArrayList<Valuable> room){
        int s=0;
        for(int i=0;i<room.size();i++){
            s+=room.get(i).getValue();
        }
        return s;
    }

}

