package Object;
import java.awt.Graphics;
import java.awt.Point;

public class UseCase extends BasicObject{
    final int UseCaseHeight = 80;
    final int UseCaseWidth = 120;
    final int dy = 45;

    public UseCase(Point origPoint){
        this.originPoint = origPoint;
        this.height = UseCaseHeight;
        this.width = UseCaseWidth;
        this.name = "UseCase name";
        setPort();
    }


    public void drawShape(Graphics g){

        g.drawOval((int) originPoint.getX(), (int) originPoint.getY(), width, height);

        int stringWidth = g.getFontMetrics(font).stringWidth(name);
		double empty = (UseCaseWidth - stringWidth)/2;
		g.setFont(font);	
		g.drawString(name, (int)originPoint.getX() + (int)empty, (int)originPoint.getY() + dy);
    }
}
