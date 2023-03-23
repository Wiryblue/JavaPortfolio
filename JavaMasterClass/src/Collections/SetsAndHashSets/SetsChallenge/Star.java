package Collections.SetsAndHashSets.SetsChallenge;

import Collections.SetsAndHashSets.HeavenlyBody;

public class Star extends HeavenlyBody {

    public Star(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.STAR);
    }

    public Star(String name, double orbitalPeriod, BodyType bodyType) {
        super(name, orbitalPeriod, bodyType);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if(satellite.getKey().getBodyType() == BodyType.PLANET){
            super.addSatellite(satellite);
        }
        return false;
    }
}
