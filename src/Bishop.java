public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super("B", color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (Math.abs(toLine - line) == Math.abs(toColumn - column) && (column != toColumn)) {

            if (toColumn > column && toLine > line) {
                int j = column;
                for (int i = line + 1; i < toLine; i++) {
                    j++;
                    if (chessBoard.board[i][j] == null) return false;
                }
            }
            if (toColumn > column && toLine < line) {
                int j = column;
                for (int i = line + 1; i < toLine; i++) {
                    j--;
                    if (chessBoard.board[i][j] == null) return false;
                }
            }
            if (toColumn < column && toLine < line) {
                int j = column;
                for (int i = line - 1; i > toLine; i--) {
                    j--;
                    if (chessBoard.board[i][j] == null) return false;

                }
            }
            if (toColumn < column && toLine > line) {
                int j = column;
                for (int i = line - 1; i > toLine; i--) {
                    j++;
                    if (chessBoard.board[i][j] == null) return false;

                }
            }

        } else return false;
        return (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()));
    }
}
