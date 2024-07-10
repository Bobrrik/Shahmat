import java.util.Arrays;

public class ChessBoard {
    ChessPiece[][] board = new ChessPiece[8][8];
    String nowPlayer;

    public static ChessBoard buildBoard() {
        ChessBoard board = new ChessBoard("White");

        board.board[0][0] = new Rook("White");
        board.board[0][1] = new Horse("White");
        board.board[0][2] = new Bishop("White");
        board.board[0][3] = new Queen("White");
        board.board[0][4] = new King("White");
        board.board[0][5] = new Bishop("White");
        board.board[0][6] = new Horse("White");
        board.board[0][7] = new Rook("White");
        board.board[1][0] = new Pawn("White");
        board.board[1][1] = new Pawn("White");
        board.board[1][2] = new Pawn("White");
        board.board[1][3] = new Pawn("White");
        board.board[1][4] = new Pawn("White");
        board.board[1][5] = new Pawn("White");
        board.board[1][6] = new Pawn("White");
        board.board[1][7] = new Pawn("White");

        board.board[7][0] = new Rook("Black");
        board.board[7][1] = new Horse("Black");
        board.board[7][2] = new Bishop("Black");
        board.board[7][3] = new Queen("Black");
        board.board[7][4] = new King("Black");
        board.board[7][5] = new Bishop("Black");
        board.board[7][6] = new Horse("Black");
        board.board[7][7] = new Rook("Black");
        board.board[6][0] = new Pawn("Black");
        board.board[6][1] = new Pawn("Black");
        board.board[6][2] = new Pawn("Black");
        board.board[6][3] = new Pawn("Black");
        board.board[6][4] = new Pawn("Black");
        board.board[6][5] = new Pawn("Black");
        board.board[6][6] = new Pawn("Black");
        board.board[6][7] = new Pawn("Black");
        return board;
    }

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int Startline, int Startcolumn, int EndLine, int EndColumn) {
        if (!checkPos(Startline) || !checkPos(Startcolumn)) {
            return false;
        }
        if (!nowPlayer.equals(board[Startline][Startcolumn].getColor())) {
            return false;
        }

        if (board[Startline][Startcolumn].canMoveToPosition(this, Startline, Startcolumn, EndLine, EndColumn)) {
            if (board[Startline][Startcolumn].getSymbol().equals("K") || board[Startline][Startcolumn].getSymbol().equals("R") || board[Startline][Startcolumn].getSymbol().equals("P")) {
                board[Startline][Startcolumn].check = false;
            }

            board[EndLine][EndColumn] = board[Startline][Startcolumn];
            board[Startline][Startcolumn] = null;
            this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";
            return true;
        }
        return false;
    }

    public void printBoard() {
        System.out.println("ход " + nowPlayer);
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
        for (int z = 7; z >= 0; z--) {
            System.out.print(z + "\t");
            for (int y = 0; y < 8; y++) {
                if (board[z][y] == null) {
                    System.out.print(".." + "\t");
                } else
                    System.out.print(board[z][y].getSymbol() + board[z][y].getColor().substring(0, 1).toLowerCase() + "\t");
            }
            System.out.println();
        }

    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling0() {
        if (nowPlayer.equals("White")) {
            if (!board[0][0].getSymbol().equals("R") || !board[0][4].getSymbol().equals("K")) {
                return false;
            }
            if (!board[0][0].check || !board[0][4].check) {
                return false;
            }
            if (new King("White").isUnderAttack(this, 0, 2)) {
                return false;
            }
            if (board[0][1] == null && board[0][2] == null && board[0][3] == null) {
                board[0][3] = board[0][0];
                board[0][2] = board[0][4];
                board[0][0] = board[0][4] = null;
                return true;
            }

        } else {
            if (!board[7][0].getSymbol().equals("R") || !board[7][4].getSymbol().equals("K")) {
                return false;
            }
            if (!board[7][0].check || !board[7][4].check) {
                return false;
            }
            if (new King("Black").isUnderAttack(this, 7, 2)) {
                return false;
            }
            if (board[7][1] == null && board[7][2] == null && board[7][3] == null) {
                board[7][3] = board[7][0];
                board[7][2] = board[7][4];
                board[7][0] = board[7][4] = null;
                return true;
            }
        }
        return false;
    }

    public boolean castling7() {
        if (nowPlayer.equals("White")) {
            if (!board[0][7].getSymbol().equals("R") || !board[0][4].getSymbol().equals("K")) {
                return false;
            }
            if (!board[0][7].check || !board[0][4].check) {
                return false;
            }
            if (new King("White").isUnderAttack(this, 0, 6)) {
                return false;
            }
            if (board[0][5] == null && board[0][6] == null) {
                board[0][5] = board[0][7];
                board[0][6] = board[0][4];
                board[0][7] = board[0][4] = null;
                return true;
            }

        } else {
            if (!board[7][7].getSymbol().equals("R") || !board[7][4].getSymbol().equals("K")) {
                return false;
            }
            if (!board[7][7].check || !board[7][4].check) {
                return false;
            }
            if (new King("Black").isUnderAttack(this, 7, 6)) {
                return false;
            }
            if (board[7][6] == null && board[7][5] == null) {
                board[7][5] = board[7][7];
                board[7][6] = board[7][4];
                board[7][7] = board[7][4] = null;
                return true;
            }
        }
        return false;
    }
}