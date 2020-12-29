package moeblocks.datingsim.convo;

import moeblocks.datingsim.convo.enums.Response;

public class Transition {
    private final Response response;
    private final Scene scene;
    
    public Transition(Response response, Scene scene) {
        this.response = response;
        this.scene = scene;
    }
    
    public Response getResponse() {
        return this.response;
    }
    
    public Scene getScene() {
        return this.scene;
    }
}
