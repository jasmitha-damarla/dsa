import java.util.Scanner;

public class OverlapRectangles {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    boolean overlap(Point l1, Point r1, Point l2, Point r2 ){
        if(l1.x>r2.x || l2.x > r1.x){
            return false;
        }
        if(r1.y>l2.y || r2.y > l1.y){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Point l1 = new Point(0,10);
        Point r1 = new Point(10,0);

        Point l2 = new Point(5,5);
        Point r2 = new Point(15,0);

        OverlapRectangles ob = new OverlapRectangles();
        System.out.println(ob.overlap(l1,r1,l2,r2));
    }
}
