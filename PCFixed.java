import java.util.*;
class Q {
    int n,j=0;
    int s;
    
    Q(int s){
      this.s=s;
    }
    boolean valueSet = false;
    synchronized int get() {
      while(!valueSet)
      {
        try {
          wait();
        } catch(InterruptedException e) {
          System.out.println("InterruptedException caught");
        }
      }
      System.out.println("Got: " + n--);
      j--;
      if(j==0){
      valueSet = false;
      notify();
      
    }
      return n;
      
    }
    synchronized void put(int n) {
     while(valueSet) {
          try {
            wait();
          } catch(InterruptedException e) {
            System.out.println("InterruptedException caught");
          }
     }
          this.s=s;
          this.n = n;
          System.out.println("Put: " + n);
          j++;
          if(j==s){
          valueSet = true;
          
          notify();
          }
      }
  }
  class Producer implements Runnable {
    Q q;
  
   
  
    Producer(Q q) {
      this.q = q;
      new Thread(this, "Producer").start();
    }
  
   
  
    public void run() {
      int i = 0;
  
   
  
      while(true) {
        q.put(i++);
      }
    }
  }

  class Consumer implements Runnable {
    Q q;
  
   
  
    Consumer(Q q) {
      this.q = q;
      new Thread(this, "Consumer").start();
    }
    
    public void run() {
      while(true) {
        q.get();
      }
    }
  }
  
  public class PCFixed {
    public static void main(String args[]) {
      Scanner sc= new Scanner(System.in);
      System.out.println("enter queue size: ");
      int s= sc.nextInt();
      Q q = new Q(s);
      new Producer(q);
      new Consumer(q);
      System.out.println("Press Control-C to stop.");
    }
  }

