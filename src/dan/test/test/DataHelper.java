package dan.test.test;

import android.content.Context;
//import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {
	
	//if the database schema is changed, increment database version
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "Chatty.db";
	
	public DataHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public DataHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		
		arg0.execSQL(DataContract.CREATE_USERS_TABLE);
		arg0.execSQL(DataContract.CREATE_GROUPS_TABLE);
		arg0.execSQL(DataContract.CREATE_MEMBERSHIP_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL(DataContract.DESTROY_TABLES);
		onCreate(arg0);
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL(DataContract.DESTROY_TABLES);
		onCreate(arg0);
	}

}
