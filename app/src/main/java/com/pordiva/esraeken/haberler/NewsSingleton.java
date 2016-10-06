package com.pordiva.esraeken.haberler;

import com.pordiva.esraeken.haberler.model.Data;

import java.util.List;

/**
 * Created by esraeken on 09/09/16.
 */
public class NewsSingleton

{
    private static NewsSingleton instance;
    private NewsSingleton(){}
    public synchronized static NewsSingleton getInstance()
    {
        if(instance==null)
        {
            instance=new NewsSingleton();
        }
        return instance;
    }


    public List<Data> getGetData() {
        return getData;
    }

    public void setGetData(List<Data> getData) {
        this.getData = getData;
    }

    List<Data> getData;



}
