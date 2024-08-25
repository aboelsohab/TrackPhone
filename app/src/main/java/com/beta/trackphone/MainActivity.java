package com.beta.trackphone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.karan.churi.PermissionManager.PermissionManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;

    PermissionManager manager;

    

    // إضافة منطق لتفعيل Lost Phone Mode أو Theft Verification

// إضافة متغير لتحديد حالة الهاتف
private boolean isLostModeActivated = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    auth = FirebaseAuth.getInstance();
    user = auth.getCurrentUser();
    if(user == null)
    {
        setContentView(R.layout.activity_main);
        manager = new PermissionManager() {};
        manager.checkAndRequestPermissions(this);
    }
    else
    {
        // تحقق إذا كان الهاتف مفقود
        if(isLostModeActivated){
            activateLostPhoneMode();
        }
        else {
            Intent intent = new Intent(MainActivity.this, UserMainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}

private void activateLostPhoneMode() {
    // منطق تفعيل Lost Phone Mode
    Toast.makeText(this, "Lost Phone Mode Activated", Toast.LENGTH_LONG).show();
    // إرسال إشعار لجهات الاتصال الطارئة
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    manager.checkResult(requestCode, permissions, grantResults);
    ArrayList<String> denied_permissions = manager.getStatus().get(0).denied;

    if(denied_permissions.isEmpty())
    {
        Toast.makeText(getApplicationContext(),"Permissions enabled",Toast.LENGTH_SHORT).show();
    }
}

// إضافة منطق التعامل مع Theft Verification
private void theftVerification() {
    // منطق تفعيل Theft Verification
    Toast.makeText(this, "Checking if the phone is stolen", Toast.LENGTH_LONG).show();
    // إذا لم يتم التحقق من المستخدم، افترض أن الهاتف سرق وابدأ بتنفيذ الإجراءات
}
    

    public void goToLogin(View v)
    {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }
    public void goToRegister(View v)
    {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
