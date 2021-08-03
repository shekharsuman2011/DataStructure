package DataStructure;

class SinglyLinkedList
{
	Node head=null;
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	
	//functions
	public void AddNode(int data)
	{
		Node node=new Node(data)
				;
		if(head==null)
		{
			head=node;
		}
		else
		{
			
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=node;
		}
	}
	public void Display()
	{
		Node temp=head;
		System.out.println("Data present in the list are : ");
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public int FindElement(int data)
	{
		int index=1;
		Node temp=head;
		while(temp!=null)
		{
			if(temp.data==data)
			{
				return index;
			}
			temp=temp.next;
			index++;
		}
		return 0;
	}
	public void AddInBetween(int data,int pos)
	{
		Node temp=head;
		
		while(pos!=1 && temp.next!=null)
		{
			temp=temp.next;
			pos--;
		}
		Node temp2=temp.next;
		temp.next=new Node(data);
		temp.next.next=temp2;
	}
	public void delete(int data)
	{
		Node temp=head;
		int Index=FindElement(data);
		if(Index==0)
		{
			return;
		}
		for(int i=1;i<Index-1;i++)
		{
			temp=temp.next;
		}
		temp.next=temp.next.next;
	}
	
}
//SinglyLinkedListNode head=null;
public class Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList li=new SinglyLinkedList();
		li.AddNode(1);
		li.AddNode(2);
		li.AddNode(3);
		li.AddNode(4);
		li.AddNode(5);
		li.AddNode(6);
		li.AddNode(7);
		li.Display();
		System.out.println("Index of element 2 : "+li.FindElement(2));
		System.out.println("Index of element 99 : "+li.FindElement(99));
		li.AddInBetween(22, 3);
		li.Display();
		li.delete(22);
		li.Display();
		
	}

}
