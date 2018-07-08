package calculator;

//import java.util.Arrays;

import java.util.Arrays;


public class Model {
    
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    Question question = new Question(100);
    
    public Model() {
        
    }
    
    void reformat(Question question) { // remember PEMDAS
        
        // splits the equation by it's operators to identify multi-digit numbers
        final String[] splitQuestion = question.toString().split(String.format(WITH_DELIMITER, "[(\\)\\*\\÷\\+\\–\\^]"));
        question.clearComponents(question);
        question.setQuestion(question, splitQuestion);
        
    }
    
    
    String evaluate(Question question) {
        
        // TODO: remember to add in parenthases and exponents later: remember order of operations
        reformat(question);
        
        // TODO: you have to take care of parenthases first bruv...
        try {
            
            while (true) {

                // loop through every operation until you find the right operation, then do it. 
                // Then loop again, if the loop reaches the end of the operations without 
                // finding the right one, then move onto the next operation
                int par = getOperationIndex("(", question);
                if (par != 404) {
                    ridParenthases(par, question);
                }
                for (int i = 0; i < question.getLength(); i++) {
                    //System.out.print(question.getComponent(i) + " ");
                }
                
                double result;

                try {

                    int o = getOperationIndex("^", question);
                    while (o != 404) {
                        //System.out.println("multiplication loop " + o);

                        result = power(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("^", question);
                    }

                    o = getOperationIndex("*", question);
                    while (o != 404) {
                        //System.out.println("multiplication loop " + o);

                        result = multiply(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("*", question);
                    }

                    o = getOperationIndex("÷", question);
                    while (o != 404) {
                        //System.out.println("division loop " + o);

                        result = divide(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("÷", question);
                    }

                    o = getOperationIndex("+", question);
                    while (o != 404) {
                        //System.out.println("addition loop" + o);

                        result = add(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("+", question); // it is returning 404 here... it shoudln't be
                    }

                    o = getOperationIndex("–", question);
                    while (o != 404) {
                        //System.out.println("subtraction loop " + o);

                        result = subtract(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("–", question);
                    }
                    if(question.getComponent(0).equals("")){
                        return "0";
                    }else{
                        return question.getComponent(0);
                    }
                        
                        

                } catch (NumberFormatException n) {
                    return "Syntax Error type 1";
                }
            }
        } catch (ArrayIndexOutOfBoundsException b) {
            return "Syntax Error type 2";
        }
    }

    void ridParenthases(int parIndex, Question question) { // count the number of ( that you find on the way to ) and ignore one ) for every (
        int openParCount = 0;
        int closeParCount = 0;
        int endParDistance = 0;
        Question newQuestion = new Question(100);
        int i = parIndex;
        do {
            
            //System.out.println(i);
            if (question.getComponent(i).equals("(")) {
                openParCount++;
                //System.out.println("open: " + openParCount);
            }
            if (question.getComponent(i).equals(")")) {
                closeParCount++;
                //System.out.println("close " + closeParCount);
            }
            
            newQuestion.appendComponent(question.getComponent(i));
            
            //System.out.println("open: " + openParCount + ", close: " + closeParCount);
            endParDistance++;
            i++;
        } while (openParCount != closeParCount);
        
        //System.out.println(endParDistance);
        
        newQuestion.removeComponent(newQuestion.getLength()); // removes parenthases from the newQuestion
        newQuestion.removeComponent(0);
        
        question.setComponent(parIndex, evaluate(newQuestion));
        
        for (int j = 1; j < endParDistance; j++){
            question.removeComponent(parIndex+1);
        }

        int par = getOperationIndex("(", question);
        if (par != 404) {
            ridParenthases(par, question);
        }

    }
    
    int getOperationIndex(String Operation, Question question) {
        //System.out.println("–––––––new––––––");
        for (int i = 0; i < question.getLength(); i++) {
            //System.out.println(question.getComponent(i) + Operation);
            if (question.getComponent(i).equals(Operation)) { // if the component in question is equal to the operation needed
                return i;
            }
        }
        return 404;
    }

    Question getQuestion() {
        return question;
    }

    void addComponent(String component) { // for all calculator calculations, the 0th question will be used
        question.appendComponent(component);
    }

    void clearComponents() {
        question.clearComponents(question);
    }

    String getStringQuestion() {
        return question.toString();
    }

    double add(double comp1, double comp2/*, boolean graphing*/) {
        /*if (graphing){
            return (comp1 + comp2) * 10;
        }else{*/
            return comp1 + comp2;
        //}
    }
    
    double subtract(double comp1, double comp2) {
        return comp1 - comp2;
    }
    
    double multiply(double comp1, double comp2) {
        return comp1 * comp2;
    }
    
    double divide(double comp1, double comp2) {
        return comp1 / comp2;
    }
    
    double power(double comp1, double comp2) {
        return Math.pow(comp1, comp2);
    }
    
    Question stringToQuestion(String stringQuestion){
        String[] listString = stringQuestion.split(String.format(WITH_DELIMITER, "[(\\)\\*\\÷\\+\\–\\^]"));
        
        //for(String i: listString){
        //    System.out.println(i);
        //}
        
        Question newQuestion = new Question(listString.length);
        for(String i: listString){
            newQuestion.appendComponent(i);
        }
        
        return newQuestion;
    }
    
    
    
    
}
