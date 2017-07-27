package com.fuuzii;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

/**
 * 通过编程的方式来过滤文件，这里使用了正则表达式
 *
 * @author yinlei
 * @since 2017/7/25 11:13
 */
public class RegexPathFilter implements PathFilter {
    private final String regex;

    public RegexPathFilter(String regex) {
        this.regex = regex;
    }
    public boolean accept(Path path) {
        return !path.toString().matches(regex);
    }
}
