package animals.birds;

import animals.AbsAnimal;

public class Duck extends AbsAnimal implements IFlying{

    @Override
    public String say() {
        return String.format("Кря");
    }

    public void fly() {
        System.out.println("Я лечу");
    }

}
