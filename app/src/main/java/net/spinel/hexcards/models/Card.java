package net.spinel.hexcards.models;

/**
 * Created by Spinel on 16/5/12.
 */
public class Card {
    private String ability;
    private String camp;
    private String card_no;
    private String color;
    private String cost;
    private int defense;
    private String desc;
    private boolean is_unique;
    private String name;
    private String name_en;
    private String rarity;
    private String requirement;
    private String subtype;
    private String type;
    private int power;

    public Card() {
    }

    public Card(String ability, String camp, String card_no, String color, String cost,
                int defense, String desc, boolean is_unique, String name, String name_en,
                String rarity, String requirement, String subtype, String type, int power) {
        this.ability = ability;
        this.camp = camp;
        this.card_no = card_no;
        this.color = color;
        this.cost = cost;
        this.defense = defense;
        this.desc = desc;
        this.is_unique = is_unique;
        this.name = name;
        this.name_en = name_en;
        this.rarity = rarity;
        this.requirement = requirement;
        this.subtype = subtype;
        this.type = type;
        this.power = power;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean is_unique() {
        return is_unique;
    }

    public void setIs_unique(boolean is_unique) {
        this.is_unique = is_unique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Card{" +
                "ability='" + ability + '\'' +
                ", camp='" + camp + '\'' +
                ", card_no='" + card_no + '\'' +
                ", color='" + color + '\'' +
                ", cost='" + cost + '\'' +
                ", defense=" + defense +
                ", desc='" + desc + '\'' +
                ", is_unique=" + is_unique +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                ", rarity='" + rarity + '\'' +
                ", requirement='" + requirement + '\'' +
                ", subtype='" + subtype + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                '}';
    }
}
