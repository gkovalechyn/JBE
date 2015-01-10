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

    public AttributeInfo(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }
    
    @Override
    public void write(OutputStream out) throws IOException {
        out.write(attributeNameIndex);
        out.write(this.getLength());
        out.write(this.getInfo());
    }
    
    /**This method should return all the next bytes of this attribute after the length.
     * The length of the byte array must be equal to the length returned by the @see{getLength()} method.
     * 
     * @return The bytes that are to be written.
     */
    public abstract byte[] getInfo();

    /**
     * 
     * @return How many bytes this attribute takes
     */
    public abstract int getLength();
    
    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }
}
