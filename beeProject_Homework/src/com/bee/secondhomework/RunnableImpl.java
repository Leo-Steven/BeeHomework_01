package com.bee.secondhomework;/*
 * @author:一身都是月~
 * @date：2020/10/17 1:19
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RunnableImpl implements Runnable {
    private RandomAccessFile file;
    private RandomAccessFile copyFile;
    private long start;
    private long end;
    private long copyLength;

    public RunnableImpl(File file, File file1, long start, long end) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "r");
        this.copyFile = new RandomAccessFile(file1, "rw");
        this.copyLength = file1.length();
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {

        try {
            file.seek(start);
            copyFile.seek(start);
            copyFile.write(("\n" + Thread.currentThread().getName() + "\n").getBytes());
            byte[] bytes = new byte[1024];
            int len;
            long count = 0;
            while ((len = file.read(bytes)) != -1) {
                count += len;
                if (count > end - start) {
                    len -= count - end;
                    copyFile.write(bytes, 0, len);
                    break;
                } else {
                    copyFile.write(bytes, 0, len);
                }
            }
            copyFile.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
