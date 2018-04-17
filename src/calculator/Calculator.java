
package calculator;

public class Calculator {

    public static void main(String[] args) {
        Model model = new Model();
        
        ViewController viewController = new ViewController(model);
        viewController.setVisible(true);
    }
    
}
