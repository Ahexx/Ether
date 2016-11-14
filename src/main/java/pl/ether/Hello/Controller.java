package pl.ether.Hello;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by nikk on 12.11.16.
 */
public class Controller {

    @FXML
    private TableView<Website> table;

    @FXML
    private TableColumn<Website, Integer> idColumn;

    @FXML
    private TableColumn<Website, String> nameColumn;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private void initialize() {
        // Initialize the person table
        idColumn.setCellValueFactory(new PropertyValueFactory<Website, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Website, String>("name"));
//        table.setItems(websiteData);
    }

    private ObservableList<Website> websiteData = FXCollections.observableArrayList(
            new Website(123,"aaa"),
            new Website(1,"12312")
    );

    @FXML
    protected void addWebsite(ActionEvent event) {
        websiteData = table.getItems();
        websiteData.add(
                new Website(
                        Integer.valueOf(id.getText()),
                        name.getText())
        );
        table.setItems(websiteData);
    }
}