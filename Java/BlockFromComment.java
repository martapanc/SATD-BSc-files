/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author martapancaldi
 */
public class BlockFromComment {
    
    static String FILE_PATH = "src/gauss/HTMLAssertion.txt";
    static String COMMENT = "/ check if filename defined";
    //static String COMMENT = "// no error as default 3";
    
    public static void main (String[] args) {
        
        findBlockFromComment(COMMENT);
        /*try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line = br.readLine();
            List<String> content = new ArrayList<>();
            String comm = COMMENT;
            int index = 0;
            while (line != null) {
                content.add(line + "");
                line = br.readLine();
            }
            
            for (int i = 0; i < content.size(); i ++) 
                if (content.get(i).contains(comm))
                    index = i;
            
            Pattern open = Pattern.compile("\\{");   
            Pattern close = Pattern.compile("\\}");
            int openCount = 0, closeCount = 0, startIndex = 0, endIndex = 0;
            Matcher openMatcher, closeMatcher;
           
            for (int i = index; i > 0; i--) {
                openMatcher = open.matcher(content.get(i));
                while (openMatcher.find())
                    openCount++;
                closeMatcher = close.matcher(content.get(i));
                while (closeMatcher.find())
                    closeCount++;
                if (openCount == (closeCount+1)) { 
                    startIndex = i;
                    System.out.println("Start block index: " + startIndex);
                    break;
                }   
            }
            openCount = 0; closeCount = 0;
            
            for (int i = startIndex; i < content.size(); i ++) {
                openMatcher = open.matcher(content.get(i));
                while (openMatcher.find())
                    openCount++;
                //System.out.println(openCount);
                closeMatcher = close.matcher(content.get(i));
                while (closeMatcher.find())
                    closeCount++;
                //System.out.println(closeCount);
                if (openCount == (closeCount)) {
                    endIndex = i;
                    System.out.println("End block index: " + endIndex);
                    break;
                }
            }
            
            int j = startIndex;
            while (j <= endIndex) {
                System.out.println(content.get(j));
                j++;
            }
            
            //System.out.println(content.get(index-2) + " " + content.get(index) + " " + content.get(index+1));
        }
        catch (IOException e) {
        e.printStackTrace();
        }*/
        
    }
    
    public static int[] findBlockFromComment(String comment) {
        int[] indices = {0,0};
           
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line = br.readLine();
            List<String> content = new ArrayList<>();
            String comm = comment;
            int index = 0; //index of line containing comment
            while (line != null) {
                content.add(line + "");
                line = br.readLine();
            }
            
            for (int i = 0; i < content.size(); i ++) 
                if (content.get(i).contains(comm))
                    index = i;
            
            Pattern open = Pattern.compile("\\{");   
            Pattern close = Pattern.compile("\\}");
            int openCount = 0, closeCount = 0, startIndex = 0, endIndex = 0;
            Matcher openMatcher, closeMatcher;
           
            for (int i = index; i > 0; i--) {
                openMatcher = open.matcher(content.get(i));
                while (openMatcher.find())
                    openCount++;
                closeMatcher = close.matcher(content.get(i));
                while (closeMatcher.find())
                    closeCount++;
                if (openCount == (closeCount+1)) { 
                    startIndex = i;
                    System.out.println("Start block index: " + startIndex);
                    break;
                }   
            }
            openCount = 0; closeCount = 0;
            
            for (int i = startIndex; i < content.size(); i ++) {
                openMatcher = open.matcher(content.get(i));
                while (openMatcher.find())
                    openCount++;
                //System.out.println(openCount);
                closeMatcher = close.matcher(content.get(i));
                while (closeMatcher.find())
                    closeCount++;
                //System.out.println(closeCount);
                if (openCount == closeCount) {
                    endIndex = i;
                    System.out.println("End block index: " + endIndex);
                    break;
                }
            }
            
            int j = startIndex;
            while (j <= endIndex) {
                System.out.println(content.get(j));
                j++;
            }
            indices[0] = startIndex;
            indices[1] = endIndex;
            //System.out.println(content.get(index-2) + " " + content.get(index) + " " + content.get(index+1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
            
        return indices;
    }
}
