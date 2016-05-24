package com.example.smittal.simpletodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    int pos;

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String item = getIntent().getStringExtra("item");
        pos = getIntent().getIntExtra("pos", 0);

        editText = (EditText) findViewById(R.id.editEditItem);
        editText.setText(item);
        editText.setSelection(editText.getText().length());
    }

    public void onEditSave(View view) {
        editText = (EditText) findViewById(R.id.editEditItem);
        Intent i = new Intent();
        i.putExtra("editedText", editText.getText().toString());
        i.putExtra("pos", pos);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
