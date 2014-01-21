package org.bytescale.datastructures.util.trees.traversers;

import org.bytescale.datastructures.spec.trees.BinaryTreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstTraverser <T extends Comparable<? super T>>
        extends AbstractTraverser<T> {
    @Override
    public Iterator<BinaryTreeNode<T>> iterator() {
        return new BreadthFirstIterable<T>(tree.getRootNode()).iterator();
    }

    private class BreadthFirstIterable<T extends Comparable<? super T>> implements Iterable<BinaryTreeNode<T>> {
        Queue<BinaryTreeNode<T>> queue;

        public BreadthFirstIterable(BinaryTreeNode<T> rootNode) {
            queue = new LinkedList<BinaryTreeNode<T>>();
            traverseBreadthFirst(rootNode);
        }

        private void traverseBreadthFirst(BinaryTreeNode<T> rootNode) {
            Queue<BinaryTreeNode<T>> traversalQueue = new LinkedList<BinaryTreeNode<T>>();
            traversalQueue.add(rootNode);

            while (!traversalQueue.isEmpty()) {
                BinaryTreeNode<T> current = traversalQueue.remove();
                queue.add(current);

                if (current.getLeftChild() != null) {
                    traversalQueue.add(current.getLeftChild());
                }
                if (current.getRightChild() != null) {
                    traversalQueue.add(current.getRightChild());
                }
            }
        }


        @Override
        public Iterator<BinaryTreeNode<T>> iterator() {
            return queue.iterator();
        }
    }
}
