
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    private boolean animate;

    public char[][] maze;
    public int[] pos = new int[4];
    
    public Maze(String filepath, boolean animate) throws FileNotFoundException{
        maze = readFile(filepath);
        pos[2] = -1;
        for(int row = 0; row < maze.length; row ++){
            for(int column = 0; column < maze[row].length; column ++){
                if(maze[row][column] == 'S'){
                    pos[0] = row; 
                    pos[1] = column;
                }
            }
        }
        for(int row = 0; row < maze.length; row ++){
            for(int column = 0; column < maze[row].length; column ++){
                if(maze[row][column] == 'E'){
                    pos[2] = row; 
                    pos[3] = column;
                }
            }
        }
        System.out.println("Start: "  + pos[0] + ", " + pos[1]);
        System.out.println("End: "  + pos[2] + ", " + pos[3]);
    }

    public Maze(String filepath) throws FileNotFoundException{
        this(filepath, false);
    }

    /*
     * base case: 
     * - if current square is valid
     * - if not, break somehow
     * recursion:
     * - all four steps
     */
    int foundE;
    int r;
    int c;
    public void introw(){
        this.r++;
    }
    public void derow(){
        this.r--;
    }
    public void intcol(){
        this.c ++;
    }
    public void decol(){
        this.c--;
    }
    public void intfound(){
        this.foundE++;
    }
    public void defound(){
        this.foundE--;
    }
    public String solve(int row, int col) throws FileNotFoundException{
        char[][] maze = readFile("maze1.txt");
        int totalE = 1;
        int steps = 0;
        r = row;
        c = col;
        maze[row][col] = '@';
        if(pos[2] == -1){
            return "There is no solution";
        }
        //while(foundE < totalE){
        for(int i = 0; i < 200; i++){
            if(maze[r-1][c] == 'E'){
                steps++;
                intfound();
            }
            if(canMove(r-1, c) == true){
                if(maze[r-1][c] != '@'){
                    maze[r-1][c] = '@';
                    derow();
                }
            }
            if(maze[r+1][c] == 'E'){
                steps++;
                intfound();
            }
            if(canMove(r+1, c) == true){
                if(maze[r+1][c] != '@'){
                    maze[r+1][c] = '@';
                    introw();
                }
            }
            if(maze[r][c-1] == 'E'){
                steps++;
                intfound();
            }
            if(canMove(r, c-1) == true){
                if(maze[r][c-1] != '@'){
                    maze[r][c-1] = '@';
                    decol();
                }
            }
            if(maze[r-1][c+1] == 'E'){
                steps++;
                intfound();
            }
            if(canMove(r, c+1) == true){
                if(maze[r][c+1] != '@'){
                    maze[r][c+1] = '@';
                    intcol();
                }
            }
        }
        System.out.println(arrToString(maze));
        r = 0;
        c = 0;
        return "";
    }

    public boolean canMove(int row, int col) throws FileNotFoundException{
        char[][] maze = readFile("maze1.txt");
        if(row < 1 || col < 1){
            return false;
        }
        if(row > maze.length-2 || col > maze[0].length-2){
            return false;
        }
        if(maze[row][col] == ' '){
            return true;
        }
        if(maze[row][col] == '@'){
            return false;
        }
        return false;
    } 

    public Maze(){
    }

    public static void main(String[] args) throws FileNotFoundException{
        Maze a = new Maze();
        lol b = new lol();
         //char[][] maze = readFile("maze2.txt");
         //System.out.println(arrToString(maze));
        //Maze m = new Maze("maze2.txt");
        //System.out.println(a.startCol + " " + a.startRow);
        a.solve(b.post(0), b.post(1));
    
    }

    public char[][] readFile(String filepath) throws FileNotFoundException{
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
