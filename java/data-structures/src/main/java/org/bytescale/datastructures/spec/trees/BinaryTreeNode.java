package org.bytescale.datastructures.spec.trees;

public interface BinaryTreeNode<T extends Comparable<? super T>> {
    public void setListing(T listing);
    public T getListing();

    public void setLeftChild(BinaryTreeNode<T> node);
    public BinaryTreeNode<T> getLeftChild();

    public void setRightChild(BinaryTreeNode<T> node);
    public BinaryTreeNode<T> getRightChild();
}
