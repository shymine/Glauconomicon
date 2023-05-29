package shymine.glauconomicon.campaign;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Character {

    @Id @GeneratedValue
    private long id;
    private String name;

    @ElementCollection
    private Map<String, Integer> abilities;

    @ManyToMany(
           // cascade = CascadeType.ALL
    )
    private List<Item> equipment;

    private String background;

    public Character(String name, Map<String, Integer> abilities, List<Item> equipment, String background) {
        this.name = name;
        this.abilities = abilities;
        this.equipment = equipment;
        this.background = background;
    }

    public Character() {
        this.name = "";
        this.abilities = new HashMap<>();
        this.equipment = new ArrayList<>();
        this.background = "";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getAbilities() {
        return abilities;
    }

    public List<Item> getEquipment() {
        return equipment;
    }

    public String getBackground() {
        return background;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public Character setBackground(String background) {
        this.background = background;
        return this;
    }

    public Character setAbilities(Map<String, Integer> abilities) {
        this.abilities = abilities;
        return this;
    }

    public Character setEquipment(List<Item> equipment) {
        this.equipment = equipment;
        return this;
    }

    public Character addAbility(String s, Integer i) {
        this.abilities.put(s,i);
        return this;
    }

    public Character addEquipment(Item i) {
        this.equipment.add(i);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(name, character.name) && Objects.equals(abilities, character.abilities) && Objects.equals(equipment, character.equipment) && Objects.equals(background, character.background);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, abilities, equipment, background);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", abilities=" + abilities +
                ", equipment=" + equipment +
                ", background='" + background + '\'' +
                '}';
    }
}
