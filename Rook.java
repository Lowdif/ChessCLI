class Rook extends Piece {

    public Rook(int num) {
        super(num);
    }
    
    @Override
    public int move(String from, String to) throws InvalidMoveException {
        super.move(from, to);

        char fromChar = from.charAt(0);
        char toChar = to.charAt(0);
        int fromNum = (int) from.charAt(1);
        int toNum = (int) to.charAt(1);

        //This is logically equivalent to !(fromNum == toNum && fromChar != toChar) && !(fromChar == toChar && fromNum != toNum)
        if((fromNum == toNum) == (fromChar == toChar)) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        //prevents movement action from jumping over pieces
        //needs to be fixed
        boolean isVerticalMove = fromChar == toChar;
        if(isVerticalMove) {
            int dir = (int) Math.signum(toNum - fromNum);
            switch (dir) {
                case 1 -> {
                    for(int i = fromNum + 1; i < 9; i++) {
                        if (grid.get("%c%d".formatted(fromChar, i)) != null) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
                    }
                }
                case -1 -> {
                    for(int i = fromNum - 1; i > 0; i--) {
                        if (grid.get("%c%d".formatted(fromChar, i)) != null) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
                    }
                }
            }
        }
        else {
            int dir = (int) Math.signum(toChar - fromChar);
            switch (dir) {
                case 1 -> {
                    for(int i = fromChar - 'a'; i < 9; i++) {
                        if (grid.get("%c%d".formatted((char) (fromChar + i), fromNum)) != null) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
                    }
                }
                case -1 -> {
                    for(int i = fromChar - 'a'; i > 0; i--) {
                        if (grid.get("%c%d".formatted((char) (fromChar + i), fromNum)) != null) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
                    }
                }
            }
        }
    
        return 0;
    }
}
