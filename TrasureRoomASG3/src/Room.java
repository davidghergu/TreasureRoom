import java.util.ArrayList;

public class Room implements TreasureRoom {

    private int readers;
    private int writers;
    private ArrayList<Valuable> goods;

    public Room() {
        readers = 0;
        writers = 0;
        goods=new ArrayList<>();
    }


    public synchronized ArrayList<Valuable> acquireRead() {
        while (writers > 0||readers >0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        readers++;
        ArrayList<Valuable> goods1=goods;
        return goods1;
    }

    public synchronized void releaseRead() {
        readers--;
        notifyAll();
    }


    public synchronized ArrayList<Valuable> acquireWrite() {
        while (writers > 0||readers>0) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        writers++;
        return goods;

    }

    public synchronized void releaseWrite(ArrayList<Valuable> update) {
        writers--;
        goods=update;
        notifyAll();
    }
}
