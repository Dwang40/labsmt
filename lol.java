import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class lol {
    Maze b = new Maze();
    public int post(int numb) throws FileNotFoundException{
        int[] pos = new int[4];
        b.maze = b.readFile("maze1.txt");
        pos[2] = -1;
        for(int row = 0; row < b.maze.length; row ++){
            for(int column = 0; column < b.maze[row].length; column ++){
                if(b.maze[row][column] == 'S'){
                    pos[0] = row; 
                    pos[1] = column;
                }
            }
        }
        for(int row = 0; row < b.maze.length; row ++){
            for(int column = 0; column < b.maze[row].length; column ++){
                if(b.maze[row][column] == 'E'){
                    pos[2] = row; 
                    pos[3] = column;
                }
            }
        }
        if(numb == 0){
            return pos[0];
        }
        if(numb == 1){
            return pos[1];
        }
        if(numb == 2){
            return pos[2];
        }
        if(numb == 3){
            return pos[3];
        }
        return 10;
    }
}