package com.example.coffee.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffee.coffeetime.db.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegistrationPage extends AppCompatActivity {
    TextView loginText ;
    Button registerButton;
    EditText registrationName;
    EditText registrationSurname;
    EditText PhoneNumber;
    EditText registrationEmail;
    EditText Password;
    EditText PasswordCheck;
    FirebaseDatabase rootNode;
    String TAG="BUG";
    DatabaseReference mDatabase;
    RadioButton Useragreement;
    int value=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        registrationName=findViewById(R.id.registrationName);
        registrationSurname=findViewById(R.id.registrationSurname);
        PhoneNumber=findViewById(R.id.PhoneNumber);
        registrationEmail=findViewById(R.id.registrationEmail);
        Password=findViewById(R.id.Password);
        PasswordCheck=findViewById(R.id.PasswordCheck);
        Useragreement=findViewById(R.id.radioButtonUserAgreement);
        loginText=findViewById(R.id.registerLogin);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginRegisterIntent = new Intent(RegistrationPage.this,Login.class);
                startActivity(loginRegisterIntent);
            }
        });
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( !PasswordCheck.getText().toString().equals(Password.getText().toString()) ){

                    Toast.makeText(getBaseContext(),"Passwords Didn't Match", Toast.LENGTH_SHORT).show();
                }
                else if(registrationName.getText().toString().length() > 0 && registrationSurname.getText().toString().length()>0 && PhoneNumber.getText().toString().length()>0
                        &&Password.getText().toString().length()>0 && PasswordCheck.getText().toString().length()>0 && registrationEmail.getText().toString().length()>0
                        && Useragreement.isChecked() == true) {

                    mDatabase = FirebaseDatabase.getInstance().getReference("users");

                    // Creating new user node, which returns the unique key value
                    // new user node would be /users/$userid/
                 //   String userId = mDatabase.push().getKey();


                    // creating user object
                     User user = new User(registrationEmail.getText().toString(), registrationName.getText().toString(),
                            registrationSurname.getText().toString(), registrationEmail.getText().toString(), Password.getText().toString());

                    String id=Password.getText().toString();
                    // pushing user to 'users' node using the userId
                    mDatabase.child(id).setValue(user);
                    mDatabase.child(id).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            User user = dataSnapshot.getValue(User.class);

                            Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());
                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w(TAG, "Failed to read value.", error.toException());
                        }
                    });
                    value++;
                    Intent loginRegisterIntent = new Intent(RegistrationPage.this, Login.class);
                    startActivity(loginRegisterIntent);
                }
                else {
                    Toast.makeText(getBaseContext(),"Please Fill All Areas and Accept User Agreement", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
