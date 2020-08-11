package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;

/**
 * 读文件
 *
 * @author lizhengi 2020年8月11日 下午11:00:20
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class ReadFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 文件路径
        Path File = new Path("hdfs://Carlota1:9000/b.txt");
        // 4 创建FSDataInputStream对象
        FSDataInputStream in = fs.open(File);
        // 6 读取数据
        String info = in.readUTF();
        System.out.println(info);
        // 7 关闭流
        fs.close();
        // 8 返回创建成功信息
        System.out.println("ps:文件读取数据成功!!!");
    }

}
