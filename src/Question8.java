import javax.swing.*;

class Point{
    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void move (int x, int y){
        this.x = x;
        this.y = y;
    }

}

class PositivePoint extends Point{
    //객체 생성시 입력값 없음
    PositivePoint(){
        super(0,0);
    }
    //객체 생성시 입력값 x, y
    PositivePoint(int x, int y){
        super(x,y);
        if(getX() < 0 || getY() < 0){
            move(0,0);
        }
    }

    void move(int x, int y){
        //x 또는 y가 음수일 경우 이동하지 않음
        if(x<0||y<0) {
            return;
        }
        else {
            super.move(x, y);
        }

    }

    public String toString(){
        return "("+x+","+y+")의 점";
    }

}

public class Question8 {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint();

        p.move(10,10);
        System.out.println(p.toString() + "입니다.");

        p.move(-5,5);
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new  PositivePoint(-10,-10);
        System.out.println(p2.toString() + "입니다.");

    }
}
