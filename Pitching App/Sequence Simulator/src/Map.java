import java.awt.*;
import javax.swing.*;
public class Map {
    //Data structures to build standard pitch location, left hand specific and right hand specific hitter arrays
    protected Object[][] arrayL;
    protected Object[][] arrayR;
    protected Object[][] dummy;
    protected String[] columns = new String[] {"In/Out (L/R)", "Middle In/Middle Out (L/R)", "Middle", "Middle In/Middle Out (R/L)", "In/Out (R/L)"};

    //Initialize arrays
    public Map() {
        arrayL = new Object[5][5];
        arrayR = new Object[5][5];
        dummy = new Object[5][5];
    } 

    //Create standard pitch location array
    public Object[][] mapIndex() {
        int k = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dummy[i][j] = k;
                ++k;
            }
        }
        return dummy;
    }

    //Display window with standard pitch location map
    public void displayIndex() {
        JFrame index = new JFrame();
        JTable table = new JTable(dummy, columns);
        GridLayout layout = new GridLayout();
        Container contentPane = index.getContentPane();
        contentPane.setLayout(layout);
        contentPane.add(table);
        index.setTitle("Heat Map Index");
        index.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        index.pack();
        index.setSize(400, 400);
        index.setVisible(true);
        index.setLocationRelativeTo(null);
        //for (int i = 0; i < 5; i++) {
            //for (int j = 0; j < 5; j++) {
                //index.insert(dummy[i][j].toString(), );
            //}
        //}
    }

    //Create left hand hitter pitch location array
    public Object[][] mapL() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i==0) {
                    arrayL[i][j] = i+4-j;
                }
                else if(i==1) {
                    arrayL[i][j] = i+2-j;
                }
                else if(i==2) {
                    arrayL[i][j] = i-j;
                }
                else if(i==3) {
                    arrayL[i][j] = i-2-j;
                }
                else if(i==4) {
                    arrayL[i][j] = i-4-j;
                }
            }
        }
        return arrayL;
    }

    //Create right hand hitter pitch location array
    public Object[][] mapR() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(i==0) {
                    arrayR[i][j] = i+j;
                }
                else if(i==1) {
                    arrayR[i][j] = i-2+j;
                }
                else if(i==2) {
                    arrayR[i][j] = i-4+j;
                }
                else if(i==3) {
                    arrayR[i][j] = i-6+j;
                }
                else if(i==4) {
                    arrayR[i][j] = i-8+j;
                }
            }
        }
        return arrayR;
    }

    //Display window with left hand hitter pitch map
    public void displayMapLHH() {
        JFrame mapL = new JFrame();
        JTable left = new JTable(arrayL, columns);
        JScrollPane testL = new JScrollPane(left);
        mapL.setLayout(new BorderLayout());
        mapL.add(testL , BorderLayout.CENTER);
        mapL.setTitle("Left Hand Hitter Map");
        mapL.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        mapL.pack();
        mapL.setSize(400,400);
        mapL.setVisible(true);
        mapL.setLocationRelativeTo(null);
        //for (int i = 0; i < 5; i++) {
            //for (int j = 0; j < 5; j++) {
                //System.out.printf("%3d", arrayL[i][j]);
            //}
            //System.out.println();
        //}
    }

    //Display window with right hand hitter pitch map
    public void displayMapRHH() {
        JFrame mapR = new JFrame();
        JTable right = new JTable(arrayR, columns);
        JScrollPane testR = new JScrollPane(right);
        mapR.setLayout(new BorderLayout());
        mapR.add(testR , BorderLayout.CENTER);
        mapR.setTitle("Right Hand Hitter Map");
        mapR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        mapR.pack();
        mapR.setSize(400,400);
        mapR.setVisible(true);
        mapR.setLocationRelativeTo(null);
        //for (int i = 0; i < 5; i++) {
            //for (int j = 0; j < 5; j++) {
                //System.out.printf("%3d", arrayR[i][j]);
            //}
            //System.out.println();
        //}
    }

    //Return equivalent velo for pitch location...left hand hitter
    public Object getVeloL(Object zone) {
        Object temp = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dummy[i][j] == zone) {
                temp = arrayL[i][j]; 
                break;
               }
            }
        }
        return temp;
    }

    //Return equivalent velo for pitch location...right hand hitter
    public Object getVeloR(Object zone) {
        Object temp = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (dummy[i][j] == zone) {
                 temp = arrayR[i][j];
                break;
               }
            }
        }
        return temp;
    }
}