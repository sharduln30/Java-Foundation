import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class tcs3 {
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
            arr[i].folderName=sc.next();
            arr[i].pages=sc.nextInt();
        }
        Book[] crr = docsWithOddPages(arr);

        for(int i=0;i<crr.length;i++){
            System.out.println(crr[i].id+" "+crr[i].title+" "+crr[i].folderName+" "+crr[i].pages);
        }
    }
    static int j=0;
    
static Book[] docsWithOddPages(Book[] arr){
    
    Book[] brr=new Book[arr.length];
   
    for(int i=0;i<arr.length;i++){   
            if(arr[i].pages%2==1){
                brr[j++]=arr[i];
            }
        }
    
    return brr;
}
}
class Book
{
     int id;
     String title;
     String folderName;
     int pages;
   
    }
