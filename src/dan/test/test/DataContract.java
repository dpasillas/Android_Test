package dan.test.test;

import android.provider.BaseColumns;

public final class DataContract {

	private DataContract() {}
    
	public static abstract class User implements BaseColumns {
		public static final String TABLE_NAME = "users";
		public static final String CN_USER_NAME = "name"; //Column Name (CN)
	}
	
	public static abstract class Group implements BaseColumns {
		public static final String TABLE_NAME = "groups";
		public static final String CN_GROUP_NAME = "name"; //Column Name (CN)
	}
	
	public static abstract class Membership implements BaseColumns {
		public static final String TABLE_NAME = "mem";
		public static final String CN_USER_ID = "uid";
		public static final String CN_GROUP_ID = "gid";
	}

	public static final String DELIM = ",";
	public static final String NAME_TYPE = " TEXT";
	public static final String ID_TYPE = " INTEGER";
	public static final String CREATE_USERS_TABLE =
			"CREATE TABLE " + User.TABLE_NAME + " (\n" +
					User._ID + "Integer PRIMARY KEY AUTOINCREMENT" + DELIM +
					User.CN_USER_NAME + NAME_TYPE + " UNIQUE" +
					" );";
	
	public static final String CREATE_GROUPS_TABLE =
			"CREATE TABLE " +  Group.TABLE_NAME + " (\n" +
					Group._ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + DELIM +
					Group.CN_GROUP_NAME + NAME_TYPE + " UNIQUE" +
					" );";
	
	public static final String CREATE_MEMBERSHIP_TABLE = 
			"CREATE TABLE " +  Membership.TABLE_NAME + " (\n" +
					Membership._ID + "INTEGER PRIMARY KEY AUTOINCREMENT" + DELIM +
					Membership.CN_USER_ID + ID_TYPE +
						" REFERENCES " + User.TABLE_NAME + " (" + User._ID + " )" + DELIM +
					Membership.CN_GROUP_ID + 
						" REFERENCES " + Group.TABLE_NAME + " (" + Group._ID + " )" + DELIM +
					"UNIQUE (" + User._ID + DELIM + Group._ID + ") " + 
					" );";
	
	public static final String DESTROY_TABLES = 
			"DROP TABLE " + Membership.TABLE_NAME + "; " +
			"DROP TABLE " + Group.TABLE_NAME + "; " + 
			"DROP TABLE " + User.TABLE_NAME + "; ";
				
}
