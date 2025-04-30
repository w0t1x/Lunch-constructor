package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static DinnerConstructor dinnerConstructor;
    public static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dinnerConstructor.addCourse(dishType, dishName);
        System.out.println("Блюдо \"" + dishName + "\" добавлено как \"" + dishType + "\".");
    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem;

        //реализуйте ввод типов блюд
        while (!(nextItem = scanner.nextLine()).isEmpty()) {
            if (!dinnerConstructor.checkType(nextItem)) {
                System.out.println("Тип блюда '" + nextItem + "' не найден. Попробуйте снова.");
                continue;
            }
            types.add(nextItem);
        }

        if (types.isEmpty()) {
            System.out.println("Необходимо указать хотя бы один тип блюда.");
            return;
        }

        ArrayList<ArrayList<String>> combos = dinnerConstructor.generateCombines(types, numberOfCombos);

        System.out.println("Сгенерированные комбинации:");
        for (int i = 0; i < combos.size(); i++) {
            System.out.print("Комбинация " + (i + 1) + ": ");
            System.out.println(String.join(", ", combos.get(i)));
        }
    }
}
