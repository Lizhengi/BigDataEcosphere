package com.lizhengi;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.net.URI;


/**
 * 查找某个文件的状态信息
 *
 * @author lizhengi 2020年8月12日 上午9:58:09
 * @since 1.0.0
 *
 * ps: Hadoop服务器地址为：Carlota1
 */
public class FindFile {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 0 自动快速地使用缺省Log4j环境。
        BasicConfigurator.configure();
        // 1 获取文件系统
        Configuration configuration = new Configuration();
        // 2 配置在集群上运行
        FileSystem fs = FileSystem.get(URI.create("hdfs://Carlota1:9000"), configuration, "root");
        // 3 对文件名进行操作   ***
        Path File = new Path("/testa/part-m-00000");
        // 4 创建FileStatus对象，调用getFileStatus方法
        FileStatus filestatus = fs.getFileStatus(File);
        System.out.println(filestatus);
        // 5 返回成功信息
        System.out.println(" ps: 查找信息成功!!!");
    }

//      FileStatus字段解析
//          private Path path;                  - Path路径
//          private long length;                - 文件长度
//          private boolean isdir;              - 是不是目录
//          private short block_replication;    - 块的复本数
//          private long blocksize;             - 块大小
//          private long modification_time;     - 修改时间
//          private long access_time;           - 访问时间
//          private FsPermission permission;    - 权限
//          private String owner;               - 所有者
//          private String group;               - 所在组
//          private Path symlink;               - 符号链接,如果isdir为true那么symlink必须为null
}