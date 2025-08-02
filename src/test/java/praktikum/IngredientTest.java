package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IngredientTest {

    @Test
    public void testGetters() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 50f);

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("hot sauce", ingredient.getName());
        assertEquals(50f, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testMockedIngredient() {
        Ingredient mockIngredient = mock(Ingredient.class);

        when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient.getName()).thenReturn("mock filling");
        when(mockIngredient.getPrice()).thenReturn(77.7f);

        assertEquals(IngredientType.FILLING, mockIngredient.getType());
        assertEquals("mock filling", mockIngredient.getName());
        assertEquals(77.7f, mockIngredient.getPrice(), 0.001);

        verify(mockIngredient, times(1)).getType();
        verify(mockIngredient, times(1)).getName();
        verify(mockIngredient, times(1)).getPrice();
    }
}
