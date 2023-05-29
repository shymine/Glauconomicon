package shymine.glauconomicon.campaign;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Campaign {
    @Id @GeneratedValue
    private Long id;
    private String name;

    private String description;


    @OneToMany(
           // cascade = CascadeType.ALL
    )
    private List<Character> npcs;

    @OneToMany(
           // cascade = CascadeType.ALL
    )
    private List<Character> pcs;

    @OneToMany(
          //  cascade = CascadeType.ALL
    )
    private List<Place> places;

    public Campaign() {
        this.npcs = new ArrayList<>();
        this.pcs = new ArrayList<>();
        this.places = new ArrayList<>();
    }

    public Campaign setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Campaign setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Character> getNpcs() {
        return npcs;
    }

    public Campaign addNpc(Character c) {
        this.npcs.add(c);
        return this;
    }

    public List<Character> getPcs() {
        return pcs;
    }

    public Campaign addPc(Character c) {
        this.pcs.add(c);
        return this;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public Campaign addPlace(Place p) {
        this.places.add(p);
        return this;
    }

    public Campaign setNpcs(List<Character> npcs) {
        this.npcs = npcs;
        return this;
    }

    public Campaign setPcs(List<Character> pcs) {
        this.pcs = pcs;
        return this;
    }

    public Campaign setPlaces(List<Place> places) {
        this.places = places;
        return this;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", npcs=" + npcs +
                ", pcs=" + pcs +
                ", places=" + places +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(name, campaign.name) && Objects.equals(id, campaign.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
