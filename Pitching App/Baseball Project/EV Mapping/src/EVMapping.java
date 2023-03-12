import java.util.Scanner;

public class EVMapping {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        int response = 0;
        Map map = new Map();
        map.mapL();
        map.mapR();
        map.mapIndex();
        System.out.println("Initializing Pitcher...");
        Player player = new Player();
        System.out.println();
        while (true) {
            System.out.println("Please input a number and press enter to select an option...");
            System.out.println("1. Simulate Pitch Sequence");    
            System.out.println("2. Build A Pitch Profile"); 
            System.out.println("3. View Player Pitch Profile");
            System.out.println("4. View LHH Map");
            System.out.println("5. View RHH Map");
            System.out.println("6. View Map Index");
            System.out.println("7. About");
            System.out.println("8. Quit");
            System.out.print("Menu Choice: ");
            response = f.nextInt();
            System.out.println("...................................");
            if (response == 1) {
                Simulator.simulate(player, map);
                System.out.println("...................................");
            }
            if (response == 2) {
                player.setPitch();
                System.out.println("...................................");
            }
            if (response == 3) {
                player.playerPitchInfo();
                System.out.println("...................................");
            }
            if (response == 4) {
                map.displayMapLHH();
                System.out.println("...................................");
            }
            if (response == 5) {
                map.displayMapRHH();
                System.out.println("...................................");
            }
            if (response == 6) {
                map.displayIndex();
                System.out.println("...................................");
            }
            if (response == 7) {
                Help.about();
                System.out.println("...................................");
            }
            if (response == 8) break;
            if (1 > response || response > 8) System.out.print("Invalid input please put in a valid number to continue.");
        }
        f.close();
    }
}
