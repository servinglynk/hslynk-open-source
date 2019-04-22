package com.servinglynk.hmis.warehouse;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SyncHBaseProcessor extends Logging {
    private HBaseAdmin admin = null;
    public int batchSize = 100000;
    public SyncHBaseProcessor() throws Exception{
        admin = HbaseUtil.getAdmin();
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
            e.printStackTrace();
        }
    }
    
    public void dropHBASETable(String tableName) {
   	 try {
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
            log.info("Table ::" + tableName + " deleted.");
        } catch (TableExistsException ex) {
            log.warn("Table :: " + tableName + " does not exists.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
   }

    public List<String> getAllKeyRecords (HTable table) {
        List<String> keys = new ArrayList<>();
        try {
            Scan s = new Scan();
            ResultScanner ss = table.getScanner(s);
            for (Result r : ss) {
                keys.add(new String(r.raw()[0].getRow()));
                //log.info(new String(r.raw()[0].getRow()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return keys;
    }

    public void deleteDataInBatch(HTable table, List<String> dataIds){
        List<Delete> deletes = new ArrayList<>();
        for(String id : dataIds){
            deletes.add(new Delete(Bytes.toBytes(id)));
        }
        try {
            table.delete(deletes);
            table.flushCommits();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
