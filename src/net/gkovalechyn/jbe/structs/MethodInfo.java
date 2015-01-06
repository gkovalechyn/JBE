/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs;

import net.gkovalechyn.jbe.structs.attribute.AttributeInfo;
import java.io.IOException;
import java.io.OutputStream;
import net.gkovalechyn.jbe.edit.Writable;


/**
 *
 * @author GKO
 */
public class MethodInfo implements Writable{
    private short accessFlags;
    private short nameIndex;
    private short descriptorIndex;
    private short attributesCount;
    private AttributeInfo[] attributes;
    
    @Override
    public void write(OutputStream out) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
