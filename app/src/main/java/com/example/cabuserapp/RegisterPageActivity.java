package com.example.cabuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.core.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPageActivity<sharedPreferences, editor> extends AppCompatActivity {
    Firebase mref;
    EditText input_email, input_password,input_regname;
    Button btn_Reg;
    FirebaseAuth maut;
    FirebaseAuth.AuthStateListener mAuthlisner;
    Toolbar toolbar;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        mref = new Firebase("https://adminapp-c9ff1.firebaseio.com/User");
        input_email = findViewById(R.id.input_regemail);
        input_password = findViewById(R.id.input_password);
        btn_Reg = findViewById(R.id.btn_Reg);
        input_regname = findViewById(R.id.input_regname);



        toolbar = findViewById(R.id.toolloginpage);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        maut = FirebaseAuth.getInstance();


        btn_Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memail = input_email.getText().toString();
                String mpassword = input_password.getText().toString();


                if (TextUtils.isEmpty(memail) || TextUtils.isEmpty(mpassword)) {

                    Toast.makeText(RegisterPageActivity.this, "Fields are empty ", Toast.LENGTH_SHORT).show();

                } else{
                    maut.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(RegisterPageActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
//                    Log.d(TAG, "createUserWithEmail:success");
//                    FirebaseUser user = maut.getCurrentUser();
//                    updateUI(user);
                                Toast.makeText(RegisterPageActivity.this, "Registrtion Successfull", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(RegisterPageActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
//                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(RegisterPageActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                    updateUI(null);
                            }


                        }
                    });
            }
                savename();
            }
        });



    }



public  void savename(){

        String uname=input_regname.getText().toString();
        String uemial=input_email.getText().toString();
    SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    editor.putString("NAME", uname);
    editor.putString("Email", uemial);
    editor.commit();
}

}
