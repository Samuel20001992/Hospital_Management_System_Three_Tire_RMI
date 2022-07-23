package Employee;

//import Delete.DeleteEmployee;
//import Edit.EditEmployee;
//import app.database.models.employee.Employee;
//import app.database.models.employee.EmployeeDao;
import DataTypes.Employee;
import DataTypes.Patient;
import Delete.DeleteEmployee;
import Edit.EditEmployee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//import profile.Profile;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
;

public class ReadEmployee extends Stage {

    TableView<Employee> employeeTable;
    ObservableList<Employee> employees;
    TextField txtSearch;
    Button btnSearch;

    public ReadEmployee(Socket socket, ObjectInputStream inStream, ObjectOutputStream outStream) {


        ContextMenu contextMenu = new ContextMenu();
        MenuItem edit = new MenuItem("Edit");
        edit.setOnAction(e->{
            // ObservableList<Employee> employee = employeeTableView.getItems();

            Employee employee = employeeTable.getSelectionModel().getSelectedItem();
            if(employee == null) {
                System.err.println("Employee null");
                return;
            }


            EditEmployee employee_edit = new EditEmployee(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getMiddleName(),
                    employee.getLastName(),
                    employee.getSex(),
                    employee.getAge(),
                    employee.getPhoneNumber(),
                    employee.getEmail(),
                    employee.getAddress(),
                    employee.getHiredDate(),
                    employee.getSalary(),
                    employee.getJobType(),
                    employee.getDepartmentId(),
                    employee.getImageAddress()
            );
            employee_edit.edit_employee_main();
        });

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(e->{
            ObservableList<Employee> employee = employeeTable.getItems();
            DeleteEmployee deleteEmployee = new DeleteEmployee(employee.get(0).getId());
            try {
                deleteEmployee.delete_employee_main();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

//
//        MenuItem profile = new MenuItem("Profile");
//        profile.setOnAction(e-> {
//
//            Employee employee = employeeTable.getSelectionModel().getSelectedItem();
//
//            Profile profile1 = new Profile(
//                    employee.getId(),
//                    employee.getFirstName(),
//                    employee.getMiddleName(),
//                    employee.getLastName(),
//                    employee.getSex(),
//                    employee.getAge(),
//                    employee.getPhoneNumber(),
//                    employee.getEmail(),
//                    employee.getAddress(),
//                    employee.getHiredDate(),
//                    employee.getSalary(),
//                    employee.getJobType(),
//                    employee.getDepartmentId(),
//                    employee.getImageAddress()
//            );
//            profile1.profile_main();
//        });
//
        contextMenu.getItems().addAll(edit,delete);


        VBox root = new VBox();
        txtSearch = new TextField();
        btnSearch = new Button("Search");
        employeeTable = new TableView<>();
        HBox form = new HBox();

        ComboBox comboBoxItems = new ComboBox();
        comboBoxItems.getItems().addAll("id","first_name","middle_name","last_name","sex","age","phone_number",
                "email","address","hired_date","salary","job_type");


        createColumns();

        form.getChildren().addAll(comboBoxItems,txtSearch,btnSearch);

        employees = FXCollections.observableArrayList();
        employeeTable.setItems(employees);

        new Thread(()->{
            List<Employee> employeeList = null;
            try {

            employeeList = (List<Employee>) inStream.readObject();
                System.out.println("read employee");
                employeeList.forEach(System.out::println);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            employees.addAll(employeeList);
        }).start();

        btnSearch.setOnAction(e->{
            String selectedItem = (String) comboBoxItems.getSelectionModel().getSelectedItem();
            String searchQuery = txtSearch.getText();
            String [] search = {selectedItem,searchQuery};
            if(selectedItem.equals("")) {
                return;
            }

            if(searchQuery.equals("")) {
                System.err.println("Please enter a search query");
                return;
            }


            new Thread(()->{
             List<Employee> employeeList = null;
                try {
                    outStream.writeObject("Search Employee");
                    outStream.writeObject(search);
                    employeeList = (List<Employee>) inStream.readObject();
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
                employees.clear();
                employees.addAll(employeeList);
            }).start();


        });

        root.getChildren().addAll(
                form,employeeTable
        );

        Scene scene = new Scene(root,1800,800);
        scene.getStylesheets().add("style.css");

        setResizable(false);

        employeeTable.setContextMenu(contextMenu);
        this.setScene(scene);


    }

    private void createColumns() {
        TableColumn<Employee,Integer> idColumn = new TableColumn<>("Id");
        TableColumn<Employee,String> firstNameColumn = new TableColumn<>("First Name");
        TableColumn<Employee,String> middleNameColumn = new TableColumn<>("Middle Name");
        TableColumn<Employee,String> lastNameColumn = new TableColumn<>("Last Name");
        TableColumn<Employee,String> sexColumn = new TableColumn<>("Sex");
        TableColumn<Employee,Integer> ageColumn = new TableColumn<>("Age");
        TableColumn<Employee,Integer> phoneNumberColumn = new TableColumn<>("Phone Number");
        TableColumn<Employee,String> emailColumn = new TableColumn<>("Email");
        TableColumn<Employee,String> addressColumn = new TableColumn<>("Address");
        TableColumn<Employee, Date> hiredDateColumn = new TableColumn<>("Hired Date");
        TableColumn<Employee,Integer> salaryColumn = new TableColumn<>("Salary");
        TableColumn<Employee,String> jobTypeColumn = new TableColumn<>("Job Type");
        TableColumn<Employee,String> imageAddressColumn = new TableColumn<>("Image Address");
        TableColumn<Employee,Integer> departmentIdColumn = new TableColumn<>("Department");

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleNameColumn.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sexColumn.setCellValueFactory(new PropertyValueFactory<>("sex"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        hiredDateColumn.setCellValueFactory(new PropertyValueFactory<>("hiredDate"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        jobTypeColumn.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        departmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("departmentId"));
        imageAddressColumn.setCellValueFactory(new PropertyValueFactory<>("imageAddress"));






        employeeTable.getColumns().addAll(
                idColumn,
                firstNameColumn,
                middleNameColumn,
                lastNameColumn,
                sexColumn,
                ageColumn,
                phoneNumberColumn,
                emailColumn,
                addressColumn,
                hiredDateColumn,
                salaryColumn,
                jobTypeColumn,
                imageAddressColumn,
                departmentIdColumn
        );

        employeeTable.getColumns().forEach(col->{
            col.setMinWidth(130);
        });
    }
}
