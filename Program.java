

public class Program {
    public static void main(String[] args) {
        DynamicArray<Integer> date = new DynamicArray<>();

        date.add(11);
        date.remove(0);
        date.add(11);
        date.add(11);
        date.add(11);
        date.removeAll(11);
        date.add(11);
        date.add(12);
        date.add(1);
        date.bubbleSort();
        date.insertionSort();
        date.selectionSort();
        date.set(0, 2);
        System.out.println(date.getMax());
        System.out.println(date.getMin());
        System.out.println(date.getSum());
        System.out.println(date.getProduct());
        System.out.println(date.indexOf(12));
        System.out.println(date.contains(11));
        System.out.println(date.get(0));
        System.out.println(date.size());
        System.out.println(date.toString());
    }


}
