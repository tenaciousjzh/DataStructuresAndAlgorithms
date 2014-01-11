package org.bytescale.datastructures.util.trees;

import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

public class SimpleBinaryTreeNode<T> implements BinaryTreeNode<T> {
    private T listing;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    @Override
    public void setListing(T listing) {
        this.listing = listing;
    }

    @Override
    public T getListing() {
        return listing;
    }

    @Override
    public void setLeftChild(BinaryTreeNode<T> node) {
        this.leftChild = node;
    }

    @Override
    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public void setRightChild(BinaryTreeNode<T> node) {
        this.rightChild = node;
    }

    @Override
    public BinaryTreeNode<T> getRightNode() {
        return rightChild;
    }

    @Override
    public int compareTo(T otherNode) {
        if (otherNode == null) {
            return -1;
        }

        return 0;
    }
}
