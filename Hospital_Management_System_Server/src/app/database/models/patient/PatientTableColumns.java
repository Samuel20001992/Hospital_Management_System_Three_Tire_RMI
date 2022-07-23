package app.database.models.patient;

public class PatientTableColumns {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_MIDDLE_NAME = "middle_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_SEX = "sex";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_REGISTRATION_DATE = "registration_date";

    public final static String TABLE_NAME = "patients";

    public static int getColumnIndex(String columnName){
        switch (columnName) {
            case COLUMN_ID:
                return 1;
            case COLUMN_FIRST_NAME :
                return 2;
            case COLUMN_MIDDLE_NAME :
                return 3;
            case COLUMN_LAST_NAME :
                return 4;
            case COLUMN_SEX :
                return 5;
            case COLUMN_AGE :
                return 6;
            case COLUMN_PHONE_NUMBER :
                return 7;
            case COLUMN_ADDRESS :
                return 8;
            case COLUMN_REGISTRATION_DATE:
                return 9;
        }

        return -1;
    }

}
