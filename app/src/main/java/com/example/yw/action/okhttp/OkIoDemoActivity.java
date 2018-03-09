package com.example.yw.action.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yw.action.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;


/**
 *  1. okio read write
 *  2.
 */
public class OkIoDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_io_demo);

        testWrite();

        testRead();
        
        testGzipWrite();
        
        testUnGzipRead();
    }

    private void testUnGzipRead() {
    }

    private void testGzipWrite() {
    }

    private void testRead() {
    }

    private void testWrite() {
        try {
            Sink sink = Okio.sink(new File("testokio.txt"));
            BufferedSink bufferedSink = Okio.buffer(sink);
            bufferedSink.writeUtf8("testokio");

            bufferedSink.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
