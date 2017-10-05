package com.evon.amitrai.democontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();

    private Button btnRetrieve = null;
    private RecyclerView recyclerView = null;
    private List<ProviderData> dataList;
    private ProviderAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }



    private void initview(){
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
        btnRetrieve.setOnClickListener(this);
        dataList = new ArrayList<>();
        adapter = new ProviderAdapter(dataList);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRetrieve){
            try {
                Uri allTitles = Uri.parse(
                        "content://com.tag.custom_contentproviderdemo.Plates/plates");
                Cursor cursor = getContentResolver().query(allTitles, null, null, null, null);
                Log.e(TAG, ""+cursor);

                if (cursor != null){

                    dataList.clear();
                    adapter.notifyDataSetChanged();

                    if ( cursor.getCount() >0 && cursor.moveToFirst()){
                        while(!cursor.isAfterLast()){
                            String id = cursor.getString(cursor.getColumnIndex("_id"));
                            String title = cursor.getString(cursor.getColumnIndex("title"));
                            String content = cursor.getString(cursor.getColumnIndex("content"));
                            ProviderData data = new ProviderData();
                            data.setId(id);
                            data.setTitle(title);
                            data.setMessage(content);
                            dataList.add(data);
                            Log.e(TAG, "data received is,  id "+id+" title "+title+" content "+content);
                            cursor.moveToNext();
                        }
                    }
                    cursor.close();

                    adapter.notifyDataSetChanged();
                }



            }catch (Exception exp){
                exp.printStackTrace();
            }
        }
    }
}