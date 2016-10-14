package com.pordiva.esraeken.haberler;

import com.pordiva.esraeken.haberler.model.Data;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by esraeken on 11/10/16.
 */
public class RealmManager {
    private Realm realm;

    //region Constructor
    public RealmManager() {
        realm = Realm.getDefaultInstance();
    }
    public  void close(){
        if(realm != null){
            realm.close();
        }
    }
    //endregion

    //region Destinasyon
    public void storeData(final Data model){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(model);
            }
        });

    }


    public RealmResults<Data> getData(String id){
        return realm.where(Data.class).equalTo("id",id).findAll();
    }
    public RealmResults<Data> getData(){
        return realm.where(Data.class).findAll();
    }


  /*  public RealmResults<ModelRealm_DestinasyonDetay>  getDestinationDetailWithRewriteName(String rewriteName){
        return realm.where(ModelRealm_DestinasyonDetay.class).equalTo("rewrite_name",rewriteName).findAll();
    }*/

    //endregion


}

