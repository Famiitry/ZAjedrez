import java.util.ArrayList;
import java.util.List;

public class TableroAjedrez {

    
    public enum Pieza {
        Alfil,
        AlfilNegro,
        Torre,          
        Reina,
        Caballo,
        Peón,
    }

    private List<Movimiento> getPossibleMovements(Pieza pieza, int fila, int columna) {
        
        List<Movimiento> movements = new ArrayList<>();

        switch (pieza){
            
            case Alfil:
                movements.addAll(getPossibleAlfilMovements(fila, columna));
                break;
            
            case Torre:
                movements.addAll(getPossibleTorreMovements(fila, columna));
                break;        
            case Reina:
                movements.addAll(getPossibleReinaMovements(fila, columna));
                break;
            case Caballo:
                movements.addAll(getPossibleCaballoMovements(fila, columna));
                break;
            case Peón:
                movements.addAll(getPossiblePeónMovements(fila, columna));
                break;
        }

        return movements;
    }
    private List<Movimiento> getPossibleTorreMovements(int fila, int columna) {
    List<Movimiento> movements = new ArrayList<>();

    // Movimientos horizontales (filas)
    for (int i = 0; i < 8; i++) {
        if (i != fila) {
            movements.add(new Movimiento(i, columna));
        }
    }

    // Movimientos verticales (columnas)
    for (int j = 0; j < 8; j++) {
        if (j != columna) {
            movements.add(new Movimiento(fila, j));
        }
    }

    return movements;
}

    private List<Movimiento> getPossibleAlfilMovements(int fila, int columna) {
        List<Movimiento> movements = new ArrayList<>();

        // Check diagonal movements
        for (int i = 1; i < 8; i++) {
            int newFila = fila + i;
            int newColumna = columna + i;
            if (isValidMove(newFila, newColumna)) {
                movements.add(new Movimiento(newFila, newColumna));
            }

            newFila = fila - i;
            newColumna = columna - i;
            if (isValidMove(newFila, newColumna)) {
                movements.add(new Movimiento(newFila, newColumna));
            }

            newFila = fila + i;
            newColumna = columna - i;
            if (isValidMove(newFila, newColumna)) {
                movements.add(new Movimiento(newFila, newColumna));
            }

            newFila = fila - i;
            newColumna = columna + i;
            if (isValidMove(newFila, newColumna)) {
                movements.add(new Movimiento(newFila, newColumna));
            }
        }

        return movements;
    }
    
    private List<Movimiento> getPossibleReinaMovements(int fila, int columna) {
    List<Movimiento> movements = new ArrayList<>();

    // Movimientos horizontales (filas)
    for (int i = 0; i < 8; i++) {
        if (i != fila) {
            movements.add(new Movimiento(i, columna));
        }
    }

    // Movimientos verticales (columnas)
    for (int j = 0; j < 8; j++) {
        if (j != columna) {
            movements.add(new Movimiento(fila, j));
        }
    }

    // Movimientos diagonales
    for (int d = 1; d < 8; d++) {
        int newRow, newCol;

        // Diagonal superior izquierda
        newRow = fila - d;
        newCol = columna - d;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }

        // Diagonal superior derecha
        newRow = fila - d;
        newCol = columna + d;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }

        // Diagonal inferior izquierda
        newRow = fila + d;
        newCol = columna - d;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }

        // Diagonal inferior derecha
        newRow = fila + d;
        newCol = columna + d;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }
    }

    return movements;
}
    private List<Movimiento> getPossibleCaballoMovements(int fila, int columna) {
    List<Movimiento> movements = new ArrayList<>();

    // Movimientos en forma de "L"
    int[][] knightMoves = {
        {-2, 1}, {-1, 2}, {1, 2}, {2, 1},  // Hacia adelante y a la derecha
        {2, -1}, {1, -2}, {-1, -2}, {-2, -1}  // Hacia atrás y a la izquierda
    };

    for (int[] move : knightMoves) {
        int newRow = fila + move[0];
        int newCol = columna + move[1];
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }
    }

    return movements;
}
    private List<Movimiento> getPossiblePeónMovements(int fila, int columna) {
    List<Movimiento> movements = new ArrayList<>();

    // Peón avanza una casilla hacia adelante
    int newRow = fila - 1;
    int newCol = columna;
    if (isValidMove(newRow, newCol)) {
        movements.add(new Movimiento(newRow, newCol));
    }

    // Peón puede avanzar dos casillas desde su posición inicial
    if (fila == 6) {
        newRow = fila - 2;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }
    }

    // Peón puede capturar en diagonal
    int[] diagonalMoves = {-1, 1};
    for (int d : diagonalMoves) {
        newCol = columna + d;
        if (isValidMove(newRow, newCol)) {
            movements.add(new Movimiento(newRow, newCol));
        }
    }

    return movements;
}

    // Implement similar methods for other pieces

    private boolean isValidMove(int fila, int columna) {
        // Check if the move is within the board
        return fila >= 0 && fila < 8 && columna >= 0 && columna < 8;
    }

    public class Movimiento {
        private int fila;
        private int columna;

        public Movimiento(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        public int getFila() {
            return fila;
        }

        public int getColumna() {
            return columna;
        }
    }
}
