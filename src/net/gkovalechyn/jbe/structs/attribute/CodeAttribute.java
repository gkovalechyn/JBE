/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs.attribute;

import net.gkovalechyn.jbe.ByteUtils;
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
    
    private int length = 0;
    private byte[] info;
    protected CodeAttribute(short attributeNameIndex) {
        super(attributeNameIndex);
        //maxStack, maxLocals, codeLength(4), exceptionTableLength, attributeCount
        this.length = 12;
    }

    @Override
    public int getLength() {
        return this.length;
    }    

    @Override
    public byte[] getInfo() {
        return this.info;
    }

    public short getMaxStack() {
        return maxStack;
    }

    public short getMaxLocals() {
        return maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public byte[] getCode() {
        return code;
    }

    public short getExceptionTableLength() {
        return exceptionTableLength;
    }

    public ExceptionTable[] getExceptionTable() {
        return exceptionTable;
    }

    public short getAttributeCount() {
        return attributeCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }
    
    public void recalculateLength(){
        this.length = 12;
        this.length += this.codeLength;
        this.length += 8 * this.exceptionTableLength; //each one is 8 bytes
        
        for(AttributeInfo info : this.attributes){
            this.length += info.getLength();
        }
    }

    public void setMaxStack(short maxStack) {
        this.maxStack = maxStack;
    }

    public void setMaxLocals(short maxLocals) {
        this.maxLocals = maxLocals;
    }

    public void setCode(byte[] code) {
        this.code = code;
        this.codeLength = code.length;
    }

    public void setExceptionTable(ExceptionTable[] exceptionTable) {
        this.exceptionTable = exceptionTable;
        this.exceptionTableLength = (short) exceptionTable.length;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
        this.attributeCount = (short) attributes.length;
    }
    
    
    private void updateInfoArray(){
        this.recalculateLength();
        byte[] tmp = new byte[this.getLength()];
        byte[] variableBytes;
        int index = 0;
        //put the maxStack
        tmp[index] = (byte) ((this.maxStack & 0xFF00) >> 8);
        tmp[index + 1] = (byte) (this.maxStack & 0x00FF);
        index += 2;
        //put the maxLocals
        tmp[index] = (byte) ((this.maxLocals & 0xFF00) >> 8);
        tmp[index + 1] = (byte) (this.maxLocals & 0x00FF);
        index += 2;
        //put the codeLength
        variableBytes = ByteUtils.getBytes(this.codeLength);
        System.arraycopy(variableBytes, 0, tmp, index, variableBytes.length);
        index += 4;
        //put the code
        System.arraycopy(this.code, 0, tmp, index, this.codeLength);
        index += this.codeLength;
        //Exception table
        variableBytes = ByteUtils.getBytes(this.exceptionTableLength);
        System.arraycopy(variableBytes, 0, tmp, index, variableBytes.length);
        index += 2;
        
        for(ExceptionTable table : this.exceptionTable){
            variableBytes = table.toByteArray();
            System.arraycopy(variableBytes, 0, tmp, index, variableBytes.length);
            index+= 8;
        }
        
        //attributes
        variableBytes = ByteUtils.getBytes(this.attributeCount);
        System.arraycopy(variableBytes, 0, tmp, index, variableBytes.length);
        index += 2;
        
        for(AttributeInfo attribute : this.attributes){
            variableBytes = attribute.getInfo();
            System.arraycopy(variableBytes, 0, tmp, index, variableBytes.length);
            index += attribute.getLength();
        }
        
        this.info = tmp;
    }
    
}
