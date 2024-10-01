package org.example.application;

import org.example.chess.ChessException;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source =  UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturePiece = chessMatch.performChessMove(source, target);
            }
            catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
