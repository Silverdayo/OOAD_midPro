package Object;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
public class Port {
    final int portWidth = 10;

    private Point position;
    private ArrayList<Line> connectedLine = new ArrayList<Line>();
    private Direction dir;

    public Port(Point position){
        this.position = position;
        this.dir = null;
    }

    public Port(Point position, Direction dir){
        this.position = position;
        this.dir = dir;
    }

    public Port(Direction dir){
        this.dir = dir;
    }

    public void addLine(Line line){
        connectedLine.add(line);
    }

    public void removeLine(Line line){
        connectedLine.remove(line);
    }

    public Point getPosition(){
        return this.position;
    }

    public void setPosition(Point point){
        this.position = point;
    }

    public Direction getDirection(){
        return this.dir;
    }

    public void drawPort(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect((int)position.getX() - portWidth/2, (int)position.getY() - portWidth/2, portWidth, portWidth);
    }

    public void resetLine(){
        for (Line line : connectedLine) {
            line.reset();
        }
    }
}
