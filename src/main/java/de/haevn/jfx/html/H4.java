package de.haevn.jfx.html;

import javafx.scene.control.Label;

/**
 * javadoc is WIP
 * @version 1.0
 * @since 1.0
 * @author haevn
 */
public class H4 extends H {
    public H4() {
        this("");
    }

    public H4(String text) {
        getStyleClass().add("html-h4");
        setText(text);
        setStyle("-fx-font-size: 16;-fx-font-weight: bolder");
    }
}
