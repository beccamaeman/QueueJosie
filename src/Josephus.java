/**********************************************************************
* Programmer:   Becca Man
* Class:	CS40S
*
* Assignment:	
*
* Description:	a brief description of the program goes here
*
*
* Input:	describe any input from keyboard or file
*
* Output:	describe the result of your program
***********************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 

public class Josephus{//begin class
    
    public static void main(String args[])throws IOException {//begin main
        
	//*****declaration of constants*****
	
	//*****declaration of variables*****
        
            String strin;       //variable for readng in
            String delim = "[ ]+";          //delimiter for parsing input strings
            
            int n = 0;          //nth person to be killed
            int m = 0;          //number of people
            
            int count = 0;      //counter for while loop
            
            ArrayList order = new ArrayList();

	//*****create objects*****
            
            PrintBanner();
            
            Queue queue = new Queue();  //create queue
        
        //*****create input stream*****
        
            BufferedReader fin = new BufferedReader(new FileReader("input.txt"));
	
        //*****get input*****
        
            strin = fin.readLine();         //read first line from input buffer
            //System.out.println(strin);      //echo the input
            
            String[]tokens = strin.split(delim);      //split the input record up into string tokens
            
            n = Integer.parseInt(tokens[0]);
            m = Integer.parseInt(tokens[1]);
            
            System.out.println("Number of people " + m + "\nnth person to kill " + n);
	
	//*****processing*****
            
            for(int i = 1; i <= m; i++){
                queue.enqueue(i);       //put all people into the queue
                System.out.print(queue.check() + " ");
            }//end for int i
            
            System.out.println("\n");
            
            
            while(!queue.isEmpty()){
                count++;
                System.out.println("count " + count);
                
                if(count % n == 0){
                    Object add = queue.check();
                    System.out.println("add this " + add);
                    System.out.println("dq this " + queue.dequeue());
                    order.add(add);
                }//end if
                else{
                    queue.enqueue(queue.dequeue());
                }//end else
                    
            }//end while
            
            //System.out.println("");
            
            for(int i = 0; i < m; i++){
                System.out.println(order.get(i));
            }//end print for
            
        //*****output*****
	
            fin.close();                    //close input buffer stream
            ClosingMessage();

	}//end main
    
    /****************************************
    * print banner to output window
    * IN: none
    * OUT: none
    ****************************************/
    public static void PrintBanner(){
        String bannerOut = "";       //string to print banner to message dialog
        bannerOut += "******************************* \n";
        bannerOut += "Name: R. Man \n";
        bannerOut += "Class: CS40S \n";
        bannerOut += "Assignment: A3 Q3 \n";
        bannerOut += "******************************* \n";
        System.out.println(bannerOut);
    }//end PrintBanner method
    
    /****************************************
    * print closing message to output window
    * IN: none
    * OUT: none
    ****************************************/
    public static void ClosingMessage(){
        String closMes = "end of processing";
        System.out.println("\n\n");
        System.out.println(closMes);
    }//end ClosingMessage method
    
}//end class