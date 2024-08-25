package com.beta.trackphone;

import android.app.admin.DeviceAdminReceiver;

// سيتم استخدام هذا لإرسال إشعارات عندما يتم التحقق من أن الهاتف قد سرق أو عند تفعيل Lost Phone Mode

public class AdminReceiver extends DeviceAdminReceiver {

    @Override
    public void onEnabled(Context context, Intent intent) {
        Toast.makeText(context, "Device Admin: enabled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        Toast.makeText(context, "Device Admin: disabled", Toast.LENGTH_SHORT).show();
    }

}
