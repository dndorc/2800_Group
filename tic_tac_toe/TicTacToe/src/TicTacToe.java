import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[BoardSize.BOARD_SIZE];
    private boolean xTurn = true;

    // initial setup, default constructor
    public TicTacToe() {
        frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(BoardSize.BOARD_ROWS, BoardSize.BOARD_COLS));

        for (var i = 0; i < BoardSize.BOARD_SIZE; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 72));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    // determine what happens when a button is pressed
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        button.setText(xTurn ? "X" : "O");
        button.setEnabled(false);
        xTurn = !xTurn;

        checkForWinner();
    }

    // after every press, check if a player has won
    public void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie game!");
            resetGame();
        }
    }
    
    // reset behaviour back to initial setup
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    // created for better scalability (perhaps making a 4x4 and above tic-tac-toe game, connect-4?, etc)
    private static class BoardSize {
        static final int BOARD_ROWS = 3;
        static final int BOARD_COLS = 3;
        static final int BOARD_SIZE = BOARD_ROWS * BOARD_COLS;
    }
}
