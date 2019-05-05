/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.airhacks.individual.tqs.Cache;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nunos
 */
public class CacheTest {
    
    public CacheTest() {
    }
    
    Cache<String, String> cache = new Cache<>(3);
    
    //verificar se esta a guardar corretamente e se consigo aceder ao mesmo elemento que guardei
    @Test
    public void PutTest(){
        cache.put("123", "a");
        cache.put("345", "b");
        cache.put("456","c");
        
        assertEquals("a", cache.get("123"));
        assertEquals("b", cache.get("345"));
        assertEquals("c", cache.get("456"));  
    }
    
    
    //nao posos ir buscar o que nao existe
    @Test
    public void GetTest(){
        cache.put("123", "a");
        assertEquals(null, cache.get("NAO_EXISTE"));
    }
    
    @Test
    public void RemoveTest(){
        cache.put("123", "a");
        assertEquals("a", cache.get("123")); //existe o primeiro
        
        cache.remove("123");
        assertEquals(null, cache.get("123"));//ja nao existe
    }
    
    @Test
    public void SizeTest(){
        cache.put("123", "a");
        assertEquals("a", cache.get("123")); //existe o primeiro
        assertEquals(1,cache.size());
        
        cache.put("345", "b");
        assertEquals(2, cache.size());
        
        cache.remove("123");
        assertEquals(null, cache.get("123"));//ja nao existe
        assertEquals(1, cache.size());
    }
    
    @Test
    public void maxCacheTest(){
        cache.put("123", "a");
        assertEquals("a", cache.get("123")); //existe o primeiro
        assertEquals(1,cache.size());
        
        cache.remove("123");
        assertEquals(null, cache.get("123"));//ja nao existe
        assertEquals(0, cache.size());
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
