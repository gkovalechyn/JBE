/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs.attribute;

import net.gkovalechyn.jbe.ByteUtils;

/**
 *
 * @author GKO
 */
public class ConstantValueAttribute extends AttributeInfo{
    private final short constantValueIndex;

    public ConstantValueAttribute(short constantValueIndex, short attributeNameIndex, int attributeLength) {
        super(attributeNameIndex, attributeLength);
        this.constantValueIndex = constantValueIndex;
    }

    public short getConstantValueIndex() {
        return constantValueIndex;
    }

    @Override
    public byte[] getInfo() {
        return ByteUtils.getBytes(constantValueIndex);
    }
    
    
    
}
