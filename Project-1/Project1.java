import java.util.*;
import javax.swing.*;
import java.awt.*;

/** 
 * CSCI212 Object-Oriented Programming in Java
 * Project 1
 * March 8th, 2020
 * @author: Jonathan Santiago
 **/


public class Project1 {
	static Clock[] clockObj = new Clock[200], //200 is an arbitrary number.
			clockObjSorted = new Clock[200];
	
	
   public static void main(String[] args) {
      TextFileInput in = new TextFileInput("Project1.txt");
      String line = in.readLine();
      int j = 0; //loop counter variable to establish values for ClockObj[] based on text file.
      
  /**
   * The while loop will seperate the hours, minutes, and seconds down into tokens. The clockObj array will
   * store the data from the notepad text line by line under the format (HH:MM:SS) by default.
   **/

      while(line != null) {
         StringTokenizer foo = new StringTokenizer(line, ":");
         int[] temp = new int[3]; //breaking tokens down to hours, minutes, seconds. (Can I do this???)
         int i = 0;
         while(foo.hasMoreTokens()) {
            temp[i++] = Integer.parseInt(foo.nextToken());
         }
         if(i != 3) { //if there are not exactly 3 tokens, the string doesn't get added. Instead, the string prints.
        	 System.out.println(line);
        	 line = in.readLine();
        	 continue;
         }
         
         clockObj[j] = new Clock(temp[0], temp[1], temp[2]);
         clockObjSorted[j] = clockObj[j]; //duplicating array prior to sorting.
         j++;
         line = in.readLine(); //moving to next line
      }

      sortArray(clockObj, clockObjSorted); //sorting the second array. 

  /**
   * Since JLabel will not accept a parameter of an unknown type (such as Clock), the array will have to be
   * converted to String to prevent compilation error as a result of unrecognition of parameter type by the
   * JLabel API.
   * see (line 56 to line 60)
   **/

      String unsort = "", sort = "";
      for(int i = 0; clockObj[i] != null; i++) {
    	  unsort = unsort + clockObj[i] + "\n"; //assigning string values from Clock array for JFrame API
    	  sort = sort + clockObjSorted[i] + "\n";
      }
      
      ClockGUI pane = new ClockGUI();
      pane.setTitle("Project 1");
      pane.setLayout(new GridLayout(1, 2));
      JTextArea clockText = new JTextArea(unsort); //JLabel won't recognize a new line
      pane.getContentPane().add(clockText, BorderLayout.WEST); //layout of sorted array in left side
      clockText = new JTextArea(sort);
      clockText.setEditable(false);
      pane.getContentPane().add(clockText, BorderLayout.EAST); //layout of sorted array in right side
      pane.setSize(1000, 1000);
      pane.setLocation(100, 100);
      pane.setDefaultCloseOperation(ClockGUI.EXIT_ON_CLOSE);
      pane.setVisible(true);
   } //main method
   
  /**
   * The sorted array was generated using the Selection Sort algorithm. This algorithm involves the use
   * of a temporary Clock variable which stores the assumed lowest time, until an iteration has passed and
   * the computer detects a time value lower than what was assumed. Because time is structured differently
   * than primitive data types, three different tests were performed for each iteration to ensure accuracy.
   **/

   public static void sortArray(Clock[] obj, Clock[] objSorted) {
	   //Selection Sort Algorithm

	   int check = 0;
	   while(objSorted[check] != null) check++; //setting up maximum index position 
	   	   
	   for(int i = 0; i < check - 1; i++) {
		   
		   for(int count = i + 1; count < check; count++) {
			   
			   //hours test
			   if(objSorted[i].getHours() > objSorted[count].getHours()) {
				   swap(i, count);
				   continue;
			   }else if(objSorted[i].getHours() < objSorted[count].getHours()) continue;
			   //if hours for number we're iterating is less than the checklist, that's 
			   //enough to prove that objSorted[i] is less than objSorted[count]. We move
			   //on to next iteration. If not, we move on to the minutes test
			   
			   //minutes test
			   if(objSorted[i].getMinutes() > objSorted[count].getMinutes()) {
				   swap(i, count);
				   continue;
			   }else if(objSorted[i].getMinutes() < objSorted[count].getMinutes()) continue;
			   			   
			   //seconds test
			   if(objSorted[i].getSeconds() > objSorted[count].getSeconds())
				   swap(i, count);
		   }
	   }
   } //sortArray method
   
   public static void swap(int iteration, int test) {
	   Clock temp = clockObjSorted[iteration];
	   clockObjSorted[iteration] = clockObjSorted[test];
	   clockObjSorted[test] = temp;
   }
   
} //class Project1
