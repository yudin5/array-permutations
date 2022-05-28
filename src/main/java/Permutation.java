import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private static final List<List<String>> allArrays = new ArrayList<>();

    public static void main(String[] args) {
        String[] elements = new String[9]; // При добавлении элемента не забывать увеличивать массив
        elements[0] = "a";
        elements[1] = "b";
        elements[2] = "c";
        elements[3] = "d";
        elements[4] = "e";
        elements[5] = "f";
        elements[6] = "g";
        elements[7] = "h";
        elements[8] = "i";

        collectAllRecursive(elements.length, elements);
        System.out.println("allArrays = " + allArrays);
        System.out.println("total size = " + allArrays.size());
    }

    public static void collectAllRecursive(int n, String[] elements) {

        if (n == 1) {
            printArray(elements);
        } else {
            for (int i = 0; i < n - 1; i++) {
                collectAllRecursive(n - 1, elements);
                if (n % 2 == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
            collectAllRecursive(n - 1, elements);
        }
    }

    private static void swap(String[] input, int a, int b) {
        String tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    private static void printArray(String[] input) {
        List<String> nextArray = new ArrayList<>(Arrays.asList(input));
        allArrays.add(nextArray);
    }
}
