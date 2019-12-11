/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick.breaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author GaUrAv
 */
public class MapG2 {
    public int map[][];
    public int brickWidth;
    public int brickHight;
    public MapG2(int row, int col){
        map = new int[row][col];
        for(int i=0;i<map.length; i++){
            for(int j=0; j<map[0].length;j++){
                map[i][j] = 1;
            }
        }
        brickWidth = 550/col;
        brickHight = 160/row;
    }
    public void draw(Graphics2D g){
        for(int i=0;i<map.length; i++){
            for(int j=0; j<map[0].length;j++){
                if(map[i][j] >0 ){
                    g.setColor(Color.CYAN);
                    g.fillRect(j*brickWidth +75,i*brickHight+50, brickWidth,brickHight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickWidth +75,i*brickHight+50, brickWidth,brickHight);
                    
                }
            }
        }
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
