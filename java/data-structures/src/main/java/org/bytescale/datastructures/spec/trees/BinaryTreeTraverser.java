package org.bytescale.datastructures.spec.trees;

public interface BinaryTreeTraverser<T extends Comparable<? super T>> extends Iterable<BinaryTreeNode<T>> {

    public void setBinaryTree(BinaryTree<T> tree);
    public void setTraversalOrder(BinaryTree.TraversalOrder traversalOrder);

}
