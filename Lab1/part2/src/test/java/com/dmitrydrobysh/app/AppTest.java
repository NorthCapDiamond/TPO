package com.dmitrydrobysh.app;

import static org.junit.Assert.assertTrue;
import com.dmitrydrobysh.app.btree.*;
import static com.dmitrydrobysh.app.btree.BTree.*;

import org.junit.Test;

public class AppTest {
    // add and create nodes
    @Test 
    public void createRootElement(){
        BTree testTree = new BTree(42);

        boolean flag = (testTree.getRoot().getValue() == 42) && (testTree.getSize() == 1) && (testTree.getRoot().getLeftChild() == null && testTree.getRoot().getRightChild() == null);
        assertTrue(flag);
    }

    @Test 
    public void addToRoot(){
        BTree testTree = new BTree(42);
        testTree.append(43);
        boolean flag = (testTree.getSize() == 2) && (testTree.getRoot().getLeftChild() == null && testTree.getRoot().getRightChild() != null) && (testTree.toString().equals("42 43 "));
        assertTrue(flag);
    }

    @Test 
    public void addSomeElementsToRoot(){
        BTree testTree = new BTree(42);
        testTree.append(41);
        testTree.append(42);
        testTree.append(43);
        boolean flag = (testTree.getSize() == 4) && (testTree.getRoot().getLeftChild()!=null) && (testTree.getRoot().getRightChild()!=null) && (testTree.getRoot().getRightChild().getRightChild() != null) && (testTree.toString().equals("41 42 42 43 "));
        assertTrue(flag);
    }

    @Test
    public void addSameElements(){
        BTree testTree = new BTree(42);
        for (int i = 0; i < 3; i ++){
            testTree.append(42);
        }

        boolean flag = (testTree.getSize() == 4) && (testTree.getRoot().getLeftChild()==null) && (testTree.getRoot().getRightChild()!=null) && (testTree.getRoot().getRightChild().getRightChild() != null) && (testTree.toString().equals("42 42 42 42 "));
        assertTrue(flag);
    }

    @Test
    public void addSomeElementsToRegularNode(){
        BTree testTree = new BTree(42);
        testTree.append(48);
        testTree.append(44);
        testTree.append(52);

        boolean flag = (testTree.getSize() == 4) && (testTree.getRoot().getLeftChild()==null) && (testTree.getRoot().getRightChild()!=null) && (testTree.getRoot().getRightChild().getRightChild() != null) && ((testTree.getRoot().getRightChild()!=null) && (testTree.getRoot().getRightChild().getLeftChild() != null)) && (testTree.toString().equals("42 44 48 52 "));
        assertTrue(flag);
    }


    // delete nodes
    @Test
    public void deleteRoot(){
        BTree testTree = new BTree(42);
        testTree.delete(42);

        boolean flag = (testTree.getSize()==0) && (testTree.getRoot()==null) && (testTree.toString().equals("Tree is empty..."));
        assertTrue(flag);
    }

    @Test
    public void deleteTwoChildrenRoot(){
        BTree testTree = new BTree(42);
        testTree.append(41);
        testTree.append(43);
        testTree.delete(42);

        boolean flag = (testTree.getSize() == 2) && (testTree.getRoot().getValue() == 41) && (testTree.toString().equals("41 43 "));
        assertTrue(flag);
    }

    @Test
    public void deleteTwoChildrenRootV2(){
        BTree testTree = new BTree(42);
        testTree.append(41);
        testTree.append(43);
        testTree.delete(41);

        boolean flag = (testTree.getSize() == 2) && (testTree.getRoot().getValue() == 42) && (testTree.toString().equals("42 43 "));
        assertTrue(flag);
    }

    @Test
    public void deleteTwoChildrenRootV3(){
        BTree testTree = new BTree(42);
        testTree.append(41);
        testTree.append(43);
        testTree.delete(43);

        boolean flag = (testTree.getSize() == 2) && (testTree.getRoot().getValue() == 42) && (testTree.toString().equals("41 42 "));
        assertTrue(flag);
    }

    @Test
    public void deleteOneChildRoot(){
        BTree testTree = new BTree(42);
        testTree.append(41);

        testTree.delete(41);

        boolean flag = (testTree.getSize() == 1) && (testTree.getRoot().getValue() == 42) && (testTree.toString().equals("42 "));
        assertTrue(flag);
    }

    @Test
    public void deleteOneChildRootV2(){
        BTree testTree = new BTree(42);
        testTree.append(41);

        testTree.delete(42);

        boolean flag = (testTree.getSize() == 1) && (testTree.getRoot().getValue() == 41) && (testTree.toString().equals("41 "));
        assertTrue(flag);
    }

    @Test
    public void deleteOneChildRootV3(){
        BTree testTree = new BTree(42);
        testTree.append(43);

        testTree.delete(43);

        boolean flag = (testTree.getSize() == 1) && (testTree.getRoot().getValue() == 42) && (testTree.toString().equals("42 "));
        assertTrue(flag);
    }

    @Test
    public void deleteOneChildRootV4(){
        BTree testTree = new BTree(42);
        testTree.append(43);

        testTree.delete(42);

        boolean flag = (testTree.getSize() == 1) && (testTree.getRoot().getValue() == 43) && (testTree.toString().equals("43 "));
        assertTrue(flag);
    }

    @Test
    public void sameElementsOnlyDeleteTest(){
        BTree testTree = new BTree(42);
        for (int i = 0; i < 3; i ++){
            testTree.append(42);
        }
        for (int i = 0; i < 2; i ++){
            testTree.delete(42);
        }

        boolean flag = testTree.toString().equals("42 42 ");
        assertTrue(flag);
    }

    @Test
    public void sameElementsOnlyDeleteTestV2(){
        BTree testTree = new BTree(42);
        for (int i = 0; i < 3; i ++){
            testTree.append(41);
        }
        for (int i = 0; i < 2; i ++){
            testTree.delete(41);
        }

        boolean flag = testTree.toString().equals("41 42 ");
        assertTrue(flag);
    }

    @Test
    public void LeafDelete(){
        BTree testTree = new BTree(42);
        testTree.append(48);
        testTree.append(47);

        testTree.delete(47);

        boolean flag = (testTree.toString().equals("42 48 ")) && (testTree.getSize() == 2);
        assertTrue(flag);
    }

    @Test
    public void OneChildDelete(){
        BTree testTree = new BTree(42);
        testTree.append(48);
        testTree.append(47);
        testTree.append(45);

        testTree.delete(48);

        boolean flag = (testTree.toString().equals("42 45 47 ")) && (testTree.getSize() == 3);
        assertTrue(flag);
    }

    @Test
    public void TwoChildrenDelete(){
        BTree testTree = new BTree(42);
        testTree.append(48);
        testTree.append(46);
        testTree.append(45);
        testTree.append(47);


        testTree.delete(46);

        boolean flag = (testTree.toString().equals("42 45 47 48 ")) && (testTree.getSize() == 4);
        assertTrue(flag);
    }
}
