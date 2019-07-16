package model;

import java.io.Serializable;

/**
 * Created by White on 3-5-18.
 */

public class Menu implements Serializable {

    private int drawableId;
    private String name, code;

    public Menu(int drawableId, String name, String code) {
        this.drawableId = drawableId;
        this.code = code;
        this.name = name;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}