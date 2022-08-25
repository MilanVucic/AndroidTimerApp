package com.vucic.myfirstapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ButtonOnClickListener implements View.OnClickListener{
    private Context context;

    public ButtonOnClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(context, "I was clicked", Toast.LENGTH_SHORT).show();
    }
}
