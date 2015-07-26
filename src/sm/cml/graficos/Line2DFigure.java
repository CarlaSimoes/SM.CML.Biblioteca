/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class Line2DFigure extends Figure {

    public Shape shape;
    Point2D p=null;
    Point2D p2=null;
    double preX,preY,preX1,preY1;
    public Line2DFigure(Point2D p1, Color color,double transp,boolean alis, int gros, boolean rel) {
    //shape = new Rectangle2D.Double(0, 0, width, height);
     p=p1;
     p2=p1;
     this.shape = new Line2D.Float(p, p2);
     
     this.c=color;
     this.transparencia=transp;
    this.alisar=alis;
    this.grosor=gros;
    this.relleno=rel;
  }
   

    @Override
  public void updateShape(Point2D p1){
      p2=p1;
      ((Line2D)shape).setLine(p,p2);
      
  }
    
    @Override
   public boolean containsPoint(Point2D p1) {
        return ((Line2D)shape).ptLineDist(p1)<=2.0;
       
   }
    @Override
    public void setPointMove1(Point2D pm1) {
        preX = ((Line2D)shape).getX2() - pm1.getX();
        preY = ((Line2D)shape).getY2() - pm1.getY();
        preX1 =   pm1.getX()-((Line2D)shape).getX1();
        preY1 =   pm1.getY()-((Line2D)shape).getY1();
        
    }
   
   @Override
   public void setLocation(Point2D pos){
      double dx=preX+pos.getX();
      double dy=preY+pos.getY();
      Point2D newp1 = new Point2D.Double(pos.getX()-preX1, pos.getY()-preY1);
      Point2D newp2 = new Point2D.Double(dx, dy);
            ((Line2D)shape).setLine(newp1, newp2);
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