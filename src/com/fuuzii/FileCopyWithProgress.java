package com.fuuzii;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * 复制本地文件到 hdfs 中。
 *
 * @author yinlei
 * @since 2018/5/4 15:33
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws IOException {
        String localSource = args[0];
        String dest = args[1];
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(localSource));

        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(dest), configuration);
        OutputStream os = fs.create(new Path(dest), () -> System.out.println("."));

        IOUtils.copyBytes(bis, os, 4096, true);
    }
}
