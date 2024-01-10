package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mswing.CustomButton;
import mswing.CustomCheckbox;
import mswing.CustomComboBox;
import mswing.CustomField;
import mswing.CustomFrame;
import mswing.CustomPanel;

public class Home implements MouseListener,ActionListener{
  CustomFrame frame;
  JPanel topPanel ;
  JPanel sidePanel;
  JPanel mainPanel;
  CardLayout  cardLayout;
  JLabel sidepanelLabel1;
  JLabel sidepanelLabel2;
  JLabel sidepanelLabel3;
  CustomField searchField;
  CustomButton submitButton;

  CustomCheckbox c1;
  CustomCheckbox c2;
  CustomCheckbox c3;
  CustomCheckbox c4;



  public Home(){
    // BORDERS
    Border buttomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xcccccc));
    Border rightBorder = BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0xcccccc));
    Border emptyBorder = BorderFactory.createEmptyBorder(20, 20, 20, 40);


    frame = new CustomFrame();
    frame.setSize(800,580);
    frame.setLocationRelativeTo(null);

    topPanel = new JPanel();
    sidePanel = new JPanel();
    mainPanel = new JPanel();

    
    // MAIN PANEL (CARD LAYOUT)
    mainPanel.setBackground(new Color(0xF1F3F5));
    cardLayout = new CardLayout();
    mainPanel.setLayout(cardLayout);
    
    // CARDS OF MAIN PANEL 
    JPanel card1 = new JPanel();
    JPanel card2 = new JPanel();
    JPanel card3 = new JPanel();

    // ADDING CARDS TO MAIN PANEL
    mainPanel.add(card1,"card 1");
    mainPanel.add(card2,"card 2");
    mainPanel.add(card3,"card 3");
    
    // DEFAULT CARD = CARD 1 = CLASSIC SEARCH
    cardLayout.show(mainPanel,"card 1");


    FlowLayout fl = new FlowLayout();
    fl.setVgap(10);
    fl.setHgap(30);
    card1.setLayout(new BorderLayout());
    
    // CLASSIC SEARCH
    // new OfferCard(card1,new Color(0x74C0FC),"UI/UX designer","Google");
    // new OfferCard(card1,new Color(0xFFE066),"Datascientest","Airbnb");
    // new OfferCard(card1,new Color(0xC0EB75),"U");
    // new OfferCard(card1,new Color(0xC0EB75),"U");

    searchField = new CustomField();
    searchField.setPreferredSize(new Dimension(300,35));
    submitButton = new CustomButton();
    submitButton.setText("Find Job");
    submitButton.setBorder(new EmptyBorder(10, 10, 10, 10));
    submitButton.setBackground(new Color(0x6A70E0));
    submitButton.setBorderRadius(16);
    submitButton.setForeground(Color.WHITE);
    submitButton.addActionListener(this);


    c1 = new CustomCheckbox();
    c2 = new CustomCheckbox();
    c3 = new CustomCheckbox();
    c4 = new CustomCheckbox();

    c1.setText("rekrute.com");
    c2.setText("emploi.ma");
    c3.setText("announce.ma");


    JPanel card1HeaderTop = new JPanel();
    JPanel card1HeaderMiddle = new JPanel();
    JPanel card1HeaderBottom = new JPanel();


    // HEADER => MIDDLE
    String[] cities = {"casa","kenitra","rabat"};
    CustomComboBox<String> citiesCombo = new CustomComboBox<String>();
    citiesCombo.setLabeText("Cities");
    citiesCombo.setModel(new javax.swing.DefaultComboBoxModel<String>(cities));
    citiesCombo.setLineColor(new Color(0x6A70E0));
    citiesCombo.setSelectedIndex(-1);
    card1HeaderMiddle.add(citiesCombo);


    JPanel card1Header = new JPanel();
    card1Header.setLayout(new BoxLayout(card1Header,BoxLayout.Y_AXIS));
    
    FlowLayout fl2 = new FlowLayout();
    card1HeaderTop.setLayout(fl2);

    card1HeaderBottom.add(c1);
    card1HeaderBottom.add(c2);
    card1HeaderBottom.add(c3);

    card1HeaderTop.add(searchField); 
    card1HeaderTop.add(submitButton);
    
    card1Header.add(Box.createRigidArea(new  Dimension(0, 30)));
    card1Header.add(card1HeaderTop);
    card1Header.add(card1HeaderBottom);
    card1Header.add(Box.createRigidArea(new  Dimension(0, 30)));
    card1Header.add(card1HeaderMiddle);


    JPanel card1Main = new JPanel();
    card1Main.setLayout(fl);

    


    submitButton.setFocusable(false);
    card1.add(card1Header,BorderLayout.NORTH);
    card1.add(card1Main);
    
    new OfferCard(card1Main,new Color(0x74C0FC),"UI/UX designer","Google");
    new OfferCard(card1Main,new Color(0xFFE066),"Datascientest","Airbnb");
    // new OfferCard(card1Main,new Color(0xFFE066),"Datascientest","Airbnb");
    // new OfferCard(card1Main,new Color(0x74C0FC),"UI/UX designer","Google");







    // AI POWERD SEARCH
    card2.setBackground(Color.orange);



  

    topPanel.setPreferredSize(new Dimension(0,35));
    topPanel.setBackground(Color.WHITE);
    topPanel.setBorder(buttomBorder);

    

    sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
    sidePanel.setBackground(Color.WHITE);
    sidePanel.setBorder(rightBorder);

    sidepanelLabel1 = new JLabel("Classic search");
    ImageIcon lb1Icon = new ImageIcon("assets/search.png");
    sidepanelLabel1.setIcon(lb1Icon);
    sidepanelLabel1.setIconTextGap(12);
    sidepanelLabel1.setForeground(new Color(0x212121));
    sidepanelLabel1.setFont(new Font("Arial",Font.PLAIN,14));
    sidepanelLabel1.setBorder(BorderFactory.createCompoundBorder(buttomBorder, emptyBorder));
    sidepanelLabel1.addMouseListener(this);
    sidePanel.add(sidepanelLabel1);

    
    sidepanelLabel2 = new JLabel("AI Powered    ");
    ImageIcon lb2Icon = new ImageIcon("assets/sparks.png");
    sidepanelLabel2.setIcon(lb2Icon);
    sidepanelLabel2.setIconTextGap(12);
    sidepanelLabel2.setForeground(new Color(0x212121));
    sidepanelLabel2.setFont(new Font("Arial",Font.PLAIN,14));
    sidepanelLabel2.setBorder(BorderFactory.createCompoundBorder(buttomBorder, emptyBorder));
    sidepanelLabel2.addMouseListener(this);
    sidePanel.add(sidepanelLabel2);
    
    sidepanelLabel3 = new JLabel("Graphics        ");
    ImageIcon lb3Icon = new ImageIcon("assets/graph.png");
    sidepanelLabel3.setIcon(lb3Icon);
    sidepanelLabel3.setIconTextGap(12);
    sidepanelLabel3.setForeground(new Color(0x212121));
    sidepanelLabel3.setFont(new Font("Arial",Font.PLAIN,14));
    sidepanelLabel3.setBorder(BorderFactory.createCompoundBorder(buttomBorder, emptyBorder));
    sidepanelLabel3.addMouseListener(this);
    sidePanel.add(sidepanelLabel3);






    // ADDING PANLES TO FRAME ( BORDER LAYOUT ) 
    frame.add(topPanel,BorderLayout.NORTH);
    frame.add(sidePanel,BorderLayout.WEST);
    frame.add(mainPanel,BorderLayout.CENTER);


    frame.setVisible(true);


    

    


  }
  // MOUSE LISTENER METHODS
  @Override
  public void mouseClicked(MouseEvent event) {
    if (event.getSource() == sidepanelLabel1) {
      cardLayout.show(mainPanel,"card 1");
    }

    if (event.getSource() == sidepanelLabel2) {
      cardLayout.show(mainPanel,"card 2");
    }

    if(event.getSource() == sidepanelLabel3){
      cardLayout.show(mainPanel,"card 3");
    }
    


  }
  @Override
  public void mouseEntered(MouseEvent event) {
  }
  @Override
  public void mouseExited(MouseEvent event) {
  }
  @Override
  public void mousePressed(MouseEvent event) {
  }
  @Override
  public void mouseReleased(MouseEvent event) {
  }
  @Override
  public void actionPerformed(ActionEvent event) {
    if(event.getSource() == submitButton){
      System.out.println("text = " + searchField.getText() );
      searchField.setText("");
      String sites = "";
      if(c1.isSelected()){
        sites += "rekrute.com ";
      }
      if(c2.isSelected()){
        sites += "emploi.ma ";
      }
      if(c3.isSelected()){
        sites += "announce.ma ";
      }

      System.out.println("sites = "+ sites);
    }
  }
}


//  -------------------OFFER CARD CLASS------------------------

class OfferCard extends CustomPanel {
  public OfferCard(JPanel parent,Color color,String jobTitle,String company){

    CustomPanel offerCard = new CustomPanel();
    offerCard.setBackground(Color.WHITE);
    offerCard.setPreferredSize(new Dimension(350,100));
    offerCard.setRoundAll(16);
    offerCard.setLayout(new BorderLayout());

    CustomPanel offerCardHeader = new CustomPanel();
    offerCardHeader.setBackground(color);
    offerCardHeader.setPreferredSize(new Dimension(60,0));
    offerCardHeader.setRoundAll(16, 0, 16, 0);

    CustomPanel logoContainer = new CustomPanel();
    logoContainer.setBackground(Color.WHITE);
    logoContainer.setPreferredSize(new Dimension(30,30));
    logoContainer.setRoundAll(50);

    JLabel logoLabel = new JLabel(String.valueOf(company.charAt(0)).toUpperCase());
    logoLabel.setForeground(color);
    logoContainer.setLayout(new BorderLayout());
    logoLabel.setVerticalAlignment(JLabel.CENTER);
    logoLabel.setHorizontalAlignment(JLabel.CENTER);
    logoLabel.setFont(new Font("arial",Font.PLAIN,14));
    logoContainer.add(logoLabel);

    offerCardHeader.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    offerCardHeader.add(logoContainer,gbc);
    


    CustomPanel offerCardBody = new CustomPanel();
    offerCardBody.setBackground(Color.WHITE);
    offerCardBody.setRoundAll(0, 16, 0, 16);
    offerCard.add(offerCardHeader,BorderLayout.WEST);
    offerCard.add(offerCardBody,BorderLayout.CENTER);
    offerCardBody.setLayout(new BoxLayout(offerCardBody, BoxLayout.Y_AXIS));

    JLabel postName = new JLabel(jobTitle);
    postName.setFont(new Font("arial",Font.BOLD,13));
    postName.setForeground(new Color(0x212121));
    postName.setAlignmentX(LEFT_ALIGNMENT);
  
    JLabel companyName = new JLabel(company);
    companyName.setFont(new Font("arial",Font.PLAIN,10));
    companyName.setForeground(new Color(0x212121));
    companyName.setAlignmentX(LEFT_ALIGNMENT);

    JPanel datesiteContainer = new JPanel();
    datesiteContainer.setLayout(new BoxLayout(datesiteContainer,BoxLayout.X_AXIS));
    datesiteContainer.setBackground(Color.WHITE);
    datesiteContainer.setAlignmentX(LEFT_ALIGNMENT);

    JLabel datePost = new JLabel("poseted on "+"01/12/2023");
    datePost.setFont(new Font("arial",Font.PLAIN,10));
    datePost.setForeground(new Color(0xbbbbbb));
    
    JLabel sitePost = new JLabel("via "+"rekrut.ma");
    sitePost.setFont(new Font("arial",Font.PLAIN,10));
    sitePost.setForeground(new Color(0xbbbbbb));

    

    offerCardBody.add(postName);
    offerCardBody.add(Box.createVerticalGlue());
    offerCardBody.add(companyName);
    offerCardBody.add(datePost);
    offerCardBody.add(sitePost);
    offerCardBody.add(datesiteContainer);
    datesiteContainer.add(datePost);
    datesiteContainer.add(Box.createRigidArea(new  Dimension(20, 0)));
    datesiteContainer.add(sitePost);

    postName.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
    companyName.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));
    datesiteContainer.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));



    // companyName.setBorder(BorderFactory.createEmptyBorder(0,10,0,0));



  



    parent.add(offerCard);
  }
}