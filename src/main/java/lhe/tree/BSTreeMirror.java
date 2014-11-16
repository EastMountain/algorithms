package lhe.tree;

import java.util.Stack;

/**
 * 
 * 输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。
 * 用递归和循环两种方法完成树的镜像转换。
 */
public class BSTreeMirror {

	public void swapLeftAndRight(Node root){
		Node temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
	}
	
	/**
	 * 
	  * 递归镜像转换
	  * @param root    
	  * @return void
	 */
	public void mirror(Node root){
		if(root == null) 
			return;
		swapLeftAndRight(root);
		mirror(root.getLeft());
		mirror(root.getRight());
	}
	
	/**
	 * 
	  * 循环镜像转换
	  * @param root    
	  * @return void
	 */
	public void mirrorByLoop(Node root){
		if(root == null)
			return;
		Stack<Node> buf = new Stack<Node>();
		buf.push(root);
		while(!buf.isEmpty()){
			Node temp = buf.pop();
			if(temp != null){
				swapLeftAndRight(temp);
				buf.push(temp.getLeft());
				buf.push(temp.getRight());	
			}			
		}
	}
	
	public String toLDRString(Node root){
		if(root == null) 
			return "";	
//		String ldr = null;
//		if(root.getLeft() != null) 
//			ldr += toLDRString(root.getLeft());
//		ldr += " "+root.getValue();
//		if(root.getRight() != null)
//			ldr += toLDRString(root.getRight());
//		return ldr;
		return toLDRString(root.getLeft()) + " " + root.getValue() + " " + toLDRString(root.getRight());
	}

}
