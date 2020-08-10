import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class tcs1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

    Scanner sc = new Scanner(System.in);
   int id = sc.nextInt();
   double balance = sc.nextDouble();
   double interestRate = sc.nextDouble();
    Account ob = new Account(id,balance,interestRate);
    
    ob.setter(id,balance,interestRate);
    id=ob.getId();
    balance=ob.getBal();
    interestRate=ob.getIR();

    System.out.println(calculateInterest(ob, 10));
    }
    
    public static double calculateInterest(Account a, int noOfYears)
    {
        double interest = (a.getBal()*a.getIR()*noOfYears)/100;
        return interest;
    }
}

class Account
{
    private int id;
    private double balance;
    private double interestRate; 
    public int getId(){
        return this.id;
    }
    public double getBal(){
        return this.balance;
        
    }
    public double getIR(){
        return this.interestRate;
    }

    public void setter(int id,double bal,double ir){
        this.id=id;
        this.balance=bal;
        this.interestRate=ir;
        
    }
    Account(int id, double balance, double interestRate){
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
    }

}