
public class Demo05 {
    static int areaAfterResize(Shape s) {
        s.resize(5, 4); // width=5, height=4
        return s.area();
    }

    public static void main(String[] args) {
        System.out.println(areaAfterResize(new Rectangle(0,0))); // 20
        System.out.println(areaAfterResize(new Square(0)));      // 25 (square resizes correctly)
    }
}
