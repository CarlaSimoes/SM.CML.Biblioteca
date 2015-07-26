/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author carla
 */
public class NewLine2D extends Line2D.Float{
  
    public NewLine2D(Point2D p1, Point2D p2){
       
        super(p1,p2);
    }
    public boolean isNear(Point2D p) {
        return this.ptLineDist(p) <= 2.0;
    }
    
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
       
    }
    
}

