public class Gameboard{
private chunk[][] board;
private int size;

public Gameboard(int size){
    this.size = size;
    this.board = new chunk[size][size];
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            board[i][j] = new chunk();
        }
    }
}



}
