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
        }
        
        g.setColor(Color.red);
        //paintY1();
        /*
        if(y > 50 && y < 550){
            System.out.println(x + ((x-300)*scale) + ", " + y + ((y-300)*scale));
            g.fillOval((int)(x + ((x-300)*scale)), (int)(y + ((y-300)*scale)), 2, 2);
        }
        repaint();
        */
        
        g.fillOval(50, 50, 5, 5);
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
                    ax = ax + 0.09;
                }else{
                    ax = ax + 1;
                }
                
                Yx.setQuestion(Yx, Y[1].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
               
                
                
                by = Double.parseDouble(model.evaluate(Yx));  /* + 3*10*/; // parabola 
                System.out.println(ax + ", "+model.evaluate(Yx));
                
                x = 300 + ax;
                y = 300 - by;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}
