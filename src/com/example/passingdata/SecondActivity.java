package com.example.passingdata;

//import entity.Persona;
//
//import android.app.Activity;
import java.util.ArrayList;

import entity.Persona;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	 
//	private static final String NAME = "NAME";
//	private static final String IS_EVEN = "IS_EVEN";
//	private ExpandableListAdapter mAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras(); 
        if (extras == null) {
        	return;
        }
        String string_directo = extras.getString("string_directo");
        String string_edittext = extras.getString("string_edittext");
        int int_seekbar = extras.getInt("int_seekbar");
        boolean bol_check = extras.getBoolean("bol_check");
        String a[] = extras.getStringArray("array");
        
        ArrayList<Persona> lpersonas = getIntent().getExtras().getParcelableArrayList("arraylist");
//        @SuppressWarnings("unchecked")
//		ArrayList<Persona> list = (ArrayList<Persona>) extras.get("arraylist");
//        Persona persona = (Persona) extras.get("persona");
        int_seekbar += 10; //aumento en 10 el valor pasado, para comprobar que viaja como int
        
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, a);
        s.setAdapter(adapter);
        
        TextView personas = (TextView) findViewById(R.id.textView1);
        
        
        if (string_directo != null && string_edittext != null) {
        	Context context = getApplicationContext();
        	CharSequence text = string_directo + " " + string_edittext + " " + int_seekbar + " " + bol_check;
        	int duration = Toast.LENGTH_LONG;

        	Toast toast = Toast.makeText(context, text, duration);
        	toast.show();
        }
        
        String m = "";
        for (Persona x : lpersonas) {
             m += x.getNombre() + " " + x.getMail() + "\n";
        }
        personas.setText(m);
        
//        Para usar un ExpandableList, pero no funciona
//        List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
//        List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
//        for (int i = 0; i < 20; i++) {
//            Map<String, String> curGroupMap = new HashMap<String, String>();
//            groupData.add(curGroupMap);
//            curGroupMap.put(NAME, "Item " + i);
//            curGroupMap.put(IS_EVEN, (i % 2 == 0) ? "This group is even" : "This group is odd");
//            
//            List<Map<String, String>> children = new ArrayList<Map<String, String>>();
//            for (int j = 0; j < 5; j++) {
//                Map<String, String> curChildMap = new HashMap<String, String>();
//                children.add(curChildMap);
//               // curChildMap.put(NAME, "Child " + j);
//                curChildMap.put(IS_EVEN, (j % 2 == 0) ? "Hello " + j: "Good Morning "+ j);
//            }
//            childData.add(children);
//            
//         // Set up our adapter
//            mAdapter = new SimpleExpandableListAdapter(
//                    this,
//                    groupData,
//                    android.R.layout.simple_expandable_list_item_1,
//                    new String[] { NAME, IS_EVEN },
//                    new int[] { android.R.id.text1, android.R.id.text2 },
//                    childData,
//                    android.R.layout.simple_expandable_list_item_2,
//                    new String[] { NAME, IS_EVEN },
//                    new int[] { android.R.id.text1, android.R.id.text2 }
//                    );
//            setListAdapter(mAdapter);
//        }
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_second, menu);
        return true;
    }

    
}
