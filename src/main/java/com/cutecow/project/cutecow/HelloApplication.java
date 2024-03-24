package com.cutecow.project.cutecow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group cowGroup = new Group();

        cowGroup.getChildren().addAll(
                this.createTail(150, -180), // tail
                this.createBody(10, -100), // body
                this.createHorn(110, 90, false), // left horn
                this.createHorn(210, 90, true), // right horn
                this.createEar(80, 40), // left ear
                this.createEar(235, 40), // right ear
                this.createHead(160, 90), // head
                this.roundedWrapperEye(130, 70), // left eye
                this.createEye(130, 70), // left eye
                this.createEye(190, 70), // right eye
                this.createMouth(160, 151), // mouth
                this.createCurvedLine(160, 150, 142, 155, 140, 145), // left half mouth
                this.createCurvedLine(160, 150, 178, 155, 180, 145), // right half mouth
                this.createNose(150, 120), // nose
                this.createNose(169, 120), // nose
                this.createHell(110, 195), // left leg
                this.createHell(210, 195) // right leg
        );

        cowGroup.setTranslateX(100);
        cowGroup.setTranslateY(100);

        Scene scene = new Scene(cowGroup, 300, 300, Color.LIGHTGREEN);
        stage.setTitle("Cute Cow ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Group createBody(double x, double y) {

        Group cowGroup = new Group();

        // circle as body
        Circle bodyBack = new Circle(80);
        bodyBack.setScaleX(1.5);
        bodyBack.setTranslateX(160);
        bodyBack.setTranslateY(220);

        bodyBack.setFill(Color.WHITE);
        bodyBack.setStroke(Color.BLACK);

        Path body = new Path();
        body.setFill(Color.WHITE);
        body.setStroke(Color.BLACK);
        body.getElements().add(new MoveTo(50, 250));
        body.getElements().add(new CubicCurveTo(100, 200, 230, 200, 250, 250));
        body.getElements().add(new QuadCurveTo(200, 350, 150, 250));
        body.getElements().add(new QuadCurveTo(100, 350, 50, 250));

        cowGroup.getChildren().add(bodyBack);
        cowGroup.getChildren().add(body);
        cowGroup.setTranslateX(x);
        cowGroup.setTranslateY(y);

        return cowGroup;
    }

    private Circle createHead(double x, double y) {

        Circle head = new Circle(80);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        head.setTranslateX(x);
        head.setTranslateY(y);

        return head;
    }

    private Circle roundedWrapperEye(double x, double y) {
        Circle roundedEye = new Circle(20, Color.BROWN);
        roundedEye.setTranslateX(x);
        roundedEye.setTranslateY(y);

        return roundedEye;
    }

    private Circle createEye(double x, double y) {
        Circle eye = new Circle(5, Color.BLACK);
        eye.setTranslateX(x);
        eye.setTranslateY(y);

        return eye;
    }

    private Path createEar(double x, double y) {
        Path ear = new Path();
        ear.setFill(Color.WHITE);
        ear.setStroke(Color.BLACK);
        ear.setStrokeType(StrokeType.OUTSIDE);

        ear.getElements().add(new MoveTo(x, y - 30));
        ear.getElements().add(new CubicCurveTo(
                x + 10, y - 40,
                x + 20, y - 20,
                x + 30, y)
        );
        ear.getElements().add(new CubicCurveTo(
                x + 35, y + 10,
                x + 15, y + 20,
                x, y)
        );
        ear.getElements().add(new CubicCurveTo(
                x - 15, y + 20,
                x - 35, y + 10,
                x - 30, y)
        );
        ear.getElements().add(new CubicCurveTo(
                x - 20, y - 20,
                x - 10, y - 40,
                x, y - 30)
        );

        return ear;
    }

    private Circle createNose(double x, double y) {
        Circle nose = new Circle(6, Color.BLACK);
        nose.setTranslateX(x);
        nose.setTranslateY(y);

        return nose;
    }

    private Group createMouth(double x, double y) {
        Group mouthGroup = new Group();

        double mouthWidth = 100;
        double jawOffsetY = 0;

        // Create upper inner mouth
        Path upperInnerMouth = new Path();
        upperInnerMouth.setFill(Color.PINK);
        upperInnerMouth.setStrokeWidth(1);
        upperInnerMouth.getElements().addAll(
                new MoveTo(x - mouthWidth / 2, y - jawOffsetY),
                new CubicCurveTo(x - 20, y - 50, x + 20, y - 50, x + mouthWidth / 2, y - jawOffsetY)
        );

        // Create lower inner mouth
        Path lowerInnerMouth = new Path();
        lowerInnerMouth.setFill(Color.PINK);
        lowerInnerMouth.setStrokeWidth(0);
        lowerInnerMouth.getElements().addAll(
                new MoveTo(x - mouthWidth / 2, y - jawOffsetY),
                new CubicCurveTo(x - 20, y + 25, x + 20, y + 25, x + mouthWidth / 2, y - jawOffsetY)
        );

        mouthGroup.getChildren().addAll(upperInnerMouth, lowerInnerMouth);

        return mouthGroup;
    }

    private QuadCurve createHorn(double x, double y, boolean isFlipped) {
        QuadCurve horn = new QuadCurve();

        double controlX = x - 20, controlY = y - 50;
        double endX = x, endY = y - 100;

        horn.setStartX(x);
        horn.setStartY(y);
        horn.setControlX(controlX);
        horn.setControlY(controlY);
        horn.setEndX(endX);
        horn.setEndY(endY);

        horn.setStroke(Color.BLACK);
        horn.setStrokeWidth(2);
        horn.setStrokeType(StrokeType.OUTSIDE);

        horn.setFill(Color.WHITE);

        if (!isFlipped) {
            horn.setScaleX(-1);
        }

        return horn;
    }

    public Path createCurvedLine(
            double startX,
            double startY,
            double controlX,
            double controlY,
            double endX,
            double endY
    ) {
        // Create a new Path object for the curved line
        Path curvedLine = new Path();

        // Define the starting point of the curved line
        MoveTo moveTo = new MoveTo(startX, startY);

        // Define the quadratic Bézier curve
        QuadCurveTo curve = new QuadCurveTo(controlX, controlY, endX, endY);

        // Add the curve to the Path
        curvedLine.getElements().addAll(moveTo, curve);

        // Set the stroke color and width
        curvedLine.setStrokeWidth(2);
        curvedLine.setStroke(Color.BLACK); // Set the color of the curved line

        return curvedLine;
    }

    private Circle createHell(double x, double y) {
        Circle hell = new Circle(10, Color.BLACK);
        hell.setTranslateX(x);
        hell.setTranslateY(y);
        return hell;
    }

    private Path createTail(double x, double y) {
        Path leg = new Path();
        leg.setStroke(Color.BLACK);
        leg.setStrokeWidth(10);
        leg.getElements().add(new MoveTo(75, 275));
        leg.getElements().add(new QuadCurveTo(90, 250, 105, 275));
        leg.getElements().add(new QuadCurveTo(120, 300, 135, 275));
        leg.getElements().add(new QuadCurveTo(150, 250, 165, 275));
        leg.getElements().add(new QuadCurveTo(180, 300, 195, 275));
        leg.getElements().add(new QuadCurveTo(210, 250, 225, 275));


        leg.setTranslateX(x);
        leg.setTranslateY(y);
        return leg;
    }
}