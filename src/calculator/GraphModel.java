
package calculator;

import java.awt.*;
import javax.swing.JComponent;

public class GraphModel extends JComponent{
    
    
    
    private Image image;
    
    private Graphics2D g2;
    
    public GraphModel(){
        setDoubleBuffered(false);
    }
    
    public void plotPoint(int x, int y){
        g2.setPaint(Color.black);
        if (g2 != null){
            g2.drawLine(x, y, x+10, y+10);
            repaint();
        }
    }
    
    protected void paintComponent(Graphics g){
        if (image == null){
            // image to draw null --> create image
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            
            // enables antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                    RenderingHints.VALUE_ANTIALIAS_ON);
            // clears the draw area
            clear();
        }
        
        g.drawImage(image, 0, 0, null);
    }
    
    public void clear(){
        g2.setPaint(Color.white);
        // draw white on entire area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    
    public void red(){
        // apply red color on g2 context
        g2.setPaint(Color.red);
    }
    public void black(){
        g2.setPaint(Color.black);
    }
    public void magenta(){
        g2.setPaint(Color.black);
    }
    public void green(){
        g2.setPaint(Color.black);
    }
    public void blue(){
        g2.setPaint(Color.black);
    }
    
    
    
}
