package _11__Assignment.model.implementation;

import _11__Assignment.model.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres {

    private final String name = "MICHELIN";

    public String getName() {
        return name;
    }

    public String rotateTyres() {
        return "MICHELIN TYRES: active";
    }

}
