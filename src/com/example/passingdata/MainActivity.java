package com.example.passingdata;

//import java.util.ArrayList;
//
//import entity.Persona;

import java.util.ArrayList;

import entity.Persona;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

/* Ejemplo: PassingData
 * Transferencia de datos entre dos vistas (activities)
 * Posibles tipos de dato a pasar: 
 *  -String: directo {string_directo}, desde TextView{string_textview}
 *  -Integer: desde SeekBar{int_seekbar} 
 *  -Boolean: desde checkbox{bol_check}
 *  -Array, ArrayList, Map
 *  -Class (clase personalizada) con persistencia.
 */

public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener {
	//private static final int REQUEST_CODE = 10;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Seekbar
        SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
        bar = (SeekBar)findViewById(R.id.seekBar1); // make seekbar object
        bar.setOnSeekBarChangeListener(this); // set seekbar listener.
        
        //Click en el bot—n: button1
        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	EditText t = (EditText) findViewById(R.id.editText1);
            	SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
            	CheckBox c = (CheckBox) findViewById(R.id.checkBox1);
            	
            	String espana[] = {"Avila","Burgos","Le—n","Palencia","Salamanca","Segovia","Soria","Valladolid","Zamora"};
            	
            	ArrayList<Persona> p = new ArrayList<Persona>(2);
            	Persona j = new Persona("Juancarlos", 20, true, "juancarloscruzdiaz@gmail.com");
            	Persona r = new Persona("Romina", 21, false, "romina@gmail.com");
            	p.add(j);
            	p.add(r);
            	
            	Intent i = new Intent(getApplicationContext(), SecondActivity.class);
            	
            	i.putExtra("string_directo", "Valor directo");
            	i.putExtra("string_edittext", t.getText().toString());
            	i.putExtra("int_seekbar", bar.getProgress());
            	i.putExtra("bol_check", c.isChecked());
            	i.putExtra("array", espana);
//            	i.putExtra("persona", j);
            	i.putParcelableArrayListExtra("arraylist", p);
//            	 String m = "";
//                 for (Persona x : p) {
//                      m += x.getNombre() + " " + x.getMail() + "\n";
//                 }
//                Context context = getApplicationContext();
//         		CharSequence text = m;
//         		int duration = Toast.LENGTH_SHORT;
//         		Toast toast = Toast.makeText(context, text, duration);
//         		toast.show();
                 
                 
            	startActivity(i);
            	//startActivityForResult(i, REQUEST_CODE);
            }
        });
        
        
        // since we are using this class as the listener the class is "this"
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
	}

	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar s) {
		// TODO Auto-generated method stub
		Context context = getApplicationContext();
		CharSequence text = "El valor de seekbar: " + s.getProgress() + "";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
}
