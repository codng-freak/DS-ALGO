package DataStructures.DynamicArray;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(10);
        int i = 1;
        while (i <= 10) {
            arr.add(i);
            i++;
        }
        arr.add(100);
        arr.set(4, 50);
        arr.removeAt(10);
        arr.remove(1);
        System.out.println(arr.toString());
    }
}
