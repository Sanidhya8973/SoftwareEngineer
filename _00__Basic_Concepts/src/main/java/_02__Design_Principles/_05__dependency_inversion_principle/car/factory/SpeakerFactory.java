package _02__Design_Principles._05__dependency_inversion_principle.car.factory;

import _02__Design_Principles._05__dependency_inversion_principle.car.model.speakers_brand.BoseSpeakers;
import _02__Design_Principles._05__dependency_inversion_principle.car.model.speakers_brand.SonySpeakers;
import _02__Design_Principles._05__dependency_inversion_principle.car.model.speakers_brand.Speakers;

public class SpeakerFactory {

    public Speakers getSpeakers(String speakersBrand) {
        if (speakersBrand == null) {
            return null;
        } else if (speakersBrand.equalsIgnoreCase("SONY")) {
            return new SonySpeakers();
        } else if (speakersBrand.equalsIgnoreCase("BOSE")) {
            return new BoseSpeakers();
        } else {
            return null;
        }
    }

}
