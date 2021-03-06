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
public class MapG5 {
    public int map[][];
    public int brickWidth;
    public int brickHight;
    public MapG5(int row, int col){
        map = new int[row][col];
        for(int i=0;i<map.length; i++){
            for(int j=0; j<map[0].length;j++){
                map[i][j] = 3;
            }
        }
        brickWidth = 580/col;
        brickHight = 180/row;
    }
    public void draw(Graphics2D g){
        for(int i=0;i<map.length; i++){
            for(int j=0; j<map[0].length;j++){
                if(map[i][j] >2 ){
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    
                }
                if(map[i][j] ==2 ){
                    g.setColor(Color.cyan);
                    g.fillRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    
                }
                if(map[i][j] ==1 ){
                    g.setColor(Color.blue);
                    g.fillRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickWidth +60,i*brickHight+50, brickWidth,brickHight);
                    
                }
            }
        }
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }
}
