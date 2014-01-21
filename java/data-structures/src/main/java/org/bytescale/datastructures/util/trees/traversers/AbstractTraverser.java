package org.bytescale.datastructures.util.trees.traversers;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;
import org.bytescale.datastructures.spec.trees.BinaryTreeTraverser;

import java.util.Iterator;

public abstract class AbstractTraverser<T extends Comparable<? super T>>
        implements BinaryTreeTraverser<T> {
    protected BinaryTree<T> tree;
    protected BinaryTree.TraversalOrder traversalOrder;

    @Override
    public void setBinaryTree(BinaryTree<T> tree) {
        this.tree = tree;
    }

    @Override
    public void setTraversalOrder(BinaryTree.TraversalOrder traversalOrder) {
        this.traversalOrder = traversalOrder;
    }

    @Override
    public abstract Iterator<BinaryTreeNode<T>> iterator();
}
