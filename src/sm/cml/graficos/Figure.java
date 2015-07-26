/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.graficos;

/**
 *
 * @author carla
 */

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
 
public abstract class Figure {

 
   int left, top;      // Position of top left corner of rectangle that bounds this shape.
   int width, height;  // Size of the bounding rectangle.
   Color c,cRelleno = Color.black;  // Color of this shape.
   boolean relleno = false;
   double transparencia =1.0;
   boolean alisar=false;
   boolean editar=false;
   int grosor,stroke,fillType=0;
   public int forma;
   
  /**
   * 
   * @param f 
   */
   public void setForm(int f) {
        this.forma = f;
    }
    /**
     * 
     * @return forma
     */
    public int getForm(){
        return this.forma;
    }
   /**
    * 
    * @param c 
    */
    public void setColor(Color c) {
        this.c = c;
    }
    /**
     * 
     * @return Color c
     */
    public Color getColor(){
        return c;
    }
    /**
     * 
     * @param Color cr 
     */
    public void setColorRelleno(Color cr){
        this.cRelleno=cr;
    }
    /**
     * 
     * @return Color cRelleno
     */
    public Color getColorRelleno(){
        return cRelleno;
    }

    /**
     * 
     * @param rel 
     */
    public void setRelleno(boolean rel) {
        this.relleno = rel;
    }
    
   /**
    * 
    * @return boolean relleno
    */
    public boolean getRelleno(){
     return relleno;
    }
    
    /**
     * 
     * @param transp 
     */
    public void setTransparencia(double transp){
        this.transparencia=transp;
    }
    /**
     * 
     * @return double transparencia
     */
    public double getTransparencia(){
        return transparencia;
    }
    /**
     * 
     * @param alis 
     */
    public void setAlisar(boolean alis) {
        this.alisar = alis;
    }
    /**
     * 
     * @return boolean alisar
     */
    public boolean getAlisar(){
        return alisar;
    }
    /**
     * 
     * @param edit 
     */
    public void setEditar(boolean edit){
        this.editar=edit;
    }
    /**
     * 
     * @return boolean editar
     */
    public boolean getEditar(){
        return editar;
    }
    /**
     * 
     * @param gros 
     */
    public void setGrosor(int gros){
        this.grosor=gros;
    }
    /**
     * 
     * @return int grosor
     */
    public int getGrosor(){
        return this.grosor;
    }
    /**
     * 
     * @return int Stroke
     */
    public int getStroke(){
        return this.stroke;
    }
    /**
     * 
     * @param s 
     */
    public void setStroke(int s){
        this.stroke=s;
    }
    /**
     * 
     * @param t 
     */
    public void setFillType(int t){
        this.fillType=t;
    }
    /**
     * 
     * @return int fillType
     */
    public int getFillType(){
        return this.fillType;
    }
    
    public void paintFig(Graphics g2d){
       
    }
    /**
     * 
     * @return Shape 
     */
   public abstract Shape getShape();
   /**
    * 
    * @param p1
    * @return boolean containsPoint
    */
   public abstract boolean containsPoint(Point2D p1);
   /**
    * 
    * @param p1 
    */
   public abstract void setPointMove1(Point2D p1);
   /**
    * 
    * @param pos 
    */
   public abstract void setLocation(Point2D pos);
   /**
    * 
    * @return Rectangle2D
    */
   public abstract Rectangle2D getBounds();
   
    /**
     *
     * @param p1
     */
    public abstract void updateShape(Point2D p1);
    /**
     * 
     * @param p2
     * @param pc
     * @param pressNo 
     */
    public abstract void updateShape(Point2D p2,Point2D pc,int pressNo);
   
        
    

}  // end of class Figure



 
