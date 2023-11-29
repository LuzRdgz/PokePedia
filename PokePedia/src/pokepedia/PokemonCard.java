package pokepedia;

public class PokemonCard {
    private String name, type, imageUrl, HP, attack, defense, specialAttack, specialDefense, speed, ability;

    
    
    public PokemonCard(String n, String t, String iU, String hp, String att, String d, String sa, String sd, String s, 
    String a)
    {
        this.name = n;
        this.type = t;
        this.imageUrl = iU;
        this.HP = hp;
        this.attack = att;
        this.defense = d;
        this.specialAttack = sa;
        this.specialDefense = sd;
        this.speed = s;
        this.ability = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String t) {
        this.type = t;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String iU) {
        this.imageUrl = iU;
    }

    public String getHP() {
        return this.HP;
    }

    public void setHP(String hp) {
        this.HP = hp;
    }
    
      public String getAttack() {
        return this.attack;
    }

    public void setAttack(String att) {
        this.attack = att;
    }

    public String getDefense() {
        return this.defense;
    }

    public void setDefense(String d) {
        this.defense = d;
    }

    public String getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(String sa) {
        this.specialAttack = sa;
    }

    public String getSpecialDefense() {
        return this.specialDefense;
    }

    public void setSpecialDefense(String sd) {
        this.specialDefense = sd;
    }

    public String getSpeed() {
        return this.speed;
    }

    public void setSpeed(String s) {
        this.speed = s;
    }

    public String getAbility() {
        return this.ability;
    }

    public void setAbility(String a) {
        this.ability = a;
    }
    
    
    
}