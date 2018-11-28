package com.javarush.task.task39.task3905;

import java.awt.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {

        if (y >= image.length || y < 0 || x >= image[0].length || x < 0)
                return false;

            Color currentColor = image[y][x];
            if (currentColor == desiredColor) return false;


        Queue <Point> points = new ConcurrentLinkedQueue<>();

        points.add(new Point(x, y));
        while (!points.isEmpty()){
            int xx = (int)points.peek().getX();
            int yy = (int)points.peek().getY();
            if (isAbleToPoint(image, xx-1, yy, currentColor)) points.add(new Point(xx-1,yy));
            if (isAbleToPoint(image, xx+1, yy, currentColor)) points.add(new Point(xx+1,yy));
            if (isAbleToPoint(image, xx, yy-1, currentColor)) points.add(new Point(xx,yy-1));
            if (isAbleToPoint(image, xx, yy+1, currentColor)) points.add(new Point(xx,yy+1));

            Point point = points.poll();
            if (point!=null){
                image[(int)point.getY()][(int)point.getX()] = desiredColor;
            }

        }

        return true;
    }
    private boolean isAbleToPoint(Color[][] image, int x, int y, Color desiredColor){
        if (y < 0 || x < 0 || y >= image.length || x >= image[0].length) return false;

        if (image[y][x] != desiredColor) return false;

        return true;
    }
}
