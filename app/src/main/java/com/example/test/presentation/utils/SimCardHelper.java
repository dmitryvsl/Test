package com.example.test.presentation.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SimCardHelper {

    @Inject
    public SimCardHelper(Context context) {
        this.context = context;
    }

    Context context;

    public boolean isSimCardInstalled(){
        TelephonyManager telMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        int simState = telMgr.getSimState();

        return simState != TelephonyManager.SIM_STATE_ABSENT;
    }
}
