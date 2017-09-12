package com.servinglynk.hmis.warehouse;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DeleteTable  extends Logging{
    private HBaseAdmin admin = null;
    public DeleteTable() throws Exception{
        admin = HbaseUtil.getAdmin();
    }
    public  void dropTable(String tableName) {

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
    
    public static void main(String args[]) throws Exception {
    	DeleteTable table = new DeleteTable();
    	List<String> list = new ArrayList<>();

list.add("hmis_type_CP0004");
list.add("hmis_type_FI0009");
list.add("hmis_type_HO0002");
list.add("hmis_type_MO0006");
list.add("hmis_type_MO0010");
list.add("hmis_type_PG0001");



list.add("bulk_upload_BA0007");
list.add("bulk_upload_CP0004");
list.add("bulk_upload_FI0009");
list.add("bulk_upload_HO0002");
list.add("bulk_upload_MO0006");
list.add("bulk_upload_MO0010");
list.add("bulk_upload_activity_BA0007");
list.add("bulk_upload_activity_CP0004");
list.add("bulk_upload_activity_FI0009");
list.add("bulk_upload_activity_HO0002");
list.add("bulk_upload_activity_MO0006");
list.add("bulk_upload_activity_MO0010");
list.add("bulk_upload_activity_PG0001");
list.add("bulk_upload_error_BA0007");
list.add("bulk_upload_error_CP0004");
list.add("bulk_upload_error_FI0009");
list.add("bulk_upload_error_HO0002");
list.add("bulk_upload_error_MO0006");
list.add("bulk_upload_error_MO0010");
list.add("bulk_upload_error_PG0001");
list.add("bulk_upload_mapping_BA0007");
list.add("bulk_upload_mapping_CP0004");
list.add("bulk_upload_mapping_FI0009");
list.add("bulk_upload_mapping_HO0002");
list.add("bulk_upload_mapping_MO0006");
list.add("bulk_upload_mapping_MO0010");			    
list.add("hud_coc_report_question_7_CP0004");
list.add("hud_coc_report_question_7_HO0002");						
list.add("hud_coc_report_question_7_MO0010");						
list.add("hud_coc_report_question_7_PG0001");
list.add("sync_BA0007");
list.add("sync_CP0004");
list.add("sync_FI0009");
list.add("sync_HO0002");
list.add("sync_MO0006");
list.add("sync_MO0010");	

for(String tableName : list) {
	table.dropTable(tableName);
}
    	
    }
}
