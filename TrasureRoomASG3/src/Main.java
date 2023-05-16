public class Main {
    public static void main(String[] args) {
        Catalog.getInstance().note("Console : Creating characters.");
    Room room=new Room();
    ValuableFactory factory=new ValuableFactory();
    TaxCollector collector1=new TaxCollector(room,factory,1);
    TaxCollector collector2=new TaxCollector(room,factory,2);
    TaxCollector collector3=new TaxCollector(room,factory,3);
    King king=new King(room);
    Accountant accountant1=new Accountant(room,1);
    Accountant accountant2=new Accountant(room,2);
        Catalog.getInstance().note("Console : Everyone is ready.");
        Thread th1=new Thread(collector1);
       // Thread th2=new Thread(collector2);
      //  Thread th3=new Thread(collector3);
        Thread th4=new Thread(accountant1);
      //  Thread th5=new Thread(accountant2);
        Thread th6=new Thread(king);
        th1.start();
       // th2.start();
       // th3.start();
        th4.start();
       // th5.start();
        th6.start();

    }

    }

