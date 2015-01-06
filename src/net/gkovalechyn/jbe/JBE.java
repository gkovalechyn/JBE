/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.gkovalechyn.jbe;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import net.gkovalechyn.jbe.edit.CPTag;

/**
 *
 * @author GKO
 */
public class JBE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s  = "C:\\Users\\GKO\\Documents\\NetBeansProjects\\EstruturasDeDadps\\build\\classes\\hashtable\\A.class";
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File(s)))) {
            byte[] buff = new byte[4];
            
            in.read(buff);
            
            for(byte b: buff){
                System.out.println("Byte: " + Integer.toHexString(b & 0xFF));
            }
            
            int magic = ((buff[0] & 0xFF) << 24) + ((buff[1] & 0xFF) << 16) + ((buff[2] & 0xFF) << 8) + (buff[3] & 0xFF);
            
            buff = new byte[6];
            in.read(buff);
            short minor = (short) ((buff[0] << 8) + buff[1]);
            short major = (short) ((buff[2] << 8) + buff[3]);
            short constantPoolCount = (short) (((buff[4] & 0xFF) << 8) + (buff[5] & 0xFF));
            
            System.out.println("Magic: " + Integer.toHexString(magic));
            System.out.println("Minor: " + minor);
            System.out.println("Major: " + major);
            System.out.println("ConstantPoolCount: " + constantPoolCount);
            
            buff = new byte[1];
            in.read(buff);
            System.out.println("Tag of first CP info: " + (buff[0] & 0xFF));
            //System.out.println("Enum: " + CPTag.);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
