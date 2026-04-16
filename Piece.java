class Piece {
    public enum localTeam {BLACK, WHITE};
    private String name;
    private final localTeam team;
    public Piece(int num) {
        if(num >= 5) this.team = Piece.localTeam.BLACK;
        else this.team = Piece.localTeam.WHITE;
    }

    public int move(String from, String to) {
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
