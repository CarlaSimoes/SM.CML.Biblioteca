/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.Color;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class EllipseFigure extends Figure {
    
    public Shape shape;
    Point2D p=null;
    double preX,preY;
    public EllipseFigure(Point2D p1, Color color, double transp, boolean alis, int gros, boolean rel) {
        //shape = new Rectangle2D.Double(0, 0, width, height);
        shape = new Ellipse2D.Double(p1.getX() - 3, p1.getY() - 3, 1, 1);
        p = p1;
        this.c = color;
        this.transparencia = transp;
        this.alisar = alis;
        this.grosor = gros;
        this.relleno = rel;
    }

    @Override
    public void setPointMove1(Point2D p1) {
        preX = ((Ellipse2D)shape).getX() - p1.getX();
        preY = ((Ellipse2D)shape).getY() - p1.getY();
    }

    @Override
    public void setLocation(Point2D pos) {
        double dx=preX+pos.getX();
        double dy=preY+pos.getY();
        double ancho=((Ellipse2D)shape).getBounds().getWidth();
        double alto=((Ellipse2D)shape).getBounds().getHeight();
        ((Ellipse2D)shape).setFrame(dx, dy, ancho, alto);
    }
    @Override
    public void updateShape(Point2D p1){
        double x = Math.min(p1.getX(), p.getX());
           double y = Math.min(p1.getY(), p.getY());
            double alto = Math.abs(p1.getY() - p.getY());
            double ancho = Math.abs(p1.getX() - p.getX());
            ((Ellipse2D)shape).setFrame(x, y, ancho, alto);
    }

    @Override
    public boolean containsPoint(Point2D p1) {
        return (this.shape.contains(p1));
    }
    @Override
    public Shape getShape() {
        return shape;
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
