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
public enum AccessFlag {
    PUBLIC((short) 0x0001),
    FINAL((short) 0x0010),
    SUPER((short) 0x0020),
    INTERFACE((short) 0x0200),
    ABSTRACT((short) 0x0400);
    
    private final short mask;

    private AccessFlag(short mask) {
        this.mask = mask;
    }
    
    public short getMask(){
        return this.mask;
    }
    
    public static AccessFlag getByMask(short mask){
        switch(mask){
            case 0x0001:
                return AccessFlag.PUBLIC;
            case 0x0010:
                return AccessFlag.FINAL;
            case 0x0020:
                return AccessFlag.SUPER;
            case 0x0200:
                return AccessFlag.INTERFACE;
            case 0x0400:
                return AccessFlag.ABSTRACT;
            default:
                throw new IllegalArgumentException("Unknown AccessFlag: " + Integer.toHexString(mask));
        }
    }
}
