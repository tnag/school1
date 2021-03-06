package edu.ghs11.project1;

// HOTFIX 7
import java.util.Scanner;
//check prime palindrome feat-4
public class Checker {
    // feature-5
    long num,reverse,abc;
   
    
    // constructor
    public Checker(long z) {
 
        num = z;
    }

    
    // hotfix1 
    // recursively reverse number
    long reverseNum(long q) {
        
        String s="";
        
        if (q < 10) {
            s=reverse+""+q;
             
            reverse = Long.valueOf(s);
        }
        else {
            // print the unit digit of the given number
             
            s=reverse+""+(q % 10 );    
            reverse = Long.valueOf(s);
            // calling function for remaining number other
            // than unit digit
            reverseNum(q / 10);
           
        }
        
        return reverse;
        
    }
    
    
    
    //check if number is prime
    boolean prime( ) {
        boolean flag=false;
        int count = 0;
         for(int i = 1; i <= num; i++)  
            {  
                if(num%i == 0)  
                {  
                    count++;    //increment counter when the reminder is 0  
                }  
            }  
        if (count==2) {
            flag=true;
            System.out.println("this is prime");
        } else {
            flag=false;
            System.out.println(" this is NOT prime ");
        }
        
        return flag;
    }
    
    
    // display output uat1
    void display( ) {
    
        long temp = num;
        long rev_temp = reverseNum(temp);
        System.out.println("  reverse "+rev_temp);
        
        if ( prime() && (num == rev_temp ) )
            System.out.println("This number is a Prime Palindrome ");
        else
            System.out.println("This number is NOT a Prime Palindrome ");
    
    }   
        
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number : ");
        long n = in.nextLong();
        
        Checker chk = new Checker(n);
        chk.display();
        
        in.close();
        

    }

}


