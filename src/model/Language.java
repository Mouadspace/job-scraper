package model;


public class Language {
    public int id_offre;
    public String langueName;
    public String level;

    public Language(int id_offre, String langueName, String level){
        this.id_offre = id_offre;
        this.langueName = langueName;
        this.level = level;
    }
}
