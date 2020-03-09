import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    public void testSumm() {
        Math math = new Math();
        int res = math.summ(5, 7);
        assert res == 12 : "Сложение не работает";
    }

}
