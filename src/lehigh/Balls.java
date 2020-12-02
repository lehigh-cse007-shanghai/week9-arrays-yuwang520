package lehigh;

import processing.core.PApplet;

import java.util.ArrayList;

public class Balls extends PApplet {
    class Ball{
        int x, y, radius;
        float speedx, speedy;
        int [] color;

        Ball(){
            radius = (int) random(5,20);
            x = (int) random(radius,width-radius);
            y = (int) random(radius,height-radius);
            speedx = random(0.8f,3.0f);
            speedy = random(0.8f, 3.0f);
            color = new int[] {(int)random(255), (int)random(255), (int)random(255)};
        }
        public void move(){
            fill(color[0],color[1],color[2]);
            ellipse(x, y, radius, radius);

            if (x >= width || x <= 0) {
                speedx = -speedx;
            }
            if (y >= width || y <= 0) {
                speedy = -speedy;
            }
            x += speedx;
            y += speedy;
        }
    }
    ArrayList<Ball> balls;

    public void settings() {
        size(400, 400);
        balls = new ArrayList<>();
        for(int i=0;i<100;i++){
            balls.add(new Ball());
        }
    }
    public void draw() {
        background(0);
        for(Ball ball:balls){
            ball.move();
        }
    }




    public static void main (String[]args){
        String[] processingArgs = {"Balls"};
        Balls balls = new Balls();
        PApplet.runSketch(processingArgs, balls);
    }
}
