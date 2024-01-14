package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import DB.DBConnection;

public class OffersPieChart extends JFrame {

    private Connection con;

    public OffersPieChart() {
        setTitle("Offers Statistics by Sector");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        JPanel chartPanel = new JPanel();
        chartPanel.setPreferredSize(new Dimension(600, 400));
        chartPanel.setBorder(new EmptyBorder(50, 100, 100, 100));

        // Create and add Sector Pie Chart
        JFreeChart sectorPieChart = createSectorPieChart();
        ChartPanel sectorChartPanel = new ChartPanel(sectorPieChart);
        sectorChartPanel.setPreferredSize(new Dimension(500, 350));
        sectorChartPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        chartPanel.add(sectorChartPanel, BorderLayout.WEST);

        // Create and add City Pie Chart
        JFreeChart cityPieChart = createCityPieChart();
        ChartPanel cityChartPanel = new ChartPanel(cityPieChart);
        cityChartPanel.setPreferredSize(new Dimension(500, 350));
        cityChartPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        chartPanel.add(cityChartPanel, BorderLayout.EAST);

        add(cityChartPanel, BorderLayout.CENTER);
        OffersPieChart.this.setVisible(true);
    }

    private JFreeChart createSectorPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<String> sectors = getSectorList();

        for (String sector : sectors) {
            int offerCount = getOfferCountBySector(sector);
            dataset.setValue(sector, offerCount);
        }

        JFreeChart pieChart = ChartFactory.createPieChart("Percentage of Offers by Sector", dataset, true, true, false);
        configurePieChart(pieChart);

        return pieChart;
    }

    private JFreeChart createCityPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<String> cities = getCityList();

        for (String city : cities) {
            int offerCount = getOfferCountByCity(city);
            dataset.setValue(city, offerCount);
        }

        JFreeChart pieChart = ChartFactory.createPieChart("Percentage of Offers by City", dataset, true, true, false);
        configurePieChart(pieChart);

        return pieChart;
    }


    private void configurePieChart(JFreeChart pieChart) {
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setSectionPaint("Other", new Color(192, 192, 192));
        plot.setExplodePercent("Other", 0.2);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2})"));
        plot.setSectionOutlinesVisible(false);
        plot.setNoDataMessage("No data available");
        plot.setCircular(true);
    }

    private List<String> getSectorList() {
        List<String> sectors = new ArrayList<>();
        establishDatabaseConnection();

        try {
            String query = "SELECT DISTINCT sectors FROM Offre LIMIT 100";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        sectors.add(resultSet.getString("sectors"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            closeDatabaseConnection();
        }

        return sectors;
    }

    private List<String> getCityList() {
        List<String> cities = new ArrayList<>();
        establishDatabaseConnection();

        try {
            String query = "SELECT DISTINCT city FROM Offre LIMIT 100";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        cities.add(resultSet.getString("city"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            closeDatabaseConnection();
        }

        return cities;
    }

    private int getOfferCountByCity(String city) {
        int count = 0;
        establishDatabaseConnection();

        try {
            String query = "SELECT COUNT(*) AS count FROM Offre WHERE city = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, city);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        count = resultSet.getInt("count");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            closeDatabaseConnection();
        }
        return count;

    }

    private int getOfferCountBySector(String sector) {
        int count = 0;
        establishDatabaseConnection();

        try {
            String query = "SELECT COUNT(*) AS count FROM Offre WHERE sectors = ?";
            try (PreparedStatement statement = con.prepareStatement(query)) {
                statement.setString(1, sector);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        count = resultSet.getInt("count");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database connection
            closeDatabaseConnection();
        }

        return count;
    }

    private void establishDatabaseConnection() {
        try {
            con = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeDatabaseConnection() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(OffersPieChart::new);
    // }
}
