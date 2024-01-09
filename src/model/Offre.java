package model;


public class Offre {
    public int id_offre;
    public String Title;
    public String OffreLink;
    public String SiteName;
    public String PublicationDate;
    public String ApplyDate;
    public String OffreDescription;
    public String Region;
    public String City;
    public String Sectors;
    public String Occupation;
    public String ContractType;
    public String EducationLevel;
    public String Diploma;
    public String ExperienceLevel;
    public String SearchedProfile;
    public String PersonalityTraits;
    public String RecommandedCompetence;
    public String Salary;
    public String SocialAdvantages;
    public String RemoteWork;
    public int NumberOfPosts;

    public Offre(int id_offre, 
     String Title,
     String OffreLink,  
     String SiteName,
     String PublicationDate,
     String ApplyDate,
     String OffreDescription,
     String Region,
     String City,
     String Sectors,
     String Occupation,
     String ContractType,
     String EducationLevel,
     String Diploma,
     String ExperienceLevel,
     String SearchedProfile,
     String PersonalityTraits,
     String RecommandedCompetence,
     String Salary,
     String SocialAdvantages,
     String RemoteWork,
     int NumberOfPosts) {
        this.id_offre = id_offre;
        this.Title = Title;
        this.OffreLink = OffreLink;
        this.SiteName = SiteName;
        this.PublicationDate = PublicationDate;
        this.ApplyDate = ApplyDate;
        this.OffreDescription = OffreDescription;
        this.Region = Region;
        this.City = City;
        this.Sectors = Sectors;
        this.Occupation = Occupation;
        this.ContractType = ContractType;
        this.EducationLevel = EducationLevel;
        this.Diploma = Diploma;
        this.ExperienceLevel = ExperienceLevel;
        this.SearchedProfile = SearchedProfile;
        this.PersonalityTraits = PersonalityTraits;
        this.RecommandedCompetence = RecommandedCompetence;
        this.Salary = Salary;
        this.SocialAdvantages = SocialAdvantages;
        this.RemoteWork = RemoteWork;
        this.NumberOfPosts = NumberOfPosts;
     }

}
