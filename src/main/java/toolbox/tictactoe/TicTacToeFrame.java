package toolbox.tictactoe;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Created by perrythomson on 8/2/16.
 */
public class TicTacToeFrame extends JFrame{         //Jframe is a window container
        private char whoseTurn = 'X';                 // #1 set players
        private boolean gameOver = false;

    private Cell[][] cells = new Cell[3][3];            // #2 two dimensional array with grid

    JLabel jlblStatus = new JLabel("X's turn to play"); //#3 identify status label of text


    public TicTacToeFrame(){                                    //#4 create a constructor object (tic tac toe frame ) is created
        JPanel panel = new JPanel(new GridLayout(3,3,0,0));     //#5 create panel to hold the cells 0 for horizontal and vertical gaps
        for (int i= 0; i<3; i++)
            for (int j = 0; j<3; j++)
                panel.add(cells[i][j] = new Cell());

        panel.setBorder(new LineBorder(Color.red, 1));          //#6 add color for player turn indicator, thickness 1
        jlblStatus.setBorder(new LineBorder(Color.blue, 1));

        add(panel, BorderLayout.CENTER);
        add(jlblStatus, BorderLayout.SOUTH);
    }



    public boolean isFull() {                   //determines if board is full...is true if full
        for (int i= 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if (cells[i][j].getToken() == ' ' )
                    return false;
        return true;
    }

    public boolean isWon(char token){           // checking rows
        for (int i= 0; i<3; i++)
            if ((cells[i][0].getToken() == token)
                    && (cells[i][1].getToken() == token)
                    && (cells[i][2].getToken() == token)){
            return true;
            }

        for (int j= 0; j<3; j++)                // checking columns
            if ((cells[0][j].getToken() == token)
                    && (cells[1][j].getToken() == token)
                    && (cells[2][j].getToken() == token)){
                return true;
            }

        if ((cells[0][0].getToken() == token)           // checking diagonals
                && (cells[1][1].getToken() == token)
                && (cells[2][2].getToken() == token)){
            return true;
        }

    return false;
    }
    public class Cell extends JPanel {
        private char token = ' ';  // token of this cell

        public Cell() {
        setBorder(new LineBorder(Color.black,1));
        addMouseListener(new MyMouseListener());
        }

        public char getToken(){
            return token;
        }

        public void setToken(char c){
            token = c;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (token == 'X') {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            } else if (token == 'O') {
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
        }


        private class MyMouseListener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gameOver)
                    return;
                if (token == ' ' && whoseTurn != ' ')
                    setToken(whoseTurn);
                if (isWon(whoseTurn)) {
                    jlblStatus.setText(whoseTurn + " won -- Game Over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else if (isFull()) {
                    jlblStatus.setText("Tie game! - Game Over!");
                    whoseTurn = ' ';
                    gameOver = true;
                } else {
                    whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                    jlblStatus.setText(whoseTurn + "'s turn.");

                }
            }
        }
    }

}
