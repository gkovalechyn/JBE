/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gkovalechyn.jbe.edit;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author GKO
 */
public interface Writable {
    public void write(OutputStream out) throws IOException;
}
