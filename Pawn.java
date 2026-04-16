class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(int num) {
        super(num);
    }

    @Override
    public int move(String from, String to) throws InvalidMoveException {

        //needs to be changed to allow taking pieces and en-passant
        if(from.charAt(0) != to.charAt(0)) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

        int fromNum = (int) from.charAt(1);
        int toNum = (int) to.charAt(1);
        int maxAllowed = 1;
        
        if(isFirstMove) {
            maxAllowed = 2;
            isFirstMove = false;
        }

        switch(this.getTeam()) {
            case Piece.localTeam.BLACK -> {
                if(fromNum < toNum || toNum != fromNum - maxAllowed) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));

            }
            case Piece.localTeam.WHITE -> {
                if(fromNum > toNum || toNum != fromNum + maxAllowed) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
            }
        }
        return 0;
    }
}
