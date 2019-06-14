package com.laacompany.billingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextNama;
    private EditText mEditTextJumlah;
    private EditText mEditTextHarga;
    private EditText mEditTextDiskon;

    private TextView mTextViewTotal;

    private Button mButtonKalk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextNama = findViewById(R.id.id_edt_nama);
        mEditTextHarga = findViewById(R.id.id_edt_harga);
        mEditTextJumlah = findViewById(R.id.id_edt_jumlah);
        mEditTextDiskon = findViewById(R.id.id_edt_diskon);

        mTextViewTotal = findViewById(R.id.id_tv_laporan);

        mButtonKalk = findViewById(R.id.id_btn_kalkulasi);
        mButtonKalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;

                if (mEditTextNama.getText().toString().equals("")){
                    mEditTextNama.setError("This field may not be blank");
                    error = true;
                }

                if (mEditTextJumlah.getText().toString().equals("")){
                    mEditTextJumlah.setError("This field may not be blank");
                    error = true;
                }

                if (mEditTextHarga.getText().toString().equals("")){
                    mEditTextHarga.setError("This field may not be blank");
                    error = true;
                }

                if (mEditTextDiskon.getText().toString().equals("")){
                    mEditTextDiskon.setError("This field may not be blank");
                    error = true;
                } else {
                    int disc = Integer.valueOf(mEditTextDiskon.getText().toString());
                    if (disc < 0 || disc > 100){
                        mEditTextDiskon.setError("This field must only contain number from 0 to 100");
                        error = true;
                        //as
                    }
                }

                if (!error){
                    String nama = mEditTextNama.getText().toString();
                    int jumlah = Integer.valueOf(mEditTextJumlah.getText().toString());
                    int harga = Integer.valueOf(mEditTextHarga.getText().toString());
                    int diskon = Integer.valueOf(mEditTextDiskon.getText().toString());

                    int potongan = harga * diskon/100;
                    int total = (harga-potongan) * jumlah;

                    mTextViewTotal.setText("Nama : " + nama + "\nTotal Harga : " + String.valueOf(total));
                }


            }
        });
    }
}

