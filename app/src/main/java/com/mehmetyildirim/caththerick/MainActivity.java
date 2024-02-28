package com.mehmetyildirim.caththerick;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtSaniye,txtSkor;

    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView[] imageArrays;

    Handler handler;
    Runnable runnable;

    int skor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSaniye=findViewById(R.id.textViewSaniye);
        imageView2=findViewById(R.id.imageView2);
        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        imageView10=findViewById(R.id.imageView10);
        imageView11=findViewById(R.id.imageView11);
        imageView12=findViewById(R.id.imageView12);
        imageView13=findViewById(R.id.imageView13);
        imageView14=findViewById(R.id.imageView14);
        imageView15=findViewById(R.id.imageView15);
        imageView16=findViewById(R.id.imageView16);
        txtSkor=findViewById(R.id.textViewSkor);
        imageArrays=new ImageView[]{imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16};
        skor=0;


        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long l) {
                 txtSaniye.setText("Saniye:"+l/1000);
            }

            @Override
            public void onFinish() {
                txtSaniye.setText("Oyun bitti!");
                handler.removeCallbacks(runnable);
                for (ImageView imageView:imageArrays){
                    imageView.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Yeniden başla?");
                alert.setMessage("Eger yeniden baslarsan daha zor olucak");
                alert.setPositiveButton("evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RickGizleHizli();
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Oyun bitti", Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();

            }
        }.start();
        RickGizle();

    }
    public  void  RickYakanlandı(View view)
    {
        skor++;
        txtSkor.setText("Skor:"+skor);

    }
    public void RickGizle()
    {
        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView imageView:imageArrays){
                    imageView.setVisibility(View.INVISIBLE);
                }
                Random rand=new Random();
                int i=rand.nextInt(14);
                imageArrays[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);


    }
    public void RickGizleHizli()
    {
        handler =new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView imageView:imageArrays){
                    imageView.setVisibility(View.INVISIBLE);
                }
                Random rand=new Random();
                int i=rand.nextInt(14);
                imageArrays[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this, 250);
            }
        };
        handler.post(runnable);


    }
}
