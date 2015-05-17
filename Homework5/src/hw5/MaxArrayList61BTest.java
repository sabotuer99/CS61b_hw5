package hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxArrayList61BTest {

	@Test
	public void Constructor_Default_NoException() {
		//Arrange
		//nothing to do
		
		//Act
		@SuppressWarnings("unused")
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		
		//Assert
		//nothing to do 
	}
	
	@Test
	public void Constructor_CalledWithValidCapacity_SuperConstructorCalled() {
		//Arrange
		//nothing to do
		
		//Act
		@SuppressWarnings("unused")
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>(10);
		
		//Assert
		//nothing to do 
	}
	
	@Test
	public void Add_OneNewItem_ReturnsTrue() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		
		//Act
		boolean result = test.add(1);
		
		//Assert
		assertTrue(result);
	}
	
	@Test
	public void Add_NullItem_ReturnsFalse() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		
		//Act
		boolean result = test.add(null);
		
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void Add_ItemSmaller_ReturnsFalse() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		test.add(2);
		
		//Act
		boolean result = test.add(1);
		
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void Add_ItemBigger_ReturnsTrue() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		test.add(2);
		
		//Act
		boolean result = test.add(3);
		
		//Assert
		assertTrue(result);
	}

	@Test
	public void Add_FourItemsAssendingOrder_AllAdded() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		
		//Act
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		
		//Assert
		assertTrue(test.contains(1));
		assertTrue(test.contains(2));
		assertTrue(test.contains(3));
		assertTrue(test.contains(4));
	}
	
	@Test
	public void Add_FourItemsDescendingOrder_OnlyLargestAdded() {
		//Arrange
		MaxArrayList61B<Integer> test = new MaxArrayList61B<Integer>();
		
		//Act
		test.add(4);
		test.add(3);
		test.add(2);
		test.add(1);
		
		//Assert
		assertFalse(test.contains(1));
		assertFalse(test.contains(2));
		assertFalse(test.contains(3));
		assertTrue(test.contains(4));
	}
	
}
