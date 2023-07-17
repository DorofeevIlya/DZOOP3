package OOP3;
//Создать класс Контейнер - Container.
//        В контейнере могут быть ящики (класс Box).
//
//        У каждого ящика есть вес.
//        У каждого контейнера есть метод "получить вес" - это сумма всех весов ящиков, которые находятся в контейнере.
//
//        Класс Контейнер должен быть Comparable. Сравнивать он должен по весам контейнера (чем меньше вес, тем меньше контейнер).
//        Класс ContainerCountComparator - Comparator, который сравнивает контейнеры по количеству ящиков (чем меньше ящиков, тем меньше контейнер).
//        Класс контейнер должен быть Iterable - итерирование должно происходить по ящикам внутри контейнера.
//
//        Container c = new Container(...);
//// ...
//        for (Box box: c) {

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int a = 1 + (int) (Math.random() * 5);
        int b = 1 + (int) (Math.random() * 5);
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            arr1.add(rand.nextInt(1,20));
        }
        List<Integer> arr2 = new ArrayList<>();
        for (int j = 0; j < b; j++) {
            arr2.add(rand.nextInt(1,20));
        }
        Container cont1 = new Container(new ArrayList(convertToBoxList(arr1)));
        Container cont2 = new Container(new ArrayList(convertToBoxList(arr2)));
        System.out.println("Стандартный вывод: ");
        System.out.println(cont1 + "\n" + cont2);
        if (cont1.compareTo(cont2) == -1) {
            System.out.println("Результат метода Comparable: Первый контейнер меньше второго");
        }
        if (cont1.compareTo(cont2) == 1) {
            System.out.println("Результат метода Comparable: Первый контейнер больше второго");
        }
        if (cont1.compareTo(cont2) == 0) {
            System.out.println("Результат метода Comparable: Первый контейнер равен второму");
        }
        ContainerCountComparator containerComp = new ContainerCountComparator();
        if (containerComp.compare(cont1, cont2) == -1) {
            System.out.println("Результат метода ContainerCountComparator: Первый контейнер меньше второго");
        }
        if (containerComp.compare(cont1, cont2) == 1) {
            System.out.println("Результат метода ContainerCountComparator: Первый контейнер больше второго");
        }
        if (containerComp.compare(cont1, cont2) == 0) {
            System.out.println("Результат метода ContainerCountComparator: Первый контейнер равен второму");
        }
    }
    static List<Box> convertToBoxList(List<Integer> userArray) {
        List<Box> list = new ArrayList<>();
        for (int weight : userArray) {
        Box box = new Box (weight);
            list.add(box);
        }
        return list;
    }
    public static class ContainerCountComparator implements Comparator<Container> {
        @Override
        public int compare(Container o1, Container o2) {
            return Integer.compare(o1.getSize(), o2.getSize());
        }
    }
}
