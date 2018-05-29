package calculator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GraphModel extends JFrame {
    
    double x, y;
    double ax, by;
    int dippleplo = 1;
    int scale;
    
    Question[] Y = new Question[10];
    Question Yx;
    
    ViewControllerGraph graphingWindow;
    Model model;
    
    
    public GraphModel(ViewControllerGraph graphingWindow, Model model, int scale) {
        
        this.scale = scale;
        this.graphingWindow = graphingWindow;
        this.model = model;
        
        Y[1] = graphingWindow.getQuestion();
        
        
        
        setTitle("Graph App");
        setSize(600, 600); // remember to add 20 to every y value
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x = 49;
        y = 300;
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        /*
        g.drawString("Y", 260, 30);
        g.drawString("Y'", 260, 490);
        g.drawString("X'", 10, 260);
        g.drawString("X", 490, 260);
        if (x == 250 && y == 250) {
            g.drawString("Origin(0,0)", 250, 250);
        }
        */
        // origin (0, 0) = (300, 300)  
        
        while(dippleplo==1){
            g.drawLine(50, 300, 550, 300);
            g.drawLine(300, 50, 300, 550);  
            dippleplo++;
            for(int i = 300; i <= 550; i += scale){
                g.drawLine(i, 295, i, 305);
                g.drawLine(295, i, 305, i);
            }
            for(int i = 300; i >= 50; i -= scale){
                g.drawLine(i, 295, i, 305);
                g.drawLine(295, i, 305, i);
            }
            /*for(int i = 50; i < 550; i = i + 10){
                g.drawLine(295, i, 305, i);
            }*/
        }
        
        g.setColor(Color.red);
        paintY1();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        System.out.println(x + ", " + y);
        /*
        
        g.setColor(Color.blue);
        paintY2();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.green);
        paintY3();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.orange);
        paintY4();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.black);
        paintY5();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.magenta);
        paintY6();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.white);
        paintY7();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.blue);
        paintY8();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.yellow);
        paintY9();
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        
        
        g.setColor(Color.pink);
        paintY0();
        
        
        //g.fillOval(49, 300, 5, 5);
        if(y > 50 && y < 550){
            //System.out.println("y: "+ y);
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }*/
        repaint();
        
    }
    
    public void paintY1() {
        Yx = new Question(Y[1].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 2;
                }
                
                Yx.setQuestion(Yx, Y[1].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    
    public void paintY2() {
        Yx = new Question(Y[2].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[2].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    
    public void paintY3() {
        Yx = new Question(Y[3].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[3].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY4() {
        Yx = new Question(Y[4].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[4].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY5() {
        Yx = new Question(Y[5].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[5].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY6() {
        Yx = new Question(Y[6].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[6].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY7() {
        Yx = new Question(Y[7].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[7].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY8() {
        Yx = new Question(Y[8].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[8].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY9() {
        Yx = new Question(Y[9].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[9].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void paintY0() {
        Yx = new Question(Y[0].getLength());
        
        try {
            
            //System.out.println(x + ", " + y);
            
            Thread.sleep(10);
        
            if (x < 549) {
                ax = x - 300;
                by = y - 300;
                
                if(y > 50 && y < 550){
                    ax = ax + 0.01;
                }else{
                    ax = ax + 0.5;
                }
                
                Yx.setQuestion(Yx, Y[0].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    
    
    
}
