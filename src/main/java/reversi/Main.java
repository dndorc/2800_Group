import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) throws Exception {
        JFrame window = new JFrame("REVERSI");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GameBoard gb = new GameBoard();
        window.add(gb);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}