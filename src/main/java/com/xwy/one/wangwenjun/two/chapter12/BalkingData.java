package com.xwy.one.wangwenjun.two.chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @description:
 * @author: xwy
 * @create: 4:54 PM 2020/5/22
 **/

public class BalkingData {
    private final String fileName;
    private String content;
    private boolean changed;

    public BalkingData(String fileName, String content, boolean changed) {
        this.fileName = fileName;
        this.content = content;
        this.changed = changed;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }

        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException{
        System.out.println(Thread.currentThread().getName() + " calls to save,content =" + content);
        try (Writer writer = new FileWriter(fileName,true)){
            writer.write(content);
            writer.write("\n");
            writer.flush();
        }
    }
}