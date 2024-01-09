package scraper;

import java.sql.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DB.DataBase;
import model.Company;
import model.Language;
import model.Offre;
import model.Skill;

public class Scrapper01 {
    public static List<Skill> listSkills = new ArrayList<Skill>(); // Table Skill
    public static List<Company> listCompanies = new ArrayList<Company>(); // Table Company
    public static List<Offre> listOffres = new ArrayList<Offre>(); // Table Offre
    public static List<Language> listLangues = new ArrayList<Language>(); // Table Langue

    public static String ReturnDatePublication(String DP){
        String[] textDP = DP.split(" ");
        String[] numberDate = textDP[2].split("\\.");
        String datePub = String.join("/", numberDate[0], numberDate[1], numberDate[2]);
        return datePub;
    }

    public static Language getLangueAndLevel(int id_offre, String langueScraped){
        String[] resultArray = langueScraped.split("›");
        String langueName = "";
        String level = "";
        // Check if the array has at least two parts
        if (resultArray.length >= 2) {
            langueName = resultArray[0];
            level = resultArray[1];
        } 
        return new Language(id_offre, langueName, level);
    }
    public static void main(String[] args) throws IOException {
        List<String> urls = new ArrayList<>();
        

        // Adding numbers from 1 to 30 to the list
        for (int i = 1; i <= 1; i++) {
            urls.add(String.valueOf(i));
        }
        int id_offre = 0;
        

         // -------------------------------
        for(String numberURL : urls){
            String url = "https://www.emploi.ma/recherche-jobs-maroc?page=" + numberURL;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements offres = doc.select(".row");
                int nbr_offre = 0;

                System.out.println("\n----------------------------------------------------------------");
                System.out.println("Jobs in Emploi.com");
                for(Element offre : offres){
                    nbr_offre = nbr_offre + 1;

                    String OffreLink = offre.select("h5 > a").attr("href");
                    Document urlSite = Jsoup.connect("https://www.emploi.ma/" + OffreLink).get(); // URL
                    String Title = urlSite.select("h1.title" ).text();
                    // Title does print a real value
                    String SiteName = "Emploi.ma"; // Site Name
                    String DatePublication = ReturnDatePublication(urlSite.select(".job-ad-publication-date" ).text()); // Date de publication
                    String Company = urlSite.select(".company-title").text(); // Nom d'entreprise
                    String WebSiteCompany = urlSite.select(".website-url").text(); // website 'entreprise
                    Elements InfoDuProfile = urlSite.select("li[role=presentation]");

                    // Description:
                    String urlDescription =  urlSite.select(".job-ad-company-description a").attr("href");
                    Document docDescription = Jsoup.connect("https://www.emploi.ma/" + urlDescription).get();
                    String Description = docDescription.select(".company-profile-description").text();
                    String delimiter = "Description de l'entreprise";
                    int startIndex = Description.indexOf(delimiter);
                    if (startIndex != -1) {
                        // Add the length of the delimiter to get the start index of the remaining text
                        startIndex += delimiter.length();

                        // Extract the rest of the text
                        Description = Description.substring(startIndex);
                    }
                    // ---------------------

                    // OffreDescription
                    Elements offreDescriptionElm = urlSite.select("div:has(span.ad-ss-title):first-child");
                    StringBuilder textContent = new StringBuilder();
                    for (Element element : offreDescriptionElm) {
                        textContent.append(element.text()).append("\n");
                    }
                    String OffreDescription = textContent.toString().trim();

                    // Criterie:
                    Elements criteriaElements = urlSite.select(".job-ad-criteria tr");
                    String nombreDePoste = urlSite.select(".job-ad-criteria tr:last-child td:last-child").text();
                    // -------------------

                    String ProfileRecherce = "";
                    for (Element Profile : InfoDuProfile) {
                        String profile = Profile.text();
                        ProfileRecherce = ProfileRecherce + " | " + profile;
                    }

                    String métier = ""; // Métier :
                    String SecteurActivité = ""; // Secteur d?activité :
                    String TypeDeContract = ""; // Type de contrat :
                    String Région = ""; // Région :
                    String Ville = ""; // Ville :
                    String NiveauExpérience = ""; //  Niveau d'expérience :
                    String NiveauEtudes = ""; // Niveau d'études :

                    for(Element criteria : criteriaElements){
                        String firstCell = criteria.select("td:first-child").text();
                        Elements lastCell = criteria.select(".field-item");
                        if(firstCell != ""){
                            for(Element fieldItem : lastCell){
                                String item = fieldItem.text();
                                switch (firstCell) {
                                    case "Métier :":
                                        métier = métier + item + ";";
                                        break;
                                    case "Secteur d´activité :":
                                        SecteurActivité = SecteurActivité + item + ";";
                                        break;
                                    case "Type de contrat :":
                                        TypeDeContract = TypeDeContract + item + ";";
                                        break;
                                    case "Région :":
                                        Région = Région + item + ";";
                                        break;
                                    case "Niveau d'expérience :":
                                        NiveauExpérience = NiveauExpérience + item + ";";
                                        break;
                                    case "Niveau d'études :":
                                        NiveauEtudes = NiveauEtudes + item + ";";
                                        break;
                                    case "Langues exigées :":
                                        listLangues.add(getLangueAndLevel(id_offre, item));
                                        break;
                                    case "Compétences clés :":
                                        listSkills.add(new Skill(id_offre, item, "hard"));
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        if (firstCell.trim().equals("Ville :")){
                            Ville = criteria.select("td:last-child").text();
                        }
                    }
                    String prefix = "Exerperience ";
                    NiveauExpérience = NiveauExpérience.substring(prefix.length());

                    // Write data to the cells in the row

                    // Save in the Classes
                    
                    // Offre
                    System.out.println(Title);
                    listOffres.add(new Offre(id_offre, 
                    Title,
                    "https://www.emploi.ma/" + OffreLink,  
                    SiteName,
                    DatePublication,
                    "",
                    OffreDescription,
                    Région,
                    Ville,
                    SecteurActivité,
                    métier,
                    TypeDeContract,
                    NiveauEtudes,
                    "",
                    NiveauExpérience,
                    ProfileRecherce,
                    "",
                    "",
                    "",
                    "",
                    "NON",
                    Integer.parseInt(nombreDePoste)));


                    // Company Table
                    listCompanies.add(new Company(id_offre, 
                    "", 
                    Description, 
                    WebSiteCompany, 
                    Company));

                    System.out.println("Info of Offer were added at Row Number: " + id_offre);
                    id_offre = id_offre + 1;
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Sleeping for 7 seconds");
                Thread.sleep(7000); // Sleep for 7 seconds (7 * 1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        insertDB();

    }

    public static void insertDB() {
        
        try {
            Statement smt = DataBase.getStatement();
            // Connection con = ConnectionManager.getConnection();
            // Statement smt = con.createStatement();
            String sql;
            for (Offre f : listOffres) {
                System.out.println(f.Title);
                sql = "INSERT INTO Offre (id_offre, Title, OffreLink, SiteName, PublicationDate, ApplyDate, OffreDescription, Region, City, Sectors, Occupation, ContractType, EducationLevel, Diploma, ExperienceLevel, SearchedProfile, PersonalityTraits, RecommandedCompetence, Salary, SocialAdvantages, RemoteWork, NumberOfPosts) VALUES (" +
                        f.id_offre + ", '" +
                        f.Title.replace("'", "''") + "', '" +
                        f.OffreLink.replace("'", "''") + "', '" +
                        f.SiteName.replace("'", "''") + "', '" +
                        f.PublicationDate.replace("'", "''") + "', '" +
                        f.ApplyDate.replace("'", "''") + "', '" +
                        f.OffreDescription.replace("'", "''") + "', '" +
                        f.Region.replace("'", "''") + "', '" +
                        f.City.replace("'", "''") + "', '" +
                        f.Sectors.replace("'", "''") + "', '" +
                        f.Occupation.replace("'", "''") + "', '" +
                        f.ContractType.replace("'", "''") + "', '" +
                        f.EducationLevel.replace("'", "''") + "', '" +
                        f.Diploma.replace("'", "''") + "', '" +
                        f.ExperienceLevel.replace("'", "''") + "', '" +
                        f.SearchedProfile.replace("'", "''") + "', '" +
                        f.PersonalityTraits.replace("'", "''") + "', '" +
                        f.RecommandedCompetence.replace("'", "''") + "', '" +
                        f.Salary.replace("'", "''") + "', '" +
                        f.SocialAdvantages.replace("'", "''") + "', '" +
                        f.RemoteWork.replace("'", "''") + "', " +
                        f.NumberOfPosts + ")";
                smt.executeUpdate(sql);
            }
            
            for (Skill s : listSkills) {
                sql = "INSERT INTO skill (id_offre, skillName, skillType) VALUES (" +
                        s.id_offre + ", '" +
                        s.skillName.replace("'", "''") + "', '" +
                        s.skillType.replace("'", "''") + "')";
                smt.executeUpdate(sql);
            }
            
            for (Company c : listCompanies) {
                sql = "INSERT INTO Company (id_offre, CompanyAdresse, CompanyWebsite, CompanyName, CompanyDescription) VALUES (" +
                        c.id_offre + ", '" +
                        c.CompanyAdresse.replace("'", "''") + "', '" +
                        c.CompanyWebsite.replace("'", "''") + "', '" +
                        c.CompanyName.replace("'", "''") + "', '" +
                        c.CompanyDescription.replace("'", "''") + "')";
                smt.executeUpdate(sql);
            }
            
            for (Language l : listLangues) {
                sql = "INSERT INTO Langue (id_offre, langueName, level) VALUES (" +
                        l.id_offre + ", '" +
                        l.langueName.replace("'", "''") + "', '" +
                        l.level.replace("'", "''") + "')";
                smt.executeUpdate(sql);
            }
} catch (SQLException e) {
    System.out.println("failed here");
    e.printStackTrace();
}

    }
}
