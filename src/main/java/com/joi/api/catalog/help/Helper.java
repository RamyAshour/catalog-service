/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.help;

import com.joi.api.catalog.Global;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author ramy
 */
public class Helper {
 
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
}
    public static int getStoreIdByName(String name){
        return Global.stores.get(name.toLowerCase());
    }
     public static String getStoreNameById(int id){
        for(String key :Global.stores.keySet()){
            if(Global.stores.get(key).equals(id))
                return key;
        }
        return "du";
    }
}
