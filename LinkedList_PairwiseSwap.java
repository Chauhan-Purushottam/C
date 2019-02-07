import java.util.*;
import java.io.*;
class LinkedList
{
    class Node              //Node class to create new Node of the list
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
           // next = null;
        }
    }
     Node head;
 public Node Swap_pairwise(Node head)       //Swapping method
 {
     if(head==null || head.next == null)    //if list is empty or has one node then return head
        return head;
        
    Node prev = head;                       // Fix the head pointer to the 2nd node 
    Node current = head.next.next;
    head = head.next;
    head.next = prev;
    
    while(current !=null && current.next!=null)      // Fixing the remaining node of the list in swappped manner
    {
        prev.next = current.next;
        prev = current;
        Node next1 = current.next.next;
        current.next.next = current;
        current = next1;
    }
    prev.next = current;
    
    return head;
 }
    
public Node insert(Node head,int d)                  // Inserting the node always at the end of the list
{
    Node ptr = head;
    Node new_node = new Node(d);
    if(head == null)
    {
        head = new_node;
        new_node.next = null;
        //System.out.println("Data inserted !");
    }
    else
    {
        while(ptr.next!=null)
            ptr = ptr.next;
        ptr.next = new_node;
        new_node.next = null;
       // System.out.println("Data inserted * !");
    }
    return head;
}

public void print(Node head)        // Printing the data of the list
{
    Node ptr = head;
    if(head == null)
    {
        System.out.println("List is Empty !");
    }
    else
    {
        while(ptr!=null)
        {
            System.out.print(ptr.data+" --> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
 }
}
public class LinkedList_PairwiseSwap
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    LinkedList llist = new LinkedList();   // creating the object referencing the LinkedList class
	    llist.head = null;                     // Set the head as null
	    boolean require = true;
		System.out.println("Enter the data to insert in the List ");
		do
		{
		   int data = sc.nextInt();
		    System.out.println("Would you like to insert more data press 1 else 0");
		    int ch = sc.nextInt();
		    require = (ch==0) ? false : true;
		    llist.head = llist.insert(llist.head,data);   // calling insert method
		}while(require);
        System.out.println("Before swapping pairwise the list is : ");
		llist.print(llist.head);      // calling print method
		System.out.println("After swapping pairwise the list is : ");
    	llist.head	 = llist.Swap_pairwise(llist.head);   //calling Swap_pairwise method.
    	llist.print(llist.head);   //calling print method
		
	}
}

