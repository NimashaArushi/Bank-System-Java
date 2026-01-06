/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author NIMASHA ARUSHI
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file=new File("C:\\131\\bank.txt");
    try{
        if(  file.createNewFile()){
            System.out.println("File created successfull.");
        }
        else{
            System.out.println("File already exixts");
        }
    
    
    }catch(IOException e){
        System.out.println("\"An error occurred\"");
    }
    
    
    
    }
    
}
