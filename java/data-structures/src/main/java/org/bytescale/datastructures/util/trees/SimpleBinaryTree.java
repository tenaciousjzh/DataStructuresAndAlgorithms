package org.bytescale.datastructures.util.trees;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;
import org.bytescale.datastructures.spec.trees.BinaryTreeTraverser;
import org.bytescale.datastructures.util.trees.traversers.TraverserFactory;

import java.util.ArrayList;
import java.util.List;

public class SimpleBinaryTree<T extends Comparable<? super T>> implements BinaryTree<T> {
    private BinaryTreeNode<T> root;
    protected int nodeCount;

    public SimpleBinaryTree() {

    }

    public SimpleBinaryTree(BinaryTreeNode<T> root) {
        setRootNode(root);
    }

    @Override
    public void setRootNode(BinaryTreeNode<T> root) {
        nodeCount = 0;
        this.root = root;
        nodeCount++;
    }

    @Override
    public BinaryTreeNode<T> getRootNode() {
        return root;
    }

    @Override
    public void insert(T listing) {
        BinaryTreeNode<T> node = new SimpleBinaryTreeNode<T>();
        node.setListing(listing);

        if (node.getListing() == null) {
            throw new IllegalArgumentException("The listing for the node provided is null and can't be compared to any other node in the tree. Failed to insert node.");
        }
        if (root == null) {
            setRootNode(node);
            return;
        }

        sortNode(node, root);
    }

    private void sortNode(BinaryTreeNode<T> newNode, BinaryTreeNode<T> current) {
        if (newNodeLessThanComparable(newNode, current)) {
            if (current.getLeftChild() == null) {
                current.setLeftChild(newNode);
                nodeCount++;
            } else {
                sortNode(newNode, current.getLeftChild());
            }
        } else if (newNodeGreaterThanComparable(newNode, current)) {
            if (current.getRightChild() == null) {
                current.setRightChild(newNode);
                nodeCount++;
            } else {
                sortNode(newNode, current.getRightChild());
            }
        } else {
            System.out.println("Ignoring node as it's already in the tree.");
        }
    }

    private boolean newNodeLessThanComparable(BinaryTreeNode<T> candidate, BinaryTreeNode<T> comparable) {
        if (candidate.getListing().compareTo(comparable.getListing()) < 0) {
            return true;
        }
        return false;
    }

    private boolean newNodeGreaterThanComparable(BinaryTreeNode<T> candidate, BinaryTreeNode<T> comparable) {
        if (candidate.getListing().compareTo(comparable.getListing()) > 0) {
            return true;
        }
        return false;
    }

    private boolean newNodeEqualToComparable(BinaryTreeNode<T> candidate, BinaryTreeNode<T> comparable) {
        if (candidate.getListing().compareTo(comparable.getListing()) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInTree(T nodeValue) {
        if (root == null || nodeValue == null) {
            return false;
        }
        BinaryTreeNode<T> result = search(nodeValue);
        return (result == null) ? false : true;
    }

    public BinaryTreeNode<T> search(T nodeValue) {
        return search(nodeValue, root);
    }

    public BinaryTreeNode<T> search(T nodeValue, BinaryTreeNode<T> node) {
        if (node == null) {
            return node;
        }
        int comparison = nodeValue.compareTo(node.getListing());
        if (comparison == 0) { //found a match to the nodeValue
            return node;
        } else if (comparison < 0) { //search the left subtree
            return search(nodeValue, node.getLeftChild());
        } else if (comparison > 0) { //search the right subtree
            return search(nodeValue, node.getRightChild());
        }
        return null;
    }

    @Override
    public List<T> traverseAndFlatten(TraversalOrder traversalOrder) {
        TraverserFactory<T> factory = new TraverserFactory<T>(this, traversalOrder);
        BinaryTreeTraverser<T> traverser = factory.createTraverser();
        List<T> list = new ArrayList<T>();

        for (BinaryTreeNode<T> node : traverser) {
            list.add(node.getListing());
        }

       return list;
    }

    @Override
    public int size() {
        return nodeCount;
    }


}
