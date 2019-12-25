/*
 Programmer: Yamin Mousselli
 Teacher: Mr. Johnson
 Date: 03/27/2016
 Purpose: Demonstrate Use and Knowledge of LinkedList and Iterator. You CAN'T use an index number for inserting elements into
 linked list. You must only use the list iterator. Submit one java file only.
*/
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.*;

public class LinkedListDemo {
 public static void main(String[] args) {

    List<String> myLinkedList = new LinkedList<String>();

    String strOutput="";

    //BUILD THE SANDWICH

    myLinkedList.add("Bread1");
    myLinkedList.add("mustard");
    myLinkedList.add("lettuce");
    myLinkedList.add("chicken");
    myLinkedList.add("tomato");
    myLinkedList.add("Bread2");

    ListIterator<String> lit = myLinkedList.listIterator();

    while (lit.hasNext()) {
        strOutput += (lit.next().toString() + ",") ;
    }
   strOutput += ("You have reached the end of the sandwich.\n");


   //SHOW THE CURRENT SANDWICH IN REVERSE USING "PREVIOUS()" METHOD
   while (lit.hasPrevious()) {
         strOutput += (lit.previous().toString() + ",");
    }
    strOutput +=("You have reached the end of the sandwich.\n");


    //ADD PICKLES BETWEEN LETTUCE AND CHICKEN
    while (lit.hasNext()) {
     if (lit.next().toString().equals("lettuce")) {
      lit.add("pickles");
      break;
     }
  }

    while(lit.hasPrevious()) {
     lit.previous();
    }

    while(lit.hasNext()) {
        strOutput += (lit.next().toString() + ",") ;
    }
    strOutput +=("You have reached the end of the sandwich.\n");


   //ADD CHEESE BETWEEN TOMATO AND BREAD2
   while(lit.hasPrevious()) {
       if (lit.previous().toString().equals("Bread2")) {
        lit.add("cheese");
        break;
        }
       }

   while(lit.hasPrevious()) {
    lit.previous();
   }

   while(lit.hasNext()) {
       strOutput += (lit.next().toString() + ",");
   }
   strOutput += ("You have the reached the end of the sandwich.\n");


    //ADD SALT BETWEEN CHEESE AND BREAD2
   while(lit.hasPrevious()) {
       if(lit.previous().toString().equals("Bread2")) {
        lit.add("salt");
        break;
    }
  }

   while(lit.hasPrevious()) {
       lit.previous();
   }

   while(lit.hasNext()) {
       strOutput += (lit.next().toString() + ",");
   }
   strOutput += ("You have the reached the end of the sandwich.\n");


   //GO BACKWARDS AND INSERT BACON BETWEEN CHICKEN AND TOMATO.
   while(lit.hasPrevious()) {
         if(lit.previous().toString().equals("tomato")) {
         lit.add("bacon");
         break;
       }
     }

    while(lit.hasPrevious()) {
        lit.previous();
    }

    while(lit.hasNext()) {
       strOutput += (lit.next().toString() + ",");
   }
   strOutput += ("You have the reached the end of the sandwich.\n");


 //SHOW FINAL SANDWICH IN FORWARD ORDER
    for (String ingredients : myLinkedList) {
        strOutput += (ingredients.toString() + "," );
   }
   strOutput += ("This is the end of the sandwich.\n");
   JOptionPane.showMessageDialog(null, strOutput);
   System.exit(0);
  }
}
