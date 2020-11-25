package lehigh;

import processing.core.PApplet;

import java.util.Arrays;

public class MovingBalls extends PApplet {

 //   Ball b1;
 //   Ball b2;
    int howManyBalls = 3;
    float x [] = new float[howManyBalls];
    float y [] = new float[howManyBalls];
    float xSpeed [] = new float[howManyBalls];
    float ySpeed [] = new float[howManyBalls];
    float color [][] = new float[howManyBalls][3];
    float radius = 30;

    public void settings() {
        size(250, 250);
        Arrays.fill(xSpeed, 1);
        Arrays.fill(ySpeed,1);
        for (int i=0; i<howManyBalls; i++){
            x[i] = random(radius, width-radius);
            y[i] = random(radius, height-radius);
            color[i] = new float[] {random(255), random(255), random(255)};
        }
    //    b1 = new Ball(64);
    //    b2 = new Ball(16);
    }

    public void draw() {
        background(51);
        fill(102);
        stroke(255);

        for (int i = 0; i<howManyBalls; i++) {
            fill(color[i][0],color[i][1],color[i][2]);
            ellipse(x[i], y[i], radius * 2, radius * 2);

            if (x[i] >= width || x[i] <= 0) {
                xSpeed[i] = xSpeed[i] * -1;
            }
            if (y[i] >= width || y[i] <= 0) {
                ySpeed[i] = ySpeed[i] * -1;
            }


            x[i] = x[i] + xSpeed[i];
            y[i] = y[i] + ySpeed[i];
        }
    }

    public static void main (String[]args){
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}

