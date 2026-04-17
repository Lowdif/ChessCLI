import java.util.HashMap;

class Board {
    private String[][] gridNames = new String[8][8];
    private HashMap<String, Piece> grid = new HashMap<>();
    public Board() {
        for(int i = 0; i < gridNames.length; i++) {
            for(int j = 0; j < gridNames.length; j++) {
                int num = j+1;
                String s = String.format("%c%d", (char)('a' + i), num);
                gridNames[j][i] = s;
                
                Piece p;
                switch (num) {
                    case 2, 7 -> {
                        p = new Pawn(num);
                    }

                    case 1, 8 -> {
                        switch(s.charAt(0)) {
                            case 'h', 'a' -> {
                                p = new Rook(num);
                            }
                            case 'b', 'g' -> {
                                p = new Knight(num);
                            }
                            case 'c', 'f' -> {
                                p = new Bishop(num);
                            }
                            case 'd'-> {
                                p = new King(num);
                            }
                            default -> {
                                p = new Queen(num);
                            }
                        }
                    }

                    default -> p = null;
                }
                grid.put(s, p);
            }
        }
        Piece.grid = this.grid;
    }

    public void initBoard() {
        
    }

    public String[][] getGridNames() {
        return gridNames;
    }

    public void setGridNames(String[][] gridNames) {
        this.gridNames = gridNames;
    }

    public HashMap<String, Piece> getGrid() {
        return grid;
    }

    public void setGrid(HashMap<String, Piece> grid) {
        this.grid = grid;
    }

    public Piece getPiece(String p) {
        return grid.get(p);
    }

    public void movePiece(String from, String to) {
        Piece p = grid.get(from);
        if(p == null) {
            System.out.println("No piece there to be moved");
            return;
        }

        try {
            int status = p.move(from, to);
            if(status == -1) return;
            grid.put(from, null);
            grid.put(to, p);
            drawBoard();
        } catch (InvalidMoveException e) {
            System.err.println(e);
            drawBoard();
        }
        
    }

    public void printBoard() {
        for (String[] gridName : gridNames) {
            for (int j = 0; j < gridNames.length; j++) {
                System.out.print(gridName[j] + " ");
            }
            System.out.println();
        }
    }

    public void drawBoard() {
        for (int i = 0; i < gridNames.length; i++) {
            System.out.print(i+1 + " ");
            for (String g : gridNames[i]) {
                Piece symbol = grid.get(g);
                String s = "";
                if(symbol == null) s = " ";
                if(symbol instanceof Pawn) s = "P";
                if(symbol instanceof Rook) s = "R";
                if(symbol instanceof Knight) s = "K";
                if(symbol instanceof Bishop) s = "B";
                if(symbol instanceof Queen) s = "Q";
                if(symbol instanceof King) s = "§";

                System.out.print("[" + s + "]");
            }
            System.out.println();
        }

        for (int i = 0; i < gridNames.length; i++) System.out.print("  " + (char)('a' + i));
        System.out.println();
    }
}
