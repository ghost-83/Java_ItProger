import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    @Test
    public void testSumm() {
        Math math = new Math();
        assertEquals(12, math.summ(5, 7), "Сложение не работает");
        assertNotEquals(12, 10);
        //assert res == 12 : "Сложение не работает";
    }

    @Test
    public void testSetArray() {
        Math math = new Math();
        int[] arr = math.setArray(4, 6, 8, 10, 0);
        int[] expected = {4, 6, 8, 10, 0};
        assertArrayEquals(arr, expected);
    }

    @Test
    public void testDivide() {
        Math math = new Math();
        assertEquals(5, math.divide(10, 2), "Деление не работает");
        assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
    }

}
