package animals.pets;

import animals.AbsAnimal;

public class Cat extends AbsAnimal {

    @Override
    public String say() {
        return String.format("МяуМяу");
    }
}
