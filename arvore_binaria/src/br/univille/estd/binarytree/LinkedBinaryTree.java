package br.univille.estd.binarytree;

<E>
 
public class LinkedBinaryTree<E> {
	
	protected BTPosition<E> root; // Referencia para a raiz
	protected int size;           // Número de nodos
	
	
	public LinkedBinaryTree() {
		root = null; // inicia com uma árvore vazia
		size = 0;
	}
	
	public int size() {
		return size;
	}
	

	public boolean isInternal(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getLeft() == null && v.getRight() == null) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	
	public boolean isRoot(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			return v.equals(root);
		}
		
	}
	public boolean isExternal(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getLeft() == null && v.getRight() == null) {
				return true;
			}else {
				return false;
			}
		}
	}
	

	public boolean hasLeft(BTPosition<E> v) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}else {
			if(v.getLeft() == null) {
				return false;
			}else {
				return true;
			}
		}
	}
	
	
	public boolean hasRight(BTPosition<E> v) throws InvalidPositionException{
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			if(v.getRight() == null) {
				return false;
			}else {
				return true;
			}
		}
		
	}

	public BTPosition<E> root() throws EmptyTreeException{
		if(root == null ) {
			throw new EmptyTreeException("A Arvore está vazia");
		}
		return root;
	}

	public BTPosition<E> left(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getLeft() == null) {
				throw new BoundaryViolationException("Raiz nao tem filho da esquerda");
			}
			else {
				return v.getLeft();
			}
		}
	}
	

	public BTPosition<E> right(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getRight() == null) {
				throw new BoundaryViolationException("Raiz nao tem filho da direita");
			}
			else {
				return v.getRight();
			}
		}
	}
	

	public BTPosition<E> parent(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else{
			if(v.getParent() == null) {
				throw new BoundaryViolationException("Raiz nao tem pai");
			}
			else {
				return v.getParent();
			}
		}
	}
	

	public E replace(BTPosition<E> v, E o) throws InvalidPositionException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			var temp = v.getElement();
			v.setElement(o);
			
			return temp;
		}
		
	}
	

	public BTPosition<E> sibling(BTPosition<E> v) throws InvalidPositionException, BoundaryViolationException{
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
			var parent = v.getParent();
			if(hasLeft(parent) && left(parent).equals(v) == false) {
				return left(parent);
			}else if(hasRight(parent) && right(parent).equals(v) == false) {
				return right(parent);
			}else {
				throw new BoundaryViolationException("Nodo nao possui irmao");
			}
		}
	}
	
	
	public BTPosition<E> addRoot(E e) throws NonEmptyTreeException{
		if(root == null) {
			root = new BTPosition<E>();
			root.setElement(e);
			size = size + 1;
			return root;
		}else {
			throw new NonEmptyTreeException("Arvore ja possui raiz");
		}
		
	}
	

	public BTPosition<E> insertLeft(BTPosition<E> v, E e) throws InvalidPositionException{
		BTPosition<E> node = new BTPosition<E>();
		node.setElement(e);
		node.setParent(v);
		v.setLeft(node);
		size = size + 1;
		
		return node;
	}

	public BTPosition<E> insertRight(BTPosition<E> v, E e) throws InvalidPositionException{
		BTPosition<E> node = new BTPosition<E>();
		node.setElement(e);
		node.setParent(v);
		v.setRight(node);
		size = size + 1;
		
		return node;
	}
	

	public E remove(BTPosition<E> v) throws InvalidPositionException{
		
		E temp;
		
		if(v == null) {
			throw new InvalidPositionException("Nodo invalido");
		}
		else {
					var right = v.getRight();
					var left = v.getLeft();
					var parent = v.getParent();
					temp = v.getElement();
					if(left != null && right != null) {
						throw new InvalidPositionException("Nodo com dois filhos nao pode ser removido");
					}
					
					if(isRoot(v)) {
						temp = v.getElement();
						if(hasLeft(v)) {
							v = v.getLeft();
							v.setParent(null);
							root = v;
							size = size - 1;
						}else if(hasRight(v)) {
							v = v.getRight();
							v.setParent(null);
							root = v;
							size = size - 1;
						}else {
							v = null;
							root = null;
						}
					}else {
						if(parent.getLeft().equals(v)) {
							if(right != null) {
								v.getParent().setLeft(right);
								if(v.getParent().getLeft() != null) {
									v.getParent().getLeft().setParent(v.getParent());
								}
								size = size - 1;
							}else {
								v.getParent().setLeft(left);
								if(v.getParent().getLeft() != null) {
									v.getParent().getLeft().setParent(v.getParent());
								}
								size = size - 1;
							}
						}else {
							if(right != null) {
								v.getParent().setRight(right);
								if(v.getParent().getLeft() != null) {
									v.getParent().getRight().setParent(v.getParent());
								}
								size = size - 1;
							}else {
								v.getParent().setRight(left);
								if(v.getParent().getLeft() != null) {
									v.getParent().getRight().setParent(v.getParent());
								}
								size = size - 1;
							}
						}
					}
					
					
				
			}

		return temp;
	}

	protected BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		
		BTPosition<E> node = new BTPosition<E>();
		node.setParent(parent);
		node.setLeft(left);
		node.setRight(right);
		node.setElement(element);
		size = size + 1;

		return node;
	}

}
