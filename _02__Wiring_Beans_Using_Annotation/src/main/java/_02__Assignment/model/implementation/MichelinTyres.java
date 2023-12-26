package _02__Assignment.model.implementation;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import _02__Assignment.model.interfaces.Tyres;

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
