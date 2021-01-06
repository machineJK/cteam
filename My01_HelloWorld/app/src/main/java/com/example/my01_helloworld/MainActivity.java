package com.example.my01_helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //전역변수 설정
    EditText etPhoneNum;
    Button btnCall;
    Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //메인화면 설정
        
        //xml에서 id가져오기
        etPhoneNum = findViewById(R.id.etPhoneNum);
        btnCall = findViewById(R.id.btnCall);

        //id에 onClick 이벤트 걸기(이방식은 xml 자체에서 걸 필요 없음)
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //전화번호부를 걸려면 반드시 tel: 을 써야함
                //마지막에는 startActivity 해주기
                String phoneNum = "tel:" + etPhoneNum.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNum));
                startActivity(intent);
            }
        });

        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

    }
    
    //xml에서 직접 이벤트를 거는 방식 //자바에서 메소드를 만들어야함 // Toast를 이용해 alert
    public void btn1Clicked(View view){
        Toast.makeText(this, "버튼1이 클릭되었습니다!!!", Toast.LENGTH_SHORT).show();
    }

    //intent를 이용해 새창 띄우기
    public void btn2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }


}