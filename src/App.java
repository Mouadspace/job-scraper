import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import components.CustomButton;
import components.CustomFrame;

public class App {

    
    public App() throws FontFormatException, IOException{
        CustomFrame frame = new CustomFrame();
        
        // FONTS : 
        File font_file = new File("Poppins-Regular.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
        Font h5Font = font.deriveFont(Font.BOLD,24f);
        Font labelSmall = font.deriveFont(12f);
        Font labelMedium = font.deriveFont(Font.BOLD,12f);



        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0xFBFBFB));
        topPanel.setPreferredSize(new Dimension(100,220));
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
        // topPanel.setBackground(Color.pink);

        JLabel signupLabel = new JLabel("Sign up");
        signupLabel.setFont(h5Font);
        signupLabel.setForeground(new Color(0x6A70E0));
        signupLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        setMargin(signupLabel, 60, 0, 0, 0);
        
        JLabel joinLabel = new JLabel("Join the community today!");
        joinLabel.setFont(labelSmall);
        joinLabel.setForeground(new Color(0xC7C7C7));
        joinLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        setMargin(joinLabel, 0, 0, 25, 0);

            
        CustomButton googleSignupButton = new CustomButton();    
        googleSignupButton.setBackground(new Color(0x6A70E0));
        // googleSignupButton.setForeground(new Color(0xBEBEF2));
        googleSignupButton.setForeground(Color.WHITE);
        googleSignupButton.setText("Use Google Account");
        googleSignupButton.setFocusable(false);
        googleSignupButton.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));
        googleSignupButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ImageIcon icon = new ImageIcon("assets/frame.png");   
        googleSignupButton.setIcon(icon);
        googleSignupButton.setIconTextGap(10);
        // googleSignupButton.setHorizontalAlignment(SwingConstants.LEADING);
        // googleSignupButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JLabel orLabel = new JLabel("or");
        orLabel.setFont(labelSmall);
        orLabel.setForeground(new Color(0xC7C7C7));
        orLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        setMargin(orLabel, 25, 0, 25, 0);


        JPanel middlePanel = new JPanel();
        middlePanel.setBackground(new Color(0xFBFBFB));
        middlePanel.setPreferredSize(new Dimension(100,220));
        middlePanel.setLayout(null);
        // middlePanel.setBackground(Color.pink);



        JLabel loginLabel = new JLabel("Email");
        loginLabel.setFont(labelMedium);
        loginLabel.setForeground(new Color(0xC7C7C7));
        loginLabel.setBounds(250,25,50,25);

        JTextField loginField = new JTextField();
        loginField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(0x6A70E0)));
        // loginField.setBackground(new Color(0, true));
        loginField.setBounds(250,45,300,30);


        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(labelMedium);
        passLabel.setForeground(new Color(0xC7C7C7));
        passLabel.setBounds(250,100,100,25);
        
        JTextField passField = new JTextField();
        passField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,new Color(0x6A70E0)));
        passField.setBounds(250,120,300,30);
        // passField.setBackground(new Color(0, true));
        
        
        CustomButton signupButton = new CustomButton();    
        signupButton.setBackground(new Color(0x6A70E0));
        // signupButton.setForeground(new Color(0xBEBEF2));
        signupButton.setForeground(Color.WHITE);
        signupButton.setText("Sign up");
        signupButton.setFocusable(false);
        signupButton.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 60));
        signupButton.setBounds(250, 180, 300, 40);

        JLabel bLabel = new JLabel("Already a member?");
        bLabel.setFont(labelMedium);
        bLabel.setForeground(new Color(0xC7C7C7));
        // bLabel.setBounds(250,190,100,25);

        JLabel linkLabel = new JLabel("Sign in");
        linkLabel.setFont(labelMedium);
        linkLabel.setForeground(new Color(0x6A70E0));
        linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));


        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0xFBFBFB));
        bottomPanel.setPreferredSize(new Dimension(100,40));


        // ADDING COMPONENTS TO TOP PANEL
        topPanel.add(signupLabel);
        topPanel.add(joinLabel);
        topPanel.add(googleSignupButton);
        topPanel.add(orLabel);

        // ADDING COMPONENTS TO TOP PANEL
        middlePanel.add(loginLabel);
        middlePanel.add(loginField);
        middlePanel.add(passLabel);
        middlePanel.add(passField);
        middlePanel.add(signupButton);

        // ADDING COMPONENTS TO BOTTOM PANEL
        bottomPanel.add(bLabel);
        bottomPanel.add(linkLabel);


        // ADDING COMPONENTS TO FRAME 
        frame.add(topPanel,BorderLayout.NORTH);
        frame.add(middlePanel,BorderLayout.CENTER);
        frame.add(bottomPanel,BorderLayout.SOUTH);


        // TO AVOID BUGS
        frame.setVisible(true);
    }

    public void setMargin(JComponent cmp,int top, int left, int bottom, int right){
        Border border = cmp.getBorder();
        Border margin = new EmptyBorder(top,left,bottom,right);
        cmp.setBorder(new CompoundBorder(border, margin));
    }


    public static void main(String[] args) throws Exception {
        new App();
    }
}
