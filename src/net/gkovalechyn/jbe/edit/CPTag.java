/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gkovalechyn.jbe.edit;

/**
 *
 * @author GKO
 */
public enum CPTag {

    CONSTANT_CLASS((byte) 7),
    
    
    //first two bytes = class index
    //next two = name and type index
    CONSTANT_FIELD_REF((byte) 9),
    
    //first two bytes = class index
    //next two = name and type index
    CONSTANT_METHOD_REF((byte) 10),
    
    //first two bytes = class index
    //next two = name and type index
    CONSTANT_INTERFACE_METHOD_REF((byte) 11),
    
    //two bytes = String index in the CP
    CONSTANT_STRING((byte) 8),
    
    //4 bytes = bytes of the integer value (BIG ENDIAN)
    CONSTANT_INTEGER((byte) 3),
    
    //4 bytes = bytes of the float value (BIG ENDIAN)
    CONSTANT_FLOAT((byte) 4),
    
    //first 4 bytes = high bytes of the long value (BIG ENDIAN)
    //next 4 bytes = low bytes of the long value (BIG ENDIAN)
    CONSTANT_LONG((byte) 5),
    CONSTANT_DOUBLE((byte) 6),
    CONSTANT_NAME_AND_TYPE((byte) 12),
    CONSTANT_UTF8((byte) 1),
    CONSTANT_METHOD_HANDLE((byte) 15),
    CONSTANT_METHOD_TYPE((byte) 16),
    CONSTANT_FINVOKE_DYNAMIC((byte) 18);

    private CPTag(byte tag) {
        this.tag = tag;
    }
    private final byte tag;

    public byte tagValue() {
        return tag;
    }
}
