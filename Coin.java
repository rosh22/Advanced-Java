import java.util.*;
class Flip implements Runnable{
    boolean CoinFlip()
    {
        //true means head and false means tail
        Random rd=new Random();
        return rd.nextBoolean();
    }
    public void run()
    {
        try{
        int count=0;
        for(int i=0;i<1000;i++)
        {
            boolean x=CoinFlip();
            if(x==true)
            {
                count++;
                continue;
            }
            if(count>=3){
            System.out.println(Thread.currentThread().getName()+" gave "+count+" consecutive heads.");
            Thread.sleep(1000);
            }
            count=0;   
        }
    }
    catch(InterruptedException e){
        System.out.println(Thread.currentThread().getName()+" interrupted");
    }
    }

}

class TaskQ{
    void execute(Flip c)
    {
        Thread t=new Thread(c);
        t.start();
    }
}
public class Coin {
    public static void main(String[] args)
    {
        TaskQ t=new TaskQ();
        for(int i=0;i<5;i++)
        t.execute(new Flip());
    }
}