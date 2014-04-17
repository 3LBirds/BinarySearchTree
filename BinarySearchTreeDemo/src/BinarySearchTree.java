import java.util.Random;
import java.util.Stack;

import javax.swing.tree.TreeNode;

class BST{
	
	private Node root;
	
	//Constructor
	public BST(){
		root = null;
	}
	
	//Get the root of this binary tree
	public Node getRoot()
	{
		return root;
	}
	
	public void add(double key)
	{
		Node n = root,p = null;
		//Determine where to create the new node based on it's data value. When the current node is determined to be null,
		//then we have reached the leaf of the node
		while(null != n && n.data != key){
			p = n;
			if(key < n.data){//Look to left of current node because key is less than value of this node
				n = n.left;
			}
			else{//Look to right of current node because key is greater than value of this node
				n = n.right;
			}
		}
		
		
		//Create new node
		if(null == n)
		{
			if(null ==p)
			{
				root = new Node(key);
				
			}
			else if (key < p.data)
			{ //Create new left node
				p.left = new Node(key);
			}
			else
			{//Create new right node
				p.right = new Node(key);
			}
			
		}
		
		
	}
	
	public void setBST()
	{
		//Create BST using random value generator
		Random randomGenerator = new Random();
		Node root = getRoot();
		for(int i =0; i<10; i++)
		{	
			
			add(randomGenerator.nextInt(100));
			
		}
	}
	
	public void inorder()
	{  //Perform in-order traversal to of BST
		Node n = root;
		Stack<Node> stack = new Stack<Node>();
		
		while( null != n  || !stack.isEmpty())
		{
			if ( null != n)
			{
				stack.push(n);
				n = n.left;
				
			}
			else
			{
				n = stack.pop();
				visit(n);
				n = n.right;
			}
		}
	}
	
	private void visit(Node n) {
		//Print the current nodes data value, and the values of it's left and right node
		  System.out.print("H: " + n.data );
		  if(null != n.left)
			  System.out.print("L: " + n.left.data);
		  if(null != n.right)
			  System.out.print(" R: " + n.right.data);
	System.out.println();
	}
	
}
	
class Node{
	 double data;
	 Node left, right;
	 
	 public Node(double key)
	 {
		 data = key; 
		 left = right = null;
	 }
	
}
	



 
public class BinarySearchTree {

	public static void main(String[] args)
	{
		BST bst = new BST();
		//Create a binary search tree with 10 edges
		bst.setBST();
		//print node values
		bst.inorder();
	}

	
}