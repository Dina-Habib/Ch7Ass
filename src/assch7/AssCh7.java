/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinahabib
 */
public class AssCh7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Threadl file1=new Threadl(200,"/Users/dinahabib/NetBeansProjects/AssCh7/src/assch7/file1.txt");
        file1.setName("File1 = ");
        file1.setPriority(Thread.MIN_PRIORITY);
        
        Threadl file2=new Threadl(200,"/Users/dinahabib/NetBeansProjects/AssCh7/src/assch7/file2.txt");
        file2.setName("File2 = ");
        file2.setPriority(Threadl.MAX_PRIORITY);
        
        file1.start();
        file2.start();
    }
}
   
    class Threadl extends Thread {
        private int sleep;
        private Scanner scanner;
        
        @Override
        public void run(){
            try {
        while(scanner.hasNextLine()){
            System.out.println(this.getName() + "  " + scanner.nextLine());
                Thread.sleep(sleep);
        }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    
        
        public Threadl(int sleep,String file){
            super();
            try{
               this.scanner = new Scanner(new File(file)); 
            }catch(FileNotFoundException ex){
                ex.printStackTrace();
            }
            this.sleep=sleep;
        }
    }
    

