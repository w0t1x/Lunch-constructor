package ru.practicum.dinner;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> menu = new HashMap<>();

    public void addCourse(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            menu.put(dishType, new ArrayList<>());
        }
        menu.get(dishType).add(dishName);
    }

    public boolean checkType(String type) {
        return menu.containsKey(type);
    }

    public ArrayList<ArrayList<String>> generateCombines(ArrayList<String> types, int count) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                if (!checkType(type)) {
                    System.out.println("Нет доступных блюд типа: " + type);
                }
                String randomDish = menu.get(type).get(random.nextInt(menu.get(type).size()));
                combo.add(randomDish);
            }
            combos.add(combo);
        }
        return combos;
    }
    
}
