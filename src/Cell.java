
import java.awt.Color;
import java.awt.Graphics;
import java.util.EnumMap;
import java.util.Map;
import javax.sound.sampled.Line;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author My sony
 */
public class Cell {

    private int x;
    private int y;
    private int height;
    private int width;
    private EnumMap<Direction, Cell> neighbours = new EnumMap<>(Direction.class);
    private EnumMap<Direction, Wall> muren = new EnumMap<>(Direction.class);
    private Ghost ghost;
    private Pacman pacman;
    private boolean visited = false;
    
    
    public Cell(int xpos, int ypos , int height, int width ){
        this.x = xpos;
        this.y = ypos;
        this.height = height;
        this.width = width;
        init();
        
    }
    
    
    public void draw(Graphics g){
        for(Wall wall: muren.values()){
                    wall.draw(g);
            }
    }

    private void init() {
        Wall NORTH = new Wall(x, y, x + width, y);
        Wall WEST = new Wall(x, y, x, y + height);
        Wall EAST = new Wall(x + width, y, x + width, y + height);
        Wall SOUTH = new Wall(x, y + height, x + width, y + height);

        muren.put(Direction.WEST, WEST);
        muren.put(Direction.EAST, EAST);
        muren.put(Direction.SOUTH, SOUTH);
        muren.put(Direction.NORTH, NORTH);
    }

    public void setNeighbours(EnumMap<Direction, Cell> neighnours) {
        neighbours.putAll(neighnours);
    }

    Map<Direction, Cell> getUnvisitedNeighbours() {
         EnumMap<Direction, Cell> uCell = new EnumMap<>(Direction.class);
         Object uCellList[] = neighbours.values().toArray();
         for(int i =0; i< uCellList.length; i++){
             Cell neighbourCell = (Cell)uCellList[1];
             if(!neighbourCell.isVisited()){
                 uCell.put(getKeyByValue(neighbours,neighbourCell), neighbourCell);
             }
         }
         return uCell;
    }
    
    //return de key van een map
    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Map.Entry<T, E> entry : map.entrySet()) {
        if (value.equals(entry.getValue())) {
            return entry.getKey();
            }
        }
        return null;
    }

    public boolean isVisited() {
        return visited;
    }
}
