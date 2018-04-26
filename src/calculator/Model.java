package calculator;

import java.util.Arrays;

public class Model {

    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    Question question = new Question();

    public Model() {

    }

    void reformat(Question question) { // remember PEMDAS
        int index = 0;
        boolean notDone = true;

        Question newAndBetterQuestion = new Question();

        // splits the equation by it's operators to identify multi-digit numbers
        final String[] splitQuestion = question.toString().split(String.format(WITH_DELIMITER, "[(\\)\\*\\÷\\+\\–\\^]"));
        question.clearComponents(question);
        question.setQuestion(question, splitQuestion);

    }

    String evaluate(Question question) {
        // TODO: remember to add in parenthases and exponents later: remember order of operations
        reformat(question);
        boolean finished = false;
        try {
            while (!finished == true) {

                // loop through every operation until you find the right operation, then do it. 
                // Then loop again, if the loop reaches the end of the operations without 
                // finding the right one, then move onto the next operation
                int o = getOperationIndex("*", question);
                double result;
                try {
                    while (o != 404) {
                        System.out.println("multiplication loop " + o);

                        result = multiply(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);
                        o = getOperationIndex("*", question);
                    }
                    o = getOperationIndex("÷", question);
                    while (o != 404) {
                        System.out.println("division loop " + o);

                        result = divide(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);
                        o = getOperationIndex("÷", question);
                        
                    }
                    o = getOperationIndex("+", question);
                    while (o != 404) {

                        result = add(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);

                        o = getOperationIndex("+", question); // it is returning 404 here... it shoudln't be
                        System.out.println("addition loop " + o);
                        System.out.println(question.getComponents());

                    }
                    o = getOperationIndex("–", question);
                    while (o != 404) {
                        System.out.println("division loop " + o);

                        result = subtract(Double.parseDouble(question.getComponent(o - 1)), Double.parseDouble(question.getComponent(o + 1)));
                        question.setComponent(o - 1, Double.toString(result));
                        question.removeComponent(o);
                        question.removeComponent(o);
                        o = getOperationIndex("–", question);
                    }

                    System.out.println(question.getComponent(0) + " " + question.getComponent(1) + " " + question.getComponent(2));
                    return question.getComponent(0);

                } catch (NumberFormatException n) {
                    return "Error";
                }
            }
        } catch (ArrayIndexOutOfBoundsException b) {
            return "Error";
        }

        return "0.0";
    }

    int getOperationIndex(String Operation, Question question) {
        System.out.println("–––––––new––––––");
        for (int i = 0; i < question.getLength(); i++) {
            System.out.println(question.getComponent(i) + Operation);
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

    double add(double comp1, double comp2) {
        return comp1 + comp2;
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
}
