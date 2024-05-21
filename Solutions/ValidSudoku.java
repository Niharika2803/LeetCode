import java.util.*;

class  ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = null;
        Set<Character> colSet = null;

        //check every row & col
        for(int i = 0; i < 9; i++){
            rowSet = new HashSet<>();
            colSet = new HashSet<>();

            //each element in row & col
            for(int j = 0; j < 9; j++){
                char r = board[i][j]; //row i, col j
                char c = board[j][i]; //row j, col i

                //check row (exclude '.')
                if (r != '.'){
                    if (rowSet.contains(r)){
                        return false;
                    }
                    else {
                        rowSet.add(r);
                    }
                }

                //check col (exclude '.')
                if (c != '.'){
                    if (colSet.contains(c)){
                        return false;
                    }
                    else {
                        colSet.add(c);
                    }
                }
            }
        }

        // 3 X 3 block
        for (int i = 0; i < 9; i = i+3){
            for (int j = 0; j < 9; j = j+3){
                if (!checkBlock(i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }


    // function to validate 3 X 3 block
    public boolean checkBlock (int idxI, int idxJ, char[][] board){
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3; // end indices for block
        int cols = idxJ + 3;

        for(int i = idxI; i < rows; i++){
            for (int j = idxJ; j < cols; j++){
                if(board[i][j] == '.'){
                    continue; //skip empty spaces
                }
                if(blockSet.contains(board[i][j])){
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }
        return true;
    }
}