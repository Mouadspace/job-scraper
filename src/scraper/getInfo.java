package scraper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DB.DBConnection;
import DB.DataBase;

public class getInfo {
    public static void main(String[] args) throws IOException {
        // Declear some varaibles:
        String sql;
        ResultSet rs;
        int number = 0;
        String condSiteName;
        String condCompanyName;
        String condRemoteWork;
        String condContractType;
        String condSector;
        String condCity;
        String sqlRequest;

        // Excel File Offre:
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Offre Data");
        int rowNum = 0;
        Row row = sheet.createRow(rowNum++);
        // Put the titles of the colones:
        row.createCell(0).setCellValue("Title");
        row.createCell(1).setCellValue("OffreLink");
        row.createCell(2).setCellValue("SiteName");
        row.createCell(3).setCellValue("DatePublication");
        row.createCell(4).setCellValue("ApplyDate"); 
        row.createCell(5).setCellValue("CompanyAdresse"); 
        row.createCell(6).setCellValue("WebSiteCompany");
        row.createCell(7).setCellValue("CompanyName");
        row.createCell(8).setCellValue("ComapanyDescription");
        row.createCell(9).setCellValue("OffreDescription"); 
        row.createCell(10).setCellValue("Region");
        row.createCell(11).setCellValue("City");
        row.createCell(12).setCellValue("Sectors");
        row.createCell(13).setCellValue("Occupation");
        row.createCell(14).setCellValue("ContractType");
        row.createCell(15).setCellValue("EducationLevel");
        row.createCell(16).setCellValue("Diploma"); 
        row.createCell(17).setCellValue("ExperienceLevel");
        row.createCell(18).setCellValue("SearchedProfile");
        row.createCell(19).setCellValue("PersonalityTraits"); 
        row.createCell(20).setCellValue("RecommandedCompetence"); 
        row.createCell(21).setCellValue("Salary"); 
        row.createCell(22).setCellValue("SocialAdvantages"); 
        row.createCell(23).setCellValue("RemoteWork"); 
        row.createCell(24).setCellValue("NumberOfPosts");
        // ------------------

        // Excel File Skills
        Workbook workbookSkill = new XSSFWorkbook();
        Sheet sheetSkill = workbookSkill.createSheet("Skill Data");
        int rowNumSkill = 0;
        Row rowSkill = sheetSkill.createRow(rowNumSkill++);
        // Put the titles of the colones:
        rowSkill.createCell(0).setCellValue("skillName");
        rowSkill.createCell(1).setCellValue("skillType");
        rowSkill.createCell(2).setCellValue("Repeated");
        // -----------------

        // Excel File Skills
        Workbook workbookLangue = new XSSFWorkbook();
        Sheet sheetLangue = workbookLangue.createSheet("Langue Data");
        int rowNumLangue = 0;
        Row rowLangue = sheetLangue.createRow(rowNumLangue++);
        // Put the titles of the colones:
        rowLangue.createCell(0).setCellValue("langueName");
        rowLangue.createCell(1).setCellValue("level");
        rowLangue.createCell(2).setCellValue("Repeated");
        // -----------------
        
        // list of criterias
        // We have things that user can input, like company name
        // things that the user can choose from, like Sectors, Region, City
        
        // SiteName
        List<String> sites = new ArrayList<String>();
        // CompanyName
        List<String> companies = new ArrayList<String>();
        // Region&City
        List<String> cities = Arrays.asList(
            "Agadir", "Casablanca", "Fes", "Marrakech", "Meknes",
            "Nador", "Ouarzazate", "Oujda", "Rabat", "Safi",
            "Salé", "Tanger", "Tetouan", "El Jadida", "Kenitra",
            "Laayoune", "Dakhla", "Tetouan", "Mohammedia", "Marrakesh",
            "Khouribga", "Temara", "Taza", "Larache", "Tan-Tan", "Al Hoceima",
            "Azrou", "Youssoufia", "Sefrou", "Taroudant", "Berkan"
        );
        // Sector & Occupation
        List<String> sectors = Arrays.asList(
            "Automobile", "matériels de transport", "réparation", "Immobilier", "architecture",
            "urbanisme", "Informatique", "SSII", "Internet", "Intérim",
            "recrutement", "Télécom", "Santé", "pharmacie", "Marketing",
            "communication", "média", "agriculture", "aquaculture", "Agroalimentaire",
            "Banque", "Assurance", "Finances", "Larache", "Ingénierie",
            "Aéronautique", "naval", "Education", "formation", "Distribution",
            "décoration", "nettyoge", "sécurité", "production", "Tourisme",
            "énergie", "BTP", "Import", "Administration publique", "logistique", "juridique",
            "commercial", "gestion des projets", "management"
        );
        // Occupation
        
        // ContractType
        List<String> contractTyps = Arrays.asList(
            "CDI", "Intérim", "CDD", "Freelance",
            "Stage"
        );
        // remoteWork
        List<String> remotWorks = Arrays.asList(
            "OUI", "NON", "HYBRIDE"
        );
        
        // Get the SiteName
        try {
            Statement smt = DataBase.getStatement();
            sql = "SELECT DISTINCT SiteName FROM offre;";
            rs = smt.executeQuery(sql);
            while (rs.next()) {
                sites.add(rs.getString("SiteName"));
            }
        } catch (Exception e) {
            System.out.println("Error getting site name");
        }

        // Get the CompanyName
        try {
            Statement smt = DataBase.getStatement();
            sql = "SELECT DISTINCT CompanyName FROM company WHERE CompanyName != '';";
            rs = smt.executeQuery(sql);
            while (rs.next()) {
                companies.add(rs.getString("CompanyName"));
            }
        } catch (Exception e) {
            System.out.println("Error getting comapny name");
        }
        
        
        // The user input

        // SiteName
        Scanner SiteNameScanner = new Scanner(System.in);
        System.out.println("Choose a website: ");
        System.out.println(number + " - All" );
        for (int i = 0; i < sites.size(); i++) {
            String s = sites.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        System.out.println("Enter the number of your choice: ");
        String userSiteName = SiteNameScanner.nextLine();
        if(userSiteName.equals("0")){
            condSiteName = "";
        } else {
            condSiteName = sites.get(Integer.parseInt(userSiteName)-1);
        }
        
        

        // CompanyName
        Scanner ComapnyNameScanner = new Scanner(System.in);
        System.out.println("Choose a company: ");
        number = 0;
        System.out.println(number + " - All" );
        for (int i = 0; i < companies.size(); i++) {
            String s = companies.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        System.out.println("Enter the number of your choice: ");
        String userCompanyName = ComapnyNameScanner.nextLine();
        if(userCompanyName.equals("0")){
            condCompanyName = "";
        } else {
            condCompanyName = companies.get(Integer.parseInt(userCompanyName)-1);
        }

        // City
        System.out.println("Enter the number of your choice: ");
        System.out.println("Choose a city: ");
        number = 0;
        System.out.println(number + " - All" );
        for (int i = 0; i < cities.size(); i++) {
            String s = cities.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        Scanner CityScanner = new Scanner(System.in);
        System.out.println("Type your city: ");
        String userCity = (CityScanner.nextLine());
        if(userCity.equals("0")){
            condCity = "";
        } else {
            condCity = (cities.get(Integer.parseInt(userCity)-1)).toLowerCase();
        }
        

        // Sectors
        System.out.println("Enter the number of your choice: ");
        System.out.println("Choose a sector: ");
        number = 0;
        System.out.println(number + " - All" );
        for (int i = 0; i < sectors.size(); i++) {
            String s = sectors.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        Scanner SectorScanner = new Scanner(System.in);
        System.out.println("Type your sector: ");
        String userSector = (SectorScanner.nextLine());
        if(userSector.equals("0")){
            condSector = "";
        } else {
            condSector = (sectors.get(Integer.parseInt(userSector)-1)).toLowerCase();
        }
        
        // ContractType
        System.out.println("Enter the number of your choice: ");
        System.out.println("Choose a type of contract: ");
        number = 0;
        System.out.println(number + " - All" );
        for (int i = 0; i < contractTyps.size(); i++) {
            String s = contractTyps.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        Scanner ContractTypeScanner = new Scanner(System.in);
        System.out.println("Type your sector: ");
        String userContractType = (ContractTypeScanner.nextLine());
        if(userContractType.equals("0")){
            condContractType = "";
        } else {
            condContractType = (contractTyps.get(Integer.parseInt(userContractType)-1)).toLowerCase();
        }

        // remotWorks
        System.out.println("Enter the number of your choice: ");
        System.out.println("Do you want remotwork: ");
        number = 0;
        System.out.println(number + " - Any" );
        for (int i = 0; i < remotWorks.size(); i++) {
            String s = remotWorks.get(i);
            number = i + 1;
            System.out.println(number + " - " + s);
        }
        Scanner RemoteWorkScanner = new Scanner(System.in);
        System.out.println("Do you want a remote job: ");
        String userRemoteWork = (RemoteWorkScanner.nextLine());
        if(userRemoteWork.equals("0")){
            condRemoteWork = "";
        } else {
            condRemoteWork = (remotWorks.get(Integer.parseInt(userRemoteWork)-1)).toLowerCase();
        }

        // Create the SQL Requests
        // String sitesNamesSelected = "Emploi.ma Rekrute.ma";
        List<String> sitesSelected = Arrays.asList(
            "Emploi.ma"
        );
        try  {
            Statement smt = DataBase.getStatement();
            List<String> id_offres = new ArrayList<String>();
            StringBuilder sqlRequestAll = new StringBuilder();
            sqlRequestAll.append("SELECT * FROM Offre o JOIN Company c ON c.id_offre = o.id_offre ");
            sqlRequestAll.append("WHERE o.id_offre IN (SELECT id_offre FROM offre WHERE LOWER(Region) LIKE ? OR LOWER(City) LIKE ?) ");
            sqlRequestAll.append("AND o.id_offre IN (SELECT id_offre FROM offre WHERE LOWER(Sectors) LIKE ? OR LOWER(Occupation) LIKE ?) ");
            sqlRequestAll.append("AND o.id_offre IN (SELECT id_offre FROM offre WHERE LOWER(ContractType) LIKE ?) ");
            sqlRequestAll.append("AND LOWER(RemoteWork) LIKE ? AND o.SiteName IN (");
        
            // Add placeholders for the IN clause
            for (int i = 0; i < sitesSelected.size(); i++) {
                sqlRequestAll.append("?");
                if (i < sitesSelected.size() - 1) {
                    sqlRequestAll.append(", ");
                }
            }
        
            sqlRequestAll.append(") AND c.CompanyName LIKE ?");
        
            try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sqlRequestAll.toString())) {
                // Set the values for the WHERE clauses
                pstmt.setString(1, "%" + condCity + "%");
                pstmt.setString(2, "%" + condCity + "%");
                pstmt.setString(3, "%" + condSector + "%");
                pstmt.setString(4, "%" + condSector + "%");
                pstmt.setString(5, "%" + condContractType + "%");
                pstmt.setString(6, "%" + condRemoteWork + "%");
        
                // Set the values for the IN clause based on the elements in sitesSelected
                int parameterIndex = 7;
                for (String site : sitesSelected) {
                    pstmt.setString(parameterIndex++, site);
                }
        
                pstmt.setString(parameterIndex, "%" + condCompanyName + "%");
        rs = pstmt.executeQuery();
                
        while (rs.next()) {

            id_offres.add(rs.getString("id_offre"));
            // System.out.println("id_offre: " + rs.getString("id_offre"));
            String Title = rs.getString("Title");
            String CompanyName = rs.getString("CompanyName");
            String PublicationDate = rs.getString("PublicationDate");
            String SiteName = rs.getString("SiteName");
            // ---------------
            String OffreLink = rs.getString("OffreLink");
            String ApplyDate = rs.getString("ApplyDate");
            String OffreDescription = rs.getString("OffreDescription");
            String Region = rs.getString("Region");
            String City = rs.getString("City");
            String Sectors = rs.getString("Sectors");
            String Occupation = rs.getString("Occupation");
            String ContractType = rs.getString("ContractType");
            String EducationLevel = rs.getString("EducationLevel");
            String Diploma = rs.getString("Diploma");
            String ExperienceLevel = rs.getString("ExperienceLevel");
            String SearchedProfile = rs.getString("SearchedProfile");
            String PersonalityTraits = rs.getString("PersonalityTraits");
            String RecommandedCompetence = rs.getString("RecommandedCompetence");
            String Salary = rs.getString("Salary");
            String SocialAdvantages = rs.getString("SocialAdvantages");
            String RemoteWork = rs.getString("RemoteWork");
            String NumberOfPosts = rs.getString("NumberOfPosts");
            String CompanyAdresse = rs.getString("ExperienceLevel");
            String CompanyWebsite = rs.getString("CompanyWebsite");
            String CompanyDescription = rs.getString("CompanyDescription");

            // Add to the Excel Offre
            row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(Title);
            row.createCell(1).setCellValue(OffreLink);
            row.createCell(2).setCellValue(SiteName);
            row.createCell(3).setCellValue(PublicationDate);
            row.createCell(4).setCellValue(ApplyDate); 
            row.createCell(5).setCellValue(CompanyAdresse); 
            row.createCell(6).setCellValue(CompanyWebsite);
            row.createCell(7).setCellValue(CompanyName);
            row.createCell(8).setCellValue(CompanyDescription);
            row.createCell(9).setCellValue(OffreDescription); 
            row.createCell(10).setCellValue(Region);
            row.createCell(11).setCellValue(City);
            row.createCell(12).setCellValue(Sectors);
            row.createCell(13).setCellValue(Occupation);
            row.createCell(14).setCellValue(ContractType);
            row.createCell(15).setCellValue(EducationLevel);
            row.createCell(16).setCellValue(Diploma); 
            row.createCell(17).setCellValue(ExperienceLevel);
            row.createCell(18).setCellValue(SearchedProfile);
            row.createCell(19).setCellValue(PersonalityTraits); 
            row.createCell(20).setCellValue(RecommandedCompetence); 
            row.createCell(21).setCellValue(Salary); 
            row.createCell(22).setCellValue(SocialAdvantages); 
            row.createCell(23).setCellValue(RemoteWork); 
            row.createCell(24).setCellValue(NumberOfPosts);
        }
        
        // Number of Offres: rowNum

        // Save the Excel File
        try (FileOutputStream fileOut = new FileOutputStream("offre.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully!");
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    // Generate the SQL for the second query
    StringBuilder sqlRequest2 = new StringBuilder();
    sqlRequest2.append("SELECT skillName, skillType, COUNT(*) AS count ");
    sqlRequest2.append("FROM skill ");
    sqlRequest2.append("WHERE id_offre IN (");

    // Add placeholders for the IN clause
    for (int i = 0; i < id_offres.size(); i++) {
        sqlRequest2.append("?");
        if (i < id_offres.size() - 1) {
            sqlRequest2.append(", ");
        }
    }

    sqlRequest2.append(") ");
    sqlRequest2.append("GROUP BY skillName, skillType;");

    try (PreparedStatement pstmt2 = DBConnection.getConnection().prepareStatement(sqlRequest2.toString())) {
        // Set the values for the IN clause based on the elements in id_offres
        for (int i = 0; i < id_offres.size(); i++) {
            pstmt2.setString(i + 1, id_offres.get(i));
        }

        ResultSet rs2 = pstmt2.executeQuery();

        while (rs2.next()) {
            String skillName = rs2.getString("skillName");
            String skillType = rs2.getString("skillType");
            int repeated = rs2.getInt("count");

            // Adding to the Excel Skill File
            rowSkill = sheetSkill.createRow(rowNumSkill++);

            rowSkill.createCell(0).setCellValue(skillName);
            rowSkill.createCell(1).setCellValue(skillType);
            rowSkill.createCell(2).setCellValue(repeated);
        }

        // Save the Excel File Skill
        try (FileOutputStream fileOut = new FileOutputStream("skill.xlsx")) {
            workbookSkill.write(fileOut);
            System.out.println("Excel file of Skills created successfully!");
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    System.out.println("\n---------------------------------------\nNecessary Languages for these Offers:");

    // Generate the SQL for the second query
    sqlRequest2 = new StringBuilder();
    sqlRequest2.append("SELECT langueName, level, COUNT(*) AS count ");
    sqlRequest2.append("FROM langue ");
    sqlRequest2.append("WHERE id_offre IN (");

    // Add placeholders for the IN clause
    for (int i = 0; i < id_offres.size(); i++) {
        sqlRequest2.append("?");
        if (i < id_offres.size() - 1) {
            sqlRequest2.append(", ");
        }
    }

    sqlRequest2.append(") ");
    sqlRequest2.append("GROUP BY langueName, level;");

    try (PreparedStatement pstmt2 = DBConnection.getConnection().prepareStatement(sqlRequest2.toString())) {
        // Set the values for the IN clause based on the elements in id_offres
        for (int i = 0; i < id_offres.size(); i++) {
            pstmt2.setString(i + 1, id_offres.get(i));
        }

        ResultSet rs2 = pstmt2.executeQuery();

        while (rs2.next()) {
            String langueName = rs2.getString("langueName");
            String level = rs2.getString("level");
            int repeated = rs2.getInt("count");

            // Adding to the Excel Langue File
            rowLangue = sheetLangue.createRow(rowNumLangue++);

            rowLangue.createCell(0).setCellValue(langueName);
            rowLangue.createCell(1).setCellValue(level);
            rowLangue.createCell(2).setCellValue(repeated);
        }

        // Save the Excel File Langue
        try (FileOutputStream fileOut = new FileOutputStream("Langue.xlsx")) {
            workbookLangue.write(fileOut);
            System.out.println("Excel file of Langues created successfully!");
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        // Close Workbooks of Excel File
        // Close the workbook for Offre
        workbook.close();
        // Close the workbook for Skill
        workbookSkill.close();
        // Close the workbook for Langue
        workbookLangue.close();
    }

} catch (SQLException e) {
    e.printStackTrace();
}


        // Close the Scanners
        RemoteWorkScanner.close();
        ContractTypeScanner.close();
        SectorScanner.close();
        CityScanner.close();
        ComapnyNameScanner.close();
        SiteNameScanner.close();

    }
}
