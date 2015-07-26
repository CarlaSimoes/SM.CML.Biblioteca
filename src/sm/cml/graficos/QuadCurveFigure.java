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
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class QuadCurveFigure extends Figure{
    
    public Shape shape;
    Point2D p = null;
    Point2D p2=null;
    double preX,preY,preX1,preY1,pcX,pcY,preCx,preCy;
    boolean leftX;
    boolean upY;

    // create new QuadCurve2D.Float
    public QuadCurveFigure(Point2D p1, Color color, double transp, boolean alis, int gros, boolean rel) {
        this.shape = new Line2D.Double(p1.getX(),p1.getY(),p1.getX(),p1.getY());
        p = p1;
        this.c = color;
        this.transparencia = transp;
        this.alisar = alis;
        this.grosor = gros;
        this.relleno = rel;

    }
    
    @Override
    public void updateShape(Point2D p2,Point2D pc, int pressNo) {
         if(pressNo<=2) ((Line2D)shape).setLine(p, p2);
         
         else{
             
             shape=new QuadCurve2D.Double(p.getX(),p.getY(),pc.getX(),pc.getY(),p2.getX(),p2.getY());
         }
        
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
    public void setPointMove1(Point2D pm1) {
        preX = ((Line2D)shape).getX2() - pm1.getX();
        preY = ((Line2D)shape).getY2() - pm1.getY();
        preX1 =   pm1.getX()-((Line2D)shape).getX1();
        preY1 =   pm1.getY()-((Line2D)shape).getY1();
        if(pm1.getX()<=((QuadCurve2D)shape).getCtrlX()){
            leftX=true;
            preCx= ((QuadCurve2D)shape).getCtrlX()-pm1.getX();
        }
        else if ((pm1.getX()>((QuadCurve2D)shape).getCtrlX())){
            preCx= pm1.getX()-((QuadCurve2D)shape).getCtrlX();
            leftX=false;
        }
            
        if(pm1.getY()<=((QuadCurve2D)shape).getCtrlY()){
            preCy= ((QuadCurve2D)shape).getCtrlY()-pm1.getY();
            upY=true;
        }
        else if(pm1.getY()>((QuadCurve2D)shape).getCtrlY()){
            preCy= pm1.getY()-((QuadCurve2D)shape).getCtrlY();
            upY=false;
        }
    }
    @Override
    public void setLocation(Point2D pos) {
      double dx=preX+pos.getX();
      double dy=preY+pos.getY();
      Point2D newp1 = new Point2D.Double(pos.getX()-preX1, pos.getY()-preY1);
      Point2D newp2 = new Point2D.Double(dx, dy);
      if(leftX){
          pcX=preCx+pos.getX();
      }
      else pcX=pos.getX()-preCx;
      if(upY) pcY=preCy+pos.getY();
      else pcY=pos.getY()-preCy;
            ((QuadCurve2D)shape).setCurve(newp1.getX(),newp1.getY(),pcX,pcY, newp2.getX(),newp2.getY());
       //((RoundRectangle2D)shape).setFrame(p1.getX()+pos.getX(), p1.getY()+pos.getY(), shape.getBounds().getWidth(), shape.getBounds().getHeight());
    }

    @Override
    public void updateShape(Point2D p1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       @Override
    public Rectangle2D getBounds() {
        return this.shape.getBounds2D();
    }
}
