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
    private void createIcons(){
        for(int row = 10; row > 0; row--){
            for(int col = 0; col < COLUMN; col++){
                if(row %2 == 0){

                }
                System.out.printf( "%4d",10*row+col);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SnakesGUI s = new SnakesGUI();
        s.createIcons();
    }

}