package com.example.newapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextMenu; // implements 때문에 추가됨
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

//ArrayList에 있는 Dictionary 클래스 타입의 데이터를 RecyclerView에 보여주는 처리를 합니다.
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{           //1. class 시작하는 곳


    //    생성자에서 데이터 리스트 객체를 전달받음.
    private ArrayList<Dictionary> mList;                     // Dictionary Class 생성..?
    private Context mContext; //상태의 맥락
    SharedPreferences sp;
//getApplicationContext()를 통해 접근


// 아이템 뷰를 저장하는 뷰홀더 클래스.
// 1. 컨텍스트 메뉴를 사용하라면 RecyclerView.ViewHolder를 상속받은 클래스에서

// OnCreateContextMenuListener 리스너를 구현해야 합니다.


    public class CustomViewHolder extends RecyclerView.ViewHolder
            implements View.OnCreateContextMenuListener {                                        // 2. CustomViewHolder 상속받는 곳 시작하는 곳

        //RecyclerView.ViewHolder

        protected TextView mId;   // 메모 담는 곳
        protected TextView mEnglish; //  제목 담는곳
        protected TextView planstart; // 일정시작 담는곳
        protected TextView planfinish; // 일정종료 담는 곳
        final int DIALOG_DATE = 1;
        final int DIALOG_TIME = 2;
        private View view1;
       SharedPreferences sp;



        public CustomViewHolder(View view) {//3. CustomViewHolder 시작하는 곳
            super(view);
            Log.e("CustomAdapter Class", "CustomViewHolder -- super(view) -- 시작");
//            View.setOnClickListener(new View.OnClickListener() {
           // item_list안에 textView 를 지정해준다..??
            this.mId = (TextView) view.findViewById(R.id.id_listitem); //  메모 담는 곳
            Log.e("커스텀어댑터.자바", "커스텀 뷰홀더 안");
            this.mEnglish = (TextView) view.findViewById(R.id.english_listitem);// 제목 담는곳
            Log.e("커스텀어댑터.자바", "커스텀 뷰홀더 안");
            this.planstart = (TextView) view.findViewById(R.id.korean_listitem2); //  일정시작 담는 곳

            this.planfinish = (TextView) view.findViewById(R.id.korean_listitem); //  일정종료 담는 곳
            view.setOnCreateContextMenuListener(this);

            Log.e("CustomAdapter Class", "CustomViewHolder -- view.setOnCreateContextMenuListener(this); -- 끝  ");
            // OnCreateContextMenuListener 리스너를 현재 클래스에서 구현한다고 설정해둡니다.
        }                                                                                                   //3. CustomViewHolder 끝나는 곳


        @Override  // 3. 컨텍스트메뉴 생성 // 메뉴 항목 선택시 호출되는 리스너를 등록 // ID 1001, 1002로 리스너에서 버튼 구분
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {        //4. onCreateContextMenu 시작하는곳
            Log.e("커스텀어댑터.자바", "온크리에이트 호출 + -----------------------------mId 의 값 "+mId);

            Log.e("CustomAdapter Class", " onCreateContextMenu 시작");
            Log.e("CustomAdapter Class", " 버튼 아이디 지정 시작");
            MenuItem Edit = menu.add(Menu.NONE, 1001, 1, "편집");
            MenuItem Delete = menu.add(Menu.NONE, 1002, 2, "삭제");
//            MenuItem share = menu.add(Menu.NONE, 1003, 3, "공유");
            Edit.setOnMenuItemClickListener(onEditMenu);
            Delete.setOnMenuItemClickListener(onEditMenu);
//            share.setOnMenuItemClickListener(onEditMenu);
            Log.e("CustomAdapter Class", " 버튼 아이디 지정 끝");
            Log.e("CustomAdapter Class", " onCreateContextMenu  끝");

        }                                                                                                        //4. onCreateContextMenu 끝나는곳


           //=================4. 컨텍스트 메뉴에서 항목 클릭시 동작을 설정합니다.=======================///
        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {     //5. OnMenuItemClickListener 시작하는 곳


            @Override
            public boolean onMenuItemClick(MenuItem item) {                                                           //6. onMenuItemClick 시작하는 곳  // 1001 편집 편집 편집 편집 // 1002 삭제 삭제 삭제 삭제 삭제
                Log.e("CustomAdapter Class", " onMenuItemClick 시작");
                // 5. 편집 항목을 선택시
                //제가 알기로는 getitemid 는
                // getitem (position) 으로 가져오는 item의 id를 세팅해주는 역할을 합니다.
                //흔히 return position 을 사용하기 때문에 혼동할 수 있습니다.



                switch (item.getItemId()) {                                                                          // 7. Switch 시작하는 곳          //편집

                    //======================= 편집 버튼 클릭할때 ==========================================//
                    case 1001:
                        Log.e("E tag 입니다 !!!!!!!!!!", " 1001 편집 시작");

                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);                                                                    //편집
//                         다이얼로그를 보여주기 위해 edit_box.xml 파일을 사용합니다.
                        Log.e("E tag 입니다 !!!!!!!!!!", "   View view = LayoutInflater.from(mContext)  ");
                        View view = LayoutInflater.from(mContext)   //  xml editbox 실체화// 편집

                                .inflate(R.layout.activity_add_plan_six, null, false); //edit_box , add_plan
Log.e("E tag 입니다 !!!!!!!!!!", "   View view = .inflate(R.layout.activity_add_plan_six ");

                        Log.e("E tag 입니다 !!!!!!!!!!", "    .inflate(R.layout.edit_box, null, false);)  ");
//
//                        builder.setTitle("리스트 추가 예제");
                        builder.setView(view);
                        Log.e("E tag 입니다 !!!!!!!!!!", "  다이얼로그 안의 버튼 생성  ");




      //============================================다이얼로그 안 버튼 아이디 받아오기===============================================//
                        // =========================버튼 정의하기 // 아이디 객체에 담기===============================================//
                        final EditText editTextName = (EditText) view.findViewById(R.id.editTextMemoSix); // add_plan_six -- 메모추가 ID
                        final EditText title = (EditText) view.findViewById(R.id.editTexttitlesix); // add_plan_six -- 제목추가 ID
                        final TextView start = (TextView) view.findViewById(R.id.textView66); // add_plan_six -- textview
                        final TextView finish = (TextView) view.findViewById(R.id.textView88); // add_plan_six -- textview
                        final ImageButton check= (ImageButton) view.findViewById(R.id.imageButton88); // add_plan_six -- Check 버튼
                        //=============== 해당 줄에 입력되어 있던 데이터를 불러와서 다이얼로그에 보여줍니다.============//
                        //=============== 객체. 기억하자===========//
                        title.setText(mList.get(getAdapterPosition()). getTextno()); //제목추가
                        editTextName.setText(mList.get(getAdapterPosition()). getEnglish()); //메모추가
                      start.setText(mList.get(getAdapterPosition()). getPlanone()); //메모추가
                       finish .setText(mList.get(getAdapterPosition()). getPlantwo()); //메모추가





                        start.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                Log.e("E tag 입니다 !!!!!!!!!!", " dialog.show");
                                final Calendar cldr = Calendar.getInstance();

                                int day = cldr.get(Calendar.DAY_OF_MONTH);
                                int month = cldr.get(Calendar.MONTH);
                                int year = cldr.get(Calendar.YEAR);

                                //========datepicker dialog 객체 생성 ============ //

                                DatePickerDialog  picker = new DatePickerDialog(mContext,

                                        new DatePickerDialog.OnDateSetListener() {

                                            @Override

                                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                                start.setText( year+ "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                                            }
                                        }, year, month, day);

                                picker.show();

                            }
                        });



                        finish.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                Log.e("E tag 입니다 !!!!!!!!!!", " dialog.show");
                                final Calendar cldr = Calendar.getInstance();

                                int day = cldr.get(Calendar.DAY_OF_MONTH);
                                int month = cldr.get(Calendar.MONTH);
                                int year = cldr.get(Calendar.YEAR);

                                //========datepicker dialog 객체 생성 ============ //

                                DatePickerDialog  picker = new DatePickerDialog(mContext,

                                        new DatePickerDialog.OnDateSetListener() {

                                            @Override

                                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                                finish.setText( year+ "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                                            }
                                        }, year, month, day);

                                picker.show();

                            }
                        });




            //==============diaglog 만들어지고 Create 되는 곳 =====================//

                        final AlertDialog dialog = builder.create();
                        dialog.show();
                        Log.e("E tag 입니다 !!!!!!!!!!", " dialog.show");



//                        public void onClick2(View v) {
//                        view1.setVisibility(View.VISIBLE);
//}
                               //======= 수정 버튼 클릭시 =======//
                        check.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                Log.e("CustomAdapter", "다이얼로그 안 수정버튼클릭 시작");
                                //=============텍스트 내용을 가져온다 ================//

                                String titlee = editTextName.getText().toString(); //english_listitem 값 받아오기
                                String strID = title.getText().toString(); // id_listitem 에 값 받아오기
                                String zzzz = start.getText().toString(); //english_listitem 값 받아오기
                                String xxxx = finish.getText().toString(); // id_listitem 에 값 받아오기

//
                                //=============Dictionary 객체에 데이터 입력================//
                                Dictionary dict = new Dictionary(strID,titlee,zzzz,xxxx);            //Dictionary 클래스안에 인스턴스변수를 넣어주지 않으면 에러가 난다 // 하나만 집어 넣어줄수 있지 않나 왜 다 넣어줘여 하지??
                                mList.set(getAdapterPosition(), dict) ;//int index  Dictionary element
                                notifyItemChanged(getAdapterPosition());

                           //========Dismiss this dialog, removing it from the screen.========//
                                dialog.dismiss();
                                Log.e("CustomAdapter", "다이얼로그 안 수정버튼클릭 끝");

                            }  }); //       ========= 편집 버튼 닫히는 곳 ========

                        break;      //      ========편집 버튼에서 빠져나옴=======                                                                                                                                //편집      -- break 로 작업종료


                    //============================== 삭제 버튼 클릭할때 ==========================================//
                    case 1002:

                        Log.e("CustomAdapter", "Remove !!");
                        mList.remove(getAdapterPosition());
                        Log.e("CustomAdapter", "수정 + 반영");
                        notifyItemRemoved(getAdapterPosition());
                        Log.e("CustomAdapter", "/ 리스트 반영");
                        notifyItemRangeChanged(getAdapterPosition(), mList.size());
                        Log.e("CustomAdapter", "break; !!!!!!!");


                        break;     //  =======삭제 버튼에서 빠져나옴=======  //

//                    case 1003:
//                        Log.e("CustomAdapter", "공유하기 !! ");
//
//                        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                        intent.setType("text/plain");
//
//                        String subject = editTextName.getText().toString();
//                        String text = "Hello World !"; //
//
//                       subject.setText(mList.get(getAdapterPosition()). getTextno()); //제목추가
//                      text.setText(mList.get(getAdapterPosition()). getEnglish()); //메모추가
//
//                        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                        intent.putExtra(Intent.EXTRA_TEXT, text); //text 자리는 공유할 자리
//
// Title of intent
//                        Intent chooser = Intent.createChooser(intent, "암시적 인텐트 적용하기");
//                        mContext.startActivity(chooser); // 위에  private Context mContext; 선언해줌... 왜 작동이 되는지는 모르겠다... 에러에서 자동해결했다...


                }      // 7. Switch 끝나는 곳 //



                return true;


            }                                                                                              //6.   //onMenuItemClick 끝나는 곳
        };                                                                                               //5. OnMenuItemClickListener 끝나는 곳

    }                                                                                                     //2. CustomViewHolder 상속받는 곳 끝나는 곳

    //CustomViewHolder 끝나는곳
//        public CustomAdapter(ArrayList<Dictionary> list) {  //
//            this.mList = list;
//        }


    public CustomAdapter(Context context, ArrayList<Dictionary> list) {
        Log.e("CustomAdapter", "생성자 시작 ");//
        Log.e("CustomAdapter", "mList = list; ");//
        mList = list;
        mContext = context;
        Log.e("CustomAdapter", "mContext에 담길 context 값"+context);//
        Log.e("CustomAdapter", "mList에 담길 list 값"+list);//
        Log.e("CustomAdapter", "생성자 끝");//
    }





    @Override

    // ====================onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴 ==================================//

    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Log.e("CustomAdapter", "onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체 생성.");//
        Log.e("CustomAdapter", "inflate 시작");
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);
        Log.e("CustomAdapter", "inflate 끝");

        Log.e("CustomAdapter", "CustomViewHolder 객체생성 시작");
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        Log.e("CustomAdapter", "CustomViewHolder 객체생성 끝");
        Log.e("CustomAdapter", "onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체 생성후 Return !! .");//
        return viewHolder;

    }    //========= 10. CustomViewHolder onCreateViewHolder 끝나는 곳 =====================//





    @Override
    // ==================== onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시. ==================================//

    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int posiion) {  //Nonnull은 뭐지..? // 11. onBindViewHolder 시작하는 곳
        Log.e("CustomAdapter", "onBindViewHolder 시작하는 곳");
        Log.e("CustomAdapter", "viewholder.ID.setTextSize 시작");

        viewholder.mId.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewholder.mEnglish.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        viewholder.planstart.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        viewholder.planfinish.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);


        Log.e("CustomAdapter", "viewholder.ID.setTextSize 끝");

//++++++++++++++++++++++++++  viewholder.JINHO.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        //===============JINHO = 날짜시작을 담을 CustomAdater 에 선언된 TextView의 객체에 (Item_List의 ID) 담기 ++ @시작날짜 담는곳@



        //===================== 중력 설정하기 ..?? __ textview랑 관련있음 __ ============================//
        Log.e("CustomAdapter", "셋 그래비티 시작");
        viewholder.mId.setGravity(Gravity.CENTER);
        viewholder.mEnglish.setGravity(Gravity.CENTER);
        viewholder.planstart.setGravity(Gravity.CENTER);
        viewholder.planfinish.setGravity(Gravity.CENTER);
        Log.e("CustomAdapter", "셋 그래비티 끝");


        //=====================값 가져오기============================//
           //순서바꿈
        Log.e("CustomAdapter--  onBindViewHolder", "값 가져오기 ");

        viewholder.mId.setText(mList.get(posiion).getTextno());
        viewholder.mEnglish.setText(mList.get(posiion).getEnglish());
        viewholder.planstart.setText(mList.get(posiion).getPlanone());
        viewholder.planfinish.setText(mList.get(posiion).getPlantwo());
//        viewholder.mEnglish.setText(mList.get(posiion).getEnglish());
        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.getClass());
        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(0));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(1));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(1));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(2));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(3));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(4));
//        Log.e("커스텀 어댑터 ", "인덱스값 확인" + mList.get(5));


        //  viewholder.mId.setText(mList.get(posiion).getId()); // id 값 받아오기
        //        viewholder.mEnglish.setText(mList.get(posiion).getEnglish()); // English 값 받아오기
        //        viewholder.mKorean.setText(mList.get(posiion).getKorean());
        Log.e("CustomAdapter", "onBindViewHolder 끝나는 곳");
    }  //============= 11. onBindViewHolder 끝나는 곳=============//



    //====Returns the total number of items in the data set held by the adapter.========//
    //====전체 아이템 갯수를 리턴함====//
    //====몇번 돌아갈것인지 설정가능 ==== //



    public int getItemCount() {
        Log.e("CustomAdapter", "겟 아이템 카운트");
        return (null != mList ? mList.size() : 0);
    }

}   // class 끝나는 곳
