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
    ABSTRACT((short) 0x0400),
    SYNTHETIC((short) 0x1000),
    ANNOTATION((short) 0x2000),
    ENUM((short) 0x4000);

    private final short mask;

    private AccessFlag(short mask) {
        this.mask = mask;
    }

    public short getMask() {
        return this.mask;
    }

    public static AccessFlag getByMask(short mask) {
        switch (mask) {
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
            case 0x1000:
                return AccessFlag.SYNTHETIC;
            case 0x2000:
                return AccessFlag.ANNOTATION;
            case 0x4000:
                return AccessFlag.ENUM;
            default:
                throw new IllegalArgumentException("Unknown AccessFlag: " + Integer.toHexString(mask));
        }
    }

    public static boolean isSet(short val, AccessFlag flag) {
        return (val & flag.mask) == flag.mask;
    }
}
