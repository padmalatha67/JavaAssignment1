package com.javaassignment1;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
        Searches for files in directory matches with the input regular expression
        And print out the full absolute path of the matching files found.
 */

public class SearchForFilesInDirectory {
    public void findFilesInADirectory(String DirectoryPath, String regex){
        Pattern pattern = Pattern.compile(regex);
        File homeDirectory = new File(DirectoryPath);
        File [] listOfFiles = homeDirectory.listFiles();
        int countNoOfFiles =0;
        Boolean noFilesFoundForMatchingRegex = false;
        if(listOfFiles == null){
            System.out.println("No files are present in the given directory");
            return;
        }
        else{
            for(File file: listOfFiles){
                if(file.isFile()){
                    Matcher match = pattern.matcher(file.getName());
                    if(match.find()){
                        System.out.println(file.getAbsolutePath());
                        countNoOfFiles += 1;
                        noFilesFoundForMatchingRegex = false;
                    }
                    else{
                        noFilesFoundForMatchingRegex = true;
                    }
                }
                else{
                    findFilesInADirectory(file.getAbsolutePath(), regex);
                }
            }
            if(countNoOfFiles == 0 && noFilesFoundForMatchingRegex){
                System.out.println("No files found for that matching regex");
            }
        }
    }
}