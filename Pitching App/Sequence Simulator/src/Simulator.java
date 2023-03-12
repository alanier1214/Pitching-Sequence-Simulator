//import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
//import java.util.Arrays;
 
public class Simulator {

    static int velo = 90;
    static int temp;
    static int location;
    static double pv;
    static JFrame game = new JFrame();
    static boolean condition = true;

    public static void run(Player player, Map map) {
        Object[] possibleValues = { "Right", "Left"};
        Object[] possiblePitch = player.pitch;
        Object selectedHitter = JOptionPane.showInputDialog(game,"What handed hitter would you like to face?", "Pitching Simulator",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
        
        
        
        while(true) {
            Object selectedPitch = JOptionPane.showInputDialog(game, "What pitch did you throw?","Pitching Simulator",JOptionPane.INFORMATION_MESSAGE,null,possiblePitch, possiblePitch[0]);
            String selectedLocation = JOptionPane.showInputDialog(game, "Where was the last pitch thrown? (consult map index for number)", "Pitching Simulator");
            if (String.valueOf(selectedHitter) == "Right") {
                String number = String.valueOf(selectedPitch);
                location = Integer.parseInt(selectedLocation);
                JFrame simulator = new JFrame();
                while(condition) {
                    simulator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    simulator.setLayout(new BorderLayout());
                    temp = velo;
                    int index = 0;
                    for (int i = 0; i<player.numPitches; ++i) {
                        if (number == player.pitch[i]) index = i;    
                    }
                    velo = player.avgvelo[index];
                    int mapVeloR = (int) map.getVeloR(location);
                    velo += mapVeloR;
                    pv = (velo + temp)/2;
                    JTextArea info = new JTextArea("Last pitch was a " + player.pitch[index] + " thrown at perceived velocity " + 
                                            velo + "MPH.\n Hitters timing is at " + pv + "MPH. Next pitch and possible locations...\n");
                    for (int i = 0; i < player.numPitches; i++) {
                        for (int j = 0; j < 25; j++) {
                            int mapTempR = (int) map.getVeloR(j + 1);
                            if ((player.avgvelo[i] + mapTempR) > (pv + 6) || (player.avgvelo[i] + mapTempR) < (pv - 6)) {
                                info.append(player.pitch[i] + " at location " + (j + 1) + "\n");
                            }
                        }
                    }
                    info.setAlignmentX(200);
                    info.setAlignmentY(150);
                    simulator.add(info);
                    simulator.pack();
                    simulator.setVisible(true);
                    simulator.setLocationRelativeTo(null);
                    JFrame question = new JFrame();
                    int dialogButton = JOptionPane.showConfirmDialog(question,"Throw another pitch?", "Continue", JOptionPane.YES_NO_OPTION);
                    if (dialogButton == JOptionPane.YES_OPTION) {
                        simulator.dispose();
                        break;
                    } 
                    if (dialogButton == JOptionPane.NO_OPTION) {
                        condition = false;
                        break;
                    }
                }
                break;
            }
            if (String.valueOf(selectedHitter) == "Left") {
                String number = String.valueOf(selectedPitch);
                location = Integer.parseInt(selectedLocation);
                JFrame simulator = new JFrame();
                while(condition) {
                    simulator.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    simulator.setLayout(new BorderLayout());
                    temp = velo;
                    int index = 0;
                    for (int i = 0; i<player.numPitches; ++i) {
                        if (number == player.pitch[i]) index = i;    
                    }
                    velo = player.avgvelo[index];
                    int mapVeloL = (int) map.getVeloL(location);
                    velo += mapVeloL;
                    pv = (velo + temp)/2;
                    JTextArea info = new JTextArea("Last pitch was a " + player.pitch[index] + " thrown at perceived velocity " + 
                                            velo + "MPH.\n Hitters timing is at " + pv + "MPH. Next pitch and possible locations...\n");
                    for (int i = 0; i < player.numPitches; i++) {
                        for (int j = 0; j < 25; j++) {
                            int mapTempL = (int) map.getVeloR(j + 1);
                            if ((player.avgvelo[i] + mapTempL) > (pv + 6) || (player.avgvelo[i] + mapTempL) < (pv - 6)) {
                                info.append(player.pitch[i] + " at location " + (j + 1) + "\n");
                            }
                        }
                    }
                    info.setAlignmentX(200);
                    info.setAlignmentY(150);
                    simulator.add(info);
                    simulator.pack();
                    simulator.setVisible(true);
                    simulator.setLocationRelativeTo(null);
                    JFrame question = new JFrame();
                    int dialogButton = JOptionPane.showConfirmDialog(question,"Throw another pitch?", "Continue", JOptionPane.YES_NO_OPTION);
                    if (dialogButton == JOptionPane.YES_OPTION) {
                        simulator.dispose();
                        break;
                    }
                    if (dialogButton == JOptionPane.NO_OPTION) {
                        question.dispose();
                        game.dispose();
                        condition = false;
                        break;
                    }
                }
                break;
            }
        }
    }
        
        /*try (Scanner f = new Scanner(System.in)) {
            String decision;
            String choice;

            int location;
            double PV = 0;
            int velo = 90;
            int temp;
            int pitch;

            while (true) {
                System.out.print("What handed hitter would you like to face? (R/L): ");
                decision = f.next();
                if (decision.equals("R") || decision.equals("L")) break;
                else System.out.println("Invalid input please try again.");
            }
            while (true) {
                map.displayIndex();
                System.out.print("Where was the last pitch thrown? (enter zone number): ");
                location = f.nextInt();
                if (1 > location || location > 25) continue;
                System.out.print("What was the last pitch thrown? (pitch number): ");
                pitch = f.nextInt();
                if (1 > pitch || pitch > player.numPitches) continue;
                temp = velo;
                velo = player.avgvelo[pitch - 1];
                if (decision.equals("R")) {
                    int mapVeloR = (int) map.getVeloR(location);
                    velo += mapVeloR;
                }
                if (decision.equals("L")) {
                    int mapVeloL = (int) map.getVeloL(location);
                    velo += mapVeloL;
                }
                PV = (velo+temp)/2;
                System.out.println("Last pitch was a " + player.pitch[pitch-1] + " thrown at perceived velocity " + 
                                    velo + "MPH. Hitters timing is at " + PV + "MPH. Next pitch and possible locations...");
                for (int i = 0; i < player.numPitches; i++) {
                    for (int j = 0; j < 25; j++) {
                        if (decision.equals("R")) {
                            int mapTempR = (int) map.getVeloR(j + 1);
                            if ((player.avgvelo[i] + mapTempR) > (PV + 6) || (player.avgvelo[i] + mapTempR) < (PV - 6)) {
                                System.out.println(player.pitch[i] + " at location " + (j + 1));
                            }
                        }
                        if (decision.equals("L")) {
                            int mapTempL = (int) map.getVeloL(j + 1);
                            if ((player.avgvelo[i] + mapTempL) > (PV + 6) || (player.avgvelo[i] + mapTempL) < (PV - 6)) {
                                System.out.println(player.pitch[i] + " at location " + (j + 1));
                            }
                        }
                    }
                }
                while (true) {
                    System.out.print("Would you like to simulate another pitch? (Y/N): ");
                    choice = f.next();
                    if (choice.equals("Y")) break;
                    if (choice.equals("N")) return;
                    else System.out.println("Invalid input please try again.");     
                }
            }
        }
    }*/

    public static void simulate(Player player, Map map) {
        run(player, map);
    }
}

