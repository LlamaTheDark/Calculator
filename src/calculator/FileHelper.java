/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author llamathedark
 */
public class FileHelper {
    
    final String FILE_NAME = "eqs.sdv";
    BufferedReader reader;
    PrintWriter writer;
    
    public FileHelper(){
    
    }
    
    public static void main(String[] args){
        /*System.out.println("Testing my file helper class...");
        FileHelper f = new FileHelper();
        String[] lines = f.readTasks();
        
        for (int i = 0; i < lines.length; i++){
            System.out.println(lines[i].split(";")[0]);
            
        }
    }
    */
        FileHelper f = new FileHelper();
        String[] lines = f.readTasks();
        f.writeTasks(lines);
    }
    String[] readTasks(){
        String[] tasks = new String[100];
        int count = 0;
        try{
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine(); // read the line into a string called line
            while(line != null){ // as long as there was a line to read into, put that line into the array of Strings called tasks.
                tasks[count] = line;
                count++;
                line = reader.readLine();
            }
        }
        catch(FileNotFoundException f){
            System.out.println("Tasks file not found.");
        }
        catch (IOException i){
            System.out.println("Cannot open tasks file for output.");
        }
        
        return Arrays.copyOfRange(tasks, 0, count);
        
    }


    void writeTasks(String[] lines){
        try{
            writer = new PrintWriter(new FileWriter(FILE_NAME));
            
            for(int i = 0; i < lines.length; i++){
                writer.println(lines[i]);
            }
            writer.close();
        }
        catch (IOException i){
            System.out.println("Cannot open tasks file for output.");
        }
    }
}
