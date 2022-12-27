package animals.pets;

import animals.AbsAnimal;

public class Dog extends AbsAnimal {

    @Override
    public String say() {
        return String.format("Гав");
    }
}
