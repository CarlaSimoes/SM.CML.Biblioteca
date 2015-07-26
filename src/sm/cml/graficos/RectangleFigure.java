/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.Color;
import java.awt.Composite;
import sm.cml.graficos.Figure;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class RectangleFigure extends Figure {
  
  public Shape shape;
  Point2D p=null;
  Point2D p2=null;
  double preX,preY;
  public RectangleFigure(Point2D p1, Color color,double transp,boolean alis, int gros, boolean rel ) {
    this.shape = new Rectangle((Point) p1);
    p=p1;
    p2=p1;
    this.c=color;
    this.transparencia=transp;
    this.alisar=alis;
    this.grosor=gros;
    this.relleno=rel;
  }
  
    @Override
    public void setPointMove1(Point2D p1) {
        preX = ((Rectangle)shape).x - p1.getX();
        preY = ((Rectangle)shape).y - p1.getY();
    }

    @Override
    public void setLocation(Point2D pos) {
       
         ((Rectangle)shape).setFrame(preX+pos.getX(), preY+pos.getY(), shape.getBounds().getWidth(), shape.getBounds().getHeight());
    }
    
    
  @Override
     public void updateShape(Point2D pos){
          p2=pos;
      double x = Math.min(pos.getX(), p.getX());
       double y = Math.min(pos.getY(), p.getY());
       ((Rectangle)shape).setRect(x, y, Math.abs(p.getX() - pos.getX()), Math.abs(p.getY() - pos.getY()));
      
  }
     @Override
    public boolean containsPoint(Point2D p1) {
         
            return   (((Rectangle)shape).contains(p1));
    }                      
    

    @Override
    public Shape getShape() {
        return shape;
    }
    
       @Override
    public Rectangle2D getBounds() {
        return this.shape.getBounds2D();
    }

    @Override
    public void updateShape(Point2D p1,Point2D pc, int pressNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
    

