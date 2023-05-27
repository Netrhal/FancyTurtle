
public class Yortle {


    public static void koch(double s, int levels) {
        if (levels == 0) {
            yortle.forward(s);
            return;
        } else {
            s /= 3;
            koch(s, levels - 1);
            yortle.left(60);
            koch(s, levels - 1);
            yortle.right(120);
            koch(s, levels - 1);
            yortle.left(60);
            koch(s, levels - 1);
        }
    }

    public static void main(String[] args) {

        koch(300, 4);
    }

    static Turtle yortle = new Turtle(-200, 0);
}
