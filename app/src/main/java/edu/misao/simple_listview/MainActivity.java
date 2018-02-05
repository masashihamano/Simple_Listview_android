package edu.misao.simple_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //表示用データ
        String[] list = {"aaaa", "bbbb", "cccc", "dddd"};

        //紐付け
        listview = (ListView) findViewById( R.id.listview );

        //ArrayAdapterへ設定
        ArrayAdapter adapter = new ArrayAdapter( MainActivity.this, android.R.layout.simple_expandable_list_item_1, list );

        //リストビューへ設定
        listview.setAdapter( adapter );

        //リストをクリック
        listview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //リストビューの項目を取得
                ListView listView = (ListView) parent;
                String item = (String) listview.getItemAtPosition( position );

                //表示
                Toast.makeText( getApplicationContext(), item, Toast.LENGTH_SHORT ).show();
            }
        } );


        //リストを長押し
        listview.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //リストビューの項目を取得
                ListView listview = (ListView) parent;
                String item = (String) listview.getItemAtPosition( position );

                //表示
                Toast.makeText( getApplicationContext(), item + " long select", Toast.LENGTH_SHORT ).show();


                return false;
            }
        } );

        //リストを選択
        listview.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //選択した場合
                //リストビューの項目を取得
                ListView listView = (ListView) parent;
                String item = (String) listview.getItemAtPosition( position );

                //表示
                Toast.makeText( getApplicationContext(), item + "item select", Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //選択していない場合
                //表示
                Toast.makeText( getApplicationContext(), "no item select", Toast.LENGTH_SHORT ).show();
            }
        } );
    }
//            @Override
//            public boolean onCreateOptionsMenu(Menu menu) {
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//            return true;
//            }
//
//            @Override
//            public boolean onOptionsItemSelected(MenuItem item){
//                int id = item.getItemId();
//
//                if (id == R.id.action_settings){
//                    return true;
//                }
//
//                return super.onOptionsItemSelected( item );
//            }



}

