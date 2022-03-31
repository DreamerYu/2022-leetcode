import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Dreamer Yu
 * @Date: 3/30/22 9:01 PM
 */
public class lc498 {


    public int[] findDiagonalOrder(int[][] mat) {


        int direction = 1;


        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int index = 0;
        int row = 0;
        int col = 0;

        int allcount = mat.length + mat[0].length - 1;

        while(true){
            res[index++] = mat[row][col];

            if(row == m-1 && col == n-1) break;

            if(direction == 1){
                if(row == 0 && col == n-1){
                    row++;
                    direction = -1;
                }else if(row == 0){
                    col++;
                    direction = -1;
                }else if(col == n-1){
                    row++;
                    direction = -1;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == m-1 && col == 0){
                    direction = 1;
                    col++;
                }else if(row == m-1){
                    direction = 1;
                    col++;
                }else if(col == 0){
                    direction = 1;
                    row++;
                }else{
                    row++;
                    col--;
                }

            }
        }

        return res;
    }
}
