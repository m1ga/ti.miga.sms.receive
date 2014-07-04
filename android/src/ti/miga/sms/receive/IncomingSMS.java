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

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);

                	if(TiApplication.getInstance()!=null){
                        KrollDict props = new KrollDict();
                        props.put("message", message);
                        props.put("number", senderNum);
                        //fires the change event
                        TiApplication.getInstance().fireAppEvent("received", props);
                        //TiApplication.getInstance().fireAppEvent(BOOT_TYPE, event);
                    }


                   /*
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,
                                 "senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();
                    */
                } // end for loop
              } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);

        }
    }
}
