package org.bytescale.datastructures.spec.trees;

public interface BinaryTree<T> {

    public enum TraversalOrder { BREADTH_FIRST, DEPTH_FIRST_PRE_ORDER, DEPTH_FIRST_IN_ORDER, DEPTH_FIRST_POST_ORDER }  ;

    public void setRootNode(BinaryTreeNode<T> root);
    public BinaryTreeNode<T>  getRootNode();

    public void add(BinaryTreeNode<T> node);
    public boolean hasNodeWithListingValue(T nodeValue);


    public T[] traverseAndFlatten(TraversalOrder traversalOrder);
}
