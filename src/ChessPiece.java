public abstract class ChessPiece {
    private final String color,Symbol;
    boolean check = true;

    public ChessPiece(String symbol, String color) {
        this.Symbol = symbol;
        this.color = color;
    }
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public String getSymbol() {return Symbol;}
    public String getColor() {return color;}
    public boolean checkPos(int pos) {return pos >= 0 && pos <= 7;}
}


