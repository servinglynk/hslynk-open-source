package com.servinglynk.hmis.warehouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

public class SyncHBaseProcessor extends Logging {
    private HBaseAdmin admin = null;
    public int batchSize = 1000;
    public SyncHBaseProcessor() throws Exception{
        admin = HbaseUtil.getAdmin();
    }
    public void dropHBASETable(String tableName, Logger logger) {

        try {
            admin.deleteTable(tableName);
            log.info("Table ::" + tableName + " created.");
        } catch (TableExistsException ex) {
            log.warn("Table :: " + tableName + " already exists.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e);
        }
    }
    public void createHBASETable(String tableName, Logger logger) {

        try {
            HTableDescriptor tableDescriptor = new HTableDescriptor(
                    tableName);
            tableDescriptor.addFamily(new HColumnDescriptor("CF"));
            admin.createTable(tableDescriptor);
            log.info("Table ::" + tableName + " created.");
        } catch (TableExistsException ex) {
            log.warn("Table :: " + tableName + " already exists.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e);
        }
    }

    public List<String> getAllKeyRecords (HTable table, Logger logger) {
        List<String> keys = new ArrayList<>();
        try {
            Scan s = new Scan();
            ResultScanner ss = table.getScanner(s);
            for (Result r : ss) {
                keys.add(new String(r.raw()[0].getRow()));
                //log.info(new String(r.raw()[0].getRow()));
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return keys;
    }

    public void deleteDataInBatch(HTable table, List<String> dataIds, Logger logger){
        List<Delete> deletes = new ArrayList<>();
        for(String id : dataIds){
            deletes.add(new Delete(Bytes.toBytes(id)));
        }
        try {
            table.delete(deletes);
        }catch (Exception ex){
            logger.error(ex);
        }
    }

}
