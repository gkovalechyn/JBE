/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.structs;

/**
 *
 * @author GKO
 */
public class ExceptionTable {
    private short startPC;
    private short endPC;
    private short handlerPC;
    private short catchType;

    public short getStartPC() {
        return startPC;
    }

    public void setStartPC(short startPC) {
        this.startPC = startPC;
    }

    public short getEndPC() {
        return endPC;
    }

    public void setEndPC(short endPC) {
        this.endPC = endPC;
    }

    public short getHandlerPC() {
        return handlerPC;
    }

    public void setHandlerPC(short handlerPC) {
        this.handlerPC = handlerPC;
    }

    public short getCatchType() {
        return catchType;
    }

    public void setCatchType(short catchType) {
        this.catchType = catchType;
    }
    
    public int getLength(){
        return 8;
    }
    
    public byte[] toByteArray(){
        byte[] arr = new byte[8];
        
        arr[0] = (byte) ((this.startPC & 0xFF00) >> 8);
        arr[1] = (byte) (this.startPC & 0x00FF);
        
        arr[2] = (byte) ((this.endPC & 0xFF00) >> 8);
        arr[3] = (byte) (this.endPC & 0x00FF);
        
        arr[4] = (byte) ((this.handlerPC & 0xFF00) >> 8);
        arr[5] = (byte) (this.handlerPC & 0x00FF);
        
        arr[6] = (byte) ((this.catchType & 0xFF00) >> 8);
        arr[7] = (byte) (this.catchType & 0x00FF);
        
        return arr;
    }
}
