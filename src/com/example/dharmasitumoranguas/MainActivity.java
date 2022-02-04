package com.example.dharmasitumoranguas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity {
	
	String[] tujuan = {
			"-- choose --",
			"Padang",
			"Aceh"
	};
	
	EditText nama, alamat, jmlhTiket;
	int hrgTiket, totalByr;
	Button buyBtn;
	Spinner sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if (getIntent().getExtras() != null) {
			Bundle terima = getIntent().getExtras();
			Toast.makeText(getBaseContext(), terima.getString("balas"), Toast.LENGTH_LONG).show();
		}
		
		sp = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tujuan);
		sp.setAdapter(adp);
		
		sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int posisi, long arg3) {
				// TODO Auto-generated method stub
				posisi = sp.getSelectedItemPosition();
				
				if(tujuan[posisi] == "Padang") 
					hrgTiket = 100000;
				else if(tujuan[posisi] == "Aceh")
					hrgTiket = 75000;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		nama = (EditText)findViewById(R.id.etNama);
		alamat = (EditText)findViewById(R.id.etAlamat);
		jmlhTiket = (EditText)findViewById(R.id.etJmlTiket);
		
		buyBtn = (Button)findViewById(R.id.buy);
		buyBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this, BuyTiket.class);
				
				// kirim data //
				i.putExtra("nama", nama.getText().toString());
				i.putExtra("alamat", alamat.getText().toString());
				i.putExtra("tujuan", tujuan[sp.getSelectedItemPosition()]);
				i.putExtra("jumlahTiket", jmlhTiket.getText().toString());
				i.putExtra("harga", String.valueOf(hrgTiket));
				i.putExtra("total", String.valueOf(hrgTiket * Integer.parseInt(jmlhTiket.getText().toString())));
				
				startActivity(i);
			}
		});
	}

}
