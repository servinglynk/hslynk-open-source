package com.servinglynk.hmis.warehouse;

import org.apache.hadoop.hbase.client.HTable;

import java.util.Map;

/**
 * Created by sandeep
 */
public class TestClasses {
    public static void main(String args[]) throws Exception{

//        final Map<String, Class<? extends BaseModel>> tables = BaseProcessor.getAlltables();
//        for(String tableName : tables.keySet()) {
//            Class<? extends BaseModel> temp = tables.get(tableName);
//            ProcessClass process = new ProcessClass();
//            process.listClass(temp);

//        }

        HTable table = new HTable(HbaseUtil.getConfiguration(), "Exit_CP0004_2014");
        HBaseImport hBaseImport = new HBaseImport();
        hBaseImport.getAllKeyRecords(table);
    }
}



