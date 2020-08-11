package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;

/**
 * 上传本地文件
 *
 * @author lizhengi 2020年8月11日 下午9:45:53
 * @since 1.0.2
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class UploadFiles {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 创建源目的文件路径和文件上传操作 *****
        Path src = new Path("src/main/resources/HdfsCommand.txt");
        Path dst = new Path("/List/HdfsCommand.txt");
        fs.copyFromLocalFile(src, dst);
        // 4 关闭流
        fs.close();
        // 5 返回创建成功信息
        System.out.println("ps:文件上传成功!!!");
    }
}

