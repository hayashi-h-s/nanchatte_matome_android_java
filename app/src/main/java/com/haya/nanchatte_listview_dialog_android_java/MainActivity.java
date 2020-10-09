package com.haya.nanchatte_listview_dialog_android_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mToListViewSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMenu = findViewById(R.id.lvMenu);

        lvMenu.setOnItemClickListener(new ListItemClickListener());


        mToListViewSecond = findViewById(R.id.toListViewSecond);
        mToListViewSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ListViewSampleSecondActivity.class);
                startActivity(intent);
            }
        });


    }


    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override


//    リスト5.A第2引数viewを使って定食名を取得する
//    TextView tvText=(TextView)view;
//    Stringitem=tvText.getText().toString();

        // 2102
//    AdapterView<?>parentタップされたリスト全体を表します。
//    Viewviewタップされた1行分の画面部品そのものを表します。 → リニアレイアウトが渡されている。
//    intpositionタップされた行番号を表します。ただし、0始まりです。今回のサンプルでいえば、「から揚げ定食」が0、「ハンバーグ定食」が1、…のようになります。
//    longid5.2.2項で解説するSimpleCursorAdapterを利用する場合、DBの主キーの値を表します。それ以外は第3引数のpositionと同じ値が渡されます。

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//      第2引数viewを使って定食名を取得する場合
            TextView tvText = (TextView) view;
            String item = tvText.getText().toString();

//      String item = (String) parent.getItemAtPosition(position);

            String show = "あなたが選んだ定食：" + item;
            Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menumenu) {
//
//      MenuInflaterinflater = getMenuInflater();──❶
//      //オプションメニュー用.xmlファイルをインフレート。
//      inflater.inflate(R.menu.menu_options_menu_list,menu); ──❷//親クラスの同名メソッドを呼び出し、その戻り値を返却。
//      returnsuper.onCreateOptionsMenu(menu); ──❸
//
//    }
    

}