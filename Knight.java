class Knight extends Piece {

    public Knight(int num) {
        super(num);
    }
    
    @Override
    public int move(String from, String to) throws InvalidMoveException {
        super.move(from, to);
        int dist = (int) (from.charAt(0) - to.charAt(0));
        int absDist = Math.abs(dist);
        int absFromTo = Math.abs((int) from.charAt(1) - (int) to.charAt(1));
        boolean isInvalidDistance = absDist != 2 && absDist != 1;
        boolean isInvalidMove = (absDist == 1 && absFromTo != 2) || (absDist == 2 && absFromTo != 1);

        if(isInvalidDistance || isInvalidMove) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        return 0;
    }
}
