package calculator;

import java.util.Arrays;

public class Model {
    
    Question[] questions = new Question[100];
    
    public Model(){
        System.out.println(getStringQuestion(0));
        
    }
    
    
    int evaluate(Question question){
        int index = 0;
        boolean notDone = true;
        int[] numbers = new int[10];
        
        for(int i = 0; i < 10; i++){
            numbers[i] = i;
            System.out.println(i);
        }
        
        while(notDone){
            String CIQ = question.getComponent(index); // CIQ = component in question. This line gets the different components of the string
            if(!Arrays.asList(numbers).contains(Integer.parseInt(CIQ))){ // tests to see if the component in question is any number from 1 to 10
                switch(CIQ){
                    case "+":
                        System.out.println("This is a +");
                       break;
                    case "-":
                        
                        break;
                    case "x":
                        
                        break;
                    case "÷":
                        
                        break;
                    default:
                        System.out.println("you got that big big boi sindrum");
                        break;
                }
            }else{
                System.out.println("This is not an operation");
            }
        }
        
        return 69;
    }
    void addComponent(int index, String component){ // for all calculator calculations, the 0th question will be used
        questions[index].appendComponent(component);
    }
    void clearComponents(){
        
    }
    
    String getStringQuestion(int index){
        return questions[index].toString();
    }
}
