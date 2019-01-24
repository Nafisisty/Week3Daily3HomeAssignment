package com.example.week3daily3homeassignment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

public class UserDetails extends AppCompatActivity {

    String jsonUserObject;
    ItemUser selectedUser;
    ImageView imageView;
    TextView nameTextView;
    TextView genderTextView;
    TextView ageTextView;
    TextView dobTextView;
    TextView emailTextView;
    TextView locationTextView;
    TextView phoneTextView;
    TextView cellTextView;
    TextView natTestView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            jsonUserObject = bundle.getString("user");
        }

        selectedUser = new Gson().fromJson(jsonUserObject, ItemUser.class);

        imageView = findViewById(R.id.imageViewId);
        nameTextView = findViewById(R.id.nameTextViewId);
        genderTextView = findViewById(R.id.genderTextViewId);
        ageTextView = findViewById(R.id.ageTextViewId);
        dobTextView = findViewById(R.id.dobTextViewId);
        emailTextView = findViewById(R.id.emailTextViewId);
        locationTextView = findViewById(R.id.locationTextViewId);
        phoneTextView = findViewById(R.id.phoneTextViewId);
        cellTextView = findViewById(R.id.cellTextViewId);
        natTestView = findViewById(R.id.natTextViewId);

        Glide.with(imageView)
                .load("" + selectedUser.getLargeImage())
                .into(imageView);

        nameTextView.setText(selectedUser.getName());
        genderTextView.setText(selectedUser.getGender());
        ageTextView.setText("" + selectedUser.getAge());
        dobTextView.setText(selectedUser.getDob());
        emailTextView.setText(selectedUser.getEmail());
        locationTextView.setText(selectedUser.getLocation());
        phoneTextView.setText(selectedUser.getPhone());
        cellTextView.setText(selectedUser.getCell());
        natTestView.setText(selectedUser.getNat());

    }

}
