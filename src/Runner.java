import animals.AbsAnimal;
import animals.pets.Cat;
import com.sun.source.tree.CompoundAssignmentTree;
import data.AnimalTypeData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        String command;
        ArrayList<AnimalTypeData> ListOfAnimal = new ArrayList<>();
        String choiseOfAnimal;
        AbsAnimal animal = null;

        do {
            System.out.println("Выберите один из пунктов меню, затем нажмите Enter");
            System.out.println("ADD");
            System.out.println("LIST");
            System.out.println("EXIT");

            command = scanner.nextLine().toUpperCase().trim();
            switch (command) {
                case "ADD" : {
                    System.out.println("Какое животное хотите добавить?");
                    System.out.println("cat");
                    System.out.println("dog");
                    System.out.println("duck");
                    choiseOfAnimal = scanner.nextLine().toLowerCase().trim();
                }
                    switch (choiseOfAnimal) {
                        case "cat": {
                            ListOfAnimal.add(AnimalTypeData.CAT);
                            animal.say();
                            break;
                        }
                        case "dog": {
                            ListOfAnimal.add(AnimalTypeData.DOG);
                            animal.say();
                            break;
                        }
                        case "duck": {
                            ListOfAnimal.add(AnimalTypeData.DUCK);
                            animal.say();
                            break;
                        }
                        default:
                            System.out.println("Введенное животное не распознано");
                            break;
                    }



//                    ListOfAnimal.add()AbsAnimal animal = fillAnimanlData(AnimalTypeData.CAT);
                case "LIST" :
            }

        }while (true);


//        AbsAnimal animal = fillAnimanlData(AnimalTypeData.CAT);


    }

    private static AbsAnimal fillAnimanlData (AnimalTypeData animalTypeData) {
        AnimalFactory animalFactory = new AnimalFactory();

        AbsAnimal animal = animalFactory.create(animalTypeData);

        System.out.println("Как зовут животное?");
        animal.setName(scanner.next());

        System.out.println("Какой цвет у животного?");
        animal.setColor(scanner.next());

        System.out.println("Какой возраст у животного?");
        String ageStr = scanner.next();
        while(!isNumber(ageStr)) {
            System.out.println("Введен не верный возраст");
            System.out.println("Повторите ввод");
            ageStr = scanner.next();
        }

        animal.setAge(Integer.parseInt(ageStr));

        System.out.println("Какой вес у животного?");
        String weightStr = scanner.next();
        while(!isNumber(weightStr)) {
            System.out.println("Введен не верный вес");
            System.out.println("Повторите ввод");
            weightStr = scanner.next();
        }

        animal.setWeight(Integer.parseInt(weightStr));

        return animal;

    }
    private static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ignoring) {
            return false;
        }
    }
}
