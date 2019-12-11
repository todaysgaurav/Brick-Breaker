/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brick.breaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author GaUrAv
 */
public class Level3 extends JPanel implements KeyListener, ActionListener{
   
    private boolean play = false;
    private int score ;
    private int totalBrick ;
    private int row;
    private int col;
    
    private Timer timer;
    private int delay;
    private int playerX = 300;
    private int ballposX = 350;
    private int ballposY = 530;
    private int balldirX = -1;
    private int balldirY = -2;
    
    private MapG3 map;
    private MapGenerator mp;
    public Level3(int row, int col,int delay,int score){
        this.row = row;
        this.col = col;
        this.delay = delay;
        this.score = score;
        this.totalBrick = row*col;
        map = new MapG3(row, col);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }
    
    public void paint(Graphics g){
        // backgraound 
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);
        
        
        
        // drawing map
        
        map.draw((Graphics2D)g);
        
        // border
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        // score
        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString("LEVEL 3: "+score, 500, 30);
       
        
        // paddel
        
        g.setColor(Color.red);
        g.fillRect(playerX, 550, 100, 8);
        
        // ball
        
        g.setColor(Color.WHITE);
        g.fillOval(ballposX, ballposY, 20,20);
        //g.fillRect();
        
        if(ballposY>600){
            play = false;
            balldirX = 0;
            balldirY = 0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,35));
            g.drawString("Game Over, Score: "+score, 190, 300);
            g.setColor(Color.WHITE);
            g.setFont(new Font("serif",Font.BOLD,15));
            g.drawString("Press Enter to restart, Press Q to Exit", 190, 350);
            
        }
        
        g.dispose();
        
    }
    
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX>=592){
                playerX = 592;
            }
            else{
                moveRight();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(playerX<=5){
                playerX = 5;
            }
            else{
                moveLeft();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_ENTER){
            if(!play){
            JFrame obj = new JFrame();
                GamePlay gameplay = new GamePlay(3,5,10,0);
                obj.setBounds(10,10,700, 600);
                obj.setBackground(Color.LIGHT_GRAY);
                obj.setTitle("Brick Breaker");
                obj.setVisible(true);
                obj.setResizable(false);
                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                obj.add(gameplay);
                repaint();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_Q){
            play = false;
            System.exit(0);
        }
    }
    public void moveRight(){
        play = true;
        if(playerX+30>592){
            playerX = 592;
        }
        else{
            playerX+=30;
        }
        
    }
    public void moveLeft(){
        play = true;
        if(playerX-30<5){
            playerX = 5;
        }
        else{
            playerX-=30;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
        timer.start();
        if(play){
            // intersect paddel and ball
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                balldirY = -balldirY;
                
            }
            A:for(int i=0;i<map.map.length;i++){
                for(int j =0;j<map.map[i].length;j++){
                   // System.out.println("map: "+i+":"+j);
                    if(map.map[i][j]>0){
                        int brickX = j*map.brickWidth+80;
                        int brickY = i*map.brickHight+50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHight;
                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                        
                        Rectangle brickRect = rect;
                        
                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalBrick--;
                            score+=5;
                            if(totalBrick<=0){
                                JFrame obj = new JFrame();
                                delay--;
                                Level4 l4 = new Level4(row,col,delay,score);
                                obj.setBounds(10,10,700, 600);
                                obj.setBackground(Color.LIGHT_GRAY);
                                obj.setTitle("Brick Breaker");
                                obj.setVisible(true);
                                obj.setResizable(false);
                                obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                obj.add(l4);
                            }
                            
                            if(ballposX+19 <= brickRect.x || ballposX+1 >= brickRect.x +brickRect.width){
                                balldirX = -balldirX;
                            }
                            else{
                                balldirY = -balldirY;
                            }
                            break A;
                        }
                       
                    }
                }
                
            }         
            
            ballposX+=balldirX;
            ballposY+=balldirY;
            
            if(ballposX< 0){
                balldirX = -balldirX;
            }
            if(ballposY<0){
                balldirY = -balldirY;
            }
            if(ballposX>670){
                balldirX = -balldirX;
            }
            
        }
        repaint();
    }
    
}
