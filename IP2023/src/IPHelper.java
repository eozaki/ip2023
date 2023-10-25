public class IPHelper {
  static int random(int limit) {
    return (int)(Math.random() * limit + 1);
  }
  
  static int constrain(int n, int min, int max) {
    if(n > max) return max;
    if(n < min) return min;
    
    return n;
  }
  
  static boolean booleanRandom() {
    return (Math.random() > 0.5);
  }
  
  static boolean[][] booleanMatrix(int lines, int columns) {
    boolean response[][] = new boolean[lines][columns];
    
    for(int i = 0; i <= lines; i++) {
      for(int j = 0; j <= columns; j++) {
        response[i][j] = booleanRandom();
      }
    }

    return response;
  }

  static boolean[][] chessboardMatrix() {
    boolean[][] board = new boolean[8][8];

    for(int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++) {
        board[i][j] = ((i + j) % 2 == 0);
      }
    }

    return board;
  }
  
  static double distance(int xa, int xb, int ya, int yb) {
    return Math.sqrt(Math.pow((xa - xb), 2) + Math.pow((ya - yb), 2));
  }
}
