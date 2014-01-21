package org.bytescale.datastructures.util.trees.traversers;

import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Visits the Node itself, the Left Child, then the Right Child
 * @param <T>
 */
public class PreOrderTraverser<T extends Comparable<? super T>>
        extends AbstractTraverser<T> {
    @Override
    public Iterator<BinaryTreeNode<T>> iterator() {
        return new PreOrderIterator<T>(tree.getRootNode()).iterator();
    }

    private class PreOrderIterator<T extends Comparable<? super T>> implements Iterable<BinaryTreeNode<T>> {
        private Queue<BinaryTreeNode<T>> nodes;

        public PreOrderIterator(BinaryTreeNode<T> rootNode) {
            this.nodes = new LinkedList<BinaryTreeNode<T>>();
            traversePreOrder(rootNode);
        }

        private void traversePreOrder(BinaryTreeNode<T> node) {
            if (node == null) {
                return;
            }
            nodes.add(node);
            traversePreOrder(node.getLeftChild());
            traversePreOrder(node.getRightChild());
        }

        @Override
        public Iterator<BinaryTreeNode<T>> iterator() {
            return nodes.iterator();
        }
    }
}
