
import java.awt.Graphics;
import java.util.ArrayList;
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
public class SpeelBord extends JPanel {

    private ArrayList<Cell> cells;

    public SpeelBord() {
        cells = new ArrayList<Cell>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void createSquares(int aantalY, int aantalX) {
        int VerhoudingY = this.getHeight() / aantalY;
        int VerhoudingX = this.getWidth() / aantalX;
        cells.clear();
        for (int y = 0; y < aantalY; y++) {
            for (int x = 0; x < aantalX; x++) {
                Cell c = new Cell(0 + (VerhoudingY * y) + 3, 0 + (VerhoudingX * x) + 3, VerhoudingY, VerhoudingX);
                cells.add(c);

            }

        }

    }

    private void draw(Graphics g) {

        for (Cell c : cells) {
            c.draw(g);
        }
    }

}
