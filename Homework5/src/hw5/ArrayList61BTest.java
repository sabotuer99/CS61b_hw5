package hw5;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/** ArrayList61BTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ArrayList61BTest {
    @Test
    public void Add_TwoIntegers_ContainsWorksProperly() {
    	//Arrange
        List<Integer> L = new ArrayList61B<Integer>();
        
        //Act
        L.add(5);
        L.add(10);
        
        //Assert
        assertTrue(L.contains(5));        
        assertFalse(L.contains(0));
    }
    
    @Test
    public void Size_100Elements_Returns100() {
    	//Arrange
        List<Integer> L = new ArrayList61B<Integer>(100);
        for(int i = 0; i < 100; i +=1){
        	L.add(0);
        }
        
        //Act
        int size = L.size();
        
        //Assert
        assertEquals(100, size);  
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void Constructor_InvalidCapacity_ThrowsException() {
    	//Arrange
    	//nothing to do
    	
    	//Act
        new ArrayList61B<Integer>(-1);
        
        //Assert
        //nothing to do
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void Get_IndexOutofRange_ThrowsException() {
    	//Arrange
    	List<Integer> L = new ArrayList61B<Integer>();
    	L.add(5);
        L.add(10);
    	
    	//Act
        L.get(2);
        
        //Assert
        //nothing to do
    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ArrayList61BTest.class);
    }
}   