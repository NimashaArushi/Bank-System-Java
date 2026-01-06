
package bank;

import static bank.Bank.withdraw;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank {
 
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        int attempt=0;
        int maxattempt=3;
        boolean loginin=false;
        
        while(attempt<maxattempt){
        System.out.println("Enter the password (Attempt " + (attempt + 1) + "): ");
            int password = input.nextInt();
            
             if(password==123){
            System.out.print("Login Successfull.");
             loginin=true;
             break;
        }
        else{
           attempt++;
           if(attempt<maxattempt){System.out.println("Login Unsuccessful. Please Retry.");}
           else{
            System.out.println("Login Unsuccessful. No more attempts remaining.");}
        }
       }
        
        System.out.println("Thanks your login ");
        System.out.println("choose the choices . ");
        if(loginin){
        double balance = 0;
        int choice=0;
        while(choice!=4){
         System.out.println("................................");
        
         System.out.println("01-Deposit");
         System.out.println("02-Withdraw");
         System.out.println("03-Balance");
         System.out.println("04-exit");
         
            System.out.println("Enter your choice.");
            
            if(input.hasNext()){
            choice=input.nextInt();
            input.nextLine();
            }
            
            
            else{
                System.out.println("Invalid choice plz enter 1,2,3 or 4 only");
                input.nextLine();
                continue;
            
            }
         switch(choice){
         case 01:
         System.out.println("Enter the amount of deposit :");
          double dep = input.nextDouble();
          balance = depo(balance, dep); 
          break;
      
         
          case 02:
              System.out.println("Enter widraw amount");
              double Withamount=input.nextDouble();
             balance=withdraw(balance,Withamount);
             break;
             
             
           case 03:
            showBalance(balance);
               break;
          case 04:
               System.out.println("Exiting...");;
              break;
               
             
          default:System.out.println("invalid choice");
         }

        }
        input.close();

    }}
    
   
   public static double depo(double currentbalance,double amount) throws IOException {
       double newBalance = currentbalance + amount;
        try{
            
             FileWriter writer=new FileWriter("C:\\131\\bank.txt",true);
             
             writer.write("Dep money :"+amount+ " | Total Balance: " + newBalance + "\n");
             writer.close();
             System.out.println("item saved successfully to file!!");
            
        }
             catch(IOException e){
             System.out.println("An error occurred while saving the item");
             e.printStackTrace();
 }
        return newBalance;
   }
   
 
   public static double withdraw(double currentbalance, double amount) {
        if (amount <= currentbalance) {
            double newBalance = currentbalance - amount;
            try (FileWriter writer = new FileWriter("C:\\131\\bank.txt", true)) {
                writer.write("Withdraw: " + amount + " | Balance: " + newBalance + "\n");
                System.out.println("Withdrawal Successful.");
            } catch (IOException e) {
                System.out.println("File Error!");
            }
            return newBalance;
        } else {
            System.out.println("Insufficient Balance!");
            return currentbalance;
        }
    }

    public static void showBalance(double currentbalance)throws IOException {
        System.out.println("Current Blance : "+currentbalance);
   
   
   }}
    
    
    
    
    
    
    
    
    
    
    
   
   
   



