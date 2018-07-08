package calculator;

import java.awt.Color;
import java.awt.Graphics;
/*import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
*/
import javax.swing.JFrame;

public class GraphModel extends JFrame {
    
    double x, y;
    double ax, by;
    int graphx, graphy;
    int dippleplo = 1;
    int scale;
    double scaleIncrementOut, scaleIncrementIn;
    
    Question[] Y = new Question[10];
    Question Yx;
    
    ViewControllerGraph graphingWindow;
    Model model;
    
    
    public GraphModel(ViewControllerGraph graphingWindow, Model model, int scale) {
        
        this.scale = scale;
        this.graphingWindow = graphingWindow;
        this.model = model;
        
        Question scaleIncrementInQ = new Question(100);
        scaleIncrementInQ.appendComponent("1");
        scaleIncrementInQ.appendComponent("÷");
        scaleIncrementInQ.appendComponent(Integer.toString(scale));
        
        scaleIncrementIn = Double.parseDouble(this.model.evaluate(scaleIncrementInQ));

        scaleIncrementOut = 0.1;
        
        Y[1] = graphingWindow.getQuestion();
        
        graphy = 300;
        
        setTitle("Graph App");
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x = 0;
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

        paintY1();
        
        graphx = (int)(x+((x-300)*scale));
        graphy = (int)(y+((y-300)*scale));
        
        if(graphy > 50 && graphy < 550 && graphx > 50 && graphx < 550){
            g.fillOval(graphx, graphy, 2, 2);
        }
        if(graphx < 600){
            repaint();
        }
    }
    
    public void paintY1() {
        Yx = new Question(Y[1].getLength());
        
        try {
            Thread.sleep(10);
        
            if (x < 600) {
                ax = x - 300;
                
                System.out.println("x at: "+ ax);
                
                if(graphx < -1000 || graphx > 600){
                    ax = ax + (scale/10)+1;
                }else if(graphy > 0 && graphy < 600){
                    ax = ax + scaleIncrementIn;
                }else{
                    ax = ax + scaleIncrementOut;
                }
                    
                Yx.setQuestion(Yx, Y[1].getComponents());
                
                Yx.replaceX(Yx, Double.toString(ax));
                
                
                by = Double.parseDouble(model.evaluate(Yx)); 
                
                x = ax + 300;
                y = -by + 300;
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}
