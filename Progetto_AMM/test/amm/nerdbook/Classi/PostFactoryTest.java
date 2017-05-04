/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.nerdbook.Classi;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author en26062
 */
public class PostFactoryTest {
    
    public PostFactoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class PostFactory.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        PostFactory expResult = null;
        PostFactory result = PostFactory.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostById method, of class PostFactory.
     */
    @Test
    public void testGetPostById() {
        System.out.println("getPostById");
        int id = 0;
        PostFactory instance = null;
        Post expResult = null;
        Post result = instance.getPostById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPostList method, of class PostFactory.
     */
    @Test
    public void testGetUserPostList() {
        System.out.println("getUserPostList");
        Nerd nrd = null;
        PostFactory instance = null;
        List expResult = null;
        List result = instance.getUserPostList(nrd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupPostList method, of class PostFactory.
     */
    @Test
    public void testGetGroupPostList() {
        System.out.println("getGroupPostList");
        Gruppo grp = null;
        PostFactory instance = null;
        List expResult = null;
        List result = instance.getGroupPostList(grp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
