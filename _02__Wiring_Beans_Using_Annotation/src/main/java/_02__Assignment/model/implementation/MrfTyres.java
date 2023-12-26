package _02__Assignment.model.implementation;

import org.springframework.stereotype.Component;
import _02__Assignment.model.interfaces.Tyres;

@Component
public class MrfTyres implements Tyres {

    private final String name = "MRF";

    public String getName() {
        return name;
    }

    public String rotateTyres() {
        return "MRF TYRES: active";
    }

}
