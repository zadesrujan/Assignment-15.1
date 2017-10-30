package online;

import java.util.Scanner;

public class Bankaccount {


static double accountBalance;
//The double data type is a double-precision 64-bit IEEE 754 floating 
//point. Its range of values is beyond the scope of this discussion, but is specified in the Floating-Point Types, Formats, and Values section of the Java Language Specification.
double newAccountBalance;
  // to withdraw funds from the account
  public synchronized void withdraw(double amount)  
  {
      //variable declaration
      if(amount>accountBalance)
      {
           //there are not enough funds in the account
      System.out.println("Do not have sufficent amount in your account"); 
      }
      else
      {
      //update the new account balance
          newAccountBalance=accountBalance-amount;
          accountBalance = newAccountBalance;
          System.out.println(amount+" amount was withdrawn from your account sucessfully.");
          System.out.println("Your Account Balance: "+newAccountBalance);
      }
  }
  //to deposit the amount in the account
  public synchronized void deposit(double amount) 
  {
  if(amount<0.0) //checks for negative values
  {
  System.out.println("Can not depoist negative amount"); // can not deposit a negative amount
  }
  else
  {
  //update the new account balance
        newAccountBalance = accountBalance+amount;
        accountBalance = newAccountBalance;
        System.out.println("Your amount "+amount+" is sucessfully deposited.");
        System.out.println("Your Account Balance: "+newAccountBalance);
       }
   }
  
  public static void main(String[]args)
//static is used for memory management
//void is used to define the return type of the method
//String[] args is actually an array of java.lang.String type and it's name is args here

  {
  Bankaccount obj= new Bankaccount(); //creating object for the account class
  @SuppressWarnings("resource")
Scanner scan= new Scanner(System.in);
  //loop until user quits
  do
  {
  System.out.println("Choose Your choice:");
//system is final class
	 //out is a static member of system class and type printStream
	 //println is method of printStream class.ln means nextline

      System.out.println("1.Deposit");
      System.out.println("2.Withdraw");
      System.out.println("3.Press 'q' to quit");
 //The Java switch statement executes one statement from multiple 
//conditions. It is like if-else-if ladder statement.
      switch(scan.next().charAt(0))
      {
      case '1': System.out.println("Enter amount to be deposited");
       double amount=scan.nextDouble(); //accepting amount to be deposited
       obj.deposit(amount);//calling deposit method
       main(args);
       break;
      case '2': System.out.println("Enter amount to withdraw");
       double withDrawAmount=scan.nextDouble();//accepting amount to withdraw
       obj.withdraw(withDrawAmount); //calling withdraw method
       main(args);
       //stores the values
       break;
//quits the program it user press q letter
      case 'q': System.out.println("Thank you for quitting.");
      System.exit(0);
    //The argument serves as a status code; by convention, a nonzero status code indicates abnormal termination. 

//This method calls the exit method in class Runtime. This method never returns normally

      }
  }
  while(scan.next().charAt(0)=='q'||scan.next().charAt(0)=='Q');
  //quits the program it user press q letter
//do...while loop is similar to a while loop, except that a do...while 
//loop is guaranteed to execute at least one time.
  }
}