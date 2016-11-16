package pl.ether.forms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.ether.models.ValidationLevel;
import pl.ether.models.WebSite;

import java.time.LocalDateTime;

/**
 * Created by nikk on 12.11.16.
 */
public class Controller {

    @FXML
    private TableView<WebSite> table;

    @FXML
    private TableColumn<WebSite, Integer> idColumn;

    @FXML
    private TableColumn<WebSite, String> nameColumn;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    public void initialize() {
        // Initialize the person table
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        table.setItems(webSiteData);
        newObjects();
    }

    private void newObjects() {

        WebSite webSite = new WebSite();
        webSite.setCreationDate(LocalDateTime.now());
        webSite.setId(0L);
        webSite.setName("Google");
        webSite.setRefreshInterval(3); // 3 minuty
        webSite.setURL("http://www.google.pl");
        webSite.setValidationLevel(ValidationLevel.ALL);
        webSite.setModificationDate(webSite.getCreationDate());
        webSiteData.add(webSite);

        webSite = new WebSite();
        webSite.setCreationDate(LocalDateTime.now());
        webSite.setId(1L);
        webSite.setName("FotoTravelWorld Krzysztof Podgórzak");
        webSite.setRefreshInterval(1); // 1 minuty
        webSite.setURL("http://www.fototravelworld.com");
        webSite.setValidationLevel(ValidationLevel.BODY_TEXT);
        webSite.setModificationDate(webSite.getCreationDate());
        webSiteData.add(webSite);
    }

    public static ObservableList<WebSite> webSiteData = FXCollections.observableArrayList();

    @FXML
    private void addWebSite(ActionEvent event) {
        webSiteData = table.getItems();

        WebSite webSite = new WebSite();
        webSite.setId(Long.valueOf(id.getText()));
        webSite.setName(name.getText());

        webSiteData.add(
                webSite
        );
        table.setItems(webSiteData);
    }
}