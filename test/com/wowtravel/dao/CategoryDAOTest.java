package com.wowtravel.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wowtravel.entity.Category;

public class CategoryDAOTest {
	
	private static CategoryDAO categoryDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDao = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryDao.close();
	}

	@Test( expected=javax.persistence.EntityExistsException.class )
	public void testCreateCategory() {
		Category newCat = new Category("Excursion");
		Category category = categoryDao.create(newCat);
		
		assertTrue(category != null && category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Rest");
		cat.setCategoryId(3);
		
		Category category = categoryDao.update(cat);
		
		assertEquals(cat.getName(), category.getName());
		
	}

	@Test
	public void testGet() {
		Integer catId = 7;
		Category cat = categoryDao.get(catId);
		
		assertNotNull(cat);
	}

	@Test
	public void testDeleteType() {
		Integer catId = 14;
		categoryDao.delete(catId);
		
		Category cat = categoryDao.get(catId);
		
		assertNull(cat);
	}
	
	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDao.listAll();
		
		listCategory.forEach(c -> System.out.println(c.getName() + ", "));
		
		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDao.count();
		
		assertTrue(totalCategories > 0);
	}

	@Test
	public void testFindByName() {
		String name = "Shopping";
		Category category = categoryDao.findByName(name);
		
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String name = "Shopping1";
		Category category = categoryDao.findByName(name);
		
		assertNull(category);
	}
	
}
