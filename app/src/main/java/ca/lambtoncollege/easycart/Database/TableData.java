package ca.lambtoncollege.easycart.Database;

import android.provider.BaseColumns;

/**
 * Created by ramandeepsingh on 2017-08-16.
 */

public class TableData {
    public TableData() {

    }

    public static abstract class Tableinfo implements BaseColumns {
        public static final String PRODUCT_ID = "cab_no";
        public static final String PRODUCT_NAME = "time";
        public static final String PRODUCT_DESCRIPTION = "user_id";
        public static final String DATABASE_NAME = "dbcart";
        public static final String TABLE_NAME = "cart";
        ////////////////////////////////////////////////////


        public static final int database_version = 1;
    }
}
