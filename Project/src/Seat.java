public class Seat {
    int x;
    int y;
    boolean used;

    public Seat(int x, int y) {
        this.x = x;
        this.y = y;
        this.used = false;
    }

    public boolean IsUsed() {
        return used;
    }

    public void SetUsed(boolean used) {
        this.used = used;
    }
}
