package com.dmitrydrobysh.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    // Check Kids
    @Test
    public void CheckNameKid(){
        Kid testKid1 = new Kid("Test Kid 1", true);
        Kid testKid2 = new Kid("Test Kid 2", false);

        boolean flag = testKid1.getName() == "Test Kid 1" && testKid2.getName() == "Test Kid 2";
        assertTrue(flag);
    }

    @Test
    public void CheckNormalKid(){
        Kid testKid1 = new Kid("Test Kid 1", true);
        Kid testKid2 = new Kid("Test Kid 2", false);

        boolean flag = testKid1.isNormal() == true && testKid2.isNormal() == false;
        assertTrue(flag);
    }

    @Test
    public void CheckDoActionKid(){
        Kid testKid1 = new Kid("Test Kid 1", true);
        Kid testKid2 = new Kid("Test Kid 2", false);

        boolean flag = testKid1.doAction().equals("Test Kid 1 Is jumping on the sand") && testKid2.doAction().equals("Test Kid 2 Is jumping on the sand");
        assertTrue(flag);
    }


    // Check Horse
    @Test
    public void CheckNameHorse(){
        Horse testHorse1 = new Horse("Test Horse 1", true);
        Horse testHorse2 = new Horse("Test Horse 2", false);

        boolean flag = testHorse1.getName() == "Test Horse 1" && testHorse2.getName() == "Test Horse 2";
        assertTrue(flag);
    }

    @Test
    public void CheckNormalHorse(){
        Horse testHorse1 = new Horse("Test Horse 1", true);
        Horse testHorse2 = new Horse("Test Horse 2", false);

        boolean flag = testHorse1.isNormal() == true && testHorse2.isNormal() == false;
        assertTrue(flag);
    }

    @Test
    public void CheckDoActionHorse(){
        Horse testHorse1 = new Horse("Test Horse 1", true);
        Horse testHorse2 = new Horse("Test Horse 2", false);

        boolean flag = testHorse1.doAction().equals("Test Horse 1 Is transporting goods across the sky") && testHorse2.doAction().equals("Test Horse 2 Is transporting goods across the sky");
        assertTrue(flag);
    }


    // Watcher Check
    @Test
    public void CheckNameWatcher(){
        Watcher testWatcher = new Watcher("Test Watcher", 3);
        boolean flag = testWatcher.getName().equals("Test Watcher");

        assertTrue(flag);
    }

    @Test
    public void CheckLimitWatcher(){
        Watcher testWatcher = new Watcher("Test Watcher", 3);
        Watcher testWatcher2 = new Watcher("Test Watcher", -2);

        boolean flag = testWatcher.getLimit() == 3 && testWatcher2.getLimit() == 0;
        assertTrue(flag);
    }
}


