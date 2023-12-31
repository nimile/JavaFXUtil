package de.haevn.jfx;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UIElementsCreator {
    private UIElementsCreator() {
    }

    public static Button createButton(String title, EventHandler<ActionEvent> event) {
        return createButton(title, 150, event);
    }

    public static Button createButton(String title, Runnable event) {
        return createButton(title, 150, event);
    }


    public static Button createButton(String title, double width, Runnable event) {
        return createButton(title, width, e -> event.run());
    }
    public static Button createButton(String title, double width, EventHandler<ActionEvent> event) {
        Button button = new Button(title);
        button.setOnAction(event);
        if (width > 0) {
            button.setPrefWidth(width);
            button.setMaxWidth(width);
            button.setMinWidth(width);
        }
        return button;
    }

    public static Tab createTab(String title, Node node) {
        Tab tab = new Tab(title);
        tab.setContent(node);
        tab.setClosable(false);
        return tab;
    }

    public static GridPane createForm(Map<String, Node> entries) {
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        AtomicInteger row = new AtomicInteger();
        entries.forEach((text, node) -> {
            pane.add(new Label(text), 0, row.get());
            pane.add(node, 1, row.get());
            row.getAndIncrement();
        });

        return pane;
    }

    public static TitledPane generateTitledPane(String title, Node content, boolean expanded) {
        TitledPane tp = new TitledPane(title, content);
        tp.getStyleClass().add("fx-haevn-titledpane");
        tp.setExpanded(expanded);
        return tp;
    }

    public static HBox createCheckBox(String text, BooleanProperty property, boolean state, boolean isLeft) {
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(state);
        checkBox.selectedProperty().bindBidirectional(property);

        return isLeft ? new HBox(checkBox, new Label(text)) : new HBox(new Label(text), checkBox);
    }


    public static HBox createCheckBox(String text, Runnable setter, boolean state, boolean isLeft) {
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(state);
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> setter.run());
        return isLeft ? new HBox(checkBox, new Label(text)) : new HBox(new Label(text), checkBox);
    }


    public static <T extends TextInputControl> T createTextInput(T element, String text, SimpleStringProperty property) {
        element.textProperty().bindBidirectional(property);
        element.setPromptText(text);
        return element;
    }


    public static Label createElement(ReadOnlyStringProperty property) {
        final Label element = new Label();
        element.textProperty().bind(property);
        return element;
    }

}
