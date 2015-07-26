/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class BoundingBoxFigure extends Figure {
     public Shape shape;
  Point2D p=null;
  Point2D p2=null;
  double preX,preY;
 
  public BoundingBoxFigure(Rectangle2D rect ) {
    this.shape = new Rectangle.Float();
    ((Rectangle2D)shape).setRect(rect);
    
    this.c=Color.BLACK;
    this.relleno=false;
    this.stroke=1;
    this.grosor=1;
   
  
  }

    @Override
    public void setPointMove1(Point2D p1) {
        preX = ((Rectangle2D)shape).getX() - p1.getX();
        preY = ((Rectangle2D)shape).getY() - p1.getY();
    }

    @Override
    public void setLocation(Point2D pos) {
       
         ((Rectangle2D)shape).setFrame(preX+pos.getX(), preY+pos.getY(), shape.getBounds().getWidth(), shape.getBounds().getHeight());
    }
    
    
  @Override
     public void updateShape(Point2D pos){
          p2=pos;
      double x = Math.min(pos.getX(), p.getX());
       double y = Math.min(pos.getY(), p.getY());
       ((Rectangle2D)shape).setRect(x, y, Math.abs(p.getX() - pos.getX()), Math.abs(p.getY() - pos.getY()));
      
  }
     @Override
    public boolean containsPoint(Point2D p1) {
         
            return   (((Rectangle2D)shape).contains(p1));
    }                      
    

    @Override
    public Shape getShape() {
        return shape;
    }

    @Override
    public void updateShape(Point2D p2, Point2D pc, int pressNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       @Override
    public Rectangle2D getBounds() {
        return this.shape.getBounds2D();
    }
    
}
