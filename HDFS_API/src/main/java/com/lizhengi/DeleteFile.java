package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;

/**
 * 删除文件/目录
 *
 * @author lizhengi 2020年8月12日 上午9:20:41
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class DeleteFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 将要删除的文件/目录路径
        String File = "/List";
        // 4 删除文件 返回boolean类型   ***
        fs.delete(new Path(File), true);
        fs.close();
        // 5 返回成功信息
        System.out.println(" ps: 文件删除成功!!!");
    }
}
