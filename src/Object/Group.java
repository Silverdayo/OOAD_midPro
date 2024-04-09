package Object;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


public class Group extends BasicObject{
    private ArrayList<Shape> member;

    public Group(ArrayList<Shape> selectedArrayList){
        this.member = selectedArrayList;

    }

    public ArrayList<Shape> getMembers(){
        return this.member;
    }

    public void changeName(String name){}

    public String get_Name(){return null;}

    public void setPort(){
        for (Shape it : this.member) {
            ((BasicObject)it).setPort();
        }
    }
    
    public Point inside(Point point){
        Point returnPoint = null;
        
        for (Shape it : member) {
            if(it.inside(point) != null){
                returnPoint = it.inside(point);
                break;
            }
        }
        return returnPoint;
    }

    public void focused(Graphics g){
        for (Shape it : member) {
            it.focused(g);
        }
    }

    public void setPoint(Point point){
        for (Shape it : this.member) {
            it.setPoint(point);
        }
    }

    public void add_connectedLine(Line line){}

    public void remove_connectedLine(Line line){}

    public void mode_changeName(){}

    @Override
    public void drawShape(Graphics g){
        for (Shape it : member) {
            it.drawShape(g);
        }
    }
    
    public Point getPoint(){
        Point point = new Point(0,0);
        for (Shape it : this.member) {
            point.x += it.getPoint().getX();
            point.y += it.getPoint().getY();
        }
        point.x /= member.size();
        point.y /= member.size();
        return point;
    }
}
