package br.univille.estd.binarytree;

public class BTPosition<E> {
	
	private E element;
	private BTPosition<E> parent;
	private BTPosition<E> left;
	private BTPosition<E> right;
	
	
	public BTPosition() {}

	public BTPosition(E element) {
		this(element,null,null,null);
	}

	public BTPosition(E element, BTPosition<E> parent) {
		this(element,parent,null,null);
	}

	public BTPosition(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public BTPosition<E> getParent() {
		return parent;
	}

	public void setParent(BTPosition<E> parent) {
		this.parent = parent;
	}
	
	public BTPosition<E> getLeft() {
		return left;
	}

	public void setLeft(BTPosition<E> left) {
		this.left = left;
	}

	public BTPosition<E> getRight() {
		return right;

	public void setRight(BTPosition<E> right) {
		this.right = right;
	}
	

}
