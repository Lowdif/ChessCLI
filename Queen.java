class Queen extends Piece {

    public Queen(int num) {
        super(num);
    }

    @Override
    public int move(String from, String to) throws InvalidMoveException {
        super.move(from, to);
        char fromChar = from.charAt(0);
        char toChar = to.charAt(0);
        int dist = (int) (fromChar - toChar);
        int fromNum = (int) from.charAt(1);
        int toNum = (int) to.charAt(1);

        boolean isNotDiagonalMove = dist == 0 || (fromNum + dist != toNum && fromNum - dist != toNum);
        boolean isNotLineMove = (fromNum == toNum) == (fromChar == toChar);
        if(isNotDiagonalMove && isNotLineMove) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        return 0;
    }
    
}
