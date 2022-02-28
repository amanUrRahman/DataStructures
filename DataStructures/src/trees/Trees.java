 package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Trees {

	public static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String args[]) {
		// create tree
		TreeNode root = new TreeNode(12);
		// Left Sub-tree
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(5);
		root.left.right = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		// Right Sub-tree
		root.right = new TreeNode(-33);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(23);
		root.right.right.right = new TreeNode(30);
		root.right.right.right.left = new TreeNode(50);

		maxPathSumWithWithoutRoot(root,root.data);
		System.out.println(maxValue);

	}

	public static void postorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				if(current.right!=null)
					numbers.push(current.right);
				numbers.push(current);
				current = current.left;
				continue;
			} else {

			}
		}

	}

	public static void preorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				System.out.print(current.data + " ");
				numbers.push(current);
				current = current.left;
				continue;
			} else {
				if (current == null && !numbers.empty()) {
					current = numbers.pop();
					current = current.right;
					continue;
				} else
					break;
			}
		}
	}

	public static void mirrorTree(TreeNode root) {
		if (root == null)
			return;
		mirrorTree(root.left);
		mirrorTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static int diameterOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		int leftDiameter = diameterOfTree(root.left);
		int rightDiameter = diameterOfTree(root.right);
		return max(leftHeight + rightHeight + 1, max(leftDiameter, rightDiameter));
	}

	public static int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		return max(leftHeight, rightHeight) + 1;
	}

	public static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> traversal = new LinkedList<TreeNode>();
		TreeNode current = root;
		traversal.add(current);
		while (current != null) {
			if (current.left != null)
				traversal.add(current.left);
			if (current.right != null)
				traversal.add(current.right);
			System.out.print(traversal.peek().data + " ");
			traversal.poll();
			current = traversal.peek();
		}
	}

	public static void inorderWithoutRecursion(TreeNode root) {
		Stack<TreeNode> numbers = new Stack<TreeNode>();
		TreeNode current = root;
		while (true) {
			if (current != null) {
				numbers.push(current);
				current = current.left;
				continue;
			} else {
				if (current == null && !numbers.empty()) {
					current = numbers.pop();
					System.out.print(current.data + " ");
					current = current.right;
					continue;
				} else
					break;
			}
		}
	}

	public static void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static int max(int first, int second) {
		return first > second ? first : second;
	}
	
	public static int min(int first, int second) {
		return first > second ? second : first;
	}
	
	public static void printRootToLeaf(TreeNode root, int value) {
		if (root==null)
			return;
		
		String s = String.valueOf(root.data);
		for (char ch : s.toCharArray()) {
			value = value*10 + Integer.parseInt(String.valueOf(ch));
		}
	
		
		
		if (root.left==null && root.right==null)
			System.out.println(value);
		
		printRootToLeaf(root.left, value);
		printRootToLeaf(root.right, value);
	}
	
	public static int longestChain(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftheight = heightOfTree(root.left);
		int righthright = heightOfTree(root.right);
		
		return max(leftheight+righthright+1, max(longestChain(root.left), longestChain(root.right)));
	}
	
	public static int maxPathSum(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int leftSum = maxPathSum(root.left) + root.data;
		int rightSum = maxPathSum(root.right) + root.data;
		
		return max(leftSum,rightSum);
	}

	public static int minDepth(TreeNode root, int level) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null)
			return level;
		
		if (root.left == null)
			return minDepth(root.right, level+1);
		
		if (root.right == null)
			return minDepth(root.left, level+1);
		
		int leftdepth = minDepth(root.left, level+1);
		int rightdepth = minDepth(root.right, level+1);
		
		return min(leftdepth,rightdepth);
	}
		
	public static boolean heightBalanced(TreeNode root) {
		
		if (root == null) {
			return true;
		}
		
		int leftheight = heightOfTree(root.left);
		int rightheight = heightOfTree(root.right);
		
		if (Math.abs(leftheight-rightheight)<=1 && heightBalanced(root.left) && heightBalanced(root.right))
			return true;
		
		return false;
	}
	
	public static int countLeafNodes(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null)
			return 1;
		
		int leftcount = countLeafNodes(root.left);
		int rightcount = countLeafNodes(root.right);
		
		return leftcount+rightcount;
	}
	
	public static void rightView(TreeNode root) {
		
		if (root == null) {
			return;
		}
		
		System.out.println(root.data);
		
		if (root.right != null)
			rightView(root.right);
		else {
			rightView(root.left);
		}
	}
	
	public static int sumAllRootToLeaf(TreeNode root, int number) {
		
		if (root == null) {
			return 0;
		}
		
		int leftSum = sumAllRootToLeaf(root.left, number*10+root.data);
		int rightSum = sumAllRootToLeaf(root.right, number*10+root.data);
		
		return leftSum+rightSum;
	}
	
	public static void printNodesLeftToRight(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null)
			System.out.println(root.data);
	
		printNodesLeftToRight(root.left);
		printNodesLeftToRight(root.right);
	}
	
	public static int maxValue;
	
	public static int maxPathSumWithWithoutRoot(TreeNode root, int value) {
		
		if (root == null) {
			return 0;
		}
		
		int leftSum = 0;
		int rightSum = 0;
		
		if (root.left != null)
			leftSum = value + root.left.data;
		
		if (root.right != null)
			rightSum = value + root.right.data;
		
		maxValue = Math.max(maxValue,Math.max(leftSum, rightSum));
		
		return Math.max(Math.max(maxPathSumWithWithoutRoot(root.left, leftSum), maxPathSumWithWithoutRoot(root.right, rightSum)), 
				Math.max(maxPathSumWithWithoutRoot(root.left, 0), maxPathSumWithWithoutRoot(root.right, 0)));
	}
	
	
	
	
	
	
}
