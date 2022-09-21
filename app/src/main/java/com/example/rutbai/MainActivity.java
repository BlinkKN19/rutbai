package com.example.rutbai;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rutbai;

    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;

    int sonut = 0;
    int darut = 0;
    boolean batay = true;
    String chuoithongbao ="";
    ArrayList<String> cacladarut = new ArrayList<String>();

    int manghinhbai [][] ={
            {R.drawable.b2fv,
                    R.drawable.a3,R.drawable.h3,R.drawable.b3,R.drawable.bon3,R.drawable.n3,
                    R.drawable.s3,R.drawable.bay3,R.drawable.t3,R.drawable.c3,R.drawable.m3,
                    R.drawable.j3,R.drawable.q3,R.drawable.k3},
            {R.drawable.b2fv,
                    R.drawable.a2,R.drawable.h2,R.drawable.b2,R.drawable.bon2,R.drawable.n2,
                    R.drawable.s2,R.drawable.bay2,R.drawable.t2,R.drawable.c2,R.drawable.m2,
                    R.drawable.j2,R.drawable.q2,R.drawable.k2},
            {R.drawable.b2fv,
                    R.drawable.a1,R.drawable.h1,R.drawable.b1,R.drawable.bon1,R.drawable.n1,
                    R.drawable.s1,R.drawable.bay1,R.drawable.t1,R.drawable.c1,R.drawable.m1,
                    R.drawable.j1,R.drawable.q1,R.drawable.k1},
            {R.drawable.b2fv,
                    R.drawable.a4,R.drawable.h4,R.drawable.b4,R.drawable.bon4,R.drawable.n4,
                    R.drawable.s4,R.drawable.bay4,R.drawable.t4,R.drawable.c4,R.drawable.m4,
                    R.drawable.j4,R.drawable.q4,R.drawable.k4}
    };
    String mangtenbai[][]={
            {"rong",
                    "ách chuồn","hai chuồn","ba chuồn","bốn chuồn","năm chuồn",
                    "sáu chuồn","bảy chuồn","tám chuồn","chín chuồn","mười chuồn",
                    "bồi chuồn","đầm chuồn","già chuồn"},
            {"rong",
                    "ách rô","hai rô","ba rô","bốn rô","năm rô",
                    "sáu rô","bảy rô","tám rô","chín rô","mười rô",
                    "bồi rô","đầm rô","già rô"},
            {"rong",
                    "ách cơ","hai cơ","ba cơ","bốn cơ","năm cơ",
                    "sáu cơ","bảy cơ","tám cơ","chín cơ","mười cơ",
                    "bồi cơ","đầm cơ","già cơ"},
            {"rong",
                    "ách bích","hai bích","ba bích","bốn bích","năm bích",
                    "sáu bích","bảy bích ","tám bích","chín bích","mười bích",
                    "bồi bích","đầm bích","già bích"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai=(Button)findViewById(R.id.rutbai);
        labai1=(ImageView)findViewById(R.id.ivlabai1);
        labai2=(ImageView)findViewById(R.id.ivlabai2);
        labai3=(ImageView)findViewById(R.id.ivlabai3);
        thongbao=(TextView)findViewById(R.id.txtthongbao);
        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(darut==0)
                {
                    darut=0;
                    sonut=0;
                    batay = true;
                    chuoithongbao="";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++;

               Random rd = new Random();
                int x,y;
                while(true)
                {
                    x=rd.nextInt(4);//0->3 (b-a+1)+a;
                    y=rd.nextInt(13)+1;//1->13
                    if(cacladarut.contains(mangtenbai[x][y])==false)
                    {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }

                if(y<11)
                    batay = false;
                if(darut==1)
                {
                    sonut+=(y<10)?y:0;
                    labai1.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==2)
                {
                    sonut+=(y<10)?y:0;
                    labai2.setImageResource(manghinhbai[x][y]);
                }
                else if(darut==3)
                {
                    sonut+=(y<10)?y:0;
                    int kq=sonut%10;
                    darut=0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao+=" \nSố Nút Là: " + kq + " ";
                }
                thongbao.setText("Các Lá Đã Rút" + cacladarut.toString()
                        +chuoithongbao +"\nBa Tây "+ batay);
            }
        });
    }
}