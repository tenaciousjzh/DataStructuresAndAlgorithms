package org.bytescale.datastructures.tests;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;
import org.bytescale.datastructures.util.trees.SimpleBinaryTree;
import org.bytescale.datastructures.util.trees.SimpleBinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleBinaryTreeTest {
    private BinaryTree<Character> tree;

    @Before
    public void setup() {
        tree = new SimpleBinaryTree<Character>();

    }

    @Test
    public void testObjectCreation() {
        assertNotNull(tree);
        BinaryTreeNode<Character> rootNodeArg = new SimpleBinaryTreeNode<Character>();
        tree = new SimpleBinaryTree<Character>(rootNodeArg);
        assertNotNull(tree);
    }

    @Test
    public void testSetRootNodeGetterAndSetter() {
        BinaryTreeNode<Character> root = new SimpleBinaryTreeNode<Character>();
        root.setListing(new Character('a'));

        tree.setRootNode(root);
        assertNotNull(tree.getRootNode());
        assertEquals(root, tree.getRootNode());
    }

    @Test
    public void testAddNode() {
        BinaryTreeNode<Character> root = new SimpleBinaryTreeNode<Character>();
        root.setListing(new Character('d'));

        tree.setRootNode(root);
        tree.insert(new Character('a'));
        tree.insert(new Character('b'));
        tree.insert(new Character('c'));

        tree.insert(new Character('e'));
        tree.insert(new Character('f'));

        assertTrue(tree.isInTree('b'));

    }

    @Test
    public void testBuildTreeAndCheckSortOrder() {

        Character a = new Character('a');
        Character b = new Character('b');
        Character c = new Character('c');
        Character d = new Character('d');
        Character e = new Character('e');
        Character f = new Character('f');
        Character g = new Character('g');
        Character h = new Character('h');
        Character i = new Character('i');

        tree.insert(f);
        tree.insert(b);
        tree.insert(a);
        tree.insert(d);
        tree.insert(c);
        tree.insert(e);
        tree.insert(g);
        tree.insert(i);
        tree.insert(h);


        //Visit node, left subtree, then right subtree
        List<Character> preOrder = Arrays.asList(new Character[]
                {f, b, a, d, c, e, g, i, h});
        //Visit left subtree, node, then right subtree
        List<Character> inOrder = Arrays.asList(new Character[]
                {a, b, c, d, e, f, g, h, i});
        //Visit left subtree, right subtree, then node
        List<Character> postOrder = Arrays.asList(new Character[]
                {a, c, e, d, b, h, i, g, f});
        //Breadth first
        List<Character> breadthFirst = Arrays.asList(new Character[]
                {f, b, g, a, d, i, c, e, h});

        assertEquals(preOrder, tree.traverseAndFlatten(BinaryTree.TraversalOrder.DEPTH_FIRST_PRE_ORDER));
        assertEquals(inOrder, tree.traverseAndFlatten(BinaryTree.TraversalOrder.DEPTH_FIRST_IN_ORDER));
        assertEquals(postOrder, tree.traverseAndFlatten(BinaryTree.TraversalOrder.DEPTH_FIRST_POST_ORDER));
        assertEquals(breadthFirst, tree.traverseAndFlatten(BinaryTree.TraversalOrder.BREADTH_FIRST));
    }

    @Test
    public void testIsInTree() {
        Character a = new Character('a');
        Character b = new Character('b');
        Character c = new Character('c');
        Character d = new Character('d');
        Character e = new Character('e');
        Character f = new Character('f');
        Character g = new Character('g');
        Character h = new Character('h');
        Character i = new Character('i');

        tree.insert(f);
        tree.insert(b);
        tree.insert(a);
        tree.insert(d);
        tree.insert(c);
        tree.insert(e);
        tree.insert(g);
        tree.insert(i);
        tree.insert(h);

        boolean inTree = tree.isInTree(i);
        assertTrue(inTree);
        inTree = tree.isInTree(null);
        assertFalse(inTree);
        inTree = tree.isInTree(f);
        assertTrue(inTree);
        inTree = tree.isInTree(new Character('z'));
        assertFalse(inTree);
    }
}
