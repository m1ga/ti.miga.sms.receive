package ti.miga.sms.receive;

import org.appcelerator.kroll.common.Log;
import android.content.BroadcastReceiver;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import org.appcelerator.kroll.KrollDict;
import org.appcelerator.titanium.TiApplication;

public class IncomingSMS extends BroadcastReceiver {
    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        try {

            if (bundle != null) {

                if (intent.getAction().equals("android.intent.action.DATA_SMS_RECEIVED")) {
                    // binary sms
                    //

                    Object messages[] = (Object[]) bundle.get("pdus");
                    SmsMessage smsMessage[] = new SmsMessage[messages.length];

                    for (int n = 0; n < messages.length; n++)
                        smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);

                    byte[] data = smsMessage[0].getUserData();
                    String phoneNumber = smsMessage[0].getDisplayOriginatingAddress();
                    String str = new String(data);
                    Log.i("SmsReceiver", "binary sms : senderNum: " + phoneNumber + "; message: " + str);

                    if (TiApplication.getInstance() != null) {
                        KrollDict props = new KrollDict();
                        props.put("message", str);
                        props.put("number", phoneNumber);
                        TiApplication.getInstance().fireAppEvent("received", props);
                    }

                } else {
                    // normal sms
                    //
                    final Object[] pdusObj = (Object[]) bundle.get("pdus");

                    String phoneNumber="";
                    String message="";

                    for (int i = 0; i < pdusObj.length; i++) {

                        SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                        phoneNumber = currentMessage.getDisplayOriginatingAddress();
                        message += currentMessage.getDisplayMessageBody();

                        Log.i("SmsReceiver", "senderNum: " + phoneNumber + "; message: " + message);
                    } // end for loop

                    if (TiApplication.getInstance() != null) {
                        KrollDict props = new KrollDict();
                        props.put("message", message);
                        props.put("number", phoneNumber);
                        TiApplication.getInstance().fireAppEvent("received", props);
                    }
                } // bundle is null
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
}
