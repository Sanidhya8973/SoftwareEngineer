package _01__Understand_Problems_In_WebApp_Without_AOP.model.implementation;

import _01__Understand_Problems_In_WebApp_Without_AOP.model.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component("mrfTyres")
public class MrfTyres implements Tyres {

    private String name;

    public MrfTyres() {
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
