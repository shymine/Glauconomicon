package shymine.glauconomicon.campaign;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Place {
    @Id @GeneratedValue
    private long id;

    private String name;

    private String description;

    @OneToMany(
            //cascade = CascadeType.ALL
    )
    private List<Item> items;

    @ManyToMany(
          //  cascade = CascadeType.PERSIST
    )
    private List<Character> npcs;

    public Place() {
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Place setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Place setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Place setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public Place setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public List<Character> getNpcs() {
        return npcs;
    }

    public Place setNpcs(List<Character> npcs) {
        this.npcs = npcs;
        return this;
    }

    public Place addItem(Item i) {
        this.items.add(i);
        return this;
    }

    public Place addNpcs(Character c) {
        this.npcs.add(c);
        return this;
    }
}
