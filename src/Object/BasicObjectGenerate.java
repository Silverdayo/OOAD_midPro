package Object;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import Object.Class;

public class BasicObjectGenerate {
    private static String DrawnObject = "";
    private static int objNumbers = 99;

    public static void set_DrawnObject(String type){
        DrawnObject = type;
    }

    public static BasicObject create_BasicObject(BasicObject obj, Point location){
        switch (DrawnObject) {
            case "class":
                obj = new Class(location, objNumbers);
                break;

            case "use case":
                obj = new UseCase(location,objNumbers);
                break;

            default:
                obj = null;
                break;
        }

        if(objNumbers>0)objNumbers--;

        return obj;

    }

    public static Line create_Line(Line line, Point starPoint, Point endPoint){
        switch (DrawnObject) {
            case "association line":
                line = new AssociationLine(starPoint, endPoint);
                break;

            case "generalization line":
                line = new GeneralizationLine(starPoint, endPoint);
                break;

            case "composition line":
                line = new CompositionLine(starPoint, endPoint);
                break;

            default:
            line = null;
                break;
        }

        return line;

    }

    public static Group Group(Group group, ArrayList<Shape> members){
        group = new Group(members);
        return group;
    }
}
