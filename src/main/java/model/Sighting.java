package model;

import java.sql.Timestamp;

public class Sighting {
    private int id;
    private int animalId;
    private String ranger;
    private String location;

    public Sighting(int animalId, String ranger, String location, Timestamp lastSeen) {
        this.animalId = animalId;
        this.ranger = ranger;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sighting sighting = (Sighting) o;

        if (id != sighting.id) return false;
        if (animalId != sighting.animalId) return false;
        if (!ranger.equals(sighting.ranger)) return false;
        return location.equals(sighting.location);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + animalId;
        result = 31 * result + ranger.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
