/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs;

import java.io.IOException;
import java.io.OutputStream;
import net.gkovalechyn.jbe.edit.CPTag;
import net.gkovalechyn.jbe.edit.Writable;

/**
 *
 * @author GKO
 */
public abstract class CPInfo implements Writable{
    private final byte tag;

    public CPInfo(CPTag tag) {
        this.tag = tag.tagValue();
    }
    
    /**
     *
     * @param out
     * @throws java.io.IOException
     */
    @Override
    public void write(OutputStream out) throws IOException{
        out.write(tag);
        out.write(this.getInfo());
    }
    
    public abstract byte[] getInfo();
    
}
