package org.bytescale.datastructures.tests;

import org.bytescale.datastructures.spec.trees.BinaryTree;
import org.bytescale.datastructures.spec.trees.BinaryTreeNode;
import org.bytescale.datastructures.util.trees.SimpleBinaryTree;
import org.bytescale.datastructures.util.trees.SimpleBinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

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
        root.setListing(new Character('a'));

        BinaryTreeNode<Character> b = new SimpleBinaryTreeNode<Character>();
        b.setListing(new Character('b'));

        tree.setRootNode(root);
        tree.add(b);

        assertTrue(tree.hasNodeWithListingValue('b'));
    }

    @Test
    public void testBuildTreeAndCheckSortOrder() {
        fail();
    }
}
