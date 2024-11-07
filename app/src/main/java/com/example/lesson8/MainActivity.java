package com.example.lesson8;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        linearLayoutContainer = findViewById(R.id.linearLayoutContainer);

        Button addTextButton = findViewById(R.id.add_text_button);
        addTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTextView();
            }
        });
    }

    private void addNewTextView() {
        EditText newTextView = new EditText(this);
        newTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        newTextView.setHint("Escribe aquí...");
        newTextView.setTextSize(16);
        newTextView.setPadding(8, 8, 8, 8);

        linearLayoutContainer.addView(newTextView);

        ScrollView scrollView = findViewById(R.id.scrollView);
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}
