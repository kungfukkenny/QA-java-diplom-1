package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testDatabaseInitialization() {
        Database database = new Database();

        assertNotNull(database.availableBuns());
        assertFalse(database.availableBuns().isEmpty());

        assertNotNull(database.availableIngredients());
        assertFalse(database.availableIngredients().isEmpty());

        // Проверка первых элементов на ожидаемые значения
        assertEquals("black bun", database.availableBuns().get(0).getName());
        assertEquals(100f, database.availableBuns().get(0).getPrice(), 0.001);

        assertEquals("hot sauce", database.availableIngredients().get(0).getName());
        assertEquals(100f, database.availableIngredients().get(0).getPrice(), 0.001);
    }
}
