/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs.attribute;

/**
 *
 * @author GKO
 */
public class AttributeFactory {
    
    public static AttributeInfo[] createAttributes(byte[] clazz, int index, int attributeCount){
        AttributeInfo[] attributes = new AttributeInfo[attributeCount];
    }
    
    /**
     * 
     * @param clazz The bytes of the class
     * @param index The index of the first byte of this attribute (the first byte of the attributeNameIndex)
     * @return An @see{AttributeInfo} representing a constant value.
     */
    private static ConstantValueAttribute createConstantValueAttribute(byte[] clazz, int index){
        short nameIndex = (short) (((clazz[index ] & 0xFF) << 8) + (clazz[index + 1] & 0xFF));
        short valueIndex = (short) (((clazz[index + 6] & 0xFF) << 8) + (clazz[index + 7] & 0xFF));
        
        return new ConstantValueAttribute(valueIndex, nameIndex);
    }
    
    private static CodeAttribute createCodeAttribute(byte[] clazz, int index) {
        
    }
}
