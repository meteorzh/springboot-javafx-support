package de.felixroske.jfxsupport;

import de.felixroske.jfxtest.SampleView;
import de.felixroske.jfxtest.SpringJavaFxTestingBase;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

public class SampleViewTest extends SpringJavaFxTestingBase {

    @Autowired
    SampleView view;

    Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    @AfterEach
    void afterEach() {
        Platform.runLater(() -> view.hide());
    }

    @Test
    @DisplayName ("Show view")
    void showViewTest() {
        Platform.runLater(() -> view.showView(Modality.APPLICATION_MODAL));
        WaitForAsyncUtils.waitForFxEvents();

        verifyThat(view.getView(), isVisible());
    }

    @Test
    @DisplayName ("Show view given stage")
    void showViewGivenStageTest() {
        Platform.runLater(() -> view.showView(stage, Modality.NONE));
        WaitForAsyncUtils.waitForFxEvents();

        verifyThat(view.getView(), isVisible());
    }

    @Test
    @DisplayName ("Show view and wait")
    void showViewAndWaitTest() {
        Platform.runLater(() -> view.showViewAndWait(Modality.WINDOW_MODAL));
        WaitForAsyncUtils.waitForFxEvents();

        verifyThat(view.getView(), isVisible());
    }

    @Test
    @DisplayName ("Show view and wait given stage")
    void showViewAndWaitGivenStageTest() {
        Platform.runLater(() -> view.showViewAndWait(stage, Modality.APPLICATION_MODAL));
        WaitForAsyncUtils.waitForFxEvents();

        verifyThat(view.getView(), isVisible());
    }
}