import java.util.*;
import javax.swing.*;
import java.awt.*;

/** 
 * Jonathan Santiago
 * CSCI212 Object-Oriented Programming in Java
 * March 8th, 2020
 * @author: Jonathan Santiago
 **/
//Not finished yet

public class Project1 {
   public static void main(String[] args) {
      TextFileInput in = new TextFileInput("Project1.txt");
      String line = in.readLine();
      int j = 0;
      Clock[] clockObj = new Clock[200], //200 is an arbitrary number.
    		  clockObjSorted = new Clock[200];

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
         clockObj[j] = new Clock(temp[0], temp[1], temp[2]);
         clockObjSorted[j] = clockObj[j]; //duplicating array prior to sorting.
         j++;
         line = in.readLine(); //moving to next line
      }

      sortArray(clockObj, clockObjSorted);

  /**
   * Since JLabel will not accept a parameter of an unknown type (such as Clock), the array will have to be
   * converted to String to prevent compilation error as a result of unrecognition of parameter type by the
   * JLabel API.
   * see (line X to line X) ??
   **/

      String unsort = "", sort = "";
      for(int i = 0; clockObj[i] != null; i++) {
    	  unsort = unsort + clockObj[i] + "\n"; //using strings for JFrame API (not working???)
    	  sort = sort + clockObjSorted[i] + "\n"; //(not working???)
      }
      
      ClockGUI pane = new ClockGUI();
      pane.setTitle("Project 1");
      pane.setLayout(new GridLayout(1, 2));
      JLabel clockText = new JLabel(unsort); //???
      pane.getContentPane().add(clockText, BorderLayout.WEST); //layout of sorted array in left side
      clockText = new JLabel(sort); //???
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
	   Clock temp;
	   //is my algorithm right???
	   for(int k = 0; objSorted[k] != null; k++) {
		   temp = objSorted[k]; //setting an initial temp value assuming that's the lowest value
		   for(int i = k + 1; obj[i] != null; i++) {
			   //hours test
			   if(obj[i].getHours() < temp.getHours()) {
				   temp = obj[i];
				   continue;
			   }
			   else if(obj[i].getHours() > temp.getHours()) continue; 
			   
			   //minutes test
			   if(obj[i].getMinutes() < temp.getMinutes()) {
				   temp = obj[i];
				   continue;
			   }
			   else if(obj[i].getMinutes() > temp.getMinutes()) continue;
			   
			   //seconds test
			   if(obj[i].getSeconds() < temp.getSeconds()) {
				   temp = obj[i];
			   }
		   }
		   objSorted[k] = temp;
	   }
   } //sortArray method
} //class Project1
