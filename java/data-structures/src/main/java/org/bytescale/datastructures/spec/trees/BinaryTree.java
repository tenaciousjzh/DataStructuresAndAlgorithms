package org.bytescale.datastructures.spec.trees;

import java.util.List;

public interface BinaryTree<T extends Comparable<? super T>> {

    public enum TraversalOrder { BREADTH_FIRST, DEPTH_FIRST_PRE_ORDER, DEPTH_FIRST_IN_ORDER, DEPTH_FIRST_POST_ORDER }  ;

    public void setRootNode(BinaryTreeNode<T> root);
    public BinaryTreeNode<T>  getRootNode();

    public void insert(T listing);
    public boolean isInTree(T nodeValue);
    public BinaryTreeNode<T> search(T nodeValue);


    public List<T> traverseAndFlatten(TraversalOrder traversalOrder);

    public int size();
}
