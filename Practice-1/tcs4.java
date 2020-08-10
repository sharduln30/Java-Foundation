import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;



public class tcs4 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        
        Book obj1 = new Book();
        Book obj2 = new Book();
        Book obj3 = new Book();
        Book obj4 = new Book();

        Book[] arr = {obj1,obj2,obj3,obj4};
        for(int i=0;i<arr.length;i++){
            arr[i].id=sc.nextInt();sc.nextLine();
            arr[i].title=sc.nextLine();
            arr[i].author=sc.nextLine();
            arr[i].price=sc.nextDouble();sc.nextLine();
        }
        String str = sc.next();
        Book[] brr = sortBooksByPrice(arr,str);

        for(int i=0;i<j;i++){
            for(int k=i+1;k<j;k++){
                if(brr[i].id>brr[k].id){
                    int temp=brr[i].id;
                    brr[i].id=brr[k].id;
                    brr[k].id=temp;
                }
            }
        }
    for(int i=0;i<j;i++)
        System.out.println(brr[i].id+" "+brr[i].title+" "+brr[i].author+" "+brr[i].price);
    }
    static int j=0;
static Book[] sortBooksByPrice(Book[] arr, String str){
    
    Book[] brr =new Book[arr.length];
    for(int i=0;i<arr.length;i++){   
        String[] sp = arr[i].title.split(" ");
        for(int k=0;k<sp.length;k++){ 
        if(str.equalsIgnoreCase(sp[k])){
            brr[j++] = arr[i];
        }
    }
    }
    return brr;
}
}

class Book
{
     int id;
     String title;
     String author;
     double price;
    }
    // 1
    // hello world
    // aaa writer
    // 50
    // 2
    // World cup
    // bbb writer
    // 55
    // 3
    // Planet earth
    // ccc writer
    // 45
    // 4
    // India's history
    // ddd writer
    // 40
    // WORLD