package com.learn.java.intro;

import java.util.ArrayList;


/**
 * <p>Binary Tree is a Entity which will at most have 2 children</p>
 */
public class BinaryTree{
	
	private TreeNode root;// Root is the starting point of the binary tree
	
	public BinaryTree() {
		this.root = null;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(1);
		tree.insert(7);
		tree.insert(8);
		tree.insert(6);
		
		tree.preorderTraversal(tree.root);
		System.out.println();
		tree.inorderTraversal(tree.root);
		System.out.println();
		tree.postorderTraversal(tree.root);
		System.out.println();
		tree.iterativePreorderTraversal(tree.root);
		System.out.println();
		tree.iterativeInorderTraversal(tree.root);
		System.out.println();
		tree.iterativePostorderTraversal(tree.root);
		System.out.println();
	}
	
	
	/**
	 * <p>Tree Nodes contains data, left child pointer and right child pointer</p>
	 */
	class TreeNode{
		
		int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	/**
	 * <p>Creates a tree node with a given data and assigns it to the root tree node if the root tree node is null. Else it will recursively call {@code}recursiveInsert method and assigns the newly created tree to the root tree.</p>
	 * @param data data to be created as tree node and to be inserted in the binary tree.
	 */
	public void insert(int data) {
		if(root==null) {
			root = new TreeNode(data);
		}
		else{
			root = recursiveInsert(data, root);
		}
	}
	
	/**
	 * <p>This recursive function calls itself with same data and different tree node, left tree node if the given data is less than tree node data or right tree node if the given data is greater than tree node data. If the tree node is null it assigns the tree node with the new tree node with the given value and back tracking happens.</p>
	 * @param data data to be created as tree node and inserted in the binary tree.
	 * @param treeNode tree node in which the data should be inserted as a child tree node.
	 * @return returns the tree node which got appended by the new tree node with the given value. 
	 */
	public TreeNode recursiveInsert(int data, TreeNode treeNode) {	
		if(treeNode==null) {
			treeNode = new TreeNode(data);
		}
		else if(data<treeNode.data) {
			treeNode.left = recursiveInsert(data, treeNode.left);
		}
		else {
			treeNode.right = recursiveInsert(data, treeNode.right);
		}
		return treeNode;
	}
	
	/**
	 * <p>This traverses the binary tree like, root>left>right (recursive)</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void preorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			System.out.print(treeNode.data+" ");
			preorderTraversal(treeNode.left);
			preorderTraversal(treeNode.right);
		}
	}
	
	/**
	 * <p>This traverses the binary tree like, left>root>right (recursive)</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void inorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			inorderTraversal(treeNode.left);
			System.out.print(treeNode.data+" ");
			inorderTraversal(treeNode.right);
		}
	}
	
	/**
	 * <p>This traverses the binary tree like, left>right>root (recursive)</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void postorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			postorderTraversal(treeNode.left);
			postorderTraversal(treeNode.right);
			System.out.print(treeNode.data+" ");
		}
	}
	
	/**
	 * <p>This traverses the binary tree like, root>left>right (iterative). Uses stack to traverse.</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void iterativePreorderTraversal(TreeNode treeNode) {
		ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
		stack.add(treeNode);
		while(!stack.isEmpty()) {
			treeNode = pop(stack);
			System.out.print(treeNode.data+" ");
			if(treeNode.right!=null) {
				stack.add(treeNode.right);
			}
			if(treeNode.left!=null) {
				stack.add(treeNode.left);
			}
			
		}
	}
	
	/**
	 * <p>This traverses the binary tree like, left>right>root (iterative). Uses two stack to traverse.</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void iterativePostorderTraversal(TreeNode treeNode) {
		ArrayList<TreeNode> stack1 = new ArrayList<TreeNode>();
		ArrayList<TreeNode> stack2 = new ArrayList<TreeNode>();
		stack1.add(treeNode);
		while(!stack1.isEmpty()) {
			
			treeNode = pop(stack1);
			stack2.add(treeNode);
			
			if(treeNode.left!=null) {
				stack1.add(treeNode.left);
			}
			if(treeNode.right!=null) {
				stack1.add(treeNode.right);
			}
			
		}
		while(!stack2.isEmpty()) {
			System.out.print(pop(stack2).data+" ");
		}
	}

	/**
	 * <p>This traverses the binary tree like, left>root>right (iterative). Uses stack to traverse.</p>
	 * @param treeNode tree node to be traversed.
	 */
	public void iterativeInorderTraversal(TreeNode treeNode) {
		
		ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
		while (!stack.isEmpty() || treeNode!=null) {
			while (treeNode!=null) {	
				stack.add(treeNode);
				treeNode = treeNode.left;
			}
			treeNode = pop(stack);
			System.out.print(treeNode.data+" ");
			treeNode = treeNode.right;
		}
	}
	
	/**
	 * <p>Removes and returns the last element from the given stack</p>
	 * @param stack stack in which the last element should be removed and returned.
	 * @return the last element of the stack.
	 */
	public TreeNode pop(ArrayList<TreeNode> stack) {
		return stack.remove(stack.size()-1);
	}
}
