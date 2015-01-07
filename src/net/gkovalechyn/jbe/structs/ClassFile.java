/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.gkovalechyn.jbe.ByteUtils;
import net.gkovalechyn.jbe.edit.Writable;
import net.gkovalechyn.jbe.structs.attribute.AttributeInfo;

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
    
    private ClassFile(){
        
    }
    
    @Override
    public void write(OutputStream out) throws IOException {
        out.write(ClassFile.MAGIC);
        
        out.write(ByteUtils.getBytes(this.minorVersion)); //The int conversion will make it write the 4 bytes 
        out.write(ByteUtils.getBytes(this.majorVersion)); //instead of only the two ones.
        
        out.write(ByteUtils.getBytes(this.constantPoolCount));
        for(CPInfo info : this.constantPool){
            info.write(out);
        }
        
        out.write(ByteUtils.getBytes(this.accessFlags));
        out.write(ByteUtils.getBytes(this.keywordThisIndex));
        out.write(ByteUtils.getBytes(this.keywordSuperIndex));
        
        out.write(ByteUtils.getBytes(this.interfaceCount)); 
        
        for(short s : this.interfaces){
            out.write(ByteUtils.getBytes(s)); 
        }
        
        out.write(ByteUtils.getBytes(this.fieldCount)); 
        for(FieldInfo f : this.fields){
            f.write(out);
        }
        
        out.write(ByteUtils.getBytes(this.methodCount)); 
        for(MethodInfo m : this.methods){
            m.write(out);
        }
        
        out.write(ByteUtils.getBytes(this.attributeCount)); 
        for(AttributeInfo a : this.attributes){
            a.write(out);
        }
    }
    
    public static ClassFile readFile(File file) throws IOException{
        byte[] classBytes = ClassFile.getClassBytes(file);
        ClassFile result = new ClassFile();
        int classStartIndex = 10;
        
        //set the major and minor versions. (Ignore the first four bytes)
        result.minorVersion = (short) (((classBytes[4] & 0xFF) << 8) + (classBytes[5] & 0xFF));
        result.majorVersion = (short) (((classBytes[6] & 0xFF) << 8) + (classBytes[7] & 0xFF));
        
        result.constantPoolCount = (short) (((classBytes[8] & 0xFF) << 8) + (classBytes[9] & 0xFF));
        
        return null;
    }
    
    private static byte[] getClassBytes(File file) throws IOException{
        byte[] classBytes = new byte[0];
        
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] tmp = new byte[1024];
            int readBytes = 0;
            
            while((readBytes = in.read(tmp)) > 0){
                byte[] newArray = classBytes = new byte[classBytes.length + readBytes];
                //copy the old class bytes
                System.arraycopy(classBytes, 0, newArray, 0, classBytes.length);
                //copy the new ones after that
                System.arraycopy(tmp, 0, newArray, classBytes.length, readBytes);
                
                classBytes = newArray;
            }
             
            return classBytes;
        }catch(IOException e){
            throw e;
        }
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
