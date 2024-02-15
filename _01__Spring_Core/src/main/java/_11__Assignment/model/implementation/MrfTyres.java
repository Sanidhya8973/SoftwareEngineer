package _11__Assignment.model.implementation;

import _11__Assignment.model.interfaces.Tyres;
import org.springframework.stereotype.Component;

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
