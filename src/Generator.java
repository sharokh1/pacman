
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author My sony
 */
public class Generator {

    private int amountOfCells = 5;

    private int scale = 600 / amountOfCells;

    private Cell cells[][] = new Cell[amountOfCells][amountOfCells];

    public Generator() {

    }

    public Cell[][] getCells() {
        return cells;
    }

    private void fillList() {
        int x = 0;
        int y = 0;

        for (int i = 0; i < amountOfCells; i++) {
            for (int j = 0; j < amountOfCells; j++) {
                Cell cell = new Cell(x + (scale * i) + 3, y + (scale * 1) + 3, scale, scale);
                cells[j][i] = cell;
            }
        }

    }

    private void addNeighnours() {
        Cell cell;

        int nrOfRows = cells.length;
        int nrOfCollums = cells[0].length;

        for (int i = 0; i < amountOfCells; i++) {
            for (int j = 0; j < amountOfCells; j++) {

                cell = cells[i][j];
                EnumMap<Direction, Cell> neighbours = new EnumMap<>(Direction.class);
                //north
                if (j > 0) {
                    Cell neighbour = cells[i][j + 1];
                    neighbours.put(Direction.NORTH, neighbour);
                }
                //east
                if (i > 0) {
                    Cell neighbour = cells[i + 1][j];
                    neighbours.put(Direction.EAST, neighbour);

                }
                if (j < nrOfRows - 1) {
                    Cell neighbour = cells[i][j - 1];
                    neighbours.put(Direction.SOUTH, neighbour);
                }
                if (i < nrOfCollums - 1) {
                    Cell neighbour = cells[i - 1][j];
                    neighbours.put(Direction.WEST, neighbour);
                }

                cell.setNeighbours(neighbours);
                cells[i][j] = cell;

            }
        }

    }

    private void generate() {
        //stack aan maken en vullen
        Stack<Cell> stack = new Stack<Cell>();
        Random random = new Random();
        stack.add((cells[random.nextInt(amountOfCells)][random.nextInt(amountOfCells)]));

        ArrayList<Direction> directions = new ArrayList<Direction>();
        Direction direction;
        
        
        int Totalcells = cells.length * cells[0].length;
        int visitedCells = 1;
        Cell currentCell = stack.peek();

        while (visitedCells < Totalcells) {
            Map<Direction, Cell> neighbours = currentCell.getUnvisitedNeighbours();
            Object[] values = neighbours.values().toArray();
            for(int i = 0; i< values.length; i++){
                Cell neighbour = (Cell)values[i];
                directions.add(getKeyByValue(neighbours,neighbour));
            }
        }

    }
    
     //return key van een enummap
    private static <T, E> T getKeyByValue(Map<T, E> map, E value) 
    {
        for (Map.Entry<T, E> entry : map.entrySet()) 
        {
            if (value.equals(entry.getValue())) 
            {
                return entry.getKey();
            }
        }
        return null;
    }

}
