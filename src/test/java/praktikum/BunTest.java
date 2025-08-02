package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BunTest {

    @Test
    public void testGetNameAndPrice() {
        Bun bun = new Bun("black bun", 100f);

        assertEquals("black bun", bun.getName());
        assertEquals(100f, bun.getPrice(), 0.001);
    }

    @Test
    public void testMockedBun() {
        Bun mockBun = mock(Bun.class);

        when(mockBun.getName()).thenReturn("mock bun");
        when(mockBun.getPrice()).thenReturn(123.45f);

        assertEquals("mock bun", mockBun.getName());
        assertEquals(123.45f, mockBun.getPrice(), 0.001);

        verify(mockBun, times(1)).getName();
        verify(mockBun, times(1)).getPrice();
    }
}
