package _01__Understand_Problems_In_WebApp_Without_AOP.model.implementation;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("michelinTyres")
@Primary
public class MichelinTyres implements Tyres {

    private final String name;

    public MichelinTyres() {
        this.name = "MICHELIN TYRES";
    }

    public String getName() {
        return this.name;
    }

    public String rotateTyres() {
        return "  > " + getName() + ": active";
    }

    public String stopRotatingTyres() {
        return "  > " + getName() + ": de-active";
    }

}
