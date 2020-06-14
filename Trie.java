//Lab Partners:

//Xiaoxiang "Steven" Liu
//MW 6:15PM - 7:30PM

//Grant Yap
//MW 2:00 - 3:15PM

//Lab 5

import java.util.ArrayList;
import java.util.Stack;

public class Trie {

	private Node root;
	private Node pointer;

	public Trie() {
		root = new Node();
	}

	public Boolean insert(Trie t, String newValue) {

		pointer = root;

		for (int i = 0; i < newValue.length(); i++) {

			if (pointer.left == null && pointer.right == null && pointer.value == null) {
				pointer.value = newValue;
				return true;
			} else if (pointer.left == null && pointer.right == null && pointer.value != null) {
				build(pointer, i);
			}

			if (newValue.charAt(i) == '0') {
				if (pointer.left == null) {
					pointer.left = new Node(newValue);
					pointer.left.parent = pointer;
					return true;
				}
				pointer = pointer.left;
			} else if (newValue.charAt(i) == '1') {
				if (pointer.right == null) {
					pointer.right = new Node(newValue);
					pointer.right.parent = pointer;
					return true;
				}
				pointer = pointer.right;
			} else {
				return false;
			}
		}

		return false;
	}

	private void build(Node pointer, int pos) {
		String data = pointer.value;
		pointer.value = null;
		Node node = new Node(data);

		if (data.charAt(pos) == '0') {
			pointer.left = node;
			node.parent = pointer;
		} else if (data.charAt(pos) == '1') {
			pointer.right = node;
			node.parent = pointer;
		}
	}

	public String search(Trie t, String value) {
		pointer = root;
		
		for(int i = 0; i< value.length(); i++) {
			if(value.charAt(i) == '0') {
				if(pointer.left != null) {
					pointer = pointer.left;
				}
				else {
					return pointer.value;
				}
			}
			else if(value.charAt(i) == '1') {
				if(pointer.right != null) {
					pointer = pointer.right;
				}
				else {
					return pointer.value;
				}
			}
		}
		return pointer.value;

	}

	public String smallest(Trie t) {
		Node node = t.root;
		ArrayList<String> list = new ArrayList<>();
		list = trieToList(t);
		return list.get(0);

	}

	public String largest(Trie t) {
		Node node = t.root;
		ArrayList<String> list = new ArrayList<>();
		list = trieToList(t);
		return list.get(list.size() - 1);

	}

	public ArrayList<String> trieToList(Trie t) {
		pointer = root;
		ArrayList<String> dataList = new ArrayList<>();
		addToList(dataList, pointer);
		return dataList;

	}

	public void addToList(ArrayList<String> list, Node pointer) {
		if(pointer.isLeaf()) {
			list.add(pointer.value);
			return;
		}
		
		if(pointer.left!= null) {
			addToList(list, pointer.left);
		}
		
		if(pointer.right!= null) {
			addToList(list, pointer.right);
		}
		
		

	}

	public int size(Trie t) {
		return trieToList(t).size();

	}
	


	public int height(Trie t) {
		Stack<Node> leaves = new Stack<>();
		pointer = t.root;
		heightHelper(pointer, leaves);
		int max = 0;
		int leafHeight;
		
		while(!leaves.empty()) {
			pointer = leaves.pop();
			leafHeight = 1;
			while(pointer.parent != null) {
				pointer = pointer.parent;
				leafHeight++;
			}
			
			if(leafHeight > max) {
				max = leafHeight;
			}
		}
		
		return max;

	}

	private void heightHelper(Node pointer, Stack<Node> leaves) {
		if(pointer.isLeaf()) {
			leaves.add(pointer);
			return;
		}
		
		if(pointer.left != null) {
			heightHelper(pointer.left, leaves);
		}
		
		if(pointer.right != null) {
			heightHelper(pointer.right, leaves);
		}

	}

}
