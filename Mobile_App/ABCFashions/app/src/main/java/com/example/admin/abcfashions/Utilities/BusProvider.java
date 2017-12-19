package com.example.admin.abcfashions.Utilities;

import de.greenrobot.event.EventBus;

/**
 * Created by Rajitha on 2017-06-11.
 */

public class BusProvider {
    private static EventBus mBus;

    private BusProvider(){ }

    public static EventBus getInstance(){

        if(mBus == null)
            mBus = EventBus.getDefault();

        return mBus;
    }
}
