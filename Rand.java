import java.util.*;
import java.util.stream.Stream;
public class Rand{
    static int rand_five = 0,l=0,a=0;
    static List<Double> list = new ArrayList<Double>();
    static double[] array = new double[20];
    static Double randDouble() {
        return Math.random()*10;
    }
    static void display(Double d) {
        if(rand_five==0)
        {
            System.out.println("5 random numbers : ");
        }
        if(rand_five<5) {
            System.out.println(d);
            rand_five++;
            return;
        }
        if(l<10)
        {
            list.add(d);
            l++;
            return;
        }
        if(l==10)
        {
            System.out.println("\nList of 10 random numbers: ");
            list.stream().forEach(System.out::println);
            l++;
        }
        if(a<20)
        {
            array[a]=d;
            a++;
            return;
        }
        if(a==20)
        {
            System.out.println("\nArray of 20 random numbers: ");
            for(int i=0;i<array.length;i++)
            {
                System.out.println(array[i]);
            }
            a++;
        }
    }
    public static void main(String args[])
    {
        Stream<Double> stream = Stream.generate(Rand::randDouble);
        stream.forEach(Rand::display);
    }
}