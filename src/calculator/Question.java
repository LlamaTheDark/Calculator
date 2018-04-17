
package calculator;

import java.util.Arrays;

public class Question {
    private int Length = 0;
    private String[] Components = new String[100];
    
    public static void main(String[] args){
        Question q = new Question();
        q.appendComponent("1");
        q.appendComponent("+");
        q.appendComponent("2");
        
        System.out.println(q.Length);
        q.toString();
        //System.out.println(Integer.parseInt(q.Components[0])+Integer.parseInt(q.Components[2]));
    }
    
    String[] getComponents(){
        return Arrays.copyOfRange(Components, 0, Length);
    }
    
    String getComponent(int index){
        return Components[index];
    }
    void setComponent(int index, String newComponent){
    
    }
    void appendComponent(String newComponent){
        Components[Length] = newComponent;
        Length++;
    }
    
    public String toString(){
        System.out.println(String.join(" ", Arrays.copyOfRange(Components, 0, Length)));
        return "";
    }
}
