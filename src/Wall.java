
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author My sony
 */
public class Wall {
    
    private int x;
    private int y;
    private int x2;
    private int y2;
    
    public Wall(int x, int y, int x2, int y2) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void draw(Graphics g) {
        
        g.drawLine(x, y, x2, y2);
        g.setColor(Color.BLACK);
    }
}
