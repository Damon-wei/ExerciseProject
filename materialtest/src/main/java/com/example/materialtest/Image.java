package com.example.materialtest;

/**
 * Created by Damon on 2017/4/6.
 * Description :
 */

public class Image {
    private String name;
    private String path;

    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
