package com.servinglynk.hmis.warehouse.restful.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StringList
{
    private List<String> data;

    public StringList() {
    }

    public StringList(List<String> data) {
        this.data = data;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}

