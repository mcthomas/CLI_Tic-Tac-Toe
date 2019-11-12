
public class Board {

    public char[][] grid;

    public Board() {
        this.grid = new char[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.grid[i][j] = '▢';
            }
        }
    }

    public boolean checkOpen(int x, int y) {
        if(y == 0 || y == 2) {
            if(y == 2) {
                y = 0;
            }
            else 
                y = 2;
        }
        if (this.grid[y][x] == '▢') {
            return true;
        } else
            return false;
    }
    
    public void move(int x, int y, char symbol) {
        if(y == 0 || y == 2) {
            if(y == 2) {
                y = 0;
            }
            else 
                y = 2;
        }
        this.grid[y][x] = symbol;
        return;
    }

    public boolean checkEnd() {
        if ((this.grid[0][0] != '▢' && this.grid[0][1] != '▢' && this.grid[0][2] != '▢')
                        && ((this.grid[0][0] == this.grid[0][1])
                                        && (this.grid[0][1] == this.grid[0][2]))) {
            return true;
        }
        
        else if ((this.grid[1][0] != '▢' && this.grid[1][1] != '▢' && this.grid[1][2] != '▢')
                        && ((this.grid[1][0] == this.grid[1][1])
                                        && (this.grid[1][1] == this.grid[1][2]))) {
            return true;
        }
        
        else if ((this.grid[2][0] != '▢' && this.grid[2][1] != '▢' && this.grid[2][2] != '▢')
                        && ((this.grid[2][0] == this.grid[2][1])
                                        && (this.grid[2][1] == this.grid[2][2]))) {
            return true;
        }
        
        else if ((this.grid[0][0] != '▢' && this.grid[1][0] != '▢' && this.grid[2][0] != '▢')
                        && ((this.grid[0][0] == this.grid[1][0])
                                        && (this.grid[1][0] == this.grid[2][0]))) {
            return true;
        }
        else if ((this.grid[0][1] != '▢' && this.grid[1][1] != '▢' && this.grid[2][1] != '▢')
                        && ((this.grid[0][1] == this.grid[1][1])
                                        && (this.grid[1][1] == this.grid[2][1]))) {
            return true;
        }
        else if ((this.grid[0][2] != '▢' && this.grid[1][2] != '▢' && this.grid[2][2] != '▢')
                        && ((this.grid[0][2] == this.grid[1][2])
                                        && (this.grid[1][2] == this.grid[2][2]))) {
            return true;
        }
        else if ((this.grid[0][0] != '▢' && this.grid[1][1] != '▢' && this.grid[2][2] != '▢')
                        && ((this.grid[0][0] == this.grid[1][1])
                                        && (this.grid[1][1] == this.grid[2][2]))) {
            return true;
        }
        else if ((this.grid[0][2] != '▢' && this.grid[1][1] != '▢' && this.grid[2][0] != '▢')
                        && ((this.grid[0][2] == this.grid[1][1])
                                        && (this.grid[1][1] == this.grid[2][0]))) {
            return true;
        }
        else
            return false;
        
    }
    
    public boolean checkDraw() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.grid[i][j] == '▢') {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateBoard() {
        int number = 4;
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            number--;
            System.out.print(number + " ");
            for (int j = 0; j < 3; j++) {
                if(j == 1 || j == 2) {
                    System.out.print(" ");
                }
                if(this.grid[i][j] == 'x') {
                    System.out.print("\u001B[31m" + this.grid[i][j] + "\u001B[0m");
                }
                else if(this.grid[i][j] == '◯') {
                    System.out.print("\u001B[34m" + this.grid[i][j] + "\u001B[0m");
                }
                else {
                    System.out.print(this.grid[i][j]);
                }
            }
        }
        System.out.println("");
        System.out.println("  1 2 3");
        System.out.println("");
    }

}
