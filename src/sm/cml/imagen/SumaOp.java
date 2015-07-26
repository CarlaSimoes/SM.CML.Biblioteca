/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.imagen;

import java.awt.image.BufferedImage;

/**
 *
 * @author carla
 */
public class SumaOp extends sm.image.BinaryOp {

    private float alpha;
    /**
     * 
     * @param img 
     */
    public SumaOp(BufferedImage img) {
        super(img);
        this.setAlpha((float) 0.5);
    }
    @Override
    public int binaryOp(int v1, int v2){
        int rdo = (int)((alpha*v1)+((1-alpha)*v2));
        if(rdo<=0) rdo=0;
        else if(rdo>=255) rdo=255;
        return rdo;
     }
    /**
     * 
     * @param alpha 
     */
    public final void setAlpha(float alpha) {
        if (alpha < 0.0f) alpha = 0.0f;
        else if (alpha > 1.0f) alpha = 1.0f;
        this.alpha = alpha;
    }
    /**
     * 
     * @return alpha
     */
    public float getAlpha() {
        return alpha;
    }
    
    
   
    
}
