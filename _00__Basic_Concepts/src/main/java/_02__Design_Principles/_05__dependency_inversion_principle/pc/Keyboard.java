package _02__Design_Principles._05__dependency_inversion_principle.pc;

public interface Keyboard {

    public abstract Integer press(Character c);

    public abstract Integer[] combination(Character... c);

}
