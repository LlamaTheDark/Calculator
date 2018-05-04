/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import javax.swing.*;

public class GraphingTool{
        
        
        
        
        public GraphingTool(GraphModel graphModel){
            // create main frame
            JFrame frame = new JFrame ("Graphing Tool");
            Container content = frame.getContentPane();
            // set layout on centent pane
            content.setLayout(new BorderLayout());

            
            // add to content pane
            content.add(graphModel, BorderLayout.CENTER);
            
            graphModel.plotPoint(5, 5);
            
            frame.setSize(500, 500);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.setVisible(true);
            
        }
}
