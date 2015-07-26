/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.Color;
import java.awt.Shape;
import sm.cml.graficos.Figure;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class PointFigure extends Figure {
    public Shape shape;
    Point2D p;
     public PointFigure(Point2D p1, Color color,double transp,boolean alis, int gros, boolean rel) {
        shape = new Ellipse2D.Double(p1.getX() - 3, p1.getY() - 3, 1, 1);
        p=p1;
        this.c=color;
        this.transparencia=transp;
        this.alisar=alis;
        this.grosor=gros;
        this.relleno=rel;
     }

    @Override
    public boolean containsPoint(Point2D p1) {
        return (this.shape.contains(p1));
    }

    @Override
    public void setLocation(Point2D pos) {
       ((Ellipse2D)shape).setFrame(pos.getX() - 3, pos.getY() - 3, 1, 1);
    }

    @Override
    public void updateShape(Point2D p1) {
      ((Ellipse2D)shape).setFrame(p1.getX() - 3, p1.getY() - 3, 1, 1);
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
    public void setPointMove1(Point2D p1) {
        ((Ellipse2D)shape).setFrame(p1.getX() - 3, p1.getY() - 3, 1, 1);
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
