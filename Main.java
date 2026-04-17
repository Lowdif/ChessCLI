import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Board b = new Board();
        //b.initBoard();
        b.drawBoard();
        Scanner s = new Scanner(System.in);
        while (true) { 
            System.out.println("Select a piece to move:");
            String piece = s.nextLine();
            if("q".equals(piece)) break;

            System.out.println("Move piece to:");
            String pos = s.nextLine();
            b.movePiece(piece, pos);
        }
        s.close();
    }
}
