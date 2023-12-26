package _01__Dependency_Injection.factory;

import _01__Dependency_Injection.model.speakers_brand.BoseSpeakers;
import _01__Dependency_Injection.model.speakers_brand.SonySpeakers;
import _01__Dependency_Injection.model.speakers_brand.Speakers;

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
