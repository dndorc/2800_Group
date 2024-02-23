import javax.swing.JPanel;

import java.awt.*;

public class GameBoard extends JPanel{

    static final int BOARD_ROWS = 8;
    static final int BOARD_COLS = 8;
    static final int BOARD_SIZE = BOARD_ROWS * BOARD_COLS;

    static final int tileSize = 16 * 3; //For now

    static final int WIDTH = tileSize * BOARD_COLS;
    static final int HEIGHT = tileSize * BOARD_ROWS;

    public GameBoard(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}