import java.util.ArrayList;

public interface TreasureRoom {
    ArrayList<Valuable> acquireRead();
    void releaseRead();
    ArrayList<Valuable> acquireWrite();
    void releaseWrite(ArrayList<Valuable> update);
}
