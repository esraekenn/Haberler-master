package com.pordiva.esraeken.haberler.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esraeken on 05/09/16.
 */
public class Response
{
    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    private List<Data> data =new ArrayList<>();

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    private boolean result;



}
