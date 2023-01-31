package main.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileManagement {

    public static final String path = "src/dir/";


    public void addFile(String fileName){
        try {
            Path absolutePath = FileSystems.getDefault().getPath(path + fileName).toAbsolutePath();
            File file = new File(absolutePath + "" );

            if (file.createNewFile()) { //checks if the file exists, if not it adds it
                System.out.println("File " + file.getName() + " created!" );
            } else {
                System.out.println("File Already exists!");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void deleteFile(String fileName){
        Path absolutePath = FileSystems.getDefault().getPath(path + fileName).toAbsolutePath();
        File file = new File(absolutePath + "" );

        if (file.delete()) { //checks if a file exits, if yes it deletes it
            System.out.println("File " + file.getName() + " deleted!" );
        } else {
            System.out.println("File " + fileName + " does not exist!");
        }
    }

    public void searchFile(String fileName){ //uses binary seach for quick search of the required file
        File file = new File(path + "" );
        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
        if(binarySearch(files , fileName, files.size()) == 0){
            System.out.println("File " + fileName + " found!");
        }
        else
            System.out.println("File " + fileName + " not found!");
    }

    public void showFiles(){
        File file = new File(path + "" );

        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));
        Collections.sort(files); //predefined command that sorts the files in asc order

        printFiles(files);

    }

    private void printFiles(ArrayList<File> files){ //prints all the files
        System.out.println("\nFiles inside the directory are: ");
        for(int i = 0; i < files.size(); i++){
            System.out.println(files.get(i).getName());
        }
        System.out.println();
    }

    private int binarySearch(ArrayList<File> list, String file,int n)
    {
        int l = 0 ;
        int r = n - 1;
        int res = -1;
        while (l <= r)
        {
            int m = l + (r - l) / 2;
            System.out.println(m);
            if (file.equals(list.get(m).getName()))
                res = 0;

            if (res == 0)
                return m;

            if (file.compareTo(list.get(m).getName()) == 1)
                l = m + 1;

            else
                r = m - 1;
        }
        return res;
    }
}
