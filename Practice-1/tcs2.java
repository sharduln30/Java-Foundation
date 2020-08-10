import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class tcs2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        
        Book obj1 = new Book();
        Book obj2 = new Book();
        Book obj3 = new Book();
        Book obj4 = new Book();

        Book[] arr = {obj1,obj2,obj3,obj4};
        for(int i=0;i<arr.length;i++){
            arr[i].id=sc.nextInt();
            arr[i].title=sc.next();
            arr[i].author=sc.next();
            arr[i].price=sc.nextDouble();
        }
        Book[] brr = sortBooksByPrice(arr);

        for(int i=0;i<brr.length;i++){
            System.out.println(brr[i].id+" "+brr[i].title+" "+brr[i].author+" "+brr[i].price);
        }
    }
    
static Book[] sortBooksByPrice(Book[] arr){
    
    for(int i=0;i<arr.length;i++){   
        for(int j=i+1;j<arr.length;j++){
            if(arr[i].price>arr[j].price){
                Book temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    return arr;
}
}

class Book
{
     int id;
     String title;
     String author;
     double price;

    // public int getId(){
    //     return this.id;
    // }   
    // public String getTitle(){
    //     return this.title;
    // }
    // public String getAuthor{
    //     return this.author;
    // }
    // public double getPrice{
    //     return this.price;
    // }
    // public void setter(int id,String title,String author,double price){
    //     this.id=id;
    //     this.title=title;
    //     this.author=author;
    //     this.price=price;
    // }
    }
