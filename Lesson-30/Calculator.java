public class Calculator {

    ICalcutor iCalcutor;

    public Calculator(ICalcutor iCalcutor) {
        this.iCalcutor = iCalcutor;
    }

    public int mult(int a, int b) {
        return iCalcutor.add(a, b) * 2;
        //return (a + b) * 2;
    }

}
