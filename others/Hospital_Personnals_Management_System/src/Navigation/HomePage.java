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
        text.setFont(Font.font(24));
        text.setText(

                "HOW TO USE THIS APPLICATION \n" +
                        "THIS APPLICATION HAS ACCESS FOR EMPLOYEES THAT ARE IN DIFFERENT POSITIONS IN HOSPITAL \n" +
                        "- HOW THE SERVICE IS GIVEN TO THEM:\n" +
                        "1. THERE IS A LOGIN IN PAGE IN WHICH THE EMPLOYEE CAN LOGIN TO USING HIS/ HER EMAIL ADDRESS AND " +
                        "GIVEN PASSWORD.\n" +
                        "2. ACCORDING TO THEIR LEVEL IN THE HOSPITAL THEY ARE GIVEN THEIR RESPECTIVE HOME PAGES TO ACCESS THE DATA THEY ARE " +
                        "ALLOWED TO HAVE ACCESS TO." +
                        "\n IN ORDER TO USE THIS APPLICATION YOU NEED TO ADD MYSQL AND JFONIX JAR FILES IN TO THE PROJECT" );
        anchorPane.getChildren().add(text);
    }


}
