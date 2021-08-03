package DataStructure;

import java.util.*;


class tree
{
	Node root=null;
	static class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	    if (value < current.data) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.data) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        return current;
	    }

	    return current;
	}
	public void add(int value) {
	    root = addRecursive(root, value);
	}
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.data) {
	        return true;
	    } 
	    return value < current.data
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	private Node deleteRecursive(Node current, int value) {
	    if (current == null) {
	        return null;
	    }

	    if (value == current.data) {
	        // Node to delete found
	        // ... code to delete the node will go here
	    	if (current.left == null && current.right == null) {
	    	    return null;
	    	}
	    	else if (current.right == null) {
	    	    return current.left;
	    	}

	    	else if (current.left == null) {
	    	    return current.right;
	    	}
	    	else if(current.left!=null && current.right!=null)
	    	{
	    		int smallestValue = findSmallestValue(current.right);
		    	current.data = smallestValue;
		    	current.right = deleteRecursive(current.right, smallestValue);
		    	return current;
	    	}
	    	
	    } 
	    if (value < current.data) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	}
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.data : findSmallestValue(root.left);
	}
	
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.data);
	        traverseInOrder(node.right);
	    }
	}
	public void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.data);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.data);
	    }
	}
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }

	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);

	    while (!nodes.isEmpty()) {

	        Node node = nodes.remove();

	        System.out.print(" " + node.data);

	        if (node.left != null) {
	            nodes.add(node.left);
	        }

	        if (node.right != null) {
	            nodes.add(node.right);
	        }
	    }
	}

}

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree li=new tree();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(7);

	}

}
