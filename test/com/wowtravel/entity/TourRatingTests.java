package com.wowtravel.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class TourRatingTests {

	@Test
	public void testAverageRating1() {
			Tour tour = new Tour();
			
			Set<Review> reviews = new HashSet<>();
			Review review1 = new Review();
			review1.setRating(5);
			reviews.add(review1);
			
			tour.setReviews(reviews);
			
			float averageRating = tour.getAverageRating();
			
			assertEquals(5.0, averageRating, 0.0);		
	}
	
	@Test
	public void testAverageRating2() {
			Tour tour = new Tour();
			
			float averageRating = tour.getAverageRating();
			
			assertEquals(0.0, averageRating, 0.0);		
	}
	
	@Test
	public void testAverageRating3() {
			Tour tour = new Tour();
			
			Set<Review> reviews = new HashSet<>();
			Review review1 = new Review();
			review1.setRating(5);
			reviews.add(review1);
			
			Review review2 = new Review();
			review2.setRating(4);
			reviews.add(review2);
			
			Review review3 = new Review();
			review3.setRating(3);
			reviews.add(review3);
			
			tour.setReviews(reviews);
			
			float averageRating = tour.getAverageRating();
			
			assertEquals(4.0, averageRating, 0.0);		
	}

	@Test
	public void testRatingString1() {
		float averageRating = 0.0f;
		Tour tour = new Tour();
		String actual = tour.getRatingString(averageRating);
		
		String expected = "off,off,off,off,off";
		
		assertEquals(expected, actual);
	}

	@Test
	public void testRatingString2() {
		float averageRating = 3.0f;
		Tour tour = new Tour();
		String actual = tour.getRatingString(averageRating);
		
		String expected = "on,on,on,on,on";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRatingString3() {
		float averageRating = 3.0f;
		Tour tour = new Tour();
		String actual = tour.getRatingString(averageRating);
		
		String expected = "on,on,on,off,off";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRatingString4() {
		float averageRating = 4.5f;
		Tour tour = new Tour();
		String actual = tour.getRatingString(averageRating);
		
		String expected = "on,on,on,on,half";
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRatingString5() {
		float averageRating = 3.6f;
		Tour tour = new Tour();
		String actual = tour.getRatingString(averageRating);
		
		String expected = "on,on,on,half,off";
		
		assertEquals(expected, actual);
	}
}