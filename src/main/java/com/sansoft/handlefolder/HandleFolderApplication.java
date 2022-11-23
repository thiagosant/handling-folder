package com.sansoft.handlefolder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class HandleFolderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandleFolderApplication.class, args);

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = input.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS: ");

        for (File folder : folders) {
            System.out.println(folder);
        }

        System.out.println();
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES: ");
        for (File file : files) {
            System.out.println(file);
        }

        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);

        input.close();
    }

}
