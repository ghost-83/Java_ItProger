public class Math {

    public int summ(int a, int b) {
        return a + b;
    }

    public int[] setArray(int... a) {
        int[] newArr = new int[a.length];
        for(short i = 0; i < a.length; i++)
            newArr[i] = a[i];
        return newArr;
    }

    public int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

}
