import java.util.*;

class Array
{
    int size,index;
    int [] arr;
    int capacity;
       Array(int size)
       {
       this.size=size;
       arr=new int[size];
       index=-1;
       capacity=size;
       }

}
class A extends Thread{
    Array x;
   
    public A(Array x)
    {
    this.x=x;
    }
   
    public void run()
    {
        while(true){
    synchronized(x)
    {
    try{
   while(x.capacity==0)
    x.wait();
    x.index=(x.index+1)%x.size;
    x.arr[x.index]=(int)(Math.random()*100);
    x.capacity--;
    System.out.println("A wrote "+x.arr[x.index]+" at index "+x.index);
    x.notifyAll();
    Thread.sleep(1000);
    }
    catch(Exception e){
    System.out.println("Exception in A");
    } } } }
}
  
class B extends Thread
{
 Array x;
 public B(Array x)
 {
 this.x=x;
 }
 public void run()
 {
    while(true){
        synchronized(x)
        {
        try{
       while(x.capacity==x.size)
       x.wait();
       System.out.println("B read "+x.arr[x.index]+" at index "+x.index);
       if(x.index==0)
       x.index=x.size-1;
       else
       x.index--;
       x.capacity++;
       x.notifyAll();
       Thread.sleep(1000);
        }
        catch(Exception e){
        System.out.println("Exception in B");
        }
    }
 }
}}

public class CircularArr extends Thread {
public static void main(String[] args)throws Exception  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int size=sc.nextInt();
    Array obj=new Array(size);
    A a=new A(obj);
    B b=new B(obj);
    a.start();
    b.start();    
}    
}