import java.util.Scanner;
class Mobile{
    String name;
    String model;
    int price;
    int year;
    Mobile()
    {
        name="Not assigned";
        model="Not assigned";
        price=0;
        year=0;
    }
    Mobile(String name,String model,int price,int year)
    {
        this.name=name;
        this.model=model;
        this.price=price;
        this.year=year;
    }
    Mobile(Mobile m)
    {
        this.name=m.name;
        this.model=m.model;
        this.price=m.price;
        this.year=m.year;
    }
    void display(){
        System.out.println("----THE details of Mobile----");
        System.out.println("Mobile Name:"+name);
        System.out.println("Mobile Model:"+model);
        System.out.println("Mobile Price:"+price);
        System.out.println("Mobile Year:"+year);
    }

}
public class Exp2b{
    
    public static void main(String[] args)
    {
        Scanner  sc =new Scanner(System.in);
        //Default constructor 
        Mobile m1 = new Mobile();
        //Parameterized Constructor
        System.out.print("Enter your Mobile Name:");
        String name=sc.nextLine();
        
        System.out.print("Enter your Mobile Model:");
        String model=sc.nextLine();

        System.out.print("Enter your Mobile Price:");
        int price=sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()
        System.out.print("Enter your Mobile Year:");
        int year=sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        Mobile m2 =new Mobile(name,model,price,year);

        //Copy Constructor
        Mobile m3= new Mobile(m2);
        //Display details
        System.out.println("Displaying Details using default constructor:");
        m1.display();

        System.out.println("Displaying Details using Parameterized constructor:");
        m2.display();
        System.out.println("Displaying Details using Copy constructor:");
        m3.display();
        sc.close();
    }
}