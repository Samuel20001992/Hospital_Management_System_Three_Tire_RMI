package Navigation;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HomePage {
    public static AnchorPane anchorPane = new AnchorPane();
    public HomePage()
    {

        Text text = new Text();
        text.setFont(Font.font(20));
        text.setText(
                "THE INTENTION OF THIS APPLICATION\n" +
                        "THE INTENTION OF THIS APPLICATION IS TO REDUCE THE PAPER WORKS THAT ARE DONE INSIDE THE\n" +
                        "HOSPITAL AND TO GIVE EMPLOYEES EASIER ACCESS TO PATIENT AND OHTER EMPLOYEES DATA\n" +
                "HOW TO USE THIS APPLICATION \n" +
                        "THIS APPLICATION HAS ACCESS FOR EMPLOYEES THAT ARE IN DIFFERENT POSITIONS IN HOSPITAL \n" +
                        "- HOW THE SERVICE IS GIVEN TO THEM:\n" +
                        "1. THERE IS A LOGIN IN PAGE IN WHICH THE EMPLOYEE CAN LOGIN TO USING HIS/ HER EMAIL \n" +
                        "ADDRESS AND GIVEN PASSWORD.\n" +
                        "2. ACCORDING TO THEIR LEVEL IN THE HOSPITAL THEY ARE GIVEN THEIR RESPECTIVE HOME PAGES\n" +
                        " TO ACCESS THE DATA THEY ARE ALLOWED TO HAVE ACCESS TO." +
                        "\n IN ORDER TO USE THIS APPLICATION YOU NEED TO ADD MYSQL AND JFONIX JAR FILES IN TO THE PROJECT\n" +
                "PRIVECY AND SECURITY OF HOSPITAL EMPLOYEES AND DATA:\n" +
                        "ONLY THE ADMINSTRATORS OF THE HOSPITAL HAS THE ACCESS TO ALL FILES PRESENT IN THE HOSPITAL\n" +
                        "OTHER EMPLOYEES HAS ACCESS TO THEIR PATIENTS BUT DON'T HAVE ACCESS TO OTHER EMPLOYEES DATA\n" +
                        "THE PATIENTS DATA CAN BE EDITTED, VIEWED AND ADDED UP ON BY THE ENTENDED EMPLOYEE ONLY."
        );
        anchorPane.getChildren().add(text);
    }


}
