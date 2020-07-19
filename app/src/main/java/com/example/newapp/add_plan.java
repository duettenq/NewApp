package com.example.newapp;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;

public class add_plan extends AppCompatActivity {

    private ArrayList<Dictionary> mArrayList; //애는 그냥 변수 // 생성자는 클래스에서 오는건
    private CustomAdapter mAdapter;

    public static final String TAG = "MainActivity";

    public static final int REQ_ADD_TEXT = 1;

//add_plan_text add = new add_plan_text(); // add_plan_text 객체 선언   --- >> 0712


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

        //=======================일정 시작 텍스트 =====================//
        final TextView planstart = (TextView) findViewById(R.id.textView6); //  왜 final을 써야 에러가 안날까..?? --> planstart 자동완성 시키니까 final이 붙게 된다
        planstart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final Calendar cldr = Calendar.getInstance();

                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                DatePickerDialog picker;
                picker = new DatePickerDialog(add_plan.this,

                        new DatePickerDialog.OnDateSetListener() {

                            @Override
// =========
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                planstart.setText( year+ "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();

            }
        });

        //=======================일정 끝 텍스트 =====================//

        final TextView planfinish = (TextView) findViewById(R.id.textView8);
        planfinish.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final Calendar cldrr = Calendar.getInstance();

                int dayy = cldrr.get(Calendar.DAY_OF_MONTH);
                int monthh = cldrr.get(Calendar.MONTH);
                int yearr = cldrr.get(Calendar.YEAR);

                DatePickerDialog picker;
                picker = new DatePickerDialog(add_plan.this,

                        new DatePickerDialog.OnDateSetListener() {

                            @Override
// =========
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                planfinish.setText( year+ "/" + (monthOfYear + 1) + "/" + dayOfMonth); //
                            }
                        }, yearr, monthh, dayy);
                picker.show();

            }
        });






            //=======================데이터 저장 버튼 =====================//
                                      //체크버튼






            ImageButton check = (ImageButton) findViewById(R.id.imageButton8);
            check.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View view) {
                    Log.e("add_plan.java", "Onclick -- 체크버튼");

                    Intent intent = new Intent(); // 제목담는곳
//                    Intent intenttwo = new Intent(); // 메모담는곳
                    Log.e("add_plan.java", "Intent 생성");
//                    Intent intenttwo = new Intent(); // 각각 인텐트 객체 생성..??



                    // =====================  제목데이터 담아주는곳 ==================== //
                    EditText editTexttitle = (EditText) findViewById(R.id.editTexttitlefive) ;
                    intent.putExtra("contact_title", editTexttitle.getText().toString()) ;
                    Log.e("add_plan.java", "제목데이터"+editTexttitle.getText());
                    Log.e("add_plan.java", "제목 에딧텍스트 주소"+editTexttitle);


                    // ===================== 메모데이터 담아주는곳 ==================== //
                    EditText editTextMemo = (EditText) findViewById(R.id.editTextMemofive);
                    intent.putExtra("contact_memo", editTextMemo.getText().toString());
                    Log.e("add_plan.java", "메모데이터"+editTextMemo.getText()); //
                    Log.e("add_plan.java", "메모 에딧텍스트 주소"+editTextMemo);

                    // ===================== 일정 시작 담아주는곳 ==================== //

                     TextView tt = (TextView) findViewById(R.id.textView6);
                    intent.putExtra("contact_plan_start", tt.getText().toString());
                    Log.e("add_plan.java", "메모데이터"+tt.getText()); //
                    Log.e("add_plan.java", "메모 에딧텍스트 주소"+tt);


                    // ===================== 일정 끝 담아주는곳 ==================== //

                    TextView rr = (TextView) findViewById(R.id.textView8);
                    intent.putExtra("contact_plan_finish", rr.getText().toString());
                    Log.e("add_plan.java", "메모데이터"+rr); //
                    Log.e("add_plan.java", "메모 에딧텍스트 주소"+rr);





                    // ===================== 데이터 넘겨주는 곳 --> MainActivity 로 ==================== //
                    setResult(RESULT_OK, intent); // 데이터 Main의 - OnActivityForResult - 에게 넘겨줌
                    Log.e("add_plan.java", "셋리절트  제목 데이터"+editTexttitle.getText().toString());
                    Log.e("add_plan.java", "셋리절트  메모 데이터" +editTextMemo.getText().toString());
                    Log.e("add_plan.java", "셋리절트  일정 시작 데이터"+tt.getText().toString());
                    Log.e("add_plan.java", "셋리절트  일정 끝 데이터" +rr.getText().toString());


                    Log.e("add_plan.java", "제목 에딧텍스트 주소"+editTexttitle);
                    Log.e("add_plan.java", "메모 에딧텍스트 주소"+editTextMemo);
                    Log.e("add_plan.java", "제목 에딧텍스트 주소"+tt);
                    Log.e("add_plan.java", "메모 에딧텍스트 주소"+rr);

                    SharedPreferences sharedPreferences= getSharedPreferences("recycler_title", MODE_PRIVATE);    // test 이름의 기본모드 설정
                    SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언

// key,value 형식으로 저장editText.getText().toString()  --- (String s , String s1)
                   //===== key 값 , Value 값 다 다르게 // recycler_title 이라는 xml 에 다 같이 있음
                    editor.putString("inputText",editTextMemo.getText().toString());
                    editor.putString("inputTitle",editTexttitle.getText().toString());
                    editor.putString("inputtt",tt.getText().toString());
                    editor.putString("inputrr",rr.getText().toString());

                    editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
                         //=========================================
                    //데이터 하나당 xml 파일을 다 다르게 해놓는 방법도 생각해보자.......  -
                    //==================================================

//                    SharedPreferences sharedPreferencess= getSharedPreferences("recycler_title", MODE_PRIVATE);    // test 이름의 기본모드 설정
//                    SharedPreferences.Editor editorr= sharedPreferencess.edit(); //sharedPreferences를 제어할 editor를 선언
//                    editorr.putString("inputText",editTexttitle.getText().toString()); // key,value 형식으로 저장editText.getText().toString()  --- (String s , String s1)
//                    editorr.commit();    //최종 커밋. 커밋을 해야 저장이 된다.





                    Log.e("add_plan.java", "커밋했습니다..??");

                    finish(); // 액티비티 종료s

                }
            });

        }//create 닫히는 곳
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







