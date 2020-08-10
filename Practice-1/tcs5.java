import java.util.Scanner;

public class tcs5 {
    public static void main(String args[] ) throws Exception {
        /* Do not alter code in main method */
       Shirt[] shirts = new Shirt[5];
        
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0;i<5;i++)
        {
            int tag = sc.nextInt();sc.nextLine();
            String brand = sc.nextLine();
            double price = sc.nextDouble();sc.nextLine();
            char g = sc.nextLine().charAt(0);
            shirts[i] = new Shirt(tag,brand,price,g);
        }
        
        
       
        double price = sc.nextDouble();
        
        for(Shirt s: shirts)
        {
            System.out.println(getDiscountPrice(s));            
        }
        
        Shirt[] result = getShirtWithMoreThanSpecificPrice(shirts,price);
        
        for(int i=0;i<j;i++)
        {
            System.out.println(result[i].getTag()+" "+result[i].getPrice()+ " " + result[i].getBrand());
        }
    }
    
    /* implement your methods here*/
    public static double getDiscountPrice(Shirt s){
        double dis=0.0;
        if(s.getGender()=='m')
            dis=s.getPrice()-0.1*s.getPrice();
        else if(s.getGender()=='f')
            dis=s.getPrice()-0.2*s.getPrice();
        else if(s.getGender()=='u')
            dis=s.getPrice()-0.3*s.getPrice();
        return dis;
    }
    static int j=0;
    public static Shirt[] getShirtWithMoreThanSpecificPrice(Shirt[] shirts, double price){

        Shirt[] shr=new Shirt[shirts.length];
        for(int i=0;i<shirts.length;i++){
            if(shirts[i].getPrice()>price)
            shr[j++]=shirts[i];
        }
        for(int i=0;i<j;i++){
            for(int k=i+1;k<j;k++){
                if(shr[i].getPrice()>shr[k].getPrice()){
                    Shirt temp=shr[i];
                    shr[i]=shr[j];
                    shr[j]=temp;
                }
            }
        }
        return shr;
    }
}

class Shirt
{
    
    //define the class as per details shared in the question
    private int tag;
    private String brand;
    private double price;
    private char gender;
    public int getTag(){
        return this.tag;
    }
    public String getBrand(){
        return this.brand;
    }
    public double getPrice(){
        return this.price;
    }
    public char getGender(){
        return this.gender;
    }
    Shirt(int tag,String brand, double price,char gender){
        this.brand=brand;
        this.tag=tag;
        this.price=price;
        this.gender=gender;
    }
}
// 1
// arrow
// 500
// m
// 2
// bare
// 600
// f
// 3
// arrow
// 400
// m
// 4
// bare
// 300
// m
// 5
// arrow
// 1000
// u
// 500