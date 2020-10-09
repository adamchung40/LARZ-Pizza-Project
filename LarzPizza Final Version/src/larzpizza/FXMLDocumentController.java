/**
*Importing all the packages required for the code.
*/
package larzpizza;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

/**
 *
 * This class creates a GUI for pizza ordering process.
 * The GUI allows the user to select items from the menu and enter personal information to place an order with the pizza company. 
 */
public class FXMLDocumentController implements Initializable {

    
    private Label label;
    @FXML
    private ImageView IvPizza;
    @FXML
    private RadioButton rbSmall;
    @FXML
    private RadioButton rbMedium;
    @FXML
    private RadioButton rbLarge;
    @FXML
    private RadioButton rbXLarge;
    @FXML
    private Label lbTopping;
    @FXML
    private ListView<String> ToppingList;
    private final String[] ToppingsItems = {"Pepproni","Bacon","BBQ Chicken","Philly Steak","Sundried Tomatoes","Onions","Jalapeno","Olives","Mushrooms","Spinach"};
    private final ObservableList<String> Toppings= FXCollections.observableArrayList(ToppingsItems);
    @FXML
    private Label lbCrsut;
    @FXML
    private Label lbBeverage;
    @FXML
    private ListView<String> lvBeverage;
    private final ObservableList<String> BeverageList= FXCollections.observableArrayList("Coke","Sprite","Sweet Tea","Unsweet Tea","Lemonade","Dr.Pepper");
    @FXML
    private Label lbBeverageSize;
    @FXML
    private ChoiceBox<String> cbBeverageSize;
    private final ObservableList<String> BeverageSize= FXCollections.observableArrayList("Small $1.50","Medium $1.80","Large $2.10");
    @FXML
    private TextField tfCompanyName;
    @FXML
    private Button btnOrder;
    @FXML
    private Button btnReset;
    @FXML
    private TextArea TaSummary;
    @FXML
    private TextField tfQuantity;
    @FXML
    private ChoiceBox<String> cbCrustType;
    private final ObservableList<String> CrustOptions= FXCollections.observableArrayList("Hand Tossed","Handmade Pan","Thin Crust");
    final ToggleGroup group = new ToggleGroup();
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private TextField t1;
    @FXML
    private TextField t2;
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    @FXML
    private TextField t5;
    @FXML
    private TextField t6;
    @FXML
    private TextField e1;
    @FXML
    private TextField e2;
    @FXML
    private TextField e3;
    @FXML
    private TextField e4;
    @FXML
    private TextField e5;
    @FXML
    private TextArea t7;
    @FXML
    private TextArea t8;
    @FXML
    private Button submit;
    @FXML
    private TextField tfBeverageQuantity;
    final ToggleGroup TF = new ToggleGroup();
    @FXML
    private TextField emailTf;
    @FXML
    private TextField passwordTf;
    @FXML
    private Button signin;
    @FXML
    private TextArea loginPass;
    @FXML
    private Label lbinformation;
  
    
    /**
    * The initialize method is used here to initialize some of the controls used in our GUI.
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToppingList.setItems(Toppings);
        ToppingList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvBeverage.setItems(BeverageList);
        lvBeverage.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        cbBeverageSize.setItems(BeverageSize);
        cbCrustType.setItems(CrustOptions);
        rbSmall.setToggleGroup(group);
        rbMedium.setToggleGroup(group);
        rbLarge.setToggleGroup(group);
        rbXLarge.setToggleGroup(group);
        r1.setToggleGroup(TF);
        r2.setToggleGroup(TF);
        lbinformation.setWrapText(true);
    }    

    /**
    * The handleOrderButtonAction method is an ActionEvent method. 
    * This method is executed only when the Order Button in the Menu tab of is clicked. 
    * This method is used to finalize the selected items from the menu and place it in the cart. 
    */ 
    @FXML
    private void handleOrderButtonAction(ActionEvent event) {
        boolean hyuyu = true;
        double price = 0.00;
        double ToppingPrice=0.00;
        double BeveragePrice=0.00;


        int pizzaQuantity=0;
        try {
            pizzaQuantity = Integer.parseInt(tfQuantity.getText());
            if(pizzaQuantity <= 0) {
                int temp =Integer.parseInt("Hyuyu");
            }
        } catch (Exception e) {
            TaSummary.appendText("\nIncorrect quantity of pizzas specified. Please try again.");
            TaSummary.appendText("\n");
            hyuyu = false;
        }

        int beverageQuantity=0;
        try {
            if ("".equals((tfBeverageQuantity.getText()))) {
                beverageQuantity = 0;
            } else {
                beverageQuantity = Integer.parseInt(tfBeverageQuantity.getText());
                if(beverageQuantity <= 0) {
                int temp =Integer.parseInt("Hyuyu");
            }
            }
        } catch (Exception e) {
            TaSummary.appendText("\nIncorrect quantity of beverages specified. Please try again.");
            TaSummary.appendText("\n");
            hyuyu = false;
        }
        
        String crust=cbCrustType.getSelectionModel().getSelectedItem();
        ObservableList<String> Topping;
        Topping=ToppingList.getSelectionModel().getSelectedItems();
        ObservableList<String> Beverage;
        Beverage=lvBeverage.getSelectionModel().getSelectedItems();
        String size=cbBeverageSize.getSelectionModel().getSelectedItem();
        
        int ToppingCount=0;
        for(String PizzaTopping :Topping){
                ToppingCount+=1;
            }
            if(ToppingCount>4) {
                System.out.println("There were more than 4 toppings chosen. Please rerun the program while choosing atmost 4 toppings");
                System.exit(0);
            }
        
        for(String Beverages:Beverage){
                if("Small $1.50".equals(size)){
                BeveragePrice+=1.50;
                }
                if("Medium $1.80".equals(size)){
                BeveragePrice+=1.80;
                }
                if("Large $2.10".equals(size)){
                BeveragePrice+=2.10;
                }
        }
        
        if(hyuyu) {
            if (crust == null) {
                TaSummary.appendText("\nPlease select a crust.");
            } 
            else {
                if(rbSmall.isSelected()){
                    ToppingPrice=ToppingCount*1;
                    price = (6*pizzaQuantity)+(ToppingPrice*pizzaQuantity)+(BeveragePrice*beverageQuantity);
                    TaSummary.appendText("\n\nPizza Size - Small"+"\nCrust Type - "+crust);
                    TaSummary.appendText("\nTopping -"+Topping);
                    TaSummary.appendText("\nPizza Quantity -"+pizzaQuantity);
                    if(Beverage != null && size != null && beverageQuantity > 0) {
                        TaSummary.appendText("\nBeverage-"+Beverage);
                        TaSummary.appendText("\nBeverage Size -"+size+"\nBeverage Quantity - "+beverageQuantity);
                    }
                    TaSummary.appendText("\nTotal Price - $"+price+"\n\n\n");
                }
                else if(rbMedium.isSelected()){
                    ToppingPrice=ToppingCount*1;
                    price = (9*pizzaQuantity)+(ToppingPrice*pizzaQuantity)+(BeveragePrice*beverageQuantity);
                    TaSummary.appendText("\n\nPizza Size - Medium"+"\nCrust Type - "+crust);
                    TaSummary.appendText("\nTopping -"+Topping);
                    TaSummary.appendText("\nPizza Quantity -"+pizzaQuantity);
                    if(Beverage != null && size != null && beverageQuantity > 0) {
                        TaSummary.appendText("\nBeverage-"+Beverage);
                        TaSummary.appendText("\nBeverage Size -"+size+"\nBeverage Quantity - "+beverageQuantity);
                    }
                    TaSummary.appendText("\nTotal Price - $"+price+"\n\n\n");
                }
                else if(rbLarge.isSelected()){
                    ToppingPrice=ToppingCount*1;
                    price = (11*pizzaQuantity)+(ToppingPrice*pizzaQuantity)+(BeveragePrice*beverageQuantity);
                    TaSummary.appendText("\n\nPizza Size - Large"+"\nCrust Type - "+crust);
                    TaSummary.appendText("\nTopping -"+Topping);
                    TaSummary.appendText("\nPizza Quantity -"+pizzaQuantity);
                    if(Beverage != null && size != null && beverageQuantity > 0) {
                        TaSummary.appendText("\nBeverage-"+Beverage);
                        TaSummary.appendText("\nBeverage Size -"+size+"\nBeverage Quantity - "+beverageQuantity);
                    }
                    TaSummary.appendText("\nTotal Price - $"+price+"\n\n\n");
                }
                else if(rbXLarge.isSelected()){
                    ToppingPrice=ToppingCount*1;
                    price = (12*pizzaQuantity)+(ToppingPrice*pizzaQuantity)+(BeveragePrice*beverageQuantity);
                    TaSummary.appendText("\n\nPizza Size - Extra Large"+"\nCrust Type - "+crust);
                    TaSummary.appendText("\nTopping -"+Topping);
                    TaSummary.appendText("\nPizza Quantity -"+pizzaQuantity);
                    if(Beverage != null && size != null && beverageQuantity > 0) {
                        TaSummary.appendText("\nBeverage-"+Beverage);
                        TaSummary.appendText("\nBeverage Size -"+size+"\nBeverage Quantity - "+beverageQuantity);
                    }
                    TaSummary.appendText("\nTotal Price - $"+price+"\n\n\n");
                }
                else {
                    TaSummary.appendText("\nPizza Size not selected. Please try again");
                }
            }
            } else {
                hyuyu = true;
            }
        }

    /**
    * The handleResetButtonAction method is an ActionEvent method. 
    * This method is executed only when the Reset button in the Menu tab is clicked. 
    * This method is used to reset the selected items on the menu so that additional items can be selected and added to cart.
    */
    @FXML
    private void handleResetButtonAction(ActionEvent event) {
        rbSmall.setSelected(false);
        rbMedium.setSelected(false);
        rbLarge.setSelected(false);
        rbXLarge.setSelected(false);
        tfQuantity.setText(null);
        cbCrustType.setValue(null);
        cbBeverageSize.setValue(null);
        tfBeverageQuantity.setText("");

    }

    /**
    * The pickboy method is also an ActionEvent method. 
    * This method is executed when the radio button r1 located in the Checkout tab on the right side of the text Delivery is clicked. 
    * This method confirms that the customer wants the order to be delivered to a given address. 
    * This method sets some of the text field editing to false, which means that the user can't enter any information in those text fields. Some of the text field editing is set to true, which means that the user can enter information in those text fields. 
    */
    @FXML
    private void pickboy(ActionEvent event) {
        e1.setEditable(false);
        e2.setEditable(false);
        e3.setEditable(false);
        e4.setEditable(false);
        e5.setEditable(false);
        t1.setEditable(true);
        t2.setEditable(true);
        t3.setEditable(true);
        t4.setEditable(true);
        t5.setEditable(true);
        t6.setEditable(true);
        
        if(loginPass.getText().contentEquals("Login Successful"))
        {
            /**
             * Information that gets filled in for pickup order if the login is successful
             */
            t1.setText("Bob");
            t2.setText("Ross");
            t3.setText("bobross@gmail.com");
            t4.setText("Happy Little St.");
            t5.setText("372512323350441");
            t6.setText("354");
        }
    }

    /**
    * The pickaction method is also an ActionEvent method. 
    * This method is executed when the radio button r2 located in the Checkout tab on the right side of the text Carryout is clicked. 
    * This method confirms that the customer will come to the store and pick up the ordered items.  
    * This method sets some of the text field editing to false, which means that the user can't enter any information in those text fields. Some of the text field editing is set to true, which means that the user can enter information in those text fields. 
    */
    @FXML
    private void pickaction(ActionEvent event) {
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        e1.setEditable(true);
        e2.setEditable(true);
        e3.setEditable(true);
        e4.setEditable(true);
        e5.setEditable(true);
        
        if(loginPass.getText().contentEquals("Login Successful"))
        {
          /**
           * Information that gets filled in for carryout if login is successful
           */
          e1.setText("Bob");
          e2.setText("Ross");
          e3.setText("4042329987");
          e4.setText("372512323350441");
          e5.setText("354");    
        }
    }

    /**
    * The handleCloseAction method is also an ActionEvent method. 
    * This method is executed when the Submit button in the Checkout tab is clicked.
    * This method is used to display the Order details and the Customer Information in the Order Confirmation tab . 
    */  
    @FXML
    private void handleCloseAction(ActionEvent event) {
        
    
        boolean hyuyuTwo=true;
        boolean cash=false;
        String field1=t1.getText();
        String field2=t2.getText();
        String field3=t3.getText();
        String field4=t4.getText();
        String field5=t5.getText();
        String field6=t6.getText();
        String f1=e1.getText();
        String f2=e2.getText();
        String f3=e3.getText();
        String f4=e4.getText();
        String f5=e5.getText();
        
        if (t1.isEditable()) {
            try
            {
                long hold = Long.parseLong(t5.getText());
                if(field5.length() < 14 || field5.length() > 16) {
                    int temp = Integer.parseInt("Hyuyu");
                }
            } catch (Exception e) {
                t8.setText("\nInvalid Credit card credentials. Please try again.");
                hyuyuTwo = false;
            }
            field6=t6.getText();
            try
            {
                int hold = Integer.parseInt(t6.getText());
                if(field6.length() < 3 || field6.length() > 4) {
                    int temp =Integer.parseInt("Hyuyu");
                }
            } catch (Exception e) {
                t8.setText("\nInvalid Credit card credentials. Please try again.");
                hyuyuTwo = false;
            }
        } else {
            if (f4.length() != 0) {
                try
                {
                    long hold = Long.parseLong(e4.getText());
                    if(f4.length() < 14 || f4.length() > 16) {
                        int temp =Integer.parseInt("Hyuyu");
                    }
                } catch (Exception e) {
                    t8.setText("\nInvalid Credit card credentials. Please try again.");
                    hyuyuTwo = false;
                }
                try 
                {   
                    int hold = Integer.parseInt(e5.getText());
                    if(f5.length() < 3 || f5.length() > 4) {
                        int temp =Integer.parseInt("Hyuyu");
                    }
                } catch (Exception e) {
                    t8.setText("\nInvalid Credit card credentials. Please try again.");
                    hyuyuTwo = false;
                }
            } else {
                cash = true;
            }
        }
    
        String field7=TaSummary.getText();


        t7.setText(field7);
      
        if (hyuyuTwo) {
            if(e1.getText().isEmpty())
            {
                t8.setText("First Name - "+field1+"\nLast Name - "+field2+"\nEmail Address - "+field3+"\nStreet Address - "+field4);
            }
            if(t1.getText().isEmpty())
            {
                t8.setText("First Name - "+f1+"\nLast Name - "+f2+"\nPhone - "+f3);
                if (cash == true) {
                    t8.appendText("\nPaying with cash.");
                } else {
                    t8.appendText("\nPaying by card.");
                }
            }
        } else {
            t8.appendText("\nInvalid Credentials");
        }
    }

    /**
     * The method handleSignInAction is also an ActionEvent method.
     * This method is executed the Sign In button in the Login tab of the GUI is clicked. 
     * This method is will be used by customer to Sign In into their account.
     */
    @FXML
    private void handleSignInAction(ActionEvent event){
        String email = emailTf.getText();
        String password = passwordTf.getText();
        
        // Example if the customer was in the database
        if( (email.contentEquals("bobross@gmail.com")) & (password.contentEquals("trees")) )
        {
            loginPass.setText("Login Successful");
        }
        else
        {
            loginPass.setText("Incorrect Login Infomation");
        }
        
    }
   
}