package _02__Design_Principles._04__interface_segregation_principle;

public interface Keyboard {

    public abstract Integer press(Character c);

    public abstract Integer[] combination(Character... c);

}