/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.edit;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author GKO
 */
public class CPInfo implements Writable{
    private final byte tag;
    private final byte[] info;

    public CPInfo(CPTag tag, byte[] info) {
        this.tag = tag.tagValue();
        this.info = info;
    }
    
    /**
     *
     * @param out
     * @throws java.io.IOException
     */
    @Override
    public void write(OutputStream out) throws IOException{
        out.write(tag);
        out.write(info);
    }
    
}
