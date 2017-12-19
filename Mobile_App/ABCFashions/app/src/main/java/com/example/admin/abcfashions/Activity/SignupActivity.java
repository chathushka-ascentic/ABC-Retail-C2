package com.example.admin.abcfashions.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.abcfashions.R;
import com.example.admin.abcfashions.WebService.Communicator;
import com.example.admin.abcfashions.WebService.LoginEvent;
import com.example.admin.abcfashions.WebService.RegUserEvent;

import de.greenrobot.event.EventBus;


public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    private Button _signupButton;
    private EditText _passwordText;
    private EditText _emailText;
    private EditText _nameText;
    private EditText _userText;
    private EditText _contactText;
    private TextView _loginLink;
//    ProgressDialog progressDialog;
    Communicator communicator;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(SignupActivity.this);
        setContentView(R.layout.activity_signup);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        _loginLink = findViewById(R.id.link_login);
        _emailText = findViewById(R.id.input_email);
        _passwordText = findViewById(R.id.input_password);
        _nameText = findViewById(R.id.input_name);
        _userText = findViewById(R.id.input_user);
        _contactText = findViewById(R.id.input_contact);
        _signupButton = findViewById(R.id.btn_signup);

        communicator = new Communicator();

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

//        progressDialog= new ProgressDialog(SignupActivity.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String user = _userText.getText().toString();
        String contacts = _contactText.getText().toString();

        // TODO: Implement your own signup logic here.

        communicator.reg_user(name,user,contacts,email,password);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                     //   onSignupSuccess();
                         onSignupFailed();
//                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Registration failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }

    public void onEvent(RegUserEvent regUserEvent){

        if(regUserEvent.getReg_user().getResult().equals("success"))
        {
//            progressDialog.dismiss();
            Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            onSignupFailed();
        }
        // your implementation

    }
}