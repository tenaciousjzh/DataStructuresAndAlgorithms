package org.bytescale.datastructures.util.trees.traversers;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;
import org.bytescale.datastructures.spec.trees.BinaryTreeTraverser;

import static org.bytescale.datastructures.spec.trees.BinaryTree.TraversalOrder.*;

public class TraverserFactory<T extends Comparable<? super T>> {
    BinaryTree<T> tree;
    BinaryTree.TraversalOrder traversalOrder;

    public TraverserFactory(BinaryTree<T> tree, BinaryTree.TraversalOrder order) {
        this.tree = tree;
        this.traversalOrder = order;
    }

    public BinaryTreeTraverser<T> createTraverser() {
        BinaryTreeTraverser<T> traverser = null;

        switch (traversalOrder) {
            case DEPTH_FIRST_IN_ORDER:
                traverser = new InOrderTraverser<T>();
                break;
            case DEPTH_FIRST_POST_ORDER:
                traverser = new PostOrderTraverser<T>();
                break;
            case DEPTH_FIRST_PRE_ORDER:
                traverser = new PreOrderTraverser<T>();
                break;
            case BREADTH_FIRST:
                traverser = new BreadthFirstTraverser<T>();
                break;
            default:
                traverser = new InOrderTraverser<T>();
                break;
        }

        traverser.setBinaryTree(tree);
        traverser.setTraversalOrder(traversalOrder);

        return traverser;
    }
}
