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

   public int getId_offre() {
      return id_offre;
   }

   public void setId_offre(int id_offre) {
      this.id_offre = id_offre;
   }

   public String getTitle() {
      return Title;
   }

   public void setTitle(String title) {
      Title = title;
   }

   public String getOffreLink() {
      return OffreLink;
   }

   public void setOffreLink(String offreLink) {
      OffreLink = offreLink;
   }

   public String getSiteName() {
      return SiteName;
   }

   public void setSiteName(String siteName) {
      SiteName = siteName;
   }

   public String getPublicationDate() {
      return PublicationDate;
   }

   public void setPublicationDate(String publicationDate) {
      PublicationDate = publicationDate;
   }

   public String getApplyDate() {
      return ApplyDate;
   }

   public void setApplyDate(String applyDate) {
      ApplyDate = applyDate;
   }

   public String getOffreDescription() {
      return OffreDescription;
   }

   public void setOffreDescription(String offreDescription) {
      OffreDescription = offreDescription;
   }

   public String getRegion() {
      return Region;
   }

   public void setRegion(String region) {
      Region = region;
   }

   public String getCity() {
      return City;
   }

   public void setCity(String city) {
      City = city;
   }

   public String getSectors() {
      return Sectors;
   }

   public void setSectors(String sectors) {
      Sectors = sectors;
   }

   public String getOccupation() {
      return Occupation;
   }

   public void setOccupation(String occupation) {
      Occupation = occupation;
   }

   public String getContractType() {
      return ContractType;
   }

   public void setContractType(String contractType) {
      ContractType = contractType;
   }

   public String getEducationLevel() {
      return EducationLevel;
   }

   public void setEducationLevel(String educationLevel) {
      EducationLevel = educationLevel;
   }

   public String getDiploma() {
      return Diploma;
   }

   public void setDiploma(String diploma) {
      Diploma = diploma;
   }

   public String getExperienceLevel() {
      return ExperienceLevel;
   }

   public void setExperienceLevel(String experienceLevel) {
      ExperienceLevel = experienceLevel;
   }

   public String getSearchedProfile() {
      return SearchedProfile;
   }

   public void setSearchedProfile(String searchedProfile) {
      SearchedProfile = searchedProfile;
   }

   public String getPersonalityTraits() {
      return PersonalityTraits;
   }

   public void setPersonalityTraits(String personalityTraits) {
      PersonalityTraits = personalityTraits;
   }

   public String getRecommandedCompetence() {
      return RecommandedCompetence;
   }

   public void setRecommandedCompetence(String recommandedCompetence) {
      RecommandedCompetence = recommandedCompetence;
   }

   public String getSalary() {
      return Salary;
   }

   public void setSalary(String salary) {
      Salary = salary;
   }

   public String getSocialAdvantages() {
      return SocialAdvantages;
   }

   public void setSocialAdvantages(String socialAdvantages) {
      SocialAdvantages = socialAdvantages;
   }

   public String getRemoteWork() {
      return RemoteWork;
   }

   public void setRemoteWork(String remoteWork) {
      RemoteWork = remoteWork;
   }

   public int getNumberOfPosts() {
      return NumberOfPosts;
   }

   public void setNumberOfPosts(int numberOfPosts) {
      NumberOfPosts = numberOfPosts;
   }

}
