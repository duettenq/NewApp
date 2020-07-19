package com.example.newapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class add_plan_six extends AppCompatActivity {

    private ArrayList<Dictionary> mArrayList; //애는 그냥 변수 // 생성자는 클래스에서 오는건
    private CustomAdapter mAdapter;

    public static final String TAG = "MainActivity";

    public static final int REQ_ADD_TEXT = 1;

//add_plan_text add = new add_plan_text(); // add_plan_text 객체 선언
        @Override
        //================onCreate =====================//

        protected void onCreate(Bundle savedInstanceState) {               // onCreate 열리는 곳
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_plan_five);

            //================달력 버튼 =====================//


            ImageButton cal = (ImageButton) findViewById(R.id.imageButton7);   // 달력 이미지 버튼 누르면 add_plan_calendar 띄어줌
            cal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), add_plan_calendar.class);
                    startActivity(intent);
                }
            });

//            //================설명 추가 버튼  --> add_plan 에서 입력하는 걸로 대체됨 =====================//
//
//                ImageButton text = (ImageButton) findViewById(R.id.imageButton12); // 일정메모 아이콘
//                text.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                                Intent intent = new Intent(getApplicationContext(), add_plan_text.class);
//                                startActivityForResult(intent,REQ_ADD_TEXT); //Intent intent , int RequestCode
//                        }
//                });


            //================하단 뒤로가기 버튼 =====================//


            ImageButton back = (ImageButton) findViewById(R.id.imageButton9);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });


            //=======================알람 버튼 =====================//

            ImageButton alarm = (ImageButton) findViewById(R.id.imageButton13);
            alarm.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), add_plan_alarm.class);
                    startActivity(intent);
                }
            });
            //=======================일정 반복 버튼 =====================//

            ImageButton routine = (ImageButton) findViewById(R.id.imageButton14);
            routine.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), add_plan_routine.class);
                    startActivity(intent);
                }
            });

            //=======================태그 추가 버튼 =====================//

            ImageButton tag = (ImageButton) findViewById(R.id.imageButton15);
                    tag.setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), add_plan_tag.class);
                            startActivity(intent);
                }
            });
            //=======================데이터 저장 버튼 =====================//

            ImageButton check = (ImageButton) findViewById(R.id.imageButton88);//체크버튼
            check.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Log.e("E tag 입니다 !!!!!!!!!!", "Onclick");
                    Intent intent = new Intent();
                    // =====================  제목추가 하는곳 ==================== //
                    EditText editTexttitle = (EditText) findViewById(R.id.editTexttitlesix) ;

                    intent.putExtra("contact_name", editTexttitle.getText().toString()) ;
                    // ===================== 메모추가 하는곳 ==================== //
                    EditText editTextName = (EditText) findViewById(R.id.editTextMemoSix);
                    // =====일정제목추가 ID ===== //
                    intent.putExtra("contact_name", editTextName.getText().toString());
                    // ===================== 데이터 넘겨주는 곳 --> MainActivity 로 ==================== //
                    setResult(RESULT_OK, intent); // 데이터 Main의 - OnActivityForResult - 에게 넘겨줌
                    finish(); // 액티비티 종료s

                }
            });

        }
}// class 닫히는 곳




            //=======================데이터 공유 버튼 =====================//

//            Button share= (Button) findViewById(R.id.button); // 공유버튼
//            share.setOnClickListener(new View.OnClickListener() {
//
//
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                    intent.setType("text/plain");
//                    String subject = "안드로이드 2주차 과제";
//                    String text = "Hello World !"; //
//
//                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                    intent.putExtra(Intent.EXTRA_TEXT, text); //text 자리는 공유할 자리
//
//                    Intent chooser = Intent.createChooser(intent, "암시적 인텐트 적용하기");
//                    startActivity(chooser);
//
//                }
//            });





    //onCreate 닫히는 곳
    //onCreate 밑에 onActivityResult() 만들자






//    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
//            super.onActivityResult(requestCode, resultCode, intent);
//
//            TextView textViewName = (TextView) findViewById(R.id.textdata);
//            String name = intent.getStringExtra("contact_name");
//
//            if (name != null)
//                textViewName.setText(name);}

//        }else if (name == null) {
//            Intent inntent = new Intent(getApplicationContext(), add_plan_calendar.class);
//            startActivity(inntent);
//
//        }






//textView id 좀 적어줘....
        // 어떤 데이터를 받을 거임 ...??????







