package model;

public class Company {
    public int id_offre;
    public String CompanyAdresse;
    public String CompanyWebsite;
    public String CompanyName;
    public String CompanyDescription;

    public Company(){
        
    }

    public Company(int id_offre, String CompanyAdresse, String CompanyDescription, String CompanyWebsite, String CompanyName){
        this.id_offre = id_offre;
        this.CompanyAdresse = CompanyAdresse;
        this.CompanyDescription = CompanyDescription;
        this.CompanyWebsite = CompanyWebsite;
        this.CompanyName = CompanyName;
        
    }

    public int getId_offre() {
        return id_offre;
    }

    public String getCompanyAdresse() {
        return CompanyAdresse;
    }

    public String getCompanyWebsite() {
        return CompanyWebsite;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getCompanyDescription() {
        return CompanyDescription;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setCompanyAdresse(String companyAdresse) {
        CompanyAdresse = companyAdresse;
    }

    public void setCompanyWebsite(String companyWebsite) {
        CompanyWebsite = companyWebsite;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setCompanyDescription(String companyDescription) {
        CompanyDescription = companyDescription;
    }
}
