/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.cml.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;

/**
 *
 * @author carla
 */
public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter {
    private int umbral;
    /**
     * Initializes UmbralizacionOp
     * @param umbral 
     */
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }

    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        double media;
        
        
        
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
            int numS=pixel.numSamples;
            int sum=0;
            for(int i=0; i<numS; i++){
                sum+=pixel.sample[i];
            }
            media=sum/numS;
            if(media>=this.umbral){
                for(int i=0; i<numS; i++){
                    
                    pixel.sample[i]=250;
                }
            }
            else{
                 for(int i=0; i<numS; i++){
                    pixel.sample[i]=0;
                }
            }
            
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
}
    

