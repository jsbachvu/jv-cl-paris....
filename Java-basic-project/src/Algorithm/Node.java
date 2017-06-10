package Algorithm;

public class Node {

	private String c;
	private int count;

	private Node leftNode = null;
	private Node rightNode = null;
	private Node parent = null;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node(String c, int count) {
		super();
		this.c = c;
		this.count = count;
	}

	public Node(String c) {
		super();
		this.c = c;
		this.count = 0;
	}

	public Node(String c, int count, Node leftNode, Node rightNode) {
		super();
		this.c = c;
		this.count = count;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}

	public Node(String c, int count, Node leftNode, Node rightNode, Node parent) {
		super();
		this.c = c;
		this.count = count;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.parent = parent;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public String toString(){
		return c + " : " + count;
	}

}
