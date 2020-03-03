package com.ims_hr.latihan9;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar RB_Rate;
    Button B_Submit;
    Button B_Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inisial();
        Listen_B_Submit();
        Listen_B_Exit();
    }

    private void Inisial() {
        RB_Rate = findViewById(R.id.ratingBar_Main_Rate);
        B_Submit = findViewById(R.id.button_Main_Submit);
        B_Exit = findViewById(R.id.button_Main_Exit);
    }

    private void Listen_B_Submit() {
        B_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float Rating = RB_Rate.getRating();
                String Kategori = "";
                if(Rating >= 5) {
                    Kategori = "Sangat Setuju";
                } else if(Rating >= 4) {
                    Kategori = "Setuju";
                } else if(Rating >= 3) {
                    Kategori = "Kurang Setuju";
                } else if(Rating >= 2) {
                    Kategori = "Tidak Setuju";
                } else {
                    Kategori = "Sangat Tidak Setuju";
                }
                String Pesan = "Nilai rating adalah " + Rating +
                        " yang artinya saya " + Kategori;
                Toast.makeText(MainActivity.this, Pesan, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Listen_B_Exit() {
        B_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Konfirmasi = getResources().getString(R.string.MainActivity_Konfirmasi);
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage(Konfirmasi)
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Nggak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Konfirmasi");
                alert.show();
            }
        });
    }

}
