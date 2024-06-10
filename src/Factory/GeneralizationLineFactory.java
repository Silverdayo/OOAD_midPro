package Factory;

import java.awt.Point;

import Object.Line;
import Object.GeneralizationLine;

public class GeneralizationLineFactory implements ILineFactory{

    @Override
    public Line LineGenerate(Point startPoint, Point endPoint) {
        return new GeneralizationLine(startPoint, endPoint);
    }
    
}
