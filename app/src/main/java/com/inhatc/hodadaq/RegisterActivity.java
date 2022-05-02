package com.inhatc.hodadaq;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    DatabaseReference mDatabase;

    String get_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button DoRegister = findViewById(R.id.btnDoRegister);
        final EditText name = findViewById(R.id.edtUserName);
        final EditText email = findViewById(R.id.edtUserEmail);
        final EditText password = findViewById(R.id.edtUserPassword);
        final EditText birth = findViewById(R.id.edtUserBirth);
        final EditText phone = findViewById(R.id.edtUserPhone);


        DoRegister.setOnClickListener(v -> {
            String get_name = name.getText().toString();
            String get_email = email.getText().toString();
            String get_password = password.getText().toString();
            String get_phone = phone.getText().toString();
            String get_birth = birth.getText().toString();

            // Send UserData to DB
            HashMap result = new HashMap<>();
            result.put("name", get_name);
            result.put("email", get_email);
            result.put("password", get_password);
            result.put("birth", get_birth);
            result.put("phone", get_phone);

            mDatabase = FirebaseDatabase.getInstance().getReference();
            mDatabase.child("user").child("info").push().setValue(result);

            Toast.makeText(RegisterActivity.this, "I'll let you know after the administrator approves it.",
                    Toast.LENGTH_SHORT).show();

        });
    }
}












