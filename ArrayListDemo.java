import java.util.*;
class Student{
    String sId;
    String sName;
    Student(String pId,String pName){
        this.sId=pId;
        this.sName=pName;
    }
}

class Employee{
    String eId;
    String eName;
    Employee(String pId,String pName){
        this.eId=pId;
        this.eName=pName;
    }
}

 


class EmpComparator implements Comparator<Employee> {
    @Override 
    public int compare(Employee e1, Employee e2)
    {
        return (e1.eName).compareTo(e2.eName);
    }
}

 

public class ArrayListDemo {
    public static void main(String args[]) {
        Student s1=new Student("S01","fog");
        Student s2=new Student("S02","cloud");
        Student s3=new Student("S03","sky");
        Student s4=new Student("S04","bigdata");
        
        Employee e1=new Employee("E01","MOON");
        Employee e2 =new Employee("E02","EARTH");
        Employee e3=new Employee("E03","VENUS");
        Employee e4 =new Employee("E04","JUPITER");
        ArrayList aList=new ArrayList();
        //ArrayList<Employee> aList=new ArrayList();
        aList.add(s1);
        aList.add(s2);
        aList.add(e1);
        aList.add(e2);
        
        Iterator it=aList.iterator();
        while(it.hasNext()){
            Object obj= it.next();
            if(obj instanceof Student ){
                //System.out.println("STUDENT");
                Student stu = (Student)obj;
                System.out.println("STUDENT"+stu.sName);
                
            }
            else if(obj instanceof Employee ){
                //System.out.println("EMPLOYEE");
                Employee emp = (Employee)obj;
                System.out.println("Employee"+emp.eName);
            }
            else
                System.out.println("IRRELEVANT");
        }
        
        Enumeration e = Collections.enumeration(aList);
        // Print the Enumeration
        System.out.println("\nEnumeration over list: ");
 
        // print the enumeration
        while (e.hasMoreElements())
                System.out.println("Value is: " + e.nextElement());
                
                
             
             
        System.out.println("Workign with HAshSet");        
        HashSet<Student> hashSet = new HashSet<Student>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
 
        // printing every element in Set
 
        for (Student value : hashSet) {
            System.out.println(value.sName);
        }
        
        System.out.println("Workign with TreeSet");
        TreeSet<Employee> treeSet = new TreeSet<Employee>(new EmpComparator());
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        
        for (Employee value : treeSet) {
            System.out.println(value.eName);
        }
      
           
    }
}