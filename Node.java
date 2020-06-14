//Lab Partners:

//Xiaoxiang "Steven" Liu
//xliu102@u.rochester.edu
//MW 6:15PM - 7:30PM

//Grant Yap
//gyap@u.rochester.edu
//MW 2:00 - 3:15PM

//Lab 5

public class Node {
	public Node left;
	public Node right;
	public Node parent;
	public String value;
	
	public Node() {
		
	}
	
	public Node(String value) {
		this.value = value;
	}
	
	public boolean isLeaf() {
		if(right == null && left == null) {
			return true;
		}
		
		return false;
	}

}
