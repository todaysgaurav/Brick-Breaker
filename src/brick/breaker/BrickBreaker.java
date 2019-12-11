/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick.breaker;

import java.awt.Color;
import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author GaUrAv
 */
public class BrickBreaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        GamePlay gameplay = new GamePlay(3,5,2,0);
        obj.setBounds(10,10,700, 600);
        obj.setBackground(Color.LIGHT_GRAY);
        obj.setTitle("Brick Breaker");
        obj.setVisible(true);
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);
       
    }
   
    
}
