/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs.attribute;

import net.gkovalechyn.jbe.structs.ExceptionTable;

/**
 *
 * @author GKO
 */
public class CodeAttribute extends AttributeInfo{
    private short maxStack;
    private short maxLocals;
    
    private int codeLength;
    private byte[] code;
    
    private short exceptionTableLength;
    private ExceptionTable[] exceptionTable;
    
    private short attributeCount;
    private AttributeInfo[] attributes;
    
    public CodeAttribute(short attributeNameIndex) {
        super(attributeNameIndex, -1);
    }
    

    @Override
    public byte[] getInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
