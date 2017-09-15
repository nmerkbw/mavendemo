package com.example.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

/**
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/11
 */
public class HbaseDMLDemo {
    private HTablePool tablePool;

    public HbaseDMLDemo(String zkHosts, String zkParent) {
        //设置数据库地址(具体地址咨询管理员)
        Configuration conf = HBaseConfiguration.create();
        conf.set(HConstants.ZOOKEEPER_QUORUM, zkHosts);
        conf.set(HConstants.ZOOKEEPER_ZNODE_PARENT, zkParent);

        //构造数据库连接对象，全局唯一，进程退出前进行关闭
        HTablePool tablePool = new HTablePool(conf, 100);
        this.tablePool = tablePool;
    }

    /**
    * 关闭HBase连接
    * @throws IOException
    */
    public void close() throws IOException {
        tablePool.close();
    }

    /**
    * 插入/更新一行的两个列
    * @param tableName 表名
    * @param row rowKey
    * @param family family名字
    * @param column1 列1的名字
    * @param value1 列1的值
    * @param column2 列2的名字
    * @param value2 列2的值
    * @throws IOException
    */
    public void upsertData(byte[] tableName, byte[] row, byte[] family,
        byte[] column1, byte[] value1, byte[] column2, byte[] value2)
        throws IOException {
            HTableInterface table = this.tablePool.getTable(tableName);
            try {
                Put put = new Put(row);
                put.add(family, column1, value1);
                put.add(family, column2, value2);
                table.put(put);
            } finally {
                table.close();
            }
    }

    public void batchUpserting(byte[] tableName, byte[] row1, byte[] family,
        byte[] column, byte[] value1, byte[] row2, byte[] value2)
        throws IOException {
            HTableInterface table = this.tablePool.getTable(tableName);
            try {
                Put put1 = new Put(row1);
                put1.add(family, column, value1);
                Put put2 = new Put(row2);
                put2.add(family, column, value2);
                List putList = new ArrayList<Put>();
                putList.add(put1);
                putList.add(put2);
                table.put(putList);
            } finally {
                table.close();
            }
    }

    /**
    * 删除一行数据
    * @param tableName
    * @param row
    * @throws IOException
    */
    public void deleteData(byte[] tableName, byte[] row) throws IOException {
        HTableInterface table = this.tablePool.getTable(tableName);
        try {
            // 删除一整行数据
            Delete delete = new Delete(row);
            table.delete(delete);
        /**
        * 删除一行中的某些列
        * Delete delete = new Delete(row);
        * delete.deleteColumn(family, column1);
        * delete.deleteColumn(family, column2)
        * table.delete(delete);
        */
        } finally {
            table.close();
        }
    }

    /**
    * 查询一行数据
    * @param tableName
    * @param row
    * @throws IOException
    */
    public void getData(byte[] tableName, byte[] row) throws IOException {
        HTableInterface table = this.tablePool.getTable(tableName);
        try {
            // 查询一整行数据
            Get get = new Get(row);
            Result result = table.get(get);
            //从result中获取某个列的值
            // result.getValue(family, column1);
            /**
            * 查询一行中的某些列
            * Get get = new Get(row);
            * get.addColumn(family, column1);
            * get.addColumn(family, column2)
            * Result result = table.get(get);
            */
        } finally {
            table.close();
        }
    }

    /**
    * 扫描一个范围的数据
    * @param tableName
    * @param startRow
    * @param stopRow
    * @param limit
    * @throws IOException
    */
    public void scanData(byte[] tableName, byte[] startRow, byte[] stopRow, int limit) throws IOException {
        HTableInterface table = this.tablePool.getTable(tableName);
        try {
            Scan scan = new Scan(startRow, stopRow);
            /**
            * 只扫描某些列
            * scan.addColumn(family, column1);
            * scan.addColumn(family, column2);
            */
            ResultScanner scanner = table.getScanner(scan);
            int readCount = 0;
            for (Result result : scanner) {
                readCount++;
                // 处理查询结果result
                // ...
                if (readCount >= limit) {
                    // 查询数量达到limit值，终止扫描
                    break;
                }
            }
            // 最后需要关闭scanner
            scanner.close();
        } finally {
            table.close();
        }
    }

    public void main(String[] args) {
        // 初始化访问HBase的全局类, 参数dataID和dataGroup是hbase数据库的地址信息，具体请咨询管理员
        HbaseDMLDemo hbaseDemo = new HbaseDMLDemo(Config.zkHosts, Config.zkParent);

        // 在各个线程中，通过HBaseDMLDemo访问HBase
        // hbaseDemo#upsertData
        // hbaseDemo#getData
    }
}
