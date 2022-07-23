package app.database.models.employee;

public class EmployeeTableColumns {

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_MIDDLE_NAME = "middle_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_SEX = "sex";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_HIRED_DATE = "hired_date";
    public static final String COLUMN_SALARY = "salary";
    public static final String COLUMN_JOB_TYPE = "job_type";
    public static final String COLUMN_DEPARTMENT_ID = "department_id";
    public static final String COLUMN_IMAGE_ADDRESS = "image_address";
    public static final String COLUMN_PASSWORD= "password";

    public static final String TABLE_NAME = "employees";

    public static int getColumnIndex(String columnName) {
        switch (columnName) {
            case COLUMN_ID:
                return 1;
            case COLUMN_FIRST_NAME:
                return 2;
            case COLUMN_MIDDLE_NAME:
                return 3;
            case COLUMN_LAST_NAME:
                return 4;
            case COLUMN_SEX:
                return 5;
            case COLUMN_AGE:
                return 6;
            case COLUMN_PHONE_NUMBER:
                return 7;
            case COLUMN_EMAIL:
                return 8;
            case COLUMN_ADDRESS:
                return 9;
            case COLUMN_HIRED_DATE:
                return 10;
            case COLUMN_SALARY:
                return 11;
            case COLUMN_JOB_TYPE:
                return 12;
            case COLUMN_DEPARTMENT_ID:
                return 13;
            case COLUMN_IMAGE_ADDRESS:
                return 14;
            case COLUMN_PASSWORD:
                return 15;
        }

        return -1;
    }
}
