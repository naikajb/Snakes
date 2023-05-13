import javax.swing.*;

public class SnakesGUI extends JFrame {

    //array for images on the squares
    ImageIcon[][] icons = new ImageIcon[10][10];
    final int ROW = 10, COLUMN = 10;


    //TODO make it print
    //100 99 98 ... 91
    //81 82 83 ... 90
    //80 79 78 ... 71
    //61 62 63 ... 60
    //    .....
    // 1 2 3 .... 10

    /**
     * creates and initializes icons array for GUI
     */
    private void createIcons(){
        int num = 0;
        ImageIcon img;
        for(int row = 10; row > 0; row--){
            for(int col = 0; col < COLUMN; col++){
                if(row %2 != 0){
                    num = 10*row+col-9;
                }else{
                    num = 10*row-col;
                }
                img = new ImageIcon("src/images/"+num+".png");
                System.out.printf( "%4d",num);
                //System.out.print(" " +img.getIconHeight());
                icons[row-1][col] = img;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SnakesGUI s = new SnakesGUI();
        s.createIcons();
    }

}