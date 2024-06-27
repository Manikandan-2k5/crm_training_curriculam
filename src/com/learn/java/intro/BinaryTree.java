package com.learn.java.intro;

import java.util.ArrayList;

public class BinaryTree{
	
	private TreeNode root;
	
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
		tree.insert(9);
		tree.insert(10);
		
//		tree.preorderTraversal(tree.root);
//		System.out.println();
		tree.inorderTraversal(tree.root);
//		System.out.println();
//		tree.postorderTraversal(tree.root);
//		System.out.println();
//		tree.iterativePreorderTraversal(tree.root);
//		System.out.println();
//		tree.iterativePostorderTraversal(tree.root);
		System.out.println();
		tree.iterativeInorderTraversal(tree.root);
	}
	
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
	
	public void insert(int data) {
		if(root==null) {
			root = new TreeNode(data);
		}
		else{
			root = recursiveInsert(data, root);
		}
	}
	
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
	
	public void preorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			System.out.print(treeNode.data+" ");
			preorderTraversal(treeNode.left);
			preorderTraversal(treeNode.right);
		}
	}
	
	public void inorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			inorderTraversal(treeNode.left);
			System.out.print(treeNode.data+" ");
			inorderTraversal(treeNode.right);
		}
	}
	
	public void postorderTraversal(TreeNode treeNode) {
		if(treeNode!=null) {
			postorderTraversal(treeNode.left);
			postorderTraversal(treeNode.right);
			System.out.print(treeNode.data+" ");
		}
	}
	
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
	
	public TreeNode pop(ArrayList<TreeNode> stack) {
		return stack.remove(stack.size()-1);
	}
}
