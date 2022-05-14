package game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameFrame extends JPanel implements ActionListener, KeyListener {
          private int[] snakelenghtX=new int[750];
          private int[] snakelenghtY=new int[750];
          private int lengthsnake=3;

          private int[] xpos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
          private int[] ypos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};

          private Random random=new Random();
          private int enemyX,enemyY;
          private boolean left=false;
          private boolean right=true;
          private boolean up=false;
          private boolean down=false;
          private int moves = 0;
          private int score=0;
          private boolean Gameover=false;
          private ImageIcon snaketitle=new ImageIcon("src/game/assets/snaketitle.jpg");

          private ImageIcon leftMouth=new ImageIcon("src/game/assets/leftmouth.png");
          private ImageIcon rightMouth=new ImageIcon("src/game/assets/rightmouth.png");
          private ImageIcon upMouth=new ImageIcon("src/game/assets/upmouth.png");
          private ImageIcon downMouth=new ImageIcon("src/game/assets/downmouth.png");
          private ImageIcon snakeImage=new ImageIcon("src/game/assets/snakeimage.png");

          private ImageIcon Enemy=new ImageIcon("src/game/assets/enemy.png");
          private Timer timer;
          private  int delay=200;

          GameFrame(){
              addKeyListener(this);
              setFocusable(true);
              setFocusTraversalKeysEnabled(true);

              timer=new Timer(delay,this);
              timer.start();
              newEnemy();
          }


    //
          @Override
          public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.white);
            g.drawRect(24,10,851,55);
            g.drawRect(24,74,851,576);
            snaketitle.paintIcon(this,g,25,11);
            g.setColor(Color.BLACK);
            g.fillRect(25,75,850,575);

            if (moves==0) {
                snakelenghtX[0] = 100;
                snakelenghtX[1] = 75;
                snakelenghtX[2] = 50;

                snakelenghtY[0] = 100;
                snakelenghtY[1] = 100;
                snakelenghtY[2] = 100;

//                moves++;
            }
            if(left){
                leftMouth.paintIcon(this,g,snakelenghtX[0],snakelenghtY[0]);
            }
            if(right){
                rightMouth.paintIcon(this,g,snakelenghtX[0],snakelenghtY[0]);
            }
            if(up) {
                upMouth.paintIcon(this, g, snakelenghtX[0], snakelenghtY[0]);
            }
            if(down){
                downMouth.paintIcon(this,g,snakelenghtX[0],snakelenghtY[0]);
            }

            for(int i=1;i<lengthsnake;i++){
                    snakeImage.paintIcon(this,g,snakelenghtX[i],snakelenghtY[i]);
            }
            Enemy.paintIcon(this,g,enemyX,enemyY);

            if(Gameover){
                g.setColor(Color.white);
                g.setFont(new Font("Arial",Font.BOLD,50));
                g.drawString("GameOver",300,300);

                g.setFont(new Font("Arial",Font.BOLD,30));
                g.drawString("Your Score "+score,330,350);

                g.setFont(new Font("Arial",Font.PLAIN,20));
                g.drawString("Press space to Restart",345,400);

            }
            g.setColor(Color.white);
            g.setFont(new Font("Arial",Font.PLAIN,14));
            g.drawString("Score :"+score,750,30);
            g.drawString("Length :"+lengthsnake,750,55);
            g.dispose();
       }
       public void actionPerformed(ActionEvent e) {
           for(int i=lengthsnake-1;i>0;i--){
               snakelenghtX[i]=snakelenghtX[i-1];
               snakelenghtY[i]=snakelenghtY[i-1];
           }

            if(left){
                snakelenghtX[0]=snakelenghtX[0]-25;
            }
            if(right){
                snakelenghtX[0]=snakelenghtX[0]+25;
            }
            if(up){
                snakelenghtY[0]=snakelenghtY[0]-25;
            }
            if(down){
                snakelenghtY[0]=snakelenghtY[0]+25;
            }

            if(snakelenghtX[0]>850){
                snakelenghtX[0]=25;
            }
            if(snakelenghtX[0]<25){
               snakelenghtX[0]=850;
            }
            if(snakelenghtY[0]>625){
               snakelenghtY[0]=75;
            }
            if(snakelenghtY[0]<75){
               snakelenghtY[0]=625;
            }

            colliedwithenemy();
            colliedswithbody();
            repaint();
       }




    @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            restart();
        }
         if(e.getKeyCode()==KeyEvent.VK_LEFT&&(!right)){
             left=true;
             right=false;
             up=false;
             down=false;
             moves++;
         }
         if(e.getKeyCode()==KeyEvent.VK_RIGHT&&(!left)){
              left=false;
              right=true;
              up=false;
              down=false;
              moves++;
          }
          if(e.getKeyCode()==KeyEvent.VK_UP&&(!down)){
              left=false;
              right=false;
              up=true;
              down=false;
              moves++;
          }
          if(e.getKeyCode()==KeyEvent.VK_DOWN&&(!up)){
              left=false;
              right=false;
              up=false;
              down=true;
              moves++;
          }
      }



    @Override
       public void keyReleased(KeyEvent e) {

      }
      @Override
      public void keyTyped(KeyEvent e) {

      }
     private void newEnemy() {
        enemyX=xpos[random.nextInt(34)];
        enemyY=ypos[random.nextInt(23)];
        for(int i=lengthsnake-1;i>=0;i--){
            if(snakelenghtX[i]==enemyX && snakelenghtY[i]==enemyY){
                newEnemy();
            }
        }
     }
     private void colliedwithenemy() {
            if(snakelenghtX[0]==enemyX && snakelenghtY[0]==enemyY){
                newEnemy();
                lengthsnake++;
                score++;
            }

    }
    private void colliedswithbody() {
        for(int i=lengthsnake-1;i>0;i--){
            if(snakelenghtX[i]==snakelenghtX[0]&&snakelenghtY[i]==snakelenghtY[0]){
                timer.stop();
                Gameover=true;
            }
        }
    }
    private void restart() {
              Gameover=false;
              moves=0;
              score=0;
              lengthsnake=3;
              left=false;
              up=false;
              down=false;
              right=true;
              timer.start();
              repaint();
    }
}
