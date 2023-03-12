import java.awt.*;
import javax.swing.*;
public class Help {
    //Text window explaining the operation and creation of the program
    public static void about() {
        JFrame window = new JFrame("About"); 
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BorderLayout());
        JTextArea text = new JTextArea("Welcome to Heat Maps Pitch Sequencing by Tony Lanier.\nThis tool is intended to help pitchers understand\nhow their stuff plays and how to effectively\nattack batters. Sequecning is based off of previous\npitch velocity, its perceived velocity, and the hitters\ncurrent timing. This program follows the rule that\nthe next pitch's perceived velocity should be\n+/- 6MPH to the hitters current timing. Based off\nuser inputted pitches this program will generate what\npitches and what locations are best to keep the\nhitter off balance. All maps are interpreted as if standing\non the pitchers mound.");
        text.setAlignmentX(200);
        text.setAlignmentY(150);
        window.add(text);
        window.pack();
        window.setSize(400,300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}