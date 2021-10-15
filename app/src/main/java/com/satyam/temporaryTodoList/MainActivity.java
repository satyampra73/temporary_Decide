package com.satyam.temporaryTodoList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.satyam.todolistsampletest.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText editText;
    ArrayList<String> arrayList;
    ArrayAdapter <String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.listview);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        arrayList =new ArrayList<>();
        arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        setUpListViewListner();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additem(v);
            }
        });
    }

    private void setUpListViewListner() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context,"item has been remove",Toast.LENGTH_SHORT).show();
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void additem(View v){
        String str=editText.getText().toString();
        if(!(str.isEmpty())) {
            arrayAdapter.add(str);
            editText.setText("");
        }
        else {
            Toast.makeText(getApplicationContext(),"please enter the text",Toast.LENGTH_SHORT).show();
        }



    }
}