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
public enum MethodAccessFlag {
    PUBLIC((short) 0x0001),
    PRIVATE((short) 0x0002),
    PROTECTED((short) 0x0004),
    STATIC((short) 0x0008),
    FINAL((short) 0x0010),
    SYNCHRONIZED((short) 0x0020),
    BRIDGE((short) 0x0040),
    VARARGS((short) 0x0080),
    NATIVE((short) 0x0100),
    ABSTRACT((short) 0x0400),
    STRICTFP((short) 0x0800),
    SYNTHETIC((short) 0x1000);
    
    private final short mask;

    private MethodAccessFlag(short mask) {
        this.mask = mask;
    }

    public short getMask() {
        return mask;
    }
    
    public static boolean hasFlag(short val, MethodAccessFlag flag){
        return (val & flag.mask) == flag.mask;
    }
    
    public static short enable(MethodAccessFlag flag, short val){
        return (short) (val | flag.mask);
    }
    
    public static short disable(MethodAccessFlag flag, short val){
        return (short) (val & (~flag.mask));
    }
}
