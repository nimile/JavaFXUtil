package de.haevn.jfx.html;

import de.haevn.utils.network.NetworkInteraction;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class AH4 extends Hyperlink {
    private String link;

    public AH4() {
        this("", "");
    }

    public AH4(String text, String link) {
        getStyleClass().add("html-ah4");
        setText(text);
        setLink(link);
        setStyle("-fx-font-size: 16;-fx-font-weight: bolder");
        setOnAction(this::openLink);
    }

    public void setLink(String link) {
        this.link = link;
    }

    private void openLink(ActionEvent event) {
        if (!link.isEmpty()) {
            NetworkInteraction.openWebsite(link);
        }
    }

}