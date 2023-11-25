package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    
    private String currentString;
    private List<String> history;


    public SimpleController() {
        this.history = new ArrayList<>();
    }
    /**
     * {@inheritdoc}
     */
    @Override
    public void setString(String newNext) {
        this.currentString = Objects.requireNonNull(newNext, "Should not pass a null string");
    }
    
    /**
     * {@inheritdoc}
     */
    @Override
    public String getNextString() {
        return this.currentString;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public List<String> getHistory() {
        return this.history;
    }

    /**
     * {@inheritdoc}
     */
    @Override
    public void printCurrent() {
        if (this.currentString == null) {
            throw new IllegalStateException("Current string is not set");
        } else {
            System.out.println(this.currentString);
            this.history.add(this.currentString);
        }
    }
}
