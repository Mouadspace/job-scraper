package model;

public class Company {
    public int id_offre;
    public String CompanyAdresse;
    public String CompanyWebsite;
    public String CompanyName;
    public String CompanyDescription;

    public Company(int id_offre, String CompanyAdresse, String CompanyDescription, String CompanyWebsite, String CompanyName){
        this.id_offre = id_offre;
        this.CompanyAdresse = CompanyAdresse;
        this.CompanyDescription = CompanyDescription;
        this.CompanyWebsite = CompanyWebsite;
        this.CompanyName = CompanyName;
        
    }
}
