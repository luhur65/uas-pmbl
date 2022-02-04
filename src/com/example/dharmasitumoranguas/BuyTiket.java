package com.example.dharmasitumoranguas;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class BuyTiket extends Activity {
	
	TextView nama, alamat, tujuan, jmlTiket, hrgTiket, totalByr;
	Button btnKembali;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_tiket);
		
		nama = (TextView)findViewById(R.id.tvNama);
		alamat = (TextView)findViewById(R.id.tvAlamat);
		tujuan = (TextView)findViewById(R.id.tvTujuan);
		jmlTiket = (TextView)findViewById(R.id.tvJmlTiket);
		hrgTiket = (TextView)findViewById(R.id.tvHarga);
		totalByr = (TextView)findViewById(R.id.totalByr);
		
		nama.setText(getIntent().getStringExtra("nama"));
		alamat.setText(getIntent().getStringExtra("alamat"));
		tujuan.setText(getIntent().getStringExtra("tujuan"));
		jmlTiket.setText(getIntent().getStringExtra("jumlahTiket"));
		hrgTiket.setText(getIntent().getStringExtra("harga"));
		totalByr.setText(getIntent().getStringExtra("total"));
		
		// Toast.makeText(getBaseContext(), getIntent().getStringExtra("harga"), Toast.LENGTH_LONG).show();
		
		btnKembali = (Button) findViewById(R.id.back);
		btnKembali.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle kirim = new Bundle();
				// kirim pesan balasan untuk data yg telah diterima
				kirim.putString("balas", "Data Sudah Diterima!");
				
				Intent kembali = new Intent(BuyTiket.this, MainActivity.class);
				kembali.putExtras(kirim);
				startActivity(kembali);
				
			}
		});
		
	}


}
