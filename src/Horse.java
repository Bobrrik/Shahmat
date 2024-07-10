public class Horse extends ChessPiece {
    public Horse(String color) {
        super("H", color);
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((chessBoard.board[toLine][toColumn] == null) || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {

        } else return false;
        int Dvij1 = Math.abs(toLine - line);
        int Dvij2 = Math.abs(toColumn - column);
        return (Dvij2 == 2 && Dvij1 ==1) || (Dvij2 == 1 && Dvij1 ==2);
    }

}
