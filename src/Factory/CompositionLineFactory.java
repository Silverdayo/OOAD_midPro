package Factory;

import java.awt.Point;

import Object.Line;
import Object.CompositionLine;

public class CompositionLineFactory implements ILineFactory{

    @Override
    public Line LineGenerate(Point startPoint, Point endPoint) {
        return new CompositionLine(startPoint, endPoint);
    }
    
}
