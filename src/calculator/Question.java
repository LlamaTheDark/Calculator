
package calculator;

import java.util.Arrays;

public class Question {
    private int Length = 0;
    private String[] Components = new String[100];
    //static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    
    public static void main(String[] args){        
        
        //int[] balls = {0, 1, 2};
        //System.out.println(balls[4]);
        
        
        /*
        try {
            Integer.parseInt("r");
        }^
        catch (NumberFormatException n){
            System.out.println("please enter a number");
        }
        
        
        Question q = new Question();
        q.appendComponent("1");
        q.appendComponent("1");
        q.appendComponent("+");
        q.appendComponent("2");
        
        String[] splitEquation = q.toString().split("[(\\)\\*\\÷\\+\\-\\^]");
        System.out.println(String.join(" ", splitEquation));
        //System.out.println(Arrays.toString(q.toString().split("((?<=[(\\)\\*\\÷\\+\\-\\^])|(?=[(\\)\\*\\÷\\+\\-\\^]))")).split("[\\,\\]"));
        
        final String[] aEach = q.toString().split(String.format(WITH_DELIMITER, "[(\\)\\*\\÷\\+\\-\\^]"));
        System.out.println(String.join(" ", aEach));
        //System.out.println(Integer.parseInt(q.Components[0])+Integer.parseInt(q.Components[2]));
        */
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
}


// make some value that will change based on whether or not an open parenthases was placed and have all values after that be a part of that parenthases group until the 
// close parenthases has been pressed.