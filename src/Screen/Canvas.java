package Screen;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Factory.GroupFactory;
import Mode.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.EventListener;

import Object.BasicObject;
import Object.Line;
import Object.Shape;
import Object.Group;

public class Canvas extends JPanel{
    public Mode currentMode = null;
    private EventListener listener = null;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private ArrayList<Shape> selectedShapes = new ArrayList<Shape>();
    private ArrayList<Line> lines = new ArrayList<Line>();
    public Shape focusedShape = null;
    private Point SelectedAreaStartPoint = null;
    private Point SelectedAreaEndPoint = null;

    private static Canvas mainCanvas = null;
    final Color originalColor = new Color(220, 220, 220);

    public Canvas(){
        setBackground(originalColor);
    }

    public void getsize(){
        System.out.println(this.getSize().toString());
    }

    public static Canvas getCanvas(){
        if(mainCanvas == null){
            mainCanvas = new Canvas();
        }

        return mainCanvas;
    }

    public void setMode(){
        removeMouseListener((MouseListener)listener);
        removeMouseMotionListener((MouseMotionListener)listener);

        listener = currentMode;

        addMouseListener((MouseListener)listener);
        addMouseMotionListener((MouseMotionListener)listener);

        focusedShape = null;
        resetSelectedArea();
        repaint();
    }

    @Override
    public void paint(Graphics g){

        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = shapes.size()-1;i>=0;i--) {
            shapes.get(i).drawShape(g);
        }

        for (int i = lines.size()-1;i>=0;i--) {
            lines.get(i).drawShape(g);
        }

        if(focusedShape != null) focusedShape.focused(g);

        if(SelectedAreaStartPoint != null && SelectedAreaEndPoint != null){
            int[] ptx = {SelectedAreaStartPoint.x, SelectedAreaEndPoint.x, SelectedAreaEndPoint.x, SelectedAreaStartPoint.x};
            int[] pty = {SelectedAreaStartPoint.y, SelectedAreaStartPoint.y, SelectedAreaEndPoint.y, SelectedAreaEndPoint.y};
            g.setColor(new Color(100,100,100,33));
            g.fillPolygon(ptx, pty, 4);

            for (Shape it : selectedShapes) {
                it.focused(g);
            }
        }
        
    }

    public void addShape(BasicObject obj){
        shapes.add(obj);
        repaint();
    }

    public void addLine(Line l){
        lines.add(l);
        repaint();
    }

    public void removeLine(Line l){
        lines.remove(l);
        repaint();
    }

    public ArrayList<Shape> get_shapes(){
        return this.shapes;
    }

    public ArrayList<Line> get_lines(){
        return this.lines;
    }

    public Shape getInsideShape(Point point){
        Shape returnShape = null;
        for (Shape it : this.shapes) {
            if(it.inside(point) != null){
                if(returnShape == null || returnShape.getdepth() > it.getdepth()) returnShape = it;
            }
        }
        return returnShape;
    }

    public void changeObjName(){
        JFrame jframe = new JFrame("change object name");
        jframe.setSize(400, 300);
        jframe.setLocationRelativeTo(null);
        jframe.getContentPane().setLayout(new GridLayout(2,1,10,10));

        JTextArea newName = new JTextArea();
        jframe.add(newName);

        JPanel Jpanel = new JPanel();
        Jpanel.setLayout(new GridLayout(1,2,10,10));
        jframe.add(Jpanel);

        JButton confirm = new JButton("OK");
        Jpanel.add(confirm);
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                focusedShape.changeName(newName.getText());
                jframe.dispose();
                repaint();
            }
        });

        JButton cancel = new JButton("Cancel");
        Jpanel.add(cancel);
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jframe.dispose();
                repaint();
            }
        });

        jframe.setVisible(true);
    }

    public void selectedArea(Point startPoint, Point endPoint){
        selectedShapes.clear();
        SelectedAreaStartPoint = startPoint;
        SelectedAreaEndPoint = endPoint;
        for (Shape it : shapes) {
            if(inSelectedArea(it.getPoint())) selectedShapes.add(it);
        }
    }

    public void resetSelectedArea(){
        SelectedAreaStartPoint = null;
        SelectedAreaEndPoint = null;
        selectedShapes = new ArrayList<Shape>();
        focusedShape = null;
        repaint();
    }

    public boolean inSelectedArea(Point point){
        if(point == null) System.out.println("yes");
        return ((SelectedAreaStartPoint.x < point.x && SelectedAreaStartPoint.y < point.y)&&(SelectedAreaEndPoint.x > point.x && SelectedAreaEndPoint.y > point.y ))? true:false;
    }

    public void Group(){
        if(selectedShapes.size() >=2) {
            Group group = null;
            for (Shape it : selectedShapes) {
                shapes.remove(it);
            }
            group = GroupFactory.GroupGenerate(selectedShapes);
    
            shapes.add(group);
        }
        resetSelectedArea();
    }

    public void unGroup(){
        if(focusedShape instanceof Group){
            for (Shape it : ((Group)focusedShape).getMembers()) {
                shapes.add(it);
            }
            shapes.remove(focusedShape);
        }
    }
}
