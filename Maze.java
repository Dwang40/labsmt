package Maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    private boolean animate;

    private char[][] maze;
    private int startRow;
    private int startCol;

    public Maze(String filepath, boolean animate) throws FileNotFoundException{
        maze = readFile(filepath);
        for(int row = 0; row < maze.length; row ++){
            for(int column = 0; column < maze[row].length; column ++){
                if(maze[row][column] == 'S'){
                    startRow = row; 
                    startCol = column;
                }
            }
        }
        System.out.println("Start: "  + startRow + ", " + startCol);
        
    }

    public Maze(String filepath) throws FileNotFoundException{
        this(filepath, false);
    }

    /*
     * base case: 
     * - if current square is valid
     * - if not, break somehow
     * recurion:
     * - all four steps
     */
    public String solve(int row, int col){
        
        if(!isValid(row, col) || maze[row][col] == '#'){
            
        }
    }

    public boolean isValid(int row, int col){
        return row > -1 && row < maze.length && col > -1 && col < maze[row].length;
    }








    public static void main(String[] args) throws FileNotFoundException{
        // char[][] maze = readFile("maze1.txt");
        // System.out.println(arrToString(maze));
        Maze m = new Maze("maze1.txt");
    
    }






    public static char[][] readFile(String filepath) throws FileNotFoundException{
        char[][] parsed = null;
       
        Scanner sc = new Scanner(new File(filepath));
        int numRows = 0;
        int maxCols = 0;
        while (sc.hasNextLine()) {
            numRows++;
            maxCols = Math.max(maxCols, sc.nextLine().length());
        }
        sc.close();

        parsed = new char[numRows][maxCols];

        sc = new Scanner(new File(filepath)).useDelimiter("");
        int row = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            for (int col = 0; col < line.length(); col++) {
                parsed[row][col] = line.charAt(col);
            }

            row ++;
        }
        sc.close();

       

        return parsed;
    }

    public static void printArray(char[][] arr) {
        for (char[] row : arr) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static String arrToString(char[][] arr) {
        String str = "";
        for (char[] row : arr) {
            for (char c : row) {
                str += c;
            }
            str += "\n";
        }
        return str;
    }

    public String toString(){
        return arrToString(maze);
    }
}
