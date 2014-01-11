package org.bytescale.datastructures.util.trees;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

public class SimpleBinaryTree<T> implements BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public SimpleBinaryTree() {

    }

    public SimpleBinaryTree(BinaryTreeNode<T> root) {
        setRootNode(root);
    }

    @Override
    public void setRootNode(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public BinaryTreeNode<T> getRootNode() {
        return root;
    }

    @Override
    public void add(BinaryTreeNode<T> node) {

    }

    @Override
    public boolean hasNodeWithListingValue(T nodeValue) {
        return false;
    }

    @Override
    public T[] traverseAndFlatten(TraversalOrder traversalOrder) {
        return null;
    }
}
