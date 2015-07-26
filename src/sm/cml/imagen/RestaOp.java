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
public class RestaOp extends sm.image.BinaryOp {

    private float alpha;
    public RestaOp(BufferedImage img) {
        super(img);
    }
    @Override
    public int binaryOp(int v1, int v2){
        int rdo = (int)((v1)-(v2));
        if(rdo<=0) rdo=0;
        else if(rdo>=255) rdo=255;
        return rdo;
     }
    
}
