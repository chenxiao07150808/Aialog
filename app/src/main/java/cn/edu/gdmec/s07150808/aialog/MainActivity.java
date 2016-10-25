package cn.edu.gdmec.s07150808.aialog;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
private TextView charactor,uidate,uitime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        charactor = (TextView) findViewById(R.id.character);

        uidate= (TextView) findViewById(R.id.uidate);

        uitime= (TextView) findViewById(R.id.uitime);

    }
    public void characterpickerdialog(View v){

        final String options="1234567890*-";

        CharacterPickerDialog cpd=new CharacterPickerDialog(this,new View(this),null,options,false){
            /*为字符选择框设置点击事件。
                 1.获取点击的事件，通过getText()获取点击事件的值，在通过toString的方法转化为字符串。
                 2.将上一步，返回的值传入charator上。
                3.判断事件的状态，通过dismiss关闭。
            */

            @Override
            public void onClick(View v) {
                charactor.append(((Button)v).getText().toString());
                if(((Button) v).getText().toString().equals("")){
                    dismiss();
                }
            }
        };
        cpd.show();
    }
  public void datepickerdialog(View v){
      DatePickerDialog.OnDateSetListener dl= new DatePickerDialog.OnDateSetListener() {
          @Override
          public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
              uidate.setText("当前日期"+year+"-"+(month+1)+"-"+dayOfMonth);
          }
      };
      DatePickerDialog dpd=new DatePickerDialog(this,0,dl,2016,9,25);
      dpd.show();
  }
    public void timepickerdialog(View v){
        TimePickerDialog.OnTimeSetListener ot= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                uitime.setText("当前时间:"+hourOfDay+":"+minute);
            }
        };


        TimePickerDialog tpg=new TimePickerDialog(this,ot,15,29,true);
        tpg.show();
    }
    public  void proggressdialog(View v){
        final ProgressDialog pd=ProgressDialog.show(this,"加载","加载中，请稍后.....",true);
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    pd.dismiss();
                }
                }
            }.start();
    }
}
