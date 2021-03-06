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
    
    //firts two bytes = length
    //next bytes = ByteArray[length]
    CONSTANT_UTF8((byte) 1),
    CONSTANT_METHOD_HANDLE((byte) 15),
    CONSTANT_METHOD_TYPE((byte) 16),
    CONSTANT_INVOKE_DYNAMIC((byte) 18);

    private CPTag(byte tag) {
        this.tag = tag;
    }
    private final byte tag;

    public byte tagValue() {
        return tag;
    }
    
    public static CPTag getByByte(byte tag){
        switch(tag){
            case 7:
                return CPTag.CONSTANT_CLASS;
            case 9:
                return CPTag.CONSTANT_FIELD_REF;
            case 10:
                return CPTag.CONSTANT_METHOD_REF;
            case 11:
                return CPTag.CONSTANT_INTERFACE_METHOD_REF;
            case 8:
                return CPTag.CONSTANT_STRING;
            case 3:
                return CPTag.CONSTANT_INTEGER;
            case 4:
                return CPTag.CONSTANT_FLOAT;
            case 5:
                return CPTag.CONSTANT_LONG;
            case 6:
                return CPTag.CONSTANT_DOUBLE;
            case 12:
                return CPTag.CONSTANT_NAME_AND_TYPE;
            case 1:
                return CPTag.CONSTANT_UTF8;
            case 15:
                return CONSTANT_METHOD_HANDLE;
            case 16:
                return CONSTANT_METHOD_TYPE;
            case 18:
                return CONSTANT_INVOKE_DYNAMIC;
            default :
                throw new IllegalArgumentException("Unknown constant pool tag: " + tag);
        }
    }
}
