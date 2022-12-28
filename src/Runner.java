import animals.AbsAnimal;
import animals.pets.Cat;
import com.sun.source.tree.CompoundAssignmentTree;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<AbsAnimal> ListOfAnimal = new ArrayList<>();

    public static void main(String... args) {
        String command = "";
        String choiseOfAnimal = "";
        do {
            System.out.println("Выберите один из пунктов меню, затем нажмите Enter");
            System.out.println("ADD");
            System.out.println("LIST");
            System.out.println("EXIT");
            command = scanner.next().toUpperCase().trim();
            boolean isCommandExist = false;
            for (CommandsData commandsData: CommandsData.values()){
                if (commandsData.name().equals(command)) {
                    isCommandExist = true;
                    break;
                }
            }
            if (!isCommandExist) {
                System.out.println("Введена неправильная команда");
                continue;
            }
            CommandsData commandsData = CommandsData.valueOf(command);
            switch (commandsData) {
                case ADD : {
                    boolean isAnimalExist = false;
                    do {
                    System.out.println("Какое животное хотите добавить?");
                    System.out.println("cat");
                    System.out.println("dog");
                    System.out.println("duck");
                    choiseOfAnimal = scanner.next().toUpperCase().trim();
                    for (AnimalTypeData animalData: AnimalTypeData.values()){
                        if (animalData.name().equals(choiseOfAnimal)) {
                            isAnimalExist = true;
                            break;
                        }
                    }
                    if (!isAnimalExist) {
                        System.out.println("Мы не можем добавить такое животное");
                    }
                    } while (!isAnimalExist);

                    AnimalTypeData animalType = AnimalTypeData.valueOf(choiseOfAnimal);
                    AbsAnimal animal = fillAnimanlData(animalType);
                    ListOfAnimal.add(animal);
                    animal.say();
                }
                case LIST : {
                    for (AbsAnimal animal: ListOfAnimal) {
                        System.out.println(animal.toString());
                    }
                    break;
                }
                case EXIT :
                    System.exit(0);
            }
        }while (true);
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
