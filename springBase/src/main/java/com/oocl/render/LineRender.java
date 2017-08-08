package com.oocl.render;

import com.oocl.analyser.Analyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by CHENCO7 on 8/8/2017.
 */
@Controller
public class LineRender implements Render {

    @Autowired
    private Analyser analyser;

    public void render() {
        analyser.analyse();
        System.out.println("Line render ..");
    }

    public void setAnalyser(Analyser analyser) {
        this.analyser = analyser;
    }
}
