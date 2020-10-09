package com.haya.nanchatte_listview_dialog_android_java;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    //ダイアログビルダーを生成。
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()); //──❶
    // ダイアログのタイトルを設定。

    builder.setTitle(R.string.dialog_title);  //──❷1
    // ダイアログのメッセージを設定。
    builder.setMessage(R.string.dialog_msg); // ──❷2

    // PositiveButtonを設定。
    builder.setPositiveButton(
        R.string.dialog_btn_ok,
        new DialogButtonClickListener()); //──❸1

    // NegativeButtonを設定。
    builder.setNegativeButton(
        R.string.dialog_btn_ng,
        new DialogButtonClickListener()); //──❸2

    // NeutralButtonを設定。
    builder.setNeutralButton(
        R.string.dialog_btn_nu,
        new DialogButtonClickListener()); //──❸3

    // ダイアログオブジェクトを生成し、リターン。
    AlertDialog dialog = builder.create(); // ──❹
    return dialog;
  }

  private class DialogButtonClickListener implements DialogInterface.OnClickListener {
    @Override
    public void onClick(DialogInterface dialog, int which) {
      //トーストメッセージ用文字列変数を用意。
      String msg = "";
      //タップされたアクションボタンで分岐。
      switch (which) { //──❶

        // PositiveButtonならば…
        case DialogInterface.BUTTON_POSITIVE: //──❷1
          // 注文用のメッセージを格納。
          msg = getString(R.string.dialog_ok_toast);
          break;

        //NegativeButtonならば…
        case DialogInterface.BUTTON_NEGATIVE: //──❷2
          // キャンセル用のメッセージを格納。
          msg = getString(R.string.dialog_ng_toast);
          break;

        //NeutralButtonならば…
        case DialogInterface.BUTTON_NEUTRAL: // ──❷3
          // 問い合わせ用のメッセージを格納。
          msg = getString(R.string.dialog_nu_toast);
          break;
      }

      //トーストの表示。
      Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

    }
  }
}
