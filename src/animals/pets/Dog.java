package animals.pets;

import animals.AbsAnimal;

public class Dog extends AbsAnimal {

    @Override
    public String say() {
        System.out.println("Гав");
        return null;
    }
}
