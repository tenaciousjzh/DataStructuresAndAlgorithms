package org.bytescale.datastructures.util.trees.traversers;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Visits the Left Child, the Right Child and then the Node itself
 * @param <T>
 */
public class PostOrderTraverser<T extends Comparable<? super T>>
        extends AbstractDepthFirstTraverser<T> {

    @Override
    public Iterator<BinaryTreeNode<T>> iterator() {
        return new PostOrderIterator<T>(tree.getRootNode()).iterator();
    }

    private class PostOrderIterator<T extends Comparable<? super T>> implements Iterable<BinaryTreeNode<T>> {
        private final Queue<BinaryTreeNode<T>> nodes;

        public PostOrderIterator(BinaryTreeNode<T> rootNode) {
            this.nodes = new LinkedList<BinaryTreeNode<T>>();
            traversePostOrder(rootNode);
        }

        private void traversePostOrder(BinaryTreeNode<T> node) {
            if (node == null) {
                return;
            }
            traversePostOrder(node.getLeftChild());
            traversePostOrder(node.getRightChild());
            nodes.add(node);
        }

        @Override
        public Iterator<BinaryTreeNode<T>> iterator() {
            return nodes.iterator();
        }
    }
}
