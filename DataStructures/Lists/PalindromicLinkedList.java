///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Name         : Palindromic Linked List                                                                        //
//Input        : reference to the head of the Linked List                                                       //
//Output       : return whether the Linked List is palindromic or not                                           //
//Description  : This program demonstrates whether the Linked List is palindromic or not                        //
//Authors      : Amit Thakur                                                                                    //                                                                                                                       //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/*
This is the example which demonstrates the logic of testing whether a Linked List is a palindromic or no.
For Testing this we have made use of the Two Examples
I>  1->2->3->3->2->1->null
II> 1->2->3->4->2->1->null
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class ListNode 
{
     int val;
     ListNode next;
     ListNode(int x) 
     { 
       val = x; 
     }
}

/*
This method is defined in the solution class which tests whether the Linked List is a palindrome or not.
So, we pass a referenec of the head node of the linked list to be checked and the method gives the required output.

Logic:-
We make use of the two pointers like the slow and fast.
The fast will move two node ahead and the slow node will move only one node ahead
So, at the end of the first loop whenerver the fast pointer reaches the end then
the slow pointer will reach to the middle of the Linked List and simultaneously 
we replace the next pointers with the prev pointer whcih is initailly initialised
to null.So, now the list will be check with the new pointers i.e prev and slow
so, we simultaneously check whether the values of the Linked List are same or not.
If they are not same then we return false else we return true.

*/
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
      ListNode slow = head;
      ListNode fast = head;
      ListNode prev = null;

      while (fast != null && fast.next != null) {

          fast = fast.next.next;

          ListNode temp = slow;
          slow = slow.next;

          temp.next = prev;
           prev = temp;
       }

         if (fast != null) {
           slow = slow.next;
         }

         while (prev != null && slow != null) {
             if (prev.val != slow.val) {
                  return false;
             }

             prev = prev.next;
             slow = slow.next;
         }

        return prev == null && slow == null;
        
    }
}

public class Main {
    public static void main(String[] args) 
    {
      int i=0,j=0,val=0,size=0;
      ListNode head=null,head2=null;
      System.out.println("Palindrome of a Linked List!!!!!\n");
      
      //Creating the object of the solution class
      Solution sobj=new Solution();
      
      System.out.println("Enter the size Linked List:-\n");
      
      Scanner sc=new Scanner(System.in);
      
      size=sc.nextInt();
      
      System.out.println("Enter the elements of the Linked List:-");

      for(i=1;i<=size;i++)
      {
        val=sc.nextInt();
        
        if(head==null)
        {
          head=new ListNode(val);
          head2=head;
        }
        else
        {
          head.next=new ListNode(val);
        }
        head.next=null;
      }
      
      //creating a Linked List using the constructor mentioned above
      
      
      //Creating a head pointer to the Linked List I
      ListNode head=new ListNode(1);
      
      //creating the remaining List
      ListNode node1=new ListNode(2);
      ListNode node2=new ListNode(3);
      ListNode node3=new ListNode(3);
      ListNode node4=new ListNode(2);
      ListNode node5=new ListNode(1);
      
      head.next=node1;
      node1.next=node2;
      node2.next=node3;
      node3.next=node4;
      node4.next=node5;
      node5.next=null;
      
      //Passing the created Linked List to the method:- is Palindrome
      boolean ret=sobj.isPalindrome(head);
      
      if(ret==true)
      {
        System.out.println("The given Linked List is a Palindromic Liked List\n");
      }
      else
      {
        System.out.println("The given Linked List is a not Palindromic Liked List\n");
      }
      
      
      //Creating a head pointer to the Linked List II
      head=new ListNode(1);
      
      //creating the remaining List
      node1=new ListNode(2);
      node2=new ListNode(3);
      node3=new ListNode(5);
      node4=new ListNode(2);
      node5=new ListNode(1);
      
      head.next=node1;
      node1.next=node2;
      node2.next=node3;
      node3.next=node4;
      node4.next=node5;
      node5.next=null;
      
      //Passing the created Linked List to the method:- is Palindrome
      boolean ret=sobj.isPalindrome(head2);
      
      if(ret==true)
      {
        System.out.println("The given Linked List is a Palindromic Liked List\n");
      }
      else
      {
        System.out.println("The given Linked List is a not Palindromic Liked List\n");
      }
      
    }
}
