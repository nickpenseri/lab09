package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class StdoutView implements DrawNumberView{

    private static final String NEW_GAME = "A new game starts";

    private DrawNumberController controller;
    

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
        if (res.equals(DrawResult.YOU_WON) || res.equals(DrawResult.YOU_WON)) {
            System.out.println(NEW_GAME);
            controller.resetGame();
        }
    }
}
