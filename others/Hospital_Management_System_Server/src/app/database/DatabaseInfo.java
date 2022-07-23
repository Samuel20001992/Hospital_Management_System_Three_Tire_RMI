package app.database;

import java.util.TimeZone;

public class DatabaseInfo {

    public static final String dbName = "advanced_java_project";
    public static final String dbUrl = "jdbc:mysql://localhost/" + dbName + "?serverTimezone=" + TimeZone.getDefault().getID();
    public static String username = "root";
    public static String password = "";

}
