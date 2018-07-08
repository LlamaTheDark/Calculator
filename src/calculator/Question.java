
package calculator;

import java.util.Arrays;
import java.util.List;

public class Question {
    private int Length = 0;
    private String[] Components;
   
    
    
    public Question(int compLength){
        Components = new String[compLength];
    }
    
    
    String[] getComponents(){
        //System.out.println(Length);
        return Arrays.copyOfRange(Components, 0, Length);
    }
    
    String getComponent(int index){
        return Components[index];
    }
    
    void setComponent(int index, String newComponent){
        Components[index] = newComponent;
    }
    void setQuestion(Question question, String[] newQuestion){
        question.clearComponents(question);
        
        for (String component: newQuestion){
            question.appendComponent(component);
            
        }
        Length = question.getLength();
    }
    
    
    void clearComponents(Question question){
        for (int i = 0; i < Components.length; i++){
            question.setComponent(i, "");
        }
        Length = 0;
    }
    void removeComponent(int index){
        for (int i = index; i < Components.length-1; i++){
            Components[i] = Components[i+1];
            
        }
        Length--;
    }
    
    
    void appendComponent(String newComponent){
        Components[Length] = newComponent;
        Length++;
    }
    
    int getLength(){
        return Length;
    }
    
    
    public String toString(){
        return String.join("", Arrays.copyOfRange(Components, 0, Length));
    }
    
    void replaceX(Question question, String ax){
        List<String> list = Arrays.asList(Components);
        
        if (list.contains("x")){
            
            for (int i = 0; i < question.getLength(); i++){
                if(question.Components[i].equals("x") || question.getComponent(i).equals("X")){
                    
                    question.setComponent(i, ax);
                
                }
            }
            
        }
    }
    
}


// make some value that will change based on whether or not an open parenthases was placed and have all values after that be a part of that parenthases group until the 
// close parenthases has been pressed.