import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcutatorTest {

    Calculator calc = null;

    ICalcutor iCalcutor = mock(ICalcutor.class);

    @BeforeAll
    public void setUp() {
        calc = new Calculator(iCalcutor);
    }

    @Test
    public void testMult() {
        when(iCalcutor.add(2, 3)).thenReturn(5);
        assertEquals(10, calc.mult(2, 3));
        verify(iCalcutor).add(2, 3);
    }

}
