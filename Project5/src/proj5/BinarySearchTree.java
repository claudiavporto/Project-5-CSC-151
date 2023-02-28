package proj5;

/**
 * BinarySearchTree class represents a Binary Search Tree ADT
 *
 * BinarySearchTree class invariants:
 * 1. For a given node n, all nodes in left subtree of n are less than or
 *    equal to n in value, and all nodes in right subtree of n are greater
 *    than n
 * 
 * @author Chris Fernandes, Kristina Striegnitz
 * @version Fall 2022
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private BSTNode<T> root;


	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root = null;
	}


    /**
	 * inserts an new value into this BST    
	 * @param newValue value to insert
	 */
	public void insert(T newValue) {
		root = insert(root, newValue);
	}


	/**
	 * inserts value into tree rooted at subroot
	 * 
	 * @param subroot subroot of tree to insert into
	 * @param value the value to insert
	 * @return root of the subtree I've just finished inserting into
	 */
	private BSTNode<T> insert(BSTNode<T> subroot, T value) {
		if (subroot==null){
			return new BSTNode<T>(value);
		}
		else if (value.compareTo(subroot.key) > 0){
			subroot.rlink = insert(subroot.rlink,value);
			return subroot;
		}
		else {
			subroot.llink = insert(subroot.llink, value);
			return subroot;
		}
	}


	/**
	 * deletes value from tree.  If value not there, do nothing.
	 * @param value  value to delete
	 */
	public void delete(T value) {
		delete(getRoot(),value);
	}


	/**
	 * deletes value from tree rooted at subroot
	 * @param subroot  root of tree to be deleted from
	 * @param value  element to delete
	 * @return pointer to tree rooted at subroot that has value removed from it
	 */
	private BSTNode<T> delete(BSTNode<T> subroot, T value) {
		/**
		 * if subroot is an empty tree
		 *     return null
		 * else if victim is on the left of subroot
		 *     subroot's left link must become what recursion on subroot's left child gives you
		 * else if victim is on the right of subroot
		 *     subroot's right link must become what recursion on subroot's rlink gives you
		 * else
		 *     victim is found!
		 *     case 1) victim is a leaf
		 *         return null
		 *     case 2) victim has exactly one (right) subtree
		 *         return pointer to that right subtree
		 *     (case 2a - take care of just left subtree only)
		 *     case 3) victim has two subtrees
		 *         pick a replacement (largest value in the left subtree)
		 *         move the data from replacement node to victim node
		 *         delete the replacement
		 */

		if(subroot == null){
			return null;
		}else if(value.compareTo(subroot.key) < 0){
			subroot.llink = delete(subroot.llink, value);
		}else if(value.compareTo(subroot.key) > 0){
			subroot.rlink = delete(subroot.rlink, value);
		}else{
			if(subroot.isLeaf()){
				return null;
			}else if(subroot.hasRightChildOnly()){
				return subroot.rlink;
			}else if(subroot.hasLeftChildOnly()){
				return subroot.llink;
			}else{
				T toReplace = findMax(subroot).key;
				delete(toReplace);
				subroot.key = toReplace;
			}
		}
		return subroot;
	}


    /**
     * checks whether the target value is in the tree
     * @return true or false to indicate whether the target value is in the tree
     */
    public boolean search(T target) {
		return search(target, getRoot());
    }


	/**
	 * recursive helper method for search()
	 *
	 * @param subroot subroot of subtree to search through
	 * @param target value that we are searching for
	 * @return true iff target is in the tree
	 */
	private boolean search(T target, BSTNode<T> subroot){
		if(subroot == null){
			return false;
		}else if(target.compareTo(subroot.key) > 0) {
			return search(target, subroot.rlink);
		}else if(target.compareTo(subroot.key) < 0){
			return search(target, subroot.llink);
		}else{
			return true;
		}
	}


	/**
	 * Returns a pointer to the object that is stored within the BSTNode
	 * @param toFind object to find
	 * @return pointer to object
	 */
	public T getData(T toFind){
		return getData(getRoot(), toFind);
	}

	/**
	 * recursive helper method for getData()
	 *
	 * @param subroot root of subtree to make into a string
	 * @param toFind value to find
	 * @return data at BSTNode
	 */
	private T getData(BSTNode<T> subroot, T toFind){
		if(!this.search(toFind)){
			return null;
		}else if(subroot.key.compareTo(toFind) < 0){
			return getData(subroot.rlink, toFind);
		}else if(subroot.key.compareTo(toFind) > 0){
			return getData(subroot.llink, toFind);
		}else{
			return subroot.key;
		}
	}

	/**
	 * Finds and returns the largest value in the subtree
	 * @return the largest value in the subtree
	 */
	public T findMax(){
		if(findMax(getRoot()).key == null){
			return null;
		}else {
			return findMax(getRoot()).key;
		}
	}

	/**
	 * recursive helper for findMax()
	 * @param subroot  root of tree to be deleted from
	 * @return pointer to tree rooted at subroot
	 */
	private BSTNode<T> findMax(BSTNode<T> subroot){
		if(subroot == null){
			return null;
		}else if(subroot.rlink == null){
			return subroot;
		}else{
			return findMax(subroot.rlink);
		}
	}


	/**
	 * @return the number of items in the tree
	 */
	public int size(){
		return size(this.root);
	}
	private int size(BSTNode<T> subroot){
		if(subroot == null){
			return 0;
		}else{
			return 1 + size(subroot.llink) + size(subroot.rlink);
		}
	}


	/**
	 * returns tree as printable string
	 * @return tree in string format with form (left subtree) value (right subtree)
	 */
	public String toString(){
		return toString(root);
	}


	/**
	 * recursive helper method for toString()
	 *
	 * @param N root of subtree to make into a string
	 * @return string version of tree rooted at N
	 */
	private String toString(BSTNode<T> N){
		String ret = "";
		if (N != null){
			ret += "(";
			ret += toString(N.llink);
			ret += "  " + N + "  ";
			ret += toString(N.rlink);
			ret += ")";
		}
		return ret;
	}


	/**
	 * Returns the Binary Search Tree BSTNode data one after another
	 * @return tree in string form
	 */
	public String printString(){
		return printString(getRoot());
	}


	/**
	 * recursive helper method for printString()
	 *
	 * @param subroot root of subtree to make into a string
	 * @return string version of tree rooted at subroot
	 */
	private String printString(BSTNode<T> subroot){
		String toReturn = "";
		if(subroot != null){
			toReturn += printString(subroot.llink);
			toReturn += subroot.key + "\n";
			toReturn += printString(subroot.rlink);
		}
		return toReturn;
	}


	private BSTNode<T> getRoot(){
		return this.root;
	}
}