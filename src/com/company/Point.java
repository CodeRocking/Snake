package com.company;


public class Point {

    public int x;
    public int y;


    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Point(com.company.Point thisPoint) {
        x = thisPoint.x;
        y = thisPoint.y;
    }

//    public Line toPoint(){
//        return new Line(angle,x,b);
//    }
//    public void setPoint(Point point){
//        x= point.x;
//        y=point.y;
//    }
}


