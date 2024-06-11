package Object;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import Screen.Canvas;



public class Group extends BasicObject{
    private ArrayList<BasicObject> member;

    public Group(ArrayList<BasicObject> selectedArrayList){
        this.member = selectedArrayList;

    }

    public ArrayList<BasicObject> getMembers(){
        return this.member;
    }

    public void changeName(String name){}

    public String get_Name(){return null;}

    public void setPort(){
        for (BasicObject it : this.member) {
            it.setPort();
        }
    }
    
    public Point inside(Point point){
        Point returnPoint = null;
        
        for (BasicObject it : member) {
            if(it.inside(point) != null){
                returnPoint = it.inside(point);
                break;
            }
        }
        return returnPoint;
    }

    public void focused(Graphics g){
        for (BasicObject it : member) {
            it.focused(g);
        }
    }

    public void setPoint(Point point){
        for (BasicObject it : this.member) {
            it.setPoint(point);
        }
    }

    public void add_connectedLine(Line line){}

    public void remove_connectedLine(Line line){}

    public void mode_changeName(){}

    @Override
    public void drawShape(Graphics g){
        for (BasicObject it : member) {
            it.drawShape(g);
        }
    }
    
    public Point getPoint(){
        Point point = new Point(0,0);
        for (BasicObject it : this.member) {
            point.x += it.getPoint().getX();
            point.y += it.getPoint().getY();
        }
        point.x /= member.size();
        point.y /= member.size();
        return point;
    }

    public void UnGroup(){
        Canvas canvas = Canvas.getCanvas();
        for (BasicObject it : member) {
            canvas.addShape(it);
        }
        canvas.removeShape(this);
    }
}
