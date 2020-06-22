/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guille
 */
public class CategoriasDaoTest {
    
    public CategoriasDaoTest() {
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
     * Test of getConexion method, of class CategoriasDao.
     */
   
    
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        CategoriasDao instance = new CategoriasDao();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of read method, of class Categorias*/
    
    @Test
    public void testRead() {
        System.out.println("read");
        CategoriasDao instance = new CategoriasDao();
        Integer idCategoria = 1;
        Categoria expResult = null;
        Categoria result = instance.read(idCategoria);
        assertNotEquals(expResult, result);
        
        //PRUEBA LEER UN Categoria QUE NO EXISTA
        idCategoria = 9999;
        expResult = null;
        result = instance.read(idCategoria);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class CategoriasDao.
    */
    @Test
    public void testInsert() {
        System.out.println("insert");
        CategoriasDao instance = new CategoriasDao();
        Categoria categoria = new Categoria(1,"Prueba1","PruebaNombre");
        Integer expResult = null;
        Integer result = instance.insert(categoria);
        assertNotEquals(expResult, result);
        
        instance.delete(result);
        
        // PRUEBA INSERTAR Categoria CON ERROR
        Categoria categoria2 = new Categoria(1,null,"PruebaNombre");
        expResult = null;
        result = instance.insert(categoria2);
        assertEquals(expResult, result);  
    }

    /**
     * Test of update method, of class CategoriasDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        CategoriasDao instance = new CategoriasDao();
        
        Categoria categoria = new Categoria(1,"Prueba1","PruebaNombre");
        Integer id = instance.insert(categoria);
        Categoria categoriaModificado = new Categoria(id,"Prueba1","PruebaNombre");
        Integer expResult = 1;
        Integer result = instance.update(categoriaModificado);
        assertEquals(expResult, result);
        
        //ACTUALIZACION CON ERRORES
        Categoria categoriaModificado2 = new Categoria(id,null,"PruebaNombre");
        expResult = 0;
        result = instance.update(categoriaModificado2);
        assertEquals(expResult, result);
        instance.delete(id);
    }

    /**
     * Test of delete method, of class CategoriasDao.
    */ 
    @Test
    public void testDelete() {
        System.out.println("delete");
        CategoriasDao instance = new CategoriasDao();
        Categoria categoria = new Categoria(6,"Prueba1","PruebaNombre");
        Integer id = instance.insert(categoria);
        Integer idCategoria = id;
        Integer expResult = 1;
        Integer result = instance.delete(idCategoria);
        assertEquals(expResult, result);
        
        //ELIMINAR UN Categoria QUE NO SE PUEDA BORRAR
        idCategoria = 6;
        expResult = 0;
        result = instance.delete(idCategoria);
        assertEquals(expResult, result);
    }

    /**
     * Test of listar method, of class CategoriasDao.
    */ 
    @Test
    public void testListar() {
        System.out.println("listar");
        Integer posicion = 1;
        CategoriasDao instance = new CategoriasDao();
        ArrayList<Categoria> expResult = null;
        ArrayList<Categoria> result = instance.listar(posicion);
        assertNotEquals(expResult, result);
    }
}
