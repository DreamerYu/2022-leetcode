import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Dreamer Yu
 * @Date: 4/7/22 9:44 PM
 */
public class lc490_dfs {


    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {


        return dfs(maze, start[0],start[1],destination,new HashSet<>());
    }

    public boolean dfs(int[][] maze, int row, int col, int[] destination, Set<String> visited){
        if(row == destination[0] && col == destination[1]){
            return true;
        }

        visited.add(row+"-"+col);
        for(int[] d : dirs){
            int newrow = row;
            int newcol = col;
            while(newrow >= 0 && newrow < maze.length && newcol >= 0 && newcol < maze[0].length &&  maze[newrow][newcol] != 1){
                newrow += d[0];
                newcol += d[1];
            }
            newrow -= d[0];
            newcol -= d[1];
            if(!visited.contains(newrow+"-"+newcol) && dfs(maze, newrow,newcol,destination, visited)){
                return true;
            }

        }
        return false;
    }
}
