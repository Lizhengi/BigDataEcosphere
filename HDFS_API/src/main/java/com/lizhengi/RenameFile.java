package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;


/**
 * 重命名文件/目录
 *
 * @author lizhengi 2020年8月12日 上午9:10:20
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class RenameFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 对文件名进行操作   ***
        Path old = new Path("/test");
        Path now = new Path("/testa");
        // 4 调用hdfs的rename重命名方法，返回值为boolean类型    ***
        fs.rename(old, now);
        // 5 返回成功信息
        System.out.println(" ps: 文件重命名成功!!!");
    }

}
