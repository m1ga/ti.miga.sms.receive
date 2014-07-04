package ti.miga.sms.receive;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import android.content.BroadcastReceiver;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;

@Kroll.module(name="Tisms", id="ti.miga.sms.receive")
public class TismsModule extends KrollModule
{

	public TismsModule()
	{
		super();
	}

	@Kroll.method
	public void init(){
		IncomingSMS rec = new IncomingSMS();
		Log.i("SmsReceiver", "init");
	}

}
