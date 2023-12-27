import java.awt.FontFormatException;
import java.io.IOException;

import ui.Register;

public class App {
    
    public App() throws FontFormatException, IOException {
        new Register();
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
