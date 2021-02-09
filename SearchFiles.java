package com.javaassignment1;

import java.util.Scanner;

import static java.lang.Boolean.TRUE;

/*
        This program will take inputs repeatedly and  call searchForFilesinDirectory to search for files
 */

public class SearchFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SearchForFilesInDirectory searchForFiles = new SearchForFilesInDirectory();
        String input = "";
        String homeDirectory = System.getProperty("user.dir");

        do{
            System.out.println("Please enter a regex or enter exit to exit");
            input = scanner.next();
            if(input.equals("exit")){
                break;
            }
            else{
                searchForFiles.findFilesInADirectory(homeDirectory, input);
            }
        }while(TRUE);

    }
}
