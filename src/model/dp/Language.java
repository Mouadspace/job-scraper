package model;


public class Language {
    public int id_offre;
    public String langueName;
    public String level;

    public Language(){}

    public Language(int id_offre, String langueName, String level){
        this.id_offre = id_offre;
        this.langueName = langueName;
        this.level = level;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getLangueName() {
        return langueName;
    }

    public void setLangueName(String langueName) {
        this.langueName = langueName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
