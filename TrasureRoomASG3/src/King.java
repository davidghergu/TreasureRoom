
import java.util.ArrayList;

public class King implements Runnable {
    private TreasureRoom lock;


    public King(Room lock) {
        this.lock = lock;
        Catalog.getInstance().note("King is now ready.");

    }

    public void run(){
        while(true){
            random(8000, 16000);
            Catalog.getInstance().note("King says: I propose the party for tonight.");
            int price=partyPrice();
            random(1000, 3000);
            Catalog.getInstance().note("King says: I will see if i can afford it first.");
            ArrayList<Valuable> room=lock.acquireWrite();
            random(2000, 4000);
            int roomprice=value(room);
            Catalog.getInstance().note("King says: I need "+price+" and there is "+roomprice);
            if(price<=roomprice){
                if(price==roomprice){
                    ArrayList<Valuable> nothing=new ArrayList<>();
                    lock.releaseWrite(nothing);
                    Catalog.getInstance().note("King says: Let's Party!");
                }else if(price<roomprice){
                int i=0;
                while (price>=0){
                    random(2000, 3000);
                   price-= room.get(i).getValue();
                   room.remove(i);
                    //i++;

                }
                    ArrayList<Valuable> updated=updateRoom(i,room);
                    Catalog.getInstance().note("King says: i got the valuables and there is "+value(room)+" left.");
                    lock.releaseWrite(room);
                    Catalog.getInstance().note("King says: Let's PARTY!!");
                }
            }
            else{
                Catalog.getInstance().note("King says: there is not enough valuables to pay for the party so it is canceled.");
                random(3000, 5000);
                lock.releaseWrite(room);
            }
        }}


    private void random(int min, int max){
        long time = (long)(Math.random() * (max -min) + min);
        try{Thread.sleep(time);
        }catch(InterruptedException e)
        {e.printStackTrace();
        }}

    private int partyPrice(){
        return (int)(Math.random() * (180 -40) + 40);
    }

    private ArrayList<Valuable> updateRoom(int i,ArrayList<Valuable> list){
        ArrayList<Valuable> room1=new ArrayList<>();
        for(int k=i;k<list.size();k++)
        {
            room1.add(list.get(i));
        }
        return room1;
    }

    private int value(ArrayList<Valuable> room){
        int s=0;
      for(int i=0;i<room.size();i++){
          s+=room.get(i).getValue();
      }
      return s;
      }

}
