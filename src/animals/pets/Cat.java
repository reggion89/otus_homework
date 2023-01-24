package animals.pets;

import animals.AbsAnimal;

public class Cat extends AbsAnimal {

    @Override
    public String say() {
        System.out.println("Гав");
        return null;
    }
}
