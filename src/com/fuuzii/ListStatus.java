package com.fuuzii;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * @author yinlei
 * @since 2017/7/25 10:37
 */
public class ListStatus {
    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            args = new String[]{ "/" };
        }
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path[] paths = new Path[args.length];
        for (int i = 0; i < paths.length; i++) {
            paths[i] = new Path(args[i]);
        }
        // 可以使用通配符来过滤文件，PathFilter可以通过编程来手工过滤
//        FileStatus[] statuses = fs.globStatus(Path, PathFilter)
        FileStatus[] status = fs.listStatus(paths);
        Path[] listedPaths = FileUtil.stat2Paths(status);
        for (Path p : listedPaths) {
            System.out.println(p);
        }
    }
}
