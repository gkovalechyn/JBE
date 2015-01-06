/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs;

import java.io.IOException;
import java.io.OutputStream;
import net.gkovalechyn.jbe.structs.attribute.AttributeInfo;
import net.gkovalechyn.jbe.structs.CPInfo;
import net.gkovalechyn.jbe.structs.FieldInfo;
import net.gkovalechyn.jbe.structs.MethodInfo;
import net.gkovalechyn.jbe.edit.Writable;

/**
 *
 * @author GKO
 */
public class ClassFile implements Writable{
    public static final int MAGIC = 0xCAFEBABE;
    
    private short majorVersion;
    private short minorVersion;
    
    private short constantPoolCount;
    private CPInfo[] constantPool;
    
    private short accessFlags;
    
    private short keywordThisIndex;
    
    private short keywordSuperIndex;
    
    private short interfaceCount;
    private short[] interfaces;
    
    private short fieldCount;
    private FieldInfo[] fields;
    
    private short methodCount;
    private MethodInfo[] methods;
    
    private short attributeCount;
    private AttributeInfo[] attributes;
    
    @Override
    public void write(OutputStream out) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public short getAccessFlags() {
        return accessFlags;
    }

    public short getKeywordThisIndex() {
        return keywordThisIndex;
    }

    public short getKeywordSuperIndex() {
        return keywordSuperIndex;
    }

    public short getInterfaceCount() {
        return interfaceCount;
    }

    public short getFieldCount() {
        return fieldCount;
    }

    public short getMethodCount() {
        return methodCount;
    }

    public short getAttributeCount() {
        return attributeCount;
    }
    
    
    
}
