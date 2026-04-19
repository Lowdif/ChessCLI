class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(int num) {
        super(num);
    }

    @Override
    public int move(String from, String to) throws InvalidMoveException {
        super.move(from, to);
        
        char fromChar = from.charAt(0);
        char toChar = to.charAt(0);
        boolean isCapture = grid.get(to) != null && (toChar == fromChar - 1) || (toChar == fromChar + 1);
        
        //needs to be changed to allow taking pieces and en-passant
        if(isCapture) return 0;

        //checks if movement is not on the same vertical line
        if(fromChar != toChar) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        int fromNum = (int) from.charAt(1);
        int toNum = (int) to.charAt(1);
        int maxAllowed = 1;
        
        //prevents pawn from ignoring other pieces when moving forward
        if(grid.get(to) != null) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        if(isFirstMove) {
            maxAllowed = 2;
            isFirstMove = false;
        }

        switch(this.getTeam()) {
            case localTeam.BLACK -> {
                if(fromNum < toNum || toNum != fromNum - maxAllowed) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

            }
            case localTeam.WHITE -> {
                if(fromNum > toNum || toNum != fromNum + maxAllowed) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
            }
        }
        return 0;
    }
}
