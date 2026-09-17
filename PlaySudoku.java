import java.util.*;
public class Boni {
    static boolean checkValUntilInsert (int[][] grid, int val, int valog, int posx, int posy){
        boolean presence = false;
        checkCol :
        for (int a=0; a<9; a++){ 
            if (grid[a][posy]==val) {
                presence = true;
                break checkCol;
            }
        }
        checkLine :
        for (int b=0; b<9; b++){ 
            if (grid[posx][b]==val) {
                presence = true;
                break checkLine;
            }
        }
        if (!presence) {
            grid[posx][posy]=val;
            return true;
        }
        else {
            if (valog==val+1) return false;
            else if (val<9) return checkValUntilInsert(grid, val+1, valog, posx, posy);
            else return checkValUntilInsert(grid, 0, valog, posx, posy);
        }
    }
    static int[][] create (int[][] grid){
        boolean inserted=true;
        start :
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (grid[i][j]==0) {
                    Random nb = new Random();
                    int insert = nb.nextInt(9)+1;
                    inserted=checkValUntilInsert(grid, insert, insert, i, j);
                }
                if (!inserted) break start;
            }
        }
        if (!inserted) {
            for (int x=0; x<9; x++) Arrays.fill(grid[x], 0);
            return create(grid);
        } else { return grid; }
    } 
    public static void main (String arg[]){
        int[][] values =new int[9][9];
        for (int x=0; x<9; x++) Arrays.fill(values[x], 0);
        create(values);
        String lineSep = new String("-------------");
        for (int x=0; x<9; x++){
            if (x==0 || x==3 || x==6) System.out.println(lineSep);
            System.out.println("|"+values[x][0]+values[x][1]+values[x][2]+"|"+values[x][3]+values[x][4]+values[x][5]+"|"+values[x][6]+values[x][7]+values[x][8]+"|");
        }
        System.out.println(lineSep);
    }
}