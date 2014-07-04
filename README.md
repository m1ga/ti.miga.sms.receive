Titanium Android module to receive SMS inside your Titanium app.

```
var smsRev = require('ti.miga.sms.receive');
smsRev.init();

Ti.App.addEventListener("received",function(e){
	alert(e.number + " " + e.message);
});
```

Can receive normal and binary sms (Port 8080)
Use https://github.com/omorandi/TiAndroidSMS by Olivier Morandi to send sms
