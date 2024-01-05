package _02__AOP_Terms.model.implementation;

import _02__AOP_Terms.model.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component("michelinTyres")
public class MichelinTyres implements Tyres {

    private final String name;

    public MichelinTyres() {
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
