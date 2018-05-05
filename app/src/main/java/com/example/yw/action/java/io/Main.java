package com.example.yw.action.java.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jack
 * On 18-3-28:上午9:33
 * Desc:
 */

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/home/jack/Downloads/test.apk");
        readData(new FileInputStream(file));
        readDataToBuffer(new FileInputStream(file));
    }

    private static byte[] readData(InputStream input) {
        long startTime = System.currentTimeMillis();
        int size = 0x400;
        byte[] ret = null;
        try {
            ByteArrayOutputStream handle = null;
            handle = new ByteArrayOutputStream();
                byte[] data = new byte[size];
                int cnt = 0;
                do {
                    int readCnt = input.read(data);
                    if(readCnt == -1) {
                        break;
                    }

                    cnt += readCnt;
                    handle.write(data, 0, readCnt);
                } while(cnt < 0x500000);
                ret = handle.toByteArray();
        } catch(Throwable th) {

        }
        System.out.println("pay time: " + (System.currentTimeMillis() - startTime));
        return ret;
    }

    private static byte[] readDataToBuffer(InputStream input) {
        long startTime = System.currentTimeMillis();
        int size;
        ByteArrayOutputStream handle = null;
        byte[] ret = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
            handle = new ByteArrayOutputStream();
            size = 0x400;
                byte[] data = new byte[size];
                int cnt = 0;
                do {
                    int readCnt = bufferedInputStream.read(data);
                    if(readCnt == -1) {
                        break;
                    }

                    cnt += readCnt;
                    handle.write(data, 0, readCnt);
                } while(cnt < 0x500000);
                ret = handle.toByteArray();
        } catch(Throwable th) {

        }
        System.out.println("normal way pay time: " + (System.currentTimeMillis() - startTime));
        return ret;
    }
}
