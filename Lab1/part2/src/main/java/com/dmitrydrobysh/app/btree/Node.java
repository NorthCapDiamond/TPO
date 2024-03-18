package com.dmitrydrobysh.app.btree;

import java.io.IOException;

public class Node{
	private int value;			//Поле не может быть null,
	private Node parent; 		//Поле может быть null,
	private Node leftChild; 	//Поле может быть null,
	private Node rightChild; 	//Поле может быть null


	public Node(int value, Node parent, Node leftChild, Node rightChild){
		this.value = value;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}


	public void setNode(int value, Node parent, Node leftChild, Node rightChild){
		this.value = value;
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Node getNode(){
		return this;
	}


	public void setParent(Node parent){
		this.parent = parent;
	}

	public Node getParent(){
		return this.parent;
	}

	public void setLeftChild(Node leftChild){
		this.leftChild = leftChild;
	}

	public Node getLeftChild(){
		return this.leftChild;
	}

	public void setRightChild(Node rightChild){
		this.rightChild = rightChild;
	}

	public Node getRightChild(){
		return this.rightChild;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return this.value;
	}

	@Override
	public String toString(){
		return Integer.toString(this.value);
	}
}