package com.example.task;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;




public class HelloController {

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:javaDatabase.db");
        System.out.println("Connected!");
        return con;
    }
    public static void insertData(String firstName, String password, String dateOfBirth, String email, String number) throws SQLException, ClassNotFoundException {
        Connection con = connect();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user(firstName, password, email, number, dateOfBirth) VALUES(?,?,?,?,?)";
        ps = con.prepareStatement(sql);
        ps.setString(1,firstName);
        ps.setString(2,password);
        ps.setString(3,email);
        ps.setString(4,number);
        ps.setString(5,dateOfBirth);
        ps.execute();
    }
    public String[] readData(String email) throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String[] data = null;

        String sql = "Select password, email from user where email = ?";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            String password = rs.getString("Password");
            String Email = rs.getString("Email");
            data = new String[]{Email, password};

        }catch(SQLException ignored){

        }
        finally {
            rs.close();
            ps.close();
            connection.close();
        }

        return data;
    }


    HashMap<String, String[]> hashMap = new HashMap<>();
    HashMap<String, String[]> catMap = new HashMap<>();

    File file1 = new File("C:\\Users\\hp\\IdeaProjects\\Task\\src\\main\\java\\com\\example\\task\\userinfo.txt");
    File file2 = new File("C:\\Users\\hp\\IdeaProjects\\Task\\src\\main\\java\\com\\example\\task\\catinfo.txt");
    Path path = Paths.get(file1.toURI());
    Path path2 = Paths.get(file2.toURI());

    FileWriter fwrite = new FileWriter(file1, true);
    FileWriter fwrite2 = new FileWriter(file2, true);


    private String userdata;
    private String[] userdataList;
    private String catdata;
    private String[] catdataList;
    private Stage stage;
    private Scene scene;
    private Parent root;

//    public int catid;
//    String s=String.valueOf(catid);

    //login variables
    @FXML
    private Button ulogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ToggleButton toggleb;
    @FXML
    private Label label;


    @FXML
    void passwordkeytyped(KeyEvent event) {
        if(toggleb.isSelected()){
            label.setVisible(true);
            label.textProperty().bind(Bindings.concat(password.getText()));
            toggleb.setText("hide");
        }else{
            label.setVisible(false);
            toggleb.setText("show");
        }
    }
    @FXML
    void togglebutton(ActionEvent event) {
        if(toggleb.isSelected()){
            label.setVisible(true);
            label.textProperty().bind(Bindings.concat(password.getText()));
            toggleb.setText("hide");
        }else{
            label.setVisible(false);
            toggleb.setText("show");
        }
    }

    //sign up variables
    @FXML
    private TextField s_username;
    @FXML
    private TextField email;
    @FXML
    private TextField number;
    @FXML
    private PasswordField s_pass;
    @FXML
    private PasswordField confirmpass;
    @FXML
    private Hyperlink signin;
    @FXML
    private DatePicker myDatePicker1;
    @FXML
    private Label myLabel1;

    //buy button

    @FXML
    private Button buybutton;


    @FXML
    private TextField breed;

    //catid

    @FXML
    private TextField cname;

    @FXML
    private TextField color;

    @FXML
    private TextField date;

    @FXML
    private TextField sex;


    Label breedlab = new Label();
    Label colorlab = new Label();
    Label idlab = new Label();
    Label namelab = new Label();
    Label sexlab = new Label();

    public int catid;
    public int min = 50000;
    public int max = 90000;
    public String s;

//    public <String> void savecatinfopls(String s){

////        breedlab.setText(" " + breed.getText());
////        breedlab.setText(" " + breed.getText());
////        breedlab.setText(" " + breed.getText());
//    }







    public void getDate1(ActionEvent event) {

        LocalDate myDate = myDatePicker1.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        myLabel1.setText(myFormattedDate);
    }





    //    public void getDate(ActionEvent event) {
//
//        LocalDate myDate = myDatePicker1.getValue();
//        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
//    }


    public HelloController() throws IOException {
    }


    public void switchToScene1(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene4(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene5(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene6(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene6.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene7(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene7.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene8(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene8.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene9(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene9.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene10(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene10.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene11(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene11.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene12(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene 12.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene14(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene14.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene15(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene15.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void Ulogin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        checklogin(event);

    }

    private void checklogin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

//        userdata = Files.readAllLines(path).toString();
//        userdata = userdata.replaceAll("\\[", "");
//        userdata = userdata.replaceAll("]", "");
//        System.out.println(userdata);
//        if (userdata.isEmpty()) {
//        } else {
//                userdata = userdata.replaceAll(", ","");
//            userdataList = userdata.split("_");
//            for (String nameL : userdataList) {
//                System.out.println(nameL);
//            }
//            for (int i = 0; i < userdataList.length; i += 5) {
//                hashMap.put(userdataList[i], new String[]{userdataList[i + 1], userdataList[i + 2], userdataList[i + 3], userdataList[i + 4]});
//            }
        String email = null, pass = null;
        if(readData(username.getText()) != null){
            email = readData(username.getText())[0];
            pass = readData(username.getText())[1];
        }

         if (username.getText().isEmpty() || password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please enter the required fields");
        }else if((username.getText().equals(email)) && password.getText().equals(pass)){
            infoBox("Login Successful!", null, "Success");
            switchToScene3(event);
        }else {
            infoBox("Please enter correct Email and Password", null, "Failed");
//            wronglogin.setText("incorrect username or password");
        }
//        boolean matched = false;
////        String uname = username.getText().toString();
////        String pwd = password.getText().toString();
//        FileReader fr = new FileReader(file1);
//        BufferedReader br = new BufferedReader(fr);
//        String line = null;
////        ArrayList<String> lines = new ArrayList<String>();
//
//        while ((line = br.readLine()) != null) {
//
//
//            if (line.equals("\t" + username.getText().toString() + "\t" + password.getText().toString())) {
//                matched = true;
//
//                break;
//
//            }
//        }
//        fr.close();
//        br.close();
//        if (matched) {
//            switchToScene3(event);
//        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, "Form Error!",
//                    "Please enter the required fields");
////            wronglogin.setText("please enter the required fields");
//
//        } else {
//            infoBox("Please enter correct Email and Password", null, "Failed");
////            wronglogin.setText("incorrect username or password");
//        }


//        HelloApplication obj = new HelloApplication();
//        if (username.getText().toString().equals("taimoor") && password.getText().toString().equals("123")) {
//            infoBox("Login Successful!", null, "Success");
////            wronglogin.setText("success!");
//
//            Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, "Form Error!",
//                    "Please enter the required fields");
////            wronglogin.setText("please enter the required fields");
//
//        } else {
//            infoBox("Please enter correct Email and Password", null, "Failed");
////            wronglogin.setText("incorrect username or password");
//        }
    }

//    public void usignup(ActionEvent event) throws IOException{
//        HelloApplication obj2 = new HelloApplication();
//        if (s_username.getText().isEmpty() || s_pass.getText().isEmpty() || email.getText().isEmpty() || number.getText().isEmpty() || confirmpass.getText().isEmpty()) {
//            showAlert(Alert.AlertType.ERROR, "Form Error!",
//                    "Please enter the required fields");
//
//            Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//       } else if (s_pass.getText().toString().equals(confirmpass.getText().toString()) ) {
//            infoBox("Sign in Successful! You are redirected to the login page!", null, "Success");
////            obj2.changeScene("Scene3.fxml");
////            switchToScene3(event);
//////            wronglogin.setText("please enter the required fields");
////
////        } else {
////            showAlert(Alert.AlertType.ERROR, "Form Error!",
//                    "the password and confirm password do not match!");
//        }
//  }


    public void alreadyacc(ActionEvent event) throws IOException {
        switchToScene1(event);
    }

    public void ulogout(ActionEvent event) throws IOException {
        infoBox("Press OK to logout", null, "Success");
        switchToScene1(event);
    }

    public void usignup(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
//        userdata = Files.readAllLines(path).toString();
//        userdata = userdata.replaceAll("\\[", "");
//        userdata = userdata.replaceAll("]", "");
//        System.out.println(userdata);
//        if (userdata.isEmpty()) {
//        } else {
////                userdata = userdata.replaceAll(", ","");
//            userdataList = userdata.split("_");
////            for (String nameL : userdataList) {
////                System.out.println(nameL);
////            }
//            for (int i = 0; i < userdataList.length; i += 5) {
//                hashMap.put(userdataList[i], new String[]{userdataList[i + 1], userdataList[i + 2], userdataList[i + 3], userdataList[i + 4]});
//            }
//        }
////        fwrite.write("\t" + email.getText() + "\t" + s_pass.getText().toString() + "\t" + s_username.getText().toString() + "\t" + number.getText().toString() + "\t" + confirmpass.getText().toString() + "\t" + myLabel1.getText().toString() + "\n");
//        fwrite.close();
//        switchToScene1(event);
        String mail = null;
        if(readData(email.getText()) != null){
            mail = readData(email.getText())[0];
        }

        if (hashMap.containsKey(email.getText())) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "User already exists! try another email address");
        } else if (s_username.getText().isEmpty() || s_pass.getText().isEmpty() || email.getText().isEmpty() || number.getText().isEmpty() || confirmpass.getText().isEmpty() || myLabel1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please fill in required fields");
        } else if (!(email.getText().endsWith("@gmail.com"))) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Invalid Email Address");
        } else if (s_pass.getText().length() < 8) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Password cannot be less than 8 characters");
        } else if (number.getText().length() < 11) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Phone number must have 11 digits!");
        } else if (((!Objects.equals(s_pass.getText(), confirmpass.getText())))) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Password and confirm Password are not same");
        } else {
//            hashMap.put(email.getText(), new String[]{s_pass.getText(), s_username.getText()});
            insertData(s_username.getText(), s_pass.getText(), myLabel1.getText(), email.getText(), number.getText());
            switchToScene1(event);
//                root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
//                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//                scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            fwrite.write(email.getText() + "_");
//            fwrite.write(s_pass.getText() + "_");
//            fwrite.write(s_username.getText() + "_");
//            fwrite.write(number.getText() + "_");
//            fwrite.write(myLabel1.getText() + "_");
//            fwrite.write("\n");
//            fwrite.close();


//            System.out.println(hashMap.get(email.getText()));
        }


//        hashMap.put(email.getText(), new String[]{s_pass.getText(), s_username.getText()});
//        fwrite.write(email.getText() + "-");
//        fwrite.write(s_pass.getText() + "-");
//        fwrite.write(s_username.getText() + "-");
//        fwrite.close();
//        System.out.println(hashMap);
//        switchToScene3(event);
    }
    public void updatecatinfo(ActionEvent event)throws IOException {
        switchToScene9(event);
    }
    public void savecatinfo(ActionEvent event)throws IOException{

        catdata = Files.readAllLines(path2).toString();
        catdata = catdata.replaceAll("\\[", "");
        catdata = catdata.replaceAll("]", "");
//        System.out.println(catdata);
        if (catdata.isEmpty()){

        }else{
            catdataList = catdata.split("_");
            System.out.println(catdataList);
            for (String nameL : catdataList) {
                System.out.println(nameL);
            }

            for (int i=0; i<catdataList.length; i+=6){
                catMap.put(catdataList[i], new String[]{catdataList[i + 1], catdataList[i + 2], catdataList[i + 3], catdataList[i + 4], catdataList[i + 5]});
                catid = (int)(Math.random()*(max-min+1)+min);
                s = String.valueOf(catid);

            }
        }
        if (cname.getText().isEmpty() || color.getText().isEmpty() || date.getText().isEmpty() || sex.getText().isEmpty() || breed.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!",
                    "Please fill in required fields");
        }else{
            catMap.put(s, new String[]{breed.getText(), color.getText()});

//            savecatinfopls(s);
            switchToScene3(event);
            fwrite2.write(cname.getText() + "_");
            fwrite2.write(color.getText() + "_");
            fwrite2.write(date.getText() + "_");
            fwrite2.write(sex.getText() + "_");
            fwrite2.write(breed.getText() + "_");
            fwrite2.write(s + "_");
            fwrite2.write("\n");
            fwrite2.close();


        }
        idlab.setText(" " + s);

    }

    public void catinfo(ActionEvent event) throws IOException{

        switchToScene10(event);

    }



    public void buyaction(ActionEvent event)throws IOException{


//        System.out.println(s);
//        labelid.setText(" " + s);
//        generatelabel.setText(" "+ s);


        switchToScene8(event);
    }







    private static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    @FXML
    private CheckBox myCheckBox;
    @FXML
    private CheckBox myCheckBox2;
    @FXML
    private CheckBox myCheckBox3;
    @FXML
    private CheckBox myCheckBox4;
    @FXML
    private CheckBox myCheckBox5;

    @FXML
    private Label myLabel;
    @FXML
    private Label myLabel2;
    @FXML
    private Label myLabel3;
    @FXML
    private Label myLabel4;
    @FXML
    private ImageView myImageView;
    @FXML
    private ImageView myImageView2;
    @FXML
    private ImageView myImageView3;
    @FXML
    private ImageView myImageView4;
    @FXML
    private ImageView myImageView5;
    @FXML
    private ImageView myImageView6;
    @FXML
    private ImageView myImageView7;

    Image myImage1 = new Image(getClass().getResourceAsStream("happy.jpg"));
    Image myImage2 = new Image(getClass().getResourceAsStream("sad.jpg"));
    Image myImage3 = new Image(getClass().getResourceAsStream("opt.jpg"));
    Image myImage4 = new Image(getClass().getResourceAsStream("opt2.jpg"));
    Image myImage5 = new Image(getClass().getResourceAsStream("opt3.jpg"));
    Image myImage6 = new Image(getClass().getResourceAsStream("white.jpg"));



    public void change(ActionEvent event) {

        if (myCheckBox.isSelected()) {
            myLabel.setText("I am Vaccinated");
            myImageView.setImage(myImage1);
        } else {
            myLabel.setText("Vaccinate Me Please");
            myImageView.setImage(myImage2);
        }
    }

    public void change2(ActionEvent event) {

        if (myCheckBox2.isSelected()) {
            myLabel2.setText("I am Vaccinated");
            myImageView2.setImage(myImage1);
        } else {
            myLabel2.setText("Vaccinate Me Please");
            myImageView2.setImage(myImage2);
        }
    }

    public void change3(ActionEvent event) {

        if (myCheckBox3.isSelected()) {
            myLabel3.setText("I am Vaccinated");
            myImageView3.setImage(myImage1);
        } else {
            myLabel3.setText("Vaccinate Me Please");
            myImageView3.setImage(myImage2);
        }
    }

    public void change4(ActionEvent event) {

        if (myCheckBox4.isSelected()) {
            myLabel4.setText("I am Vaccinated");
            myImageView4.setImage(myImage1);
        } else {
            myLabel4.setText("Vaccinate Me Please");
            myImageView4.setImage(myImage2);
        }
    }
    public void change5(ActionEvent event) {

        if (myCheckBox5.isSelected()) {
            myImageView5.setImage(myImage3);
            myImageView6.setImage(myImage4);
            myImageView7.setImage(myImage5);
        }else {
            myImageView5.setImage(myImage6);
            myImageView6.setImage(myImage6);
            myImageView7.setImage(myImage6);
        }
    }
    Image myImage10 = new Image(getClass().getResourceAsStream("smile.png"));
    Image myImage11 = new Image(getClass().getResourceAsStream("not smile.jpg"));


    public void switchToScene13(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene13.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    private CheckBox myCheckBox10;
    @FXML
    private CheckBox myCheckBox11;
    @FXML
    private Label myLabel10;
    @FXML
    private CheckBox myCheckBox12;
    @FXML
    private CheckBox myCheckBox13;
    @FXML
    private Label myLabel11;
    @FXML
    private CheckBox myCheckBox14;
    @FXML
    private CheckBox myCheckBox15;
    @FXML
    private Label myLabel12;
    @FXML
    private CheckBox myCheckBox16;
    @FXML
    private CheckBox myCheckBox17;
    @FXML
    private Label myLabel13;

    public ImageView myImgView8;

    public ImageView myImgView9;

    public void change7(ActionEvent event) {

        if (myCheckBox10.isSelected()) {
            myImageView6.setImage(myImage10);
            myLabel10.setText("Correct! Wow\n\n" +
                    "Feedback\n\n" +
                    "Cats will drink milk and eat other dairy products, including eggs, cheese, and plain yogurt.");

        } else if (myCheckBox11.isSelected()) {
            myImageView6.setImage(myImage11);
            myLabel10.setText("Incorrect! Uh-oh!\n\n" +
                    "Feedback\n\n" +
                    "Cats will drink milk and eat other dairy products, including eggs, cheese, and plain yogurt.\n" +
                    "\n");
        }
    }
    public void change8(ActionEvent event) {

        if (myCheckBox12.isSelected()) {
            myImageView7.setImage(myImage10);
            myLabel11.setText("Correct! Well done\n\n" +
                    "Feedback\n\n" +
                    "Yes, this is true. Most cats will lick themselves to get clean, because water soaks their fur to their skin and makes them cold.");

        } else if (myCheckBox13.isSelected()) {
            myImageView7.setImage(myImage11);
            myLabel11.setText("Incorrect! Uh-oh!\n\n" +
                    "Feedback\n\n" +
                    "Yes, this is true. Most cats will lick themselves to get clean, because water soaks their fur to their skin and makes them cold.");
        }

    }
    public void change9(ActionEvent event) {

        if (myCheckBox14.isSelected()) {
            myImgView8.setImage(myImage10);
            myLabel12.setText("Correct! Well done\n\n"+
                    "Feedback\n\n" +
                    "Domestic cats spend about 70% of their days sleeping and 15% of the day grooming. Cats have the physiology of a predator, meaning they are wired to chase and hunt at night, reserving their daytime energy.");

        } else if (myCheckBox15.isSelected()) {
            myImgView8.setImage(myImage11);
            myLabel12.setText("Incorrect! Uh-oh!\n\n" +
                    "Feedback\n\n" +
                    "Domestic cats spend about 70% of their days sleeping and 15% of the day grooming. Cats have the physiology of a predator, meaning they are wired to chase and hunt at night, reserving their daytime energy." +
                    "\n");
        }

    }
    public void change10(ActionEvent event) {

        if (myCheckBox16.isSelected()) {
            myImgView9.setImage(myImage10);
            myLabel13.setText("Correct! Wow\n\n" +
                    "Feedback\n\n" +
                    "Adult cats communicate with each other through scent, facial expression, body language, and touch. With humans, cats use meowing to communicate with you as they are dependent on you.");

        } else if (myCheckBox17.isSelected()) {
            myImgView9.setImage(myImage11);
            myLabel13.setText("Incorrect! Uh-oh!\n\n" +
                    "Feedback\n\n" +
                    "Adult cats communicate with each other through scent, facial expression, body language, and touch. With humans, cats use meowing to communicate with you as they are dependent on you.\n" +
                    "\n");
        }
    }
}



//}