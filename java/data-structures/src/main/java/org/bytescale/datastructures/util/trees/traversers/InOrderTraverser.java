package org.bytescale.datastructures.util.trees.traversers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

import java.util.Iterator;

/**
 * Visits the Left Child, the Node itself, then the Right Child
 * @param <T>
 */
public class InOrderTraverser<T extends Comparable<? super T>>
        extends AbstractDepthFirstTraverser<T> {

    @Override
    public Iterator<BinaryTreeNode<T>> iterator() {
        return new InOrderIterator<T>(tree.getRootNode()).iterator();
    }

    private class InOrderIterator<T extends Comparable<? super T>>
            implements Iterable<BinaryTreeNode<T>> {
        private Queue<BinaryTreeNode<T>> nodes;

        public InOrderIterator(BinaryTreeNode<T> rootNode) {
            nodes = new LinkedList<BinaryTreeNode<T>>();
            traverseInOrder(rootNode);
        }

        private void traverseInOrder(BinaryTreeNode<T> node) {
            if (node == null) {
                return;
            }
            traverseInOrder(node.getLeftChild());
            nodes.add(node);
            traverseInOrder(node.getRightChild());
        }

        @Override
        public Iterator<BinaryTreeNode<T>> iterator() {
            return nodes.iterator();
        }
    }


}
