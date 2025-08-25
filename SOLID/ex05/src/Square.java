public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public void resize(int width, int height) {
        this.side = Math.max(width, height);
    }

    @Override
    public int area() {
        return side * side;
    }
}
