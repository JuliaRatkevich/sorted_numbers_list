package com.julia;

import java.util.Arrays;

public class SortedNumbersList {

    private int[] source;

    public SortedNumbersList() {
        source = new int[0];
    }

    public SortedNumbersList(int[] array) {
        source = ArrayUtils.copyArray(array);

        ArrayUtils.selectionSort(source);
    }


    public void display() {
//        System.out.println();
//        for (int i = 0; i < source.length; i++) {
//            System.out.print(source[i] + " ");
        System.out.println(Arrays.toString(source));
        }


    public void add(int number) {
        source = ArrayUtils.append(source, number);
        ArrayUtils.selectionSort(source);
    }

    public int get(int index) {
        return source[index];
    }

    public int size() {
        return source.length;
    }

    public boolean remove(int number) {
        int[] newArray = new int[0];
        for ( int i = 0; i < source.length; i++) {
            if (source[i] == number) {
                continue;
            }
            newArray = ArrayUtils.append(newArray, source[i]);
        }
        boolean result = source.length != newArray.length;
        source = newArray;
        return result;
    }
//        int index = ArrayUtils.binarySearch(this.source, number);
//        if (index < 0)
//            return false;
//
//        int[] newSource = new int[this.source.length - 1];
//
//        for (int i = 0; i < index; i++) {
//            newSource[i] = this.source[i];
//        }
//
//        for (int i = index + 1; i < source.length; i++) {
//            newSource[i - 1] = source[i];
//        }
//        this.source = newSource;
//        return true;
//    }

    public void removeById(int index) {
        if (index > source.length - 1) {
            return;
        }

        int[] newArray = new int[source.length - 1];
        // записывает новый массив до индекса который нужно удалить
        for (int i = 0; i < index; i++) {
            newArray[i] = source[i];
        }
//        записывает массив эллементами из старого после индекса который нужно удалить
        for ( int i = index; i < newArray.length; i++) {
            newArray[i] = source[i + 1];
        }
        source = newArray;
    }

    public void removeRepeated() {
        // 0. Проверяем есть ли хотя бы 2 элемента в source иначе нечего удалять
        if (source.length < 2) {
            return;
        }
        // 1. Создаем хранилище для массива с удаленными повторяющимися элементами
        int[] newArray = new int[0];
        // 2. Устанавливаем элемент для проверки current = source[0]
        int current = source[0];
        // 3. Пробегаемся по всем элементам начиная со второго
        for ( int i = 1; i < source.length; i++) {
            // 4. Каждый элемент проверяем с current ->
            // 4.1 если равно то он являетяс повторяющимся элементом - ничего не делаем
            if (current == source[i]) {
                continue;
            }
            // 4.2 если не равно то это следующий уникальный элемент -> записываем в хранилище current
            newArray = ArrayUtils.append(newArray, current);
            // и обновляем значение current новым уникальным элементом
            current = source[i];
        }
        newArray = ArrayUtils.append(newArray, current);
        // 5. Обновляем source
        source = newArray;
    }


    /**
     * the method returns a new object of {@link SortedNumbersList} which is an intersection
     * of this and another
     * @param another
     * @return
     */

    public SortedNumbersList intersection(SortedNumbersList another) {
        int[] intersectionArray = new int[0];

        for ( int i = 0; i < source.length; i++) {
            int element = source[i];
//           если другой (another) содержит (contains) элемент
            if (another.contains(element)) {
                // тогда он часть пересечения - добавляем к intersectionArray
              intersectionArray = ArrayUtils.append(intersectionArray, element);
            }
        }

        SortedNumbersList result = new SortedNumbersList(intersectionArray);
        return result;
    }



    public SortedNumbersList union(SortedNumbersList another) {
        int[] newArray = new int[0];
        for (int i = 0; i < source.length; i++) {
            newArray = ArrayUtils.append(newArray, source[i]);
        }
        for (int j = 0; j < another.source.length; j++) {
            newArray = ArrayUtils.append(newArray, another.source[j]);
        }

        SortedNumbersList result = new SortedNumbersList(newArray);
        result.removeRepeated();

        return result;
    }


    public boolean contains(int number) {
        int result = ArrayUtils.binarySearch(source, number);
        if (result >= 0) {
            return true;
        }

        return false;
    }

}
