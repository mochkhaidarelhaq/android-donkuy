package com.example.donkuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TambahDonasiAdmin extends AppCompatActivity {
    DatabaseHelper db;
    Button btnsimpan;
    EditText judul, penerima, alasan, alamat, nomortelp, waktu, jumlah, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_donasi_admin);

        db = new DatabaseHelper(this);
        judul = (EditText) findViewById(R.id.judulTD);
        penerima = (EditText) findViewById(R.id.PenerimaBantuanTD);
        alasan = (EditText) findViewById(R.id.AlasanTD);
        alamat = (EditText) findViewById(R.id.AlamatTD);
        nomortelp = (EditText) findViewById(R.id.NomorTeleponTD);
        waktu = (EditText) findViewById(R.id.WaktuBerakhirTD);
        jumlah = (EditText) findViewById(R.id.JumlahTargetTD);
        foto = (EditText) findViewById(R.id.FotoTD);
        btnsimpan = (Button) findViewById(R.id.btn_simpanTD);
    }

        //simpan
        public void setBtnsimpan(){
            btnsimpan.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isInserted = db.insertData(judul.getText().toString(), penerima.getText().toString(),
                                    alasan.getText().toString(), alamat.getText().toString(), nomortelp.getText().toString(),
                                    jumlah.getText().toString(), waktu.getText().toString(), foto.getText().toString());
                            if (isInserted == true) {
                                Toast.makeText(TambahDonasiAdmin.this, "Data terisi", Toast.LENGTH_LONG).show();
                                Intent simpanIntent = new Intent(TambahDonasiAdmin.this, AdminHomeActivity.class);
                                startActivity(simpanIntent);
                                finish();
                            } else {
                                Toast.makeText(TambahDonasiAdmin.this, "Data tidak terisi", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
            );

    }
}
