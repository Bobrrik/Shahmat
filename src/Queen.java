public class Queen extends ChessPiece {

    public Queen(String color) {
        super("Q", color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {

            if ((line == toLine && column != toColumn) || line != toLine && column == toColumn) {

                if ((column == toColumn) && (line > toLine)) {//вниз
                    for (int i = line - 1; i > toLine; i--) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    }
                }
                if ((column == toColumn) && (line < toLine)) {//вверх
                    for (int i = line + 1; i < toLine; i++) {
                        if (chessBoard.board[i][column] != null) {
                            return false;
                        }
                    }
                }
                if ((line == toLine) && (column > toColumn)) {//лево
                    for (int i = column - 1; i > toColumn; i--) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
                if ((line == toLine) && (column < toColumn)) {//право
                    for (int i = column + 1; i < toColumn; i++) {
                        if (chessBoard.board[line][i] != null) {
                            return false;
                        }
                    }
                }
                return true;
            } else if (Math.abs(toLine - line) == Math.abs(toColumn - column) && (column != toColumn)) {

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
                    for (int i = line - 1; i < toLine; i++) {
                        j++;
                        if (chessBoard.board[i][j] == null) return false;

                    }
                }
                return true;
            } return false;

        }
        return false;
    }
}
