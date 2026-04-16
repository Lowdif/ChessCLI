class Rook extends Piece {

    public Rook(int num) {
        super(num);
    }
    
    @Override
    public int move(String from, String to) throws InvalidMoveException {
        char fromChar = from.charAt(0);
        char toChar = to.charAt(0);
        int fromNum = (int) from.charAt(1);
        int toNum = (int) to.charAt(1);

        //This is logically equivalent to !(fromNum == toNum && fromChar != toChar) && !(fromChar == toChar && fromNum != toNum)
        if((fromNum == toNum) == (fromChar == toChar)) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        return 0;
    }
}
