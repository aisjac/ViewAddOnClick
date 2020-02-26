package com.example.viewaddonclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    List<AppCompatEditText> list = new ArrayList<AppCompatEditText>();
    AppCompatEditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLinearLayout = findViewById(R.id.parent_linear_layout);



    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);

        editText = rowView.findViewById(R.id.number_edit_text);
        list.add(editText);

        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());


    }

    public void onCalculate(View view) {

        double values = 0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getEditableText().toString().equals("")){
                Toast.makeText(this, "Give your input...", Toast.LENGTH_SHORT).show();
            }else {
                double value = Double.parseDouble(list.get(i).getEditableText().toString());
                values+=value;
            }
        }
        Toast.makeText(this, "Value: "+values, Toast.LENGTH_SHORT).show();
    }
}
