/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;


import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author carla
 */
public class RoundRectFigure extends Figure {
    
  public Shape shape;
  Point2D p=null;
   double preX,preY;
    public RoundRectFigure(Point2D p1, Color color, double transp, boolean alis, int gros, boolean rel) {
        shape = new RoundRectangle2D.Double(p1.getX(), p1.getY(), 0, 0, 50, 50);
        p = p1;
        this.c = color;
        this.transparencia = transp;
        this.alisar = alis;
        this.grosor = gros;
        this.relleno = rel;
    }

    @Override
    public void setPointMove1(Point2D p1) {
       preX = ((RoundRectangle2D)shape).getMinX() - p1.getX();
       preY = ((RoundRectangle2D)shape).getMinY() - p1.getY();
    }

    @Override
    public void setLocation(Point2D pos) {
        ((RoundRectangle2D)shape).setFrame(preX+pos.getX(), preY+pos.getY(), shape.getBounds().getWidth(), shape.getBounds().getHeight());
    }
    
  @Override
    public void updateShape(Point2D p1) {
        double x = Math.min(p1.getX(), p.getX());
        double y = Math.min(p1.getY(), p.getY());
        ((RoundRectangle2D) shape).setRoundRect(x, y, Math.abs(p.getX() - p1.getX()), Math.abs(p.getY() - p1.getY()), 50, 50);

    }
    @Override
    public boolean containsPoint(Point2D p1) {
        return this.shape.contains(p1);
 
    }

    @Override
    public Shape getShape() {
        return shape;
    }
     @Override
    public void setGrosor(int g) {
        this.grosor=g;
    }

    @Override
    public void updateShape(Point2D p1,Point2D pc, int pressNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       @Override
    public Rectangle2D getBounds() {
        return this.shape.getBounds2D();
    }

    
}
