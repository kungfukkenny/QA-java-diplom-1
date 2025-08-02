package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;
    private Burger burger;

    @Before
    public void setUp() {
        bun = new Bun("white bun", 50f);
        sauce = new Ingredient(IngredientType.SAUCE, "ketchup", 20f);
        filling = new Ingredient(IngredientType.FILLING, "cutlet", 80f);
        burger = new Burger();
        burger.setBuns(bun);
    }

    @Test
    public void testAddAndRemoveIngredients() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        assertEquals(2, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(filling, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientInvalidIndex() {
        burger.addIngredient(sauce);
        burger.removeIngredient(5); // выброс IndexOutOfBoundsException
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        burger.moveIngredient(0, 1);

        assertEquals(filling, burger.ingredients.get(0));
        assertEquals(sauce, burger.ingredients.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientInvalidIndex() {
        burger.addIngredient(sauce);
        burger.moveIngredient(1, 0); // выброс IndexOutOfBoundsException
    }

    @Test
    public void testGetPriceWithIngredients() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        // цена = булочка*2 + соус + начинка = 50*2 + 20 + 80 = 200
        assertEquals(200f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetPriceWithoutIngredients() {
        // цена = булочка*2 = 50*2 = 100
        assertEquals(100f, burger.getPrice(), 0.001);
    }

    @Test
    public void testGetReceiptFormat() {
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String receipt = burger.getReceipt();

        String expected = String.format(
                "(==== %s ====)%n= %s %s =%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(),
                sauce.getType().toString().toLowerCase(), sauce.getName(),
                filling.getType().toString().toLowerCase(), filling.getName(),
                bun.getName(),
                burger.getPrice());

        assertEquals(expected, receipt);
    }
}
