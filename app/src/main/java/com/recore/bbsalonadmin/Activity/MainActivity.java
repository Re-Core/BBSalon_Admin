package com.recore.bbsalonadmin.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.recore.bbsalonadmin.Common.Common;
import com.recore.bbsalonadmin.Common.Constant;
import com.recore.bbsalonadmin.Model.User;
import com.recore.bbsalonadmin.R;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText loginPhoneNumberInput, loginPasswordInput;
    private Button btnLogin;
    private TextView imAdmin, imNotAdmin;
    private AlertDialog waitingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Paper.init(this);

        loginPhoneNumberInput = (TextInputEditText) findViewById(R.id.edtPhone);
        loginPasswordInput = (TextInputEditText) findViewById(R.id.edtCode);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        waitingDialog =new SpotsDialog(this);

    }


    private void loginUser() {
        String phoneNumber = loginPhoneNumberInput.getText().toString();
        String password = loginPasswordInput.getText().toString();


        if (phoneNumber.isEmpty() || password.isEmpty()) {

            showMessage("please Check All field");

        } else {
//            loadingBar.setTitle("Login Account");
//            loadingBar.setMessage("Please Wait this may take a while");
//            loadingBar.setCanceledOnTouchOutside(false);
//            loadingBar.show();

            // waitingDialog.setMessage(getResources().getString(R.string.waiting_string));
            waitingDialog.setCancelable(false);
            waitingDialog.show();

            allowAccessToAccount(phoneNumber, password);

        }

    }

    private void allowAccessToAccount(final String phoneNumber, final String code) {

        final DatabaseReference AdminRef;
        AdminRef = FirebaseDatabase.getInstance().getReference(Common.AdminRef);

        //checking if that node exist
        AdminRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(phoneNumber).exists()) {

                    //pass the data to the userData class
                    Common.currentUser = dataSnapshot.child(phoneNumber).getValue(User.class);
                    Paper.book().write(Constant.currentSavedUser,Common.currentUser);

                    if (Common.currentUser.getUserPhone().equals(phoneNumber)) {
                        if (Common.currentUser.getUserCode().equals(code)) {

                            Intent i = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(i);
                            finish();

                        } else {

                            showMessage("Code is incorrect");

                        }

                    }
                    waitingDialog.dismiss();

                } else {
                    showMessage("Account with phone number" + phoneNumber + "Does Not exist");
                    showMessage("please Check Your support for more info.");
                    waitingDialog.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                waitingDialog.dismiss();
            }
        });

    }

    private void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        waitingDialog.dismiss();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Paper.book().read(Constant.currentSavedUser) != null) {
            Common.currentUser = Paper.book().read(Constant.currentSavedUser);
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
            finish();
        }
    }
}