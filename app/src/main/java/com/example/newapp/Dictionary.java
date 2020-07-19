package com.example.newapp;

import android.content.SharedPreferences;
import android.util.Log;

public class Dictionary {


    private String textno; //일정메모
    private String English; //일정제목
    private String planone; //일정 시작
    private String plantwo; //일정 끝

    SharedPreferences sp;
    public String getPlanone() {
        Log.e("딕셔너리 클래스!!!!!!!!!!!!!!!!!!!", "일정시작 데이터 가져오기 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return planone;
    }

    public void setPlanone(String planone) {

        this.planone = planone;
    }

    public String getPlantwo() {
        Log.e("딕셔너리 클래스!!!!!!!!!!!!!!!!!!!!!!", "일정종료 데이터 가져오기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return plantwo;
    }

    public void setPlantwo(String plantwo) {
        this.plantwo = plantwo;
    }



public String getTextno() {

    Log.e("딕셔너리 클래스!!!!!!!!!!!!!!!!!!!!!", "제목 데이터 가져오기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    return textno;
}

    public String getEnglish() {
        Log.e("딕셔너리 클래스!!!!!!!!!!", "메모 데이터 가져오기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return English;
    }

    public void setEnglish(String english) {
        Log.e("Dictionary.class", "셋 잉그리쉬");
        English = english;
    }






    public void setTextno(String textno) {
        Log.e("Dictionary.class", "public void setTextno(String textno)");
        this.textno = textno;
    }




// 1. RecyclerView의 한 줄에 보여줄 데이터를 클래스로 선언합니다.
// 2.  item_list.xml에서 정의한 TextView 개수에 맞추어야 합니다.
//3. 텍스트뷰에 표시될 문자열을 저장하는 세 개의 String 변수를 정의





        //우클릭 - Generate -- getter & setter 한번에 설정 가능
        //Constructor 도 같은 방식임

              //===   인스턴스 값 갱신 잘하기 !!! ===//
        public Dictionary(String textno,String English,String planone,String plantwo) {     // 생성자는 인스턴스 변수를 참조한다
            Log.e("Dictionary.class", "public Dictionary() 생성자 !!!");
            this.textno = textno;
            this.English= English;                               /////////////  파트장님 죄송합니다 이거 안써서 그 지랄을 했네요 .... 사람인가...... 심지어 String English 회색 이었네... 안쓰고 있는데...
            this.planone= planone;                               /////////////  파트장님 죄송합니다 이거 안써서 그 지랄을 했네요 .... 사람인가...... 심지어 String English 회색 이었네... 안쓰고 있는데...
            this.plantwo= plantwo;                               /////////////  파트장님 죄송합니다 이거 안써서 그 지랄을 했네요 .... 사람인가...... 심지어 String English 회색 이었네... 안쓰고 있는데...

        }





    }