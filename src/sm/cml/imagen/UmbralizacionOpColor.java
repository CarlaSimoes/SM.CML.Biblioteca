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
public class UmbralizacionOpColor extends sm.image.BufferedImageOpAdapter{
    private int threshold;
    int minimum=0;
    int maximum=255;

    /**
     * Initializes UmbralizacionOp
     * @param umbral 
     */
    public UmbralizacionOpColor(int umbral) {
        this.threshold = umbral;
    }
    
//    private BufferedImageOp createThresholdOp(BufferedImage src, BufferedImage dest,int threshold,
//    int minimum, int maximum) {
//    short[] thresholdArray = new short[256];
//    for (int i = 0; i < 256; i++) {
//      if (i < threshold)
//        thresholdArray[i] = (short)minimum;
//      else
//        thresholdArray[i] = (short)maximum;
//      }
//   // return new LookupOp(new ShortLookupTable(0, thresholdArray), null);
//  }

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
            int pixelGreen=pixel.sample[1];
            int pixelRed=pixel.sample[0];
            int pixelBlue=pixel.sample[2];
            media=sum/numS;
            if(media>=this.threshold)
                for(int i=0; i<numS; i++){
                        if(pixel.sample[i]>=pixelGreen) pixel.sample[i]=pixelGreen;
                        
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
