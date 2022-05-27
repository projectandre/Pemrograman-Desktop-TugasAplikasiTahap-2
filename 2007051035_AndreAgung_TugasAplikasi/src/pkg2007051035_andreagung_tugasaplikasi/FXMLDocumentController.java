/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2007051035_andreagung_tugasaplikasi;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ANDRE
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField id;

    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfAlamat;

    @FXML
    private DatePicker dpTanggalBeli;

    @FXML
    private RadioButton rdHitam;

    

    @FXML
    private RadioButton rdPutih;

    @FXML
    private TextField tfJenis;

    @FXML
    private TextField tfHarga;

    @FXML
    private TableView<Kamera> tvResult;

    @FXML
    private TableColumn<Kamera, String> colId;

    @FXML
    private TableColumn<Kamera, String> colNama;

    @FXML
    private TableColumn<Kamera, String> colAlamat;

    @FXML
    private TableColumn<Kamera, String> colTanggal;

    @FXML
    private TableColumn<Kamera, String> colWarna;

    @FXML
    private TableColumn<Kamera, String> colJenis;

    @FXML
    private TableColumn<Kamera, Integer> colHarga;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String warna="";
        if (rdHitam.isSelected())
           warna=rdHitam.getText();
        if (rdPutih.isSelected())
           warna=rdPutih.getText();
        
        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         showBooks();
        
       
        
    }    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/kamera", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<Kamera> getBooksList(){
        ObservableList<Kamera> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM kamera";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Kamera kmr;
            while(rs.next()){
                kmr = new Kamera(rs.getString("id"),rs.getString("nama"),rs.getString("alamat"),rs.getString("tgl_beli"),rs.getString("warna"),rs.getString("jenis_kamera"),rs.getInt("harga"));
                bookList.add(kmr);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
    }
    
    public void showBooks(){
        ObservableList<Kamera> list = getBooksList();
        
        colId.setCellValueFactory(new PropertyValueFactory<Kamera, String>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<Kamera, String>("nama"));
        colAlamat.setCellValueFactory(new PropertyValueFactory<Kamera, String>("alamat"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<Kamera, String>("tgl_beli"));
        colWarna.setCellValueFactory(new PropertyValueFactory<Kamera, String>("warna"));
        colJenis.setCellValueFactory(new PropertyValueFactory<Kamera, String>("jenis_kamera"));
        colHarga.setCellValueFactory(new PropertyValueFactory<Kamera, Integer>("harga"));
        
        tvResult.setItems(list);
    }
    
    private void insertRecord(){
        String warna="";
        if (rdHitam.isSelected())
           warna=rdHitam.getText();
        if (rdPutih.isSelected())
           warna=rdPutih.getText();
        
        String query = "INSERT INTO kamera VALUES ('" + id.getText() + "','" + tfNama.getText() + "','" + tfAlamat.getText() + "','" + dpTanggalBeli.getValue().toString() + "','" + warna + "','" + tfJenis.getText() + "','" + Integer.valueOf(tfHarga.getText()) + "')";
        
        executeQuery(query);
        showBooks();
    }
    
    private void updateRecord(){
        String warna="";
        if (rdHitam.isSelected())
           warna=rdHitam.getText();
        if (rdPutih.isSelected())
           warna=rdPutih.getText();
        String query = "UPDATE  kamera SET nama  = '" + tfNama.getText() + "',alamat  = '" + tfAlamat.getText() + "', tgl_beli = '" + dpTanggalBeli.getValue().toString() + "', warna = '" + warna + "',jenis_kamera  = '" + tfJenis.getText() + "', harga = '" + Integer.valueOf(tfHarga.getText()) + "' WHERE id = '" + id.getText() + "' ";
        executeQuery(query);
        showBooks();
    }
    
    private void deleteButton(){
        String query = "DELETE FROM kamera WHERE id =" + id.getText() + "";
        executeQuery(query);
        showBooks();
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }   
    
}
