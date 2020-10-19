package com.bee.secondhomework;/*
 * @author:一身都是月~
 * @date：2020/10/16 12:02
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

public class CopyOfThread {
    public static void main(String[] args) throws IOException {
        ExecutorService excutors= newFixedThreadPool(2);
        String sep = File.separator;
        File file = new File("." + sep + "src" + sep + "com" + sep + "bee" + sep + "secondhomework" + sep + "test.txt");
        File copyFile = new File("." + sep + "src" + sep + "com" + sep + "bee" + sep + "secondhomework" + sep + "copyfile.txt");
        if (copyFile.exists()) {
            copyFile.createNewFile();
        }

        try {
            excutors.submit(new RunnableImpl(file, copyFile, 0, file.length() / 2));
            excutors.submit(new RunnableImpl(file, copyFile, file.length() / 2, file.length()));
            excutors.shutdown();
//            new Thread(new RunnableImpl(file, copyFile, 0, file.length() / 2), "Thread1").start();
//            new Thread(new RunnableImpl(file, copyFile, file.length() / 2, file.length()), "Thread2").start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
