import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GUI extends javax.swing.JFrame implements ActionListener {

    private JButton button1, button2, button3, button4, button5, button6, button7;
    private JPanel btnPanel, panel, layout;
    public static Map map;
    public static Player player;
    public static void main(String args[]) {
        map = new Map();
        map.mapR();
        map.mapL();
        map.mapIndex();
        player = new Player();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI app = new GUI();
                app.setLocationRelativeTo(null);
                app.setVisible(true);
            }
        });
    }

       
    public GUI() {
        super("Pitch Sequence Simulator");
        startGUI();
    }

    private void startGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            panel = new JPanel(new BorderLayout());
            panel.setOpaque(true);
            panel.setBorder(new EmptyBorder(2, 3, 2, 3));
            layout = new JPanel(new GridBagLayout());
            layout.setBorder(new EmptyBorder(5, 5, 5, 5));
            btnPanel = new JPanel(new GridLayout(7, 1, 10, 5));

            //Adding buttons
            button1 = new JButton("Simulate Pitch Sequence");
            button1.setVerticalTextPosition(AbstractButton.CENTER);
            button1.setHorizontalTextPosition(AbstractButton.CENTER);
            button1.setMnemonic(KeyEvent.VK_S);
            button1.setActionCommand("simulate");
            button1.addActionListener(this);
            button1.setBackground(Color.BLUE);
            button1.setForeground(Color.WHITE);
            btnPanel.add(button1);

            button2 = new JButton("Build A Pitch Profile");
            button2.setVerticalTextPosition(AbstractButton.CENTER);
            button2.setHorizontalTextPosition(AbstractButton.CENTER);
            button2.setMnemonic(KeyEvent.VK_B);
            button2.setActionCommand("build");
            button2.addActionListener(this);
            button2.setBackground(Color.BLUE);
            button2.setForeground(Color.WHITE);
            btnPanel.add(button2);

            button3 = new JButton("View Player Pitch Profile");
            button3.setVerticalTextPosition(AbstractButton.CENTER);
            button3.setHorizontalTextPosition(AbstractButton.CENTER);
            button3.setMnemonic(KeyEvent.VK_P);
            button3.setActionCommand("viewP");
            button3.addActionListener(this);
            button3.setBackground(Color.BLUE);
            button3.setForeground(Color.WHITE);
            btnPanel.add(button3);

            button4 = new JButton("View LHH Heat Map");
            button4.setVerticalTextPosition(AbstractButton.CENTER);
            button4.setHorizontalTextPosition(AbstractButton.CENTER);
            button4.setMnemonic(KeyEvent.VK_L);
            button4.setActionCommand("viewL");
            button4.addActionListener(this);
            button4.setBackground(Color.BLUE);
            button4.setForeground(Color.WHITE);
            btnPanel.add(button4);

            button5 = new JButton("View RHH Heat Map");
            button5.setVerticalTextPosition(AbstractButton.CENTER);
            button5.setHorizontalTextPosition(AbstractButton.CENTER);
            button5.setMnemonic(KeyEvent.VK_R);
            button5.setActionCommand("viewR");
            button5.addActionListener(this);
            button5.setBackground(Color.BLUE);
            button5.setForeground(Color.WHITE);
            btnPanel.add(button5);

            button6 = new JButton("View Heat Map Index");
            button6.setVerticalTextPosition(AbstractButton.CENTER);
            button6.setHorizontalTextPosition(AbstractButton.CENTER);
            button6.setMnemonic(KeyEvent.VK_M);
            button6.setActionCommand("viewM");
            button6.addActionListener(this);
            button6.setBackground(Color.BLUE);
            button6.setForeground(Color.WHITE);
            btnPanel.add(button6);

            button7 = new JButton("About");
            button7.setVerticalTextPosition(AbstractButton.CENTER);
            button7.setHorizontalTextPosition(AbstractButton.CENTER);
            button7.setMnemonic(KeyEvent.VK_A);
            button7.setActionCommand("about");
            button7.addActionListener(this);
            button7.setBackground(Color.BLUE);
            button7.setForeground(Color.WHITE);
            btnPanel.add(button7);

            layout.add(btnPanel);
            panel.add(layout, BorderLayout.CENTER);
            getContentPane().add(panel);

            pack();
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public void actionPerformed(ActionEvent e) {
        if ("simulate".equals(e.getActionCommand())) {
            if (player.status == "new") player.pitchBuilder();
            else Simulator.simulate(player, map);
        }
        if ("build".equals(e.getActionCommand())) {
            player.pitchBuilder();
        }
        if ("viewP".equals(e.getActionCommand())) {
            if (player.status == "new") player.pitchBuilder();
            if (player.status == "current") player.playerPitchInfo();
        }
        if ("viewL".equals(e.getActionCommand())) {
            map.displayMapLHH();
        }
        if ("viewR".equals(e.getActionCommand())) {
            map.displayMapRHH();
        }
        if ("viewM".equals(e.getActionCommand())) {
            map.displayIndex();
        }
        if ("about".equals(e.getActionCommand())) {
            Help.about();
        }
    }
}