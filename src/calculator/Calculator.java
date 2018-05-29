
package calculator;

import java.util.Scanner;

public class Calculator {
    
    
    public static void main(String[] args) {
        Model model = new Model();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter what you would like to do (calculate/graph): ");
        switch(input.nextLine()){
            
            case "calculate":
                
                ViewController viewController = new ViewController(model);
                viewController.setVisible(true);
                
                break;
                
            case "graph":
                
                ViewControllerGraph graph = new ViewControllerGraph(model);
                graph.setVisible(true);
                
                break;
                
            default:
                
                
                
                break;
        }
        
        
    }
    
}
