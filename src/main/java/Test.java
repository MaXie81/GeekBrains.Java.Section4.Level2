import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // создание
        List<Integer> integerList = new ArrayList<>();
        classes.ArrayList<Integer> arr = new classes.ArrayList<>();

        // добавление
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(integerList);
        System.out.println(arr);

        // вставка
        integerList.add(1, 4);
        arr.add(1, 4);
        System.out.println(integerList);
        System.out.println(arr);

        // замена
        integerList.set(3, 5);
        arr.set(3, 5);
        System.out.println(integerList);
        System.out.println(arr);

        // удаление
        integerList.remove(1);
        arr.remove(1);
        System.out.println(integerList);
        System.out.println(arr);

        // поиск
        System.out.println(integerList.get(1));
        System.out.println(arr.get(1));
        System.out.println(integerList.indexOf(2));
        System.out.println(arr.indexOf(2));

        // информация
        System.out.println(integerList.size());
        System.out.println(arr.size());
    }
}
