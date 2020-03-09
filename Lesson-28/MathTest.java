import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    static Math math = null;

    @BeforeAll
    public static void setUp() {
        math = new Math();
    }

    @AfterAll
    public static void tearDown() {
        math = null;
    }

    @Test
    //@RepeatedTest(5)
    @Tag("Array")
    public void testSetArray() {
        int[] arr = math.setArray(4, 6, 8, 10, 0);
        int[] expected = {4, 6, 8, 10, 0};
        assertArrayEquals(arr, expected);
    }

    @Nested
    @DisplayName("Производим простую математику")
    class SimpleMath {
        @Disabled
        @Test
        @DisplayName("Функция для суммирования")
        @Tag("Number")
        public void testSumm() {
            assertAll(
                    () -> assertEquals(12, math.summ(5, 7), "Сложение не работает"),
                    () -> assertNotEquals(12, 10)
            );
            //assert res == 12 : "Сложение не работает";
        }

        @Test
        @Tag("Number")
        public void testDivide() {
            assertEquals(5, math.divide(10, 2), "Деление не работает");
            assertThrows(ArithmeticException.class, () -> math.divide(5, 0));
        }
    }

}
