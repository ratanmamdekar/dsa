package com.lld;

import java.util.Map;

public class chess {
}

class Board{
    Map<Position,Piece> positionPieceMap;
    public void makeMove(Piece piece, Position destination) {
        positionPieceMap.remove(piece);
        positionPieceMap.put(destination,piece);
    }

    public Piece get(Position destination) {
        return positionPieceMap.get(destination);
    }
}

enum Color{
    BLACK,
    WHITE;
}

class Piece{
    Color color;
    Position currentPosition;
    Board currentBoard;

    void move(Position destination){
        if (isValid(destination)) {
            Piece destinationPiece = currentBoard.get(destination);
            if(destinationPiece!=null && !destinationPiece.color.equals(this.color)) {
                //capture;
            }
            currentPosition=destination;
        }

    }

    boolean isValid(Position destination) {
        Board temp = currentBoard;
        temp.makeMove(this,destination);
        if(KingInCheck(temp,color))
            return false;
        else {
            Piece destinationPiece = currentBoard.get(destination);
            if(destinationPiece!=null && destinationPiece.color.equals(this.color))
                return false;

            return isValidMove();
        }
    }

    boolean KingInCheck(Board temp, Color color) {
        return false;
    }

    private boolean isValidMove() {
        return false;
    }


    void getAllPossibleMoves(){

    }
}

class Position{

}

class Pawn{

}

class King{

}

class Queen{

}

class Knight{

}

class Bishop{

}

class Rook{

}
