import java.util.*;
public class Unique {

    static Map<String,Integer> cache = new HashMap<String,Integer>();
    static int CharCount(String s) {
        if(cache.containsKey(s))
            return cache.get(s);
        Map<Character,Boolean> UniqueChar = new HashMap<Character,Boolean>();
        for(int i=0;i<s.length();i++)
                UniqueChar.put(s.charAt(i),true);
        int count = UniqueChar.size();
        cache.put(s,count);
        return count;
    }

    static void display(String s) {
        System.out.println("String: "+s);
        System.out.println("Unique characters: "+CharCount(s));
    }
    public static void main(String[] args)
    {
        boolean  exit=true;
        while(exit){
            System.out.println("Enter choice: \n1.Enter string\n2.exit");
        Scanner sc=new Scanner(System.in);
        char ch=sc.nextLine().charAt(0);
        switch(ch){
            case '1':
            System.out.println("enter string :");
            String str=sc.nextLine();
            display(str);
            break;

            case '2':
            exit=false;
            break;
            default: 
            System.out.println("invalid");
        }}}
    }
