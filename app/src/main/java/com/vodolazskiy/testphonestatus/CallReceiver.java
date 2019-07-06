package com.vodolazskiy.testphonestatus;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class CallReceiver extends PhonecallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        Log.d(this.getClass().getName(), "onIncomingCallStarted number = " + number);
        Toast.makeText(ctx, "onIncomingCallStarted number = " + number, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        Log.d(this.getClass().getName(), "onOutgoingCallStarted number = " + number);
        Toast.makeText(ctx, "onOutgoingCallStarted number = " + number, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.d(this.getClass().getName(), "onIncomingCallEnded number = " + number);
        Toast.makeText(ctx, "onIncomingCallEnded number = " + number, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        Log.d(this.getClass().getName(), "onOutgoingCallEnded number = " + number);
        Toast.makeText(ctx, "onOutgoingCallEnded number = " + number, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        Log.d(this.getClass().getName(), "onMissedCall number = " + number);
        Toast.makeText(ctx, "onMissedCall number = " + number, Toast.LENGTH_LONG).show();
    }

}
