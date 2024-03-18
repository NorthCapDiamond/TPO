package com.dmitrydrobysh.app.btree;

public class BTree{
	private int size = 0;
	private Node rootNode;

	public BTree(int value){
		this.rootNode = new Node(value, null, null, null);
		this.size++;
	}

	public Node getRoot(){
		return this.rootNode;
	}

	public int getSize(){
		return this.size;
	}

	public void append(int value){
		this.size++;
		Node tmp = this.rootNode;
		Node newNode = new Node(value, null, null, null);

		if(this.rootNode == null){
			this.rootNode = newNode;
			return;
		}

		while((value >= tmp.getValue() && (tmp.getRightChild() != null)) || (value < tmp.getValue() && (tmp.getLeftChild() != null))){
			tmp = value >= tmp.getValue() ? tmp.getRightChild() : tmp.getLeftChild();
		}

		if(value >= tmp.getValue()){
			newNode.setParent(tmp);
			tmp.setRightChild(newNode);

		}else{
			newNode.setParent(tmp);
			tmp.setLeftChild(newNode);
		}
		return;
	}

	private Node findNode(int value){
		Node tmp = this.rootNode;
		while((value > tmp.getValue() && (tmp.getRightChild() != null)) || (value < tmp.getValue() && (tmp.getLeftChild() != null)) || (value == tmp.getValue())){
			if(tmp.getValue() == value){
				return tmp;
			}
			tmp = value >= tmp.getValue() ? tmp.getRightChild() : tmp.getLeftChild();
		}

		return null;
	}

	private Node findMaxNode(Node node){
		Node tmp = node;
		while (tmp.getRightChild() != null){
			tmp = tmp.getRightChild();
		}

		return tmp;
	}

	private void deleteLeaf(Node node){
		this.size--;
		Node parent = node.getParent();
		if(parent != null && parent.getLeftChild() == node){
			parent.setLeftChild(null);
		}
		else {
			if(parent != null){
				parent.setRightChild(null);
			}
		}

		if(parent == null){
			this.rootNode = null;
		}

		node = null;
	}

	private void deleteOneChildNode(Node node){
		this.size--;
		Node parent = node.getParent();
		Node child = node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild();

		child.setParent(parent);

		if(parent != null && parent.getLeftChild() == node){
			parent.setLeftChild(child);
		}
		else {
			if(parent != null){
				parent.setRightChild(child);
			}
		}

		if(parent == null){
			if(node.getLeftChild()!=null){
				node.getLeftChild().setParent(null);
				this.rootNode = node.getLeftChild();
			}
			else {
				node.getRightChild().setParent(null);
				this.rootNode = node.getRightChild();
			}
		}

		node = null;
	}

	private void deleteTwoChildrenNode(Node node){
		Node parent = node.getParent();
		Node deleteNode1 = findMaxNode(node.getLeftChild());
		node.setValue(deleteNode1.getValue());
		
		if(deleteNode1.getLeftChild()!=null){
			deleteOneChildNode(deleteNode1);
		}
		else {
			deleteLeaf(deleteNode1);
		}
	}

	public void delete(int value){

		if(this.size == 0){
			System.out.println("Out of elements... sorry");
			return;
		}

		Node deletedNode = findNode(value);
		if(deletedNode == null){
			System.out.println("No such element... Sorry");
			return;
		}

		if((deletedNode.getLeftChild() != null) && (deletedNode.getRightChild() !=null)){
			deleteTwoChildrenNode(deletedNode);
			return;
		}
		else if((deletedNode.getLeftChild() != null) || (deletedNode.getRightChild() !=null)){
			deleteOneChildNode(deletedNode);
			return;
		} else {
			deleteLeaf(deletedNode);
			return;
		}
	}

	private String stringBTreeWalker(Node root, String answer){
		Node tmp = root;
		answer+= (tmp.getLeftChild()!=null) ? stringBTreeWalker(tmp.getLeftChild(), "")  + tmp.toString() + " " : tmp.toString() + " ";
		answer+= (tmp.getRightChild()!=null) ? stringBTreeWalker(tmp.getRightChild(), "") : "";

		return answer;
	}


	@Override
	public String
	toString(){
		if (size == 0){
			return "Tree is empty...";
		}
		return stringBTreeWalker(this.rootNode, "");
	}
}