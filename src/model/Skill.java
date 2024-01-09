package model;


public class Skill {
    public int id_offre;
    public String skillName;
    public String skillType;
    
    public Skill(int id_offre, String skillName, String skillType){
        this.id_offre = id_offre;
        this.skillName = skillName;
        this.skillType = skillType;
    }
}
