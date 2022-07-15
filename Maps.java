import java.util.*;

public class Maps {
    
    public static void main(String[] args)
    {
       
        HashMap<String, String> map = new HashMap<>();
 

        map.put("a1234", "Steve Jobs");
        map.put("a1235", "Scott McNealy");
        map.put("a1236", "Jeff Bezos");
        map.put("a1237", "Larry Ellison");
        map.put("a1238", "Bill Gates");
        Scanner sc=new Scanner(System.in);
        boolean e=false;
        while(!e){
            System.out.println("Enter choice: \n1.Enter ID\n2.exit");
            char ch=sc.nextLine().charAt(0);
        switch(ch){
            case '1':
        System.out.println( "Enter ID: ");
        String s=sc.nextLine();
        
        if (map.containsKey(s)) {
            System.out.println( map.get(s));
        }
        else
        System.out.println( "Invalid ID");
        break;
    case '2':
e=true;
break;}
    }
}}