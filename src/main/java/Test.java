import classes.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        java.util.List<Integer> integerList = new java.util.ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        java.util.LinkedList integerLinkedList = new java.util.LinkedList();
        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("ArrayList");
        System.out.println("добавление элемента");
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(integerList);
        System.out.println(arr);

        System.out.println("вставка элемента");
        integerList.add(1, 4);
        arr.add(1, 4);
        System.out.println(integerList);
        System.out.println(arr);

        System.out.println("замена");
        integerList.set(3, 5);
        arr.set(3, 5);
        System.out.println(integerList);
        System.out.println(arr);

        System.out.println("удаление элемента");
        integerList.remove(1);
        arr.remove(1);
        System.out.println(integerList);
        System.out.println(arr);

        System.out.println("поиск и извлечение элемента");
        System.out.println(integerList.get(1));
        System.out.println(arr.get(1));
        System.out.println(integerList.indexOf(2));
        System.out.println(arr.indexOf(2));

        System.out.println("информация");
        System.out.println(integerList.size());
        System.out.println(arr.size());

        System.out.println();

        System.out.println("LinkedList");
        System.out.println("добавление элемента");
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(1);
        integerLinkedList.add(5);
        integerLinkedList.add(4);
        integerLinkedList.add(6);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(6);
        System.out.println(integerLinkedList);
        System.out.println(list);

        System.out.println("вставка элемента");
        integerLinkedList.addFirst(7);
        list.addFirst(7);
        System.out.println(integerLinkedList);
        System.out.println(list);

        System.out.println("удаление элемента");
        integerLinkedList.remove(1);
        list.remove(1);
        System.out.println(integerLinkedList);
        System.out.println(list);

        integerLinkedList.removeFirst();
        integerLinkedList.removeLast();
        list.removeFirst();
        list.removeLast();
        System.out.println(integerLinkedList);
        System.out.println(list);

        System.out.println("поиск и извлечение элемента");
        System.out.println(integerLinkedList.get(2));
        System.out.println(list.get(2));
        System.out.println(integerLinkedList.indexOf(5));
        System.out.println(list.indexOf(5));

        System.out.println("информация");
        System.out.println(integerLinkedList.size());
        System.out.println(list.size());
    }
}
