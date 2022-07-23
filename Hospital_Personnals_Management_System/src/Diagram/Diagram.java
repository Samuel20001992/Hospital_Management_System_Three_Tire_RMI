package Diagram;

import Login.Login;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Diagram extends Stage {
static int employee;
static int patient;

    static PieChart pieChart = new PieChart();
   public  Diagram()
   {

       Group group = new Group();
       Scene scene = new Scene(group,400,400);

       pieChart.setData(result());

       group.getChildren().add(pieChart);
      this.setScene(scene);
      this.setTitle("Diagram");
   }
    public static ObservableList<PieChart.Data> result(){
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        Login login = new Login();

        PieChart.Data adminstrator = new PieChart.Data("Adminstrator",login.counts[0]);
        PieChart.Data doctors = new PieChart.Data("Doctors",login.counts[1]);
        PieChart.Data nurse = new PieChart.Data("Nurse",login.counts[2]);
        PieChart.Data pharmacists = new PieChart.Data("Pharmacists",login.counts[3]);

        list.addAll(adminstrator,doctors,nurse,pharmacists);

         return list;

    }


}
