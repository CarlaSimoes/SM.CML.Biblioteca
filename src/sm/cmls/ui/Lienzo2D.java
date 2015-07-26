/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cmls.ui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import sm.cml.graficos.BoundingBoxFigure;
import sm.cml.graficos.EllipseFigure;
import sm.cml.graficos.Figure;
import sm.cml.graficos.Line2DFigure;
import sm.cml.graficos.PointFigure;
import sm.cml.graficos.QuadCurveFigure;
import sm.cml.graficos.RectangleFigure;
import sm.cml.graficos.RoundRectFigure;



/**
 *
 * @author carla
 */
public class Lienzo2D extends javax.swing.JPanel {
    private BufferedImage img;
    static final int FORMA_PUNTO = 0;
    static final int FORMA_LINE = 1;
    static final int FORMA_RECT = 2;
    static final int FORMA_ELLIPSE = 3;
    static final int FORMA_ROUNDRECT = 4;
    static final int FORMA_QUADCURVE = 5;
    
    public int forma;
    public int width;
    public int height;
    
    public Point2D p1;
    public Point2D p2;
    private Point2D newPoint;
    public int countVi;
    public boolean relleno = false;
    public double transparencia =1.0;
    public boolean alisar=false;
    public boolean editar=false;
    public int grosor=0;
    public int stroke=0;
    public int fillType=0;
    public boolean openNew=false;
    Color c = Color.black;
    Color cRelleno = Color.black;
    Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.01f);
    List<Figure> vShape = new ArrayList();
    Figure s;
    Figure boundingBox;

    private Figure beingMoved;
    private Point clickPoint;
    double preX,preY;
    Point2D pc;
    int pressNo = 0;
    final static float[] dashingPattern1 = {2f, 2f};
    final static Stroke stroke1 = new BasicStroke(2f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f);
    /**
     * Creates new form Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
    }

  /**
   * 
   * @param f 
   */
    public void setForm(int f) {
       
        this.forma=f;
    }
    /**
     * 
     * @return int forma
     */
    public int getForm(){
        return forma;
        
    }
    /**
     * 
     * @param color 
     */
    public void setColor(Color color) {      
        this.c=color;
        
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
     * @param color 
     */
    public void setColorRelleno(Color color) {
        this.cRelleno = color;
        
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
    public void setTransparencia(int transp){
        this.transparencia=(double)transp*0.01;
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
     * @return boolean editrar
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
     * @return float grosor
     */
    public float getGrosor(){
        return (float)grosor+1;
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
     * @return int stroke
     */
    public int getStroke(){
        return stroke;
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
     * @return int filType
     */
    public int getFillType(){
        return fillType;
    }
    
    public boolean isDrawed(){
        if(vShape.size()>=1) return true;
        return false;
    }
    
    public void setDimensions(int w, int h){
        this.width=w;
        this.height=h;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents
    /**
     * here occurs the update of each shape
     * while dragged
     * so it set location every time that the mouse
     * is dragged
     * @param evt 
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
         // Set end point of drag.  May change.
        if (!editar) {
            if(forma<5 && forma>0) p2.setLocation(evt.getX(), evt.getY());
            // After change, show new shape
            else if (forma == 5) {
                if (pressNo == 1) {
                    p2= new Point2D.Double(evt.getX(),evt.getY());
                    updateShape(forma, p2);
                   pressNo++;
                }
                if(pressNo==3) pc=evt.getPoint();
            }
            if(forma==0) p2=evt.getPoint();

            updateShape(forma, p2);
        }
        //If someone drags the mouse, and they just pressed inside
        //a shape, then move that shape.
        else {
            Point mouseLoc = evt.getPoint();
            if (beingMoved != null) {
               double x=mouseLoc.x;
               double y=mouseLoc.y;
               newPoint = new Point2D.Double(x,y);
         
               System.out.println(x+": "+y);
              
               clickPoint = mouseLoc;
               beingMoved.setLocation(clickPoint);
               boundingBox.setLocation(clickPoint);
            }  
        }
        this.repaint();
        
    }//GEN-LAST:event_formMouseDragged

   /**
    * All the events to create a shape depending
    * of wich phase of the creation it is
    * For the QuadCurve it is necessary a connection to other events
    * so that the shape is created and updated in pressed
    * @param evt 
    */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Save start point, and also initially
        // as end point, which drag will change.
        if (!editar) {
            p1 = evt.getPoint();
//            if (forma == 0) {
//                p2 = p1;
//            }
            if(forma<5) createShape(forma, p1);
            
            else if (forma == 5) {
                if (pressNo == 0) {
                    p1=evt.getPoint();
                    createShape(forma, p1);
                    pressNo++;
                } else if (pressNo == 3 && getSelectedShape(evt.getPoint()).getShape().contains(evt.getPoint()) ) {
                    
                    pc = evt.getPoint();
                    updateShape(forma,p2);
                    this.repaint();
                    
                } 

            }
       }
       else{
           clickPoint=evt.getPoint();
           
           beingMoved=getSelectedShape(clickPoint);
           if(beingMoved!=null){
               boundingBox= new BoundingBoxFigure(beingMoved.getBounds());
               boundingBox.setPointMove1(clickPoint);
               beingMoved.setPointMove1(clickPoint);
                System.out.println(beingMoved);
                if(beingMoved.getColor()!=c){
                    beingMoved.setColor(c);
                    this.repaint();
                }
                if(beingMoved.getGrosor()!=grosor){
                    beingMoved.setGrosor(grosor);
                    this.repaint();
                }
                
                if(beingMoved.getRelleno()!=relleno){
                    beingMoved.setRelleno(relleno);
                    if(beingMoved.getColorRelleno()!=cRelleno)
                        beingMoved.setColorRelleno(cRelleno);
                    this.repaint();
                }
                if(beingMoved.getStroke()!=stroke){
                    beingMoved.setStroke(stroke);
                    this.repaint();
                }
                
                
           }
           
           else System.out.println("Error any shape selected");
           
       }
    }//GEN-LAST:event_formMousePressed
    /**
     * Manage all the events to update 
     * setLocation to the shapes
     * in the case of quadcurve the connection is made with
     * the other mouse events
     * just to understand at what phase it is
     * and make an update in final released
     * @param evt 
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        //... If released at end of drag,
        //    which saves it in the drawing
        if (!editar) {
            
            if (forma == 5) {
                if (pressNo == 2) {
                    p2=evt.getPoint();
                    updateShape(forma,p2);
                    pressNo++;
                } 
                else if (pressNo == 3) {
                    pc=evt.getPoint();
                    pressNo = 0;
                    
                }
            }
            else {
                p2 = evt.getPoint();
                updateShape(forma,p2);
                
            }
            
           
        }
        else{ 
            beingMoved.setLocation(evt.getPoint());
            boundingBox.setLocation(evt.getPoint());
            clickPoint = null;
            beingMoved = null;
        }
        this.repaint();
    
    }//GEN-LAST:event_formMouseReleased
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * creates the specific 
     * shape depending on the 
     * variable forma selected
     * receives the first inicial point
     * @param forma
     * @param p1 
     */
    private void createShape(int forma, Point2D p1) {
        
        if (forma == FORMA_PUNTO) {
            s = new PointFigure(p1,c,transparencia,alisar,grosor,relleno); 
        }
        if (forma == FORMA_LINE) {
            s= new Line2DFigure(p1,c,transparencia,alisar,grosor,relleno);
        }
        if (forma == FORMA_RECT) {
           // s = new Rectangle((Point) p1);
            s= new RectangleFigure(p1,c,transparencia,alisar,grosor,relleno);
        }
        if (forma == FORMA_ELLIPSE) {
            s = new EllipseFigure(p1,c,transparencia,alisar,grosor,relleno);
        }
        if(forma== FORMA_ROUNDRECT){
            s= new RoundRectFigure(p1,c,transparencia,alisar,grosor,relleno);
        }
        if(forma== FORMA_QUADCURVE){
            s= new QuadCurveFigure(p1,c,transparencia,alisar,grosor,relleno);
        }
        
         
        vShape.add(s);
    }
    
    /**
     * after being created the shape will
     * be updated 
     * for each shape will receive the new point
     * in special for quadcurve receives the control point 
     * and the flag pressNo
     * @param form
     * @param p 
     */
    private void updateShape(int form, Point2D p) {
           if(form==0) ((PointFigure)s).updateShape(p);
           else if(form==1) ((Line2DFigure)s).updateShape(p);
           else if(form==2) ((RectangleFigure)s).updateShape(p);
           else if(form==3) ((EllipseFigure)s).updateShape(p);
           else if(form==4) ((RoundRectFigure)s).updateShape(p);
           else if(form==5){
               
               ((QuadCurveFigure)s).updateShape(p,pc,pressNo);
           } 
    }
    


    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Atributos
        
        Shape clipArea= new Rectangle(0,0,width,height);

        g2d.setClip(clipArea);
        g2d.draw(clipArea);
        int size=vShape.size();
        //Pintar
        if(boundingBox!=null){
            boundingBox.getShape();
            g2d.setPaint(boundingBox.getColor());
            float dash1[] = { 10.0f };
            float gros = (float) boundingBox.getGrosor() ;
            g2d.setStroke(new BasicStroke(gros,
      BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
            g2d.draw(boundingBox.getShape());
        }
        for (Figure f : vShape) {
            f.paintFig(g2d);
            if (f == vShape.get(size - 1)) {
                if (c != f.getColor()) {
                    f.setColor(c);
                }
                
                if (transparencia != f.getTransparencia()) {
                    g2d.setPaint(f.getColor());
                    f.setTransparencia(transparencia);
                }
                if (f.getTransparencia()<1.0f) {
                    g2d.setPaint(f.getColor());
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)f.getTransparencia()));
                }
                if (alisar != f.getAlisar()) {
                    g2d.setPaint(f.getColor());
                    f.setAlisar(alisar);
                }
                if (f.getAlisar()) {
                    g2d.setPaint(f.getColor());
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }
                if (grosor != f.getGrosor()) {
                    g2d.setPaint(f.getColor());
                    f.setGrosor(grosor);
                }
                if (f.getGrosor() >= 0) {
                    g2d.setPaint(f.getColor());
                    if (f.getStroke() != stroke) {
                        
                        f.setStroke(stroke);
                    }
                    float gros = (float) f.getGrosor() ;
                    if (stroke == 0) {
                        g2d.setStroke(new BasicStroke(gros, // Line width
                                BasicStroke.CAP_BUTT, // End-cap style
                                BasicStroke.JOIN_MITER));
                    } else if (stroke == 1) {
                        g2d.setStroke(new BasicStroke(gros, BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f));
                    }
                }
                if (relleno != f.getRelleno()) {
                    f.setRelleno(relleno);
                }
                if (f.getRelleno()) {
                   if (cRelleno != c) {
                       // g2d.setPaint(f.getColor());
                        
                        f.setColorRelleno(cRelleno);
                        g2d.setPaint(f.getColorRelleno());
                        //g2d.fill(f.getShape());
                        
                    }
                   if(f.getFillType()!=fillType) f.setFillType(fillType);
                    if(f.getFillType()==0) g2d.fill(f.getShape());
                    else if (f.getFillType() == 1) {
                        GradientPaint gp5 = new GradientPaint(0, 0,
                                f.getColorRelleno(), 0, 20,f.getColor(), true);

                        g2d.setPaint(gp5);
                        g2d.fill(f.getShape());
                    } else if (f.getFillType() == 2) {
                        GradientPaint gp4 = new GradientPaint(25, 25,
                                f.getColorRelleno(), 15, 25, f.getColor(), true);

                        g2d.setPaint(gp4);
                        g2d.fill(f.getShape());
                    }
                }
                g2d.draw(f.getShape());
            } else {
                g2d.setPaint(f.getColor());
                if (f.getTransparencia()<1.0f) {
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)f.getTransparencia()));
                }
                if (f.getAlisar()) {
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }
                if (f.getGrosor() >= 0) {
                    float gros = (float) f.getGrosor();
                    if (f.getStroke() == 0) {
                        g2d.setStroke(new BasicStroke(gros, // Line width
                                BasicStroke.CAP_BUTT, // End-cap style
                                BasicStroke.JOIN_MITER));
                    } else if (f.getStroke() == 1) {
                        g2d.setStroke(new BasicStroke(gros, BasicStroke.CAP_BUTT,
                                BasicStroke.JOIN_MITER, 1.0f, dashingPattern1, 2.0f));
                    }
                }
                if (f.getRelleno()) {
                    
                    if(f.getFillType()==0) g2d.fill(f.getShape());
                    else if (f.getFillType() == 1) {
                        GradientPaint gp5 = new GradientPaint(0, 0,
                                f.getColorRelleno(), 0, 20,Color.BLACK, true);

                        g2d.setPaint(gp5);
                        g2d.fill(f.getShape());
                    } else if (f.getFillType() == 2) {
                        GradientPaint gp4 = new GradientPaint(25, 25,
                                f.getColorRelleno(), 15, 25, Color.BLACK, true);

                        g2d.setPaint(gp4);
                        g2d.fill(f.getShape());
                    }
                }
                g2d.draw(f.getShape());
            }

        }
        

        this.repaint();
    }
    /**
     * Needed to compare to
     * each type of shape
     * justo to match if the point pressed belong
     * to the shape
     * @param p
     * @return Figure 
     */
    public Figure getSelectedShape(Point2D p) {
        Shape s;
        for (Figure f : vShape) {
            s=f.getShape();
            if (s instanceof Rectangle || s instanceof Ellipse2D ||s instanceof RoundRectangle2D ||s instanceof QuadCurve2D) {
                
                if(f.containsPoint(p))return f;
            }
            else if(s instanceof Line2D){
                if(f.containsPoint(p)) return f;
                
            }
            else return null;
            
        }
        return null;
        }
         
    
    


   
}
