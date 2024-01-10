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

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }
}
