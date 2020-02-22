public class Main {
    public static void main(String[] args) {

        int[][] x = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };

        System.out.print("Результат первой задачи: ");
        printInt(sum());
        System.out.print("Результат второй задачи: ");
        printInt(element(x));
    }

    public static int sum (){
        int result = 0;
        for (int i = 1; i <= 1000; i++){
            if (i % 3 == 0)
                result += i;
            else if (i % 5 == 0)
                result += i;
        }
        return result;
    }

    public static int element(int arr[][]){
        int result = arr[0][0];
        for (int[] arrList : arr)
            for (int elementArr : arrList)
                if (result > elementArr)
                    result = elementArr;
        return result;
    }

    public static void printInt (int res){
        System.out.println(res);
    }
}
