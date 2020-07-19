package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.Contacts; // contact ㅠㅠㅠㅠㅠ

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

//======== 전역 변수 선언하는 곳 ==========//
public class MainActivity extends AppCompatActivity {
    static final int REQ_ADD_CONTACT = 1;
    public static final String TAG = "MainActivity";
    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;


    TextView textView, textView1, textView2, textView3, textView4,textView5,textView6,textView7;
    EditText editTextsp;
    Gson gson;
    Context context;
    String contact_Dictionary;

    SharedPreferences sp;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        Log.e("메인액티비티.자바", "온크리에이트 호출");
        super.onCreate(savedInstanceState);
        Log.e("메인액티비티.자바", "슈퍼 온크리에이트 호출");

        mArrayList = new ArrayList<>();
        mAdapter = new CustomAdapter(this, mArrayList);




        Log.e("메인액티비티.자바", "화면1");
        setContentView(R.layout.activity_calendar_main); // 메인화면을 보여주는 코드

        textView = findViewById(R.id.shared_title);
        textView1 = findViewById(R.id.shared_start);
        textView2 = findViewById(R.id.shared_finish);
        textView3 = findViewById(R.id.shared_edittext);
        //여기다가 item list의 id를 넣는다면 ..??

        textView4 = findViewById(R.id.id_listitem);
        textView5 = findViewById(R.id.korean_listitem);
        textView6 = findViewById(R.id.korean_listitem2);
        textView7 = findViewById(R.id.english_listitem);

//mArrayList.add();
//Dictionary dd = new Dictionary(String textno,);


        sp = getSharedPreferences("recycler_title", MODE_PRIVATE);
        String input = sp.getString("inputTitle", "");   // key/default Value
        Log.e("메인액티비티.자바", "input sp. getString" + sp.getString("inputTitle", ""));

        String inpu = sp.getString("inputText", "");
        Log.e("메인액티비티.자바", "inpu sp. getString" + sp.getString("inputText", ""));

        String inp = sp.getString("inputtt", "");
        Log.e("메인액티비티.자바", "inp sp. getString" + sp.getString("inputtt", ""));

        String in = sp.getString("inputrr", "");
        Log.e("메인액티비티.자바", "in sp. getString" + sp.getString("inputrr", ""));



                textView.setText(input);
        textView1.setText(inpu);
        textView2.setText(inp);
        textView3.setText(in);


// mArrayList = sp.getAll();


// SharedPreferences shared= getSharedPreferences("Numii", MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
//        String inputText = shared.getString("inputText","");
//        textView.setText(inputText);    // TextView에 SharedPreferences에 저장되어있던 값 찍기.
//        Toast.makeText(this, "불러오기 하였습니다..", Toast.LENGTH_SHORT).show();


        //    =======================리사이클로뷰 LayoutManager 로 배치 =====================//
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list); // RecyclerView의 아이디
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView.setAdapter(mAdapter); // ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ 1시간 날라감 이것때무문에


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

//==========================일정 추가 하기 버튼 ============================================//
        ImageButton button = (ImageButton) findViewById(R.id.plusplan);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Log.e("E tag 입니다 !!!!!!!!!!", "Main onClick -- Two 액티비티로 이동");
                                          // TODO : create intent and start activity.
                                          Intent intent = new Intent(MainActivity.this, add_plan.class);
                                          Log.e("E tag 입니다 !!!!!!!!!!", "메인 -- 인텐트 객체 생성");
                                          startActivityForResult(intent, REQ_ADD_CONTACT);
                                          Log.e("E tag 입니다 !!!!!!!!!!", "startActivityForResult(intent, REQ_ADD_CONTACT);");

                                      }// onClick 닫히는 곳
                                  } //  View.OnClickListener 닫히는 곳 ..????

        ); // setOnClickListener 닫히는 곳


    } // onCreate 닫히는 곳

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQ_ADD_CONTACT) {
            if (resultCode == RESULT_OK) {

                //===메모추가 값 받아오기 === //                                                   //add_plan 의 EditText ID
                String textmemo = intent.getStringExtra("contact_memo");
                Log.e("MainActivity.java", "메인 메모데이터" + textmemo);

                //===제목추가 값 받아오기 === //
                String texttitle = intent.getStringExtra("contact_title");   // 멤버변수 String name 에 edittext 값 담기
                Log.e("MainActivity.java", "메인 제목데이터" + texttitle);


                //===일정시작 값 받아오기 === //

                String startplann = intent.getStringExtra("contact_plan_start");   // 멤버변수 String name 에 edittext 값 담기
                Log.e("MainActivity.java", "메인 일정시작 데이터" + startplann);


                //===일정 끝 값 받아오기 === //

                String finishplann = intent.getStringExtra("contact_plan_finish");   // 멤버변수 String name 에 edittext 값 담기
                Log.e("MainActivity.java", "메인 일정끝 데이터" + finishplann);


                Dictionary dict = new Dictionary(texttitle, textmemo, startplann, finishplann);
                Log.e("MainActivity.java", "내가 쓴 데이터를 참조하는 딕셔너리 생성자 생성");
                mArrayList.add(dict); //마지막 줄에 삽입됨
                Log.e("메인액티비티 - notifyItemInserted", "mArrayList 에 add (dict)");
//               Log.e("메인액티비티", "값 " + dict);
                mAdapter.notifyItemInserted(0);
                Log.e("메인액티비티 - notifyItemInserted", "mAdapter값 " + mAdapter);
                mAdapter.notifyDataSetChanged();
                Log.e("메인액티비티 - notifyDataSetChanged", "mAdapter값 " + mAdapter);

            }
        }
    }

    // === onStop 메소드 === //
    @Override
    protected void onStop() {
        super.onStop();


    }
}// Class 닫히는 곳







