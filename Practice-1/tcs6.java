import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tcs6 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        double balance = sc.nextDouble();
        double interestRate = sc.nextDouble();
        Account obj = new Account(id,balance,interestRate);
        int t=sc.nextInt();
        double i = calculateInterest(obj,t);
        System.out.format("%.3f",i);
    }
    
    public static double calculateInterest(Account a, int noOfYears)
    {
        double i = (a.interestRate*noOfYears)/100;
        a.interestRate+=i;
        double bal = (a.balance*a.interestRate)/100;
        return bal;
    }
}

class Account
{
    int id;
    double balance;
    double interestRate;
    Account(int id, double balance, double interestRate){
        this.id =id;
        this.balance=balance;
        this.interestRate=interestRate;
    }
}