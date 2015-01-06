/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs.attribute;

import java.io.IOException;
import java.io.OutputStream;
import net.gkovalechyn.jbe.edit.Writable;

/**
 *
 * @author GKO
 */
public abstract class AttributeInfo implements Writable{
    private final short attributeNameIndex;
    private final int attributeLength;

    public AttributeInfo(short attributeNameIndex, int attributeLength) {
        this.attributeNameIndex = attributeNameIndex;
        this.attributeLength = attributeLength;
    }
    
    @Override
    public void write(OutputStream out) throws IOException {
        out.write(attributeNameIndex);
        out.write(attributeLength);
        out.write(this.getInfo());
    }
    
    public abstract byte[] getInfo();

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }
    
}
