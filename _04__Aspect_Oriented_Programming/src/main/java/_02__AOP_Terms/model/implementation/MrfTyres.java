package _02__AOP_Terms.model.implementation;

import _02__AOP_Terms.model.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component("mrfTyres")
public class MrfTyres implements Tyres {

    private final String name;

    public MrfTyres() {
        this.name = "MICHELIN TYRES";
    }

    public String getName() {
        return this.name;
    }

    public String rotateTyres() {
        return "> " + getName() + ": active";
    }

    public String stopRotatingTyres() {
        return "> " + getName() + ": de-active";
    }

}
