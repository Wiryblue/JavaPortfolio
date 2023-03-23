package Section9_Classes_Inner_Abstract.Abstract;

import javax.swing.plaf.SpinnerUI;

public  abstract class Animal {
        String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat();

    public abstract void breathe();

    public String getName(){
        return name;
    }

}
