package Collections.SetsAndHashSets.SetsChallenge;

import Collections.SetsAndHashSets.HeavenlyBody;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    public Planet(String name, double orbitalPeriod, HeavenlyBody.BodyType bodyType) {
        super(name, orbitalPeriod, bodyType);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        if(this.getKey().getBodyType() == BodyType.PLANET && satellite.isMoon()) {
            return super.addSatellite(satellite);
        }
        System.out.println("Cannot inserts moon on to non planet bodies /or only moon can be satellites");
        return false;
    }
}
