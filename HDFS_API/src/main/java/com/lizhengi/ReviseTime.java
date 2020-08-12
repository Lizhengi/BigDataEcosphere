package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 返回文件/目录上次修改的时间
 *
 * @author lizhengi 2020年8月12日 上午9:41:00
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class ReviseTime {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 创建要读取的文件路径
        Path File = new Path("/testa");
        // 4 创建FileStatus对象，调用listStatus方法
        FileStatus filestatus = fs.getFileStatus(File);
        // 5 调用getModificationTime方法 返回值类型为long
        long time = filestatus.getModificationTime();
        // 6 转换long类型为Data
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        System.out.println(simpleDateFormat.format(date));
        fs.close();
        // 6 返回成功信息
        System.out.println(" ps: 返回信息成功!!!");
    }
}
