package net.spinel.hexcards.models;

/**
 * Created by Spinel on 16/5/12 下午6:22.
 * Card Model
 */
public class Card {
    private String version;
    private int card_no;
    private String color;
    private String name;
    private String name_en;
    private int cost;
    private String requirement;
    private int power;
    private int defense;
    private boolean is_unique;
    private String type;
    private String subtype;
    private String rarity;
    private String camp;
    private String rule;
    private String description;
    // perfix as "http://query.hex.wanmei.com/upload/cardOriImgFile/"
    private String img_url;

    public Card() {
    }

    public Card(String version, int card_no, String color, String name, String name_en, int cost,
                String requirement, int power, int defense, boolean is_unique, String type,
                String subtype, String rarity, String camp, String rule, String description, String img_url) {
        this.version = version;
        this.card_no = card_no;
        this.color = color;
        this.name = name;
        this.name_en = name_en;
        this.cost = cost;
        this.requirement = requirement;
        this.power = power;
        this.defense = defense;
        this.is_unique = is_unique;
        this.type = type;
        this.subtype = subtype;
        this.rarity = rarity;
        this.camp = camp;
        this.rule = rule;
        this.description = description;
        this.img_url = img_url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getCard_no() {
        return card_no;
    }

    public void setCard_no(int card_no) {
        this.card_no = card_no;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean is_unique() {
        return is_unique;
    }

    public void setIs_unique(boolean is_unique) {
        this.is_unique = is_unique;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCamp() {
        return camp;
    }

    public void setCamp(String camp) {
        this.camp = camp;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Card{" +
                "version='" + version + '\'' +
                ", card_no=" + card_no +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", name_en='" + name_en + '\'' +
                ", cost=" + cost +
                ", requirement='" + requirement + '\'' +
                ", power=" + power +
                ", defense=" + defense +
                ", is_unique=" + is_unique +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                ", rarity='" + rarity + '\'' +
                ", camp='" + camp + '\'' +
                ", rule='" + rule + '\'' +
                ", description='" + description + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
