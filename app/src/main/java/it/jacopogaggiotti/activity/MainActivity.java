package it.jacopogaggiotti.activity;


import static it.jacopogaggiotti.activity.R.id.buttonsFragment;
import static it.jacopogaggiotti.activity.R.id.contactsList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int BTN1 = 1;
    private static final int BTN2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        View button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("bottone",1);
                startActivityForResult(intent,BTN1);*/

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(contactsList,new ButtonsFragment())
                        .commit();
            }
        });

        View button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("bottone",2);
                startActivityForResult(intent,BTN2);*/

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(contactsList,new ContactsFragment())
                        .commit();
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ContactsFragment contactsFragment = new ContactsFragment();
        fragmentTransaction.replace(contactsList,contactsFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textView = findViewById(R.id.textView);
        textView.setText((String) data.getExtras().get("messaggio"));
    }
}