import java.util.HashMap;

class Piece {
    public enum localTeam {BLACK, WHITE};
    private String name;
    private final localTeam team;
    static HashMap<String, Piece> grid;

    public Piece(int num) {
        if(num >= 5) this.team = Piece.localTeam.BLACK;
        else this.team = Piece.localTeam.WHITE;
    }

    public int move(String from, String to) throws InvalidMoveException{
        // protection from taking pieces in the same team
        if(grid.get(to) != null && grid.get(to).getTeam() == this.getTeam()) throw new InvalidMoveException("Invalid move when trying to move %s from %s to %s".formatted(toString(), from, to));
        
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public localTeam getTeam() {
        return team;
    }
}
