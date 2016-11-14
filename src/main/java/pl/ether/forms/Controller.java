package pl.ether.forms;

import java.time.LocalDateTime;

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
       // idColumn.setCellValueFactory(new PropertyValueFactory<WebSite, Integer>("id"));
        //nameColumn.setCellValueFactory(new PropertyValueFactory<WebSite, String>("name"));
//        table.setItems(WebSiteData);
        WebSiteData = FXCollections.observableArrayList();
        WebSite w = new WebSite();
        w.setCreationDate(LocalDateTime.now());
        w.setId(0L);
        w.setName("Google");
        w.setRefreshInterval(3); // 3 minuty
        w.setURL("http://www.google.pl");
        w.setValidationLevel(ValidationLevel.ALL);
        w.setModyficationDate(w.getCreationDate());
        
        WebSiteData.add(w);
        w = new WebSite();
        w.setCreationDate(LocalDateTime.now());
        w.setId(1L);
        w.setName("FotoTravelWorld Krzysztof Podgórzak");
        w.setRefreshInterval(1); // 1 minuty
        w.setURL("http://www.fototravelworld.com");
        w.setValidationLevel(ValidationLevel.ALL);
        w.setModyficationDate(w.getCreationDate());
        WebSiteData.add(w);
    }

    public static ObservableList<WebSite> WebSiteData;
    @FXML
    protected void addWebSite(ActionEvent event) {
        WebSiteData = table.getItems();
        WebSiteData.add(
                new WebSite(
                        )        );
        table.setItems(WebSiteData);
    }
}