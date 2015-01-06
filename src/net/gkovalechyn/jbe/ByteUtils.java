/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe;

/**
 *
 * @author GKO
 */
public class ByteUtils {
    
    public static byte[] getBytes(long val){
        return ByteUtils.getBytes(8, val);
    }
    
    public static byte[] getBytes(int val){
        return ByteUtils.getBytes(4, val);
    }
    
    public static byte[] getBytes(short val){
        return ByteUtils.getBytes(2, val);
    }
    
    public static byte[] getBytes(float val){
        return ByteUtils.getBytes(4, Float.floatToIntBits(val));
    }
    public static byte[] getBytes(double val){
        return ByteUtils.getBytes(8, Double.doubleToLongBits(val));
    }
    
    private static byte[] getBytes(int byteCount, long val){
        byte[] bytes = new byte[byteCount];
        long mask = 0xFF;
        
        for(int i = 0; i < byteCount; i++){
            bytes[i] = (byte) ((val & mask) >> (8 * i));
            mask <<= 8;
        }
        
        return bytes;
    }
}
