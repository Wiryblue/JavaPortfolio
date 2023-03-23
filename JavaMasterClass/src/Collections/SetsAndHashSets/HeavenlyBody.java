package Collections.SetsAndHashSets;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;



    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();

    }



    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }



    public boolean addSatellite(HeavenlyBody satellite){
        if(this.key.bodyType == BodyType.PLANET && satellite.isMoon()) {
            return this.satellites.add(satellite);
        }
        System.out.println("Cannot inserts moon on to non planet bodies /or only moon can be satellites");
        return false;
    }


    public boolean isMoon(){
        return this.key.bodyType == BodyType.MOON;
    }





    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public Key getKey() {
        return key;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
       if(obj instanceof HeavenlyBody){
           HeavenlyBody theObject = (HeavenlyBody) obj;
          return this.key.equals(theObject.getKey());
       }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyType bodyType){
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.key.getBodyType() + ": " + this.getOrbitalPeriod();
    }

    public String getName() {
        return getName();
    }

    public static final class Key{
        private String name;
        private BodyType bodyType;
        private Key(String name, BodyType bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.getName().equals(key.getName())){
                return (this.getBodyType() == key.getBodyType());
            }
            return false;
        }
    }

    public enum BodyType {
        STAR,
        MOON,
        PLANET


    }
}
