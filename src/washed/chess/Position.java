package washed.chess;

public class Position {
    int x, y;

    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}