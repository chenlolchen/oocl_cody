package com.oocl.render;

import com.oocl.analyser.Analyser;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
public class PieRender implements Render {
    private Analyser analyser;

    public Analyser getAnalyser() {
        return analyser;
    }

    public void setAnalyser(Analyser analyser) {
        this.analyser = analyser;
    }

    public void render() {
        analyser.analyse();
        System.out.println("Pie render ..");
    }
}
