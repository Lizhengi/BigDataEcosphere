package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;

/**
 * 读取某个目录下的所有文件
 *
 * @author lizhengi 2020年8月12日 上午9:25:57
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class CatFiles {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 创建要读取的文件路径
        Path listf = new Path("/testa");
        // 4 创建FileStatus对象，调用listStatus方法  ***
        FileStatus stats[]=fs.listStatus(listf);
        for(int i=0;i<stats.length;i++){
            System.out.println(stats[i].getPath().toString());
        }
        fs.close();
        // 5 返回成功信息
        System.out.println(" ps: 目录文件查找完毕!!!");
    }
}
