package hw5;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void Get_KeyFound_ReturnsValue() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        
        //Act
        String result = um.get("Gracias");
        
        //Assert
        assertEquals("Dios Basado", result);
    }
    
    @Test
    public void Get_JapaneseKeyFound_ReturnsJapaneseValue() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("Спасибо", "Пожалуйста");
        um.put("ありがとう", "どう致しまして");
        um.put("Þakka þér fyrir", "Það var ekkert");
        um.put("Thank You", "You're Welcome");
        
        //Act
        String result = um.get("ありがとう");
        
        //Assert
        assertEquals("どう致しまして", result);
    }

    @Test
    public void RemoveK_KeyFound_ReturnsValueRemovesNode() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        
        //Act
        String removed = um.remove("Gracias");
        
        //Assert
        assertEquals("Dios Basado", removed);
        assertFalse(um.containsKey("Gracias"));
    }
    
    @Test
    public void RemoveKV_KeyFoundValDiff_DoNothing() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        
        //Act
        String removed = um.remove("Gracias", "Blarg");       
        
        //Assert
        assertEquals(null, removed);
        assertTrue(um.containsKey("Gracias"));
    }
    
    @Test
    public void RemoveKV_KeyValFoundVal_RemoveNodeReturnVal() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        
        //Act
        String removed = um.remove("Gracias", "Dios Basado");       
        
        //Assert
        assertEquals("Dios Basado", removed);
        assertFalse(um.containsKey("Gracias"));
    }
    
    @Test
    public void Size_OneKeyValue_ReturnsOne() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        
        //Act
        int result = um.size();       
        
        //Assert
        assertEquals(1, result);
    }
    
    @Test
    public void Size_FiveKeyValues_ReturnsFive() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("Спасибо", "Пожалуйста");
        um.put("ありがとう", "どう致しまして");
        um.put("Þakka þér fyrir", "Það var ekkert");
        um.put("Thank You", "You're Welcome");
        
        //Act
        int result = um.size();       
        
        //Assert
        assertEquals(5, result);
    }
    
    @Test
    public void Size_EmptyList_ReturnsZero() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        
        //Act
        int result = um.size();       
        
        //Assert
        assertEquals(0, result);
    }
    
    @Test
    public void Clear_FiveKeyValues_ClearsOutList() {
    	//Arrange
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        um.put("Спасибо", "Пожалуйста");
        um.put("ありがとう", "どう致しまして");
        um.put("Þakka þér fyrir", "Það var ekkert");
        um.put("Thank You", "You're Welcome");
        
        //Act
        um.clear();       
        
        //Assert
        assertEquals(0, um.size());
    }
    
    @Test
    public void IterNext_ThreeElements_ReturnsElements() {
    	//Arrange
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        
        //Act
        int[] results = new int[3];
        results[0] = umi.next();
        results[1] = umi.next();
        results[2] = umi.next();
        
        //Assert
        //Since ULLMap is unsorted, can't rely on order of next
        assertTrue(Arrays.toString(results).contains("0"));
        assertTrue(Arrays.toString(results).contains("1"));
        assertTrue(Arrays.toString(results).contains("2"));

    }
    
    @Test
    public void Invert_ThreeElements_ReturnsInvertedMap() {
    	//Arrange
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        
        //Act
        ULLMap<String, Integer> inverted = ULLMap.invert(um);
        int test1 = inverted.get("zero");
        int test2 = inverted.get("one");
        int test3 = inverted.get("two");
        
        //Assert
        //Since ULLMap is unsorted, can't rely on order of next
        assertEquals(0, test1);
        assertEquals(1, test2);
        assertEquals(2, test3);

    }

    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
} 