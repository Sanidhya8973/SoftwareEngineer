package _01__Dependency_Injection.factory;

import _01__Dependency_Injection.model.tyres_brand.MichelinTyres;
import _01__Dependency_Injection.model.tyres_brand.MrfTyres;
import _01__Dependency_Injection.model.tyres_brand.Tyres;

public class TyreFactory {

    public Tyres getTyres(String tyresBrand) {
        if (tyresBrand == null) {
            return null;
        } else if (tyresBrand.equalsIgnoreCase("MICHELIN")) {
            return new MichelinTyres();
        } else if (tyresBrand.equalsIgnoreCase("MRF")) {
            return new MrfTyres();
        } else {
            return null;
        }
    }

}
