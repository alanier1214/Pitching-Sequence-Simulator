import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Player extends javax.swing.JFrame implements ActionListener {

    //Create player variables to store number of pitches, pitch types, and velocity
    protected String[] pitch;

    protected int[] avgvelo;

    protected int numPitches;

    protected String status;

    JFrame index;

    public Player() {
        status = "new";
    }

    //Display window where user will input pitch info to create player profile
    public void pitchBuilder() {
        index = new JFrame("Player Number of Pitches");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(true);
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel btnPanel = new JPanel(new GridLayout(7, 1, 10, 5));
        
        JTextArea question = new JTextArea("How many pitches do you throw? (Maximum 5): ");
        panel.add(question);

        JButton button1 = new JButton("1");
        button1.setVerticalTextPosition(AbstractButton.CENTER);
        button1.setHorizontalTextPosition(AbstractButton.CENTER);
        button1.setMnemonic(KeyEvent.VK_1);
        button1.setActionCommand("num1");
        button1.addActionListener(this);
        button1.setBackground(Color.BLUE);
        button1.setForeground(Color.WHITE);
        btnPanel.add(button1);

        JButton button2 = new JButton("2");
        button2.setVerticalTextPosition(AbstractButton.CENTER);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);
        button2.setMnemonic(KeyEvent.VK_2);
        button2.setActionCommand("num2");
        button2.addActionListener(this);
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.WHITE);
        btnPanel.add(button2);

        JButton button3 = new JButton("3");
        button3.setVerticalTextPosition(AbstractButton.CENTER);
        button3.setHorizontalTextPosition(AbstractButton.CENTER);
        button3.setMnemonic(KeyEvent.VK_3);
        button3.setActionCommand("num3");
        button3.addActionListener(this);
        button3.setBackground(Color.BLUE);
        button3.setForeground(Color.WHITE);
        btnPanel.add(button3);

        JButton button4 = new JButton("4");
        button4.setVerticalTextPosition(AbstractButton.CENTER);
        button4.setHorizontalTextPosition(AbstractButton.CENTER);
        button4.setMnemonic(KeyEvent.VK_4);
        button4.setActionCommand("num4");
        button4.addActionListener(this);
        button4.setBackground(Color.BLUE);
        button4.setForeground(Color.WHITE);
        btnPanel.add(button4);

        JButton button5 = new JButton("5");
        button5.setVerticalTextPosition(AbstractButton.CENTER);
        button5.setHorizontalTextPosition(AbstractButton.CENTER);
        button5.setMnemonic(KeyEvent.VK_5);
        button5.setActionCommand("num5");
        button5.addActionListener(this);
        button5.setBackground(Color.BLUE);
        button5.setForeground(Color.WHITE);
        btnPanel.add(button5);

        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);
        index.getContentPane().add(panel);

        index.pack();
        index.setVisible(true);
        index.setLocationRelativeTo(null);
    }
    
    public void setPitch() {
        JFrame window = new JFrame();
        for(int j = 0; j < numPitches; ++j){
        String pitchName = JOptionPane.showInputDialog(window, "Please enter pitch name (" + (j+1) + ")");
        String pitchVelo = JOptionPane.showInputDialog(window, "Please enter average pitch velocity (whole number)");
        pitch[j] = pitchName;
        avgvelo[j] = Integer.valueOf(pitchVelo);
        }
    } 

    //Display a window detailing a players pitch arsenal
    public void playerPitchInfo() {
        JTextArea text = new JTextArea();
        int i = 0;
        while(i < numPitches) {
            text.append("Pitch " + (i+1) + " is a " + pitch[i] + ": " + avgvelo[i] + "mph\n");
            ++i;
        }
        JFrame window = new JFrame("Player Pitch Info");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(new BorderLayout());
        text.setAlignmentX(200);
        text.setAlignmentY(150);
        window.add(text);
        window.pack();
        window.setSize(400,300);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        //System.out.println("Player Pitch Profile");
        //for (int i = 0; i < numPitches; ++i) {
            //System.out.println(pitch[i] + ": " + avgvelo[i] + "MPH");
        //}
    } 

    //Buttons to indicate how many pitches a user throws and initializes profile accordingly
    public void actionPerformed(ActionEvent e) {
        if ("num1".equals(e.getActionCommand())) {
            numPitches = 1;
            pitch = new String[numPitches];
            avgvelo = new int[numPitches];
            status = "current";
            index.dispose();
            setPitch();
        }
        if ("num2".equals(e.getActionCommand())) {
            numPitches = 2;
            pitch = new String[numPitches];
            avgvelo = new int[numPitches];
            status = "current";
            index.dispose();
            setPitch();
        }
        if ("num3".equals(e.getActionCommand())) {
            numPitches = 3;
            pitch = new String[numPitches];
            avgvelo = new int[numPitches];
            status = "current";
            index.dispose();
            setPitch();
        }
        if ("num4".equals(e.getActionCommand())) {
            numPitches = 4;
            pitch = new String[numPitches];
            avgvelo = new int[numPitches];
            status = "current";
            index.dispose();
            setPitch();
        }
        if ("num5".equals(e.getActionCommand())) {
            numPitches = 5;
            pitch = new String[numPitches];
            avgvelo = new int[numPitches];
            status = "current";
            index.dispose();
            setPitch();
        }
    }
}