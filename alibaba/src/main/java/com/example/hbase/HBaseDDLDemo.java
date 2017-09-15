package com.example.hbase;

/**
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/11
 */

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class HBaseDDLDemo {
    private HBaseAdmin admin;

    public HBaseDDLDemo(String zkHosts, String zkParent) throws MasterNotRunningException,
        ZooKeeperConnectionException {
        Configuration conf = HBaseConfiguration.create();
        // 添加数据库地址的配置
        conf.set(HConstants.ZOOKEEPER_QUORUM, zkHosts);
        conf.set(HConstants.ZOOKEEPER_ZNODE_PARENT, zkParent);
        this.admin = new HBaseAdmin(conf);
    }

    /**
    * 关闭HBase连接
    * @throws IOException
    */
    public void close() throws IOException {
        admin.close();
    }

  /**
   * 创建表
   * @param tableName
   * @param family
   * @throws IOException
   */
  public void createTable(String tableName, byte[] family) throws IOException {
    HTableDescriptor htd = new HTableDescriptor(tableName);
    htd.addFamily(new HColumnDescriptor(family));
    this.admin.createTable(htd);
  }

  /**
   * 停用表
   * @param tableName
   * @throws IOException
   */
  public void disableTable(String tableName) throws IOException {
    this.admin.disableTable(tableName);
  }

  /**
   * 启用表
   * @param tableName
   * @throws IOException
   */
  public void enableTable(String tableName) throws IOException {
    this.admin.enableTable(tableName);
  }

  /**
   * 删除表
   * @param tableName
   * @param tableName
   * @throws IOException
   */
  public void deleteTable(String tableName) throws IOException {
    this.admin.deleteTable(tableName);
  }
}