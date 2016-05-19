package net.spinel.hexcards.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Spinel on 16/5/19.
 */
public class Deck implements Serializable {
    private String name, tag, desc, hero, color;
    private int mainDeckCount, sideDeckCount;
    private List<Integer> lands, creatures, others, sideDeck;

    public Deck() {
    }

    public Deck(String name, String tag, String desc, String hero, String color, List<Integer> lands,
                List<Integer> creatures, List<Integer> others, List<Integer> sideDeck) {
        this.name = name;
        this.tag = tag;
        this.desc = desc;
        this.hero = hero;
        this.color = color;
        this.lands = lands;
        this.creatures = creatures;
        this.others = others;
        this.sideDeck = sideDeck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMainDeckCount() {
        return lands.size() + creatures.size() + others.size();
    }

    public int getSideDeckCount() {
        return sideDeck.size();
    }

    public List<Integer> getLands() {
        return lands;
    }

    public void setLands(List<Integer> lands) {
        this.lands = lands;
    }

    public List<Integer> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Integer> creatures) {
        this.creatures = creatures;
    }

    public List<Integer> getOthers() {
        return others;
    }

    public void setOthers(List<Integer> others) {
        this.others = others;
    }

    public List<Integer> getSideDeck() {
        return sideDeck;
    }

    public void setSideDeck(List<Integer> sideDeck) {
        this.sideDeck = sideDeck;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", desc='" + desc + '\'' +
                ", hero='" + hero + '\'' +
                ", mainDeckCount=" + mainDeckCount +
                ", sideDeckCount=" + sideDeckCount +
                ", lands=" + lands +
                ", creatures=" + creatures +
                ", others=" + others +
                ", sideDeck=" + sideDeck +
                '}';
    }
}
