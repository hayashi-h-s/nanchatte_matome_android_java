package com.haya.nanchatte_listview_dialog_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.haya.nanchatte_listview_dialog_android_java.ConstraintLauout.constraintLayout;

import java.util.ArrayList;
import java.util.List;

public class ListViewSampleSecondActivity extends AppCompatActivity {

  ListView mListViewSecond;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_view_sumple_second);

    // 2200 ~
    mListViewSecond = findViewById(R.id.listViewSecond);

    // String型のリストデータを用意する
    List<String> menuList = new ArrayList<>();
    menuList.add("A定食");
    menuList.add("B定食");
    menuList.add("C定食");
    menuList.add("D定食");
    menuList.add("E定食");
    menuList.add("F定食");
    menuList.add("G定食");
    menuList.add("H定食");
    menuList.add("I定食");
    menuList.add("J定食");

    // adapter 2219 画像あり
    ArrayAdapter<String> adapter = new ArrayAdapter<>(
        ListViewSampleSecondActivity.this,
        android.R.layout.simple_list_item_1,
        menuList
    );

    mListViewSecond.setAdapter(adapter);

    //リストビューにリスナを設定
    mListViewSecond.setOnItemClickListener(new ListItemClickListener());

  }

  public void toConstraintLayout(View view) {
    Intent intent = new Intent(ListViewSampleSecondActivity.this, constraintLayout.class);
    startActivity(intent);
  }

  /***リストがタップされたときの処理が記述されたメンバクラス。*/
  private class ListItemClickListener implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //注文確認ダイアログフラグメントオブジェクトを生成。
      OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment(); //──❶
      // ダイアログ表示。
      dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment"); //──❷

    }

  }

}