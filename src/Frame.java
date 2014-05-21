
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author My sony
 */
public class Frame extends JFrame {
    private JTextField field ;
    private JButton button;
    private SpeelBord  bord;
    private int aantalCellen;
    
    public Frame() {
        createComponent();
    }

    private void createComponent() {

        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        field = new JTextField();
        field.setColumns(10);
        field.setBackground(Color.ORANGE);

        button = new JButton();
        button.setText("Maak vierkanten");
        button.addActionListener(new addSquareListener(this));

        bord = new SpeelBord();
        bord.setSize(new Dimension(this.getWidth() - 20, this.getHeight() - 20));
        bord.add(field);
        bord.add(button);
        bord.setBackground(Color.WHITE);
        this.add(bord);
        this.setVisible(true);
    }
     public void drawSquares(int aantal) {
        bord.createSquares(aantal , aantal);
        repaint();
    }

    class addSquareListener implements ActionListener {
        private Frame myFrame;
        public addSquareListener(Frame frame) {
            myFrame = frame;
        }

        public void actionPerformed(ActionEvent evt) {
            aantalCellen = Integer.parseInt(field.getText());
            myFrame.drawSquares(aantalCellen);
            

        }
    }
    
}
