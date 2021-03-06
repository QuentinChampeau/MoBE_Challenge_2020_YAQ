package com.example.mobe_challenge_yaq.Bean;

public class HasNoise {

    public boolean initialised = false;
    private onValueChangeListener valueChangeListener;

    public boolean isInitialised() {
        return initialised;
    }

    public void setVariable(boolean value) {
        initialised = value;
        if (valueChangeListener != null) valueChangeListener.onChange();
    }

    public onValueChangeListener getValueChangeListener() {
        return valueChangeListener;
    }

    public void setValueChangeListener(onValueChangeListener valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }

    public interface onValueChangeListener {
        void onChange();
    }
}
