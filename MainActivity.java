package com.example.listview;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity { 
ListView   myListView;
ArrayList<HashMap <String, String>> myArrayList = new ArrayList<>();
HashMap <String, String> myHashMap;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		myListView = findViewById(R.id.activitymainListView1);
		MyAdapter myAdapter = new MyAdapter();
		myListView.setAdapter(myAdapter);
        
		myHashMap = new HashMap<>();
        myHashMap.put("Name","MD ROKIB");
        myHashMap.put("Phone","01845464035");
        myArrayList.add(myHashMap);
        

        myHashMap = new HashMap<>();
        myHashMap.put("Name","MD SAIFUL");
        myHashMap.put("Phone","01845464036");
        myArrayList.add(myHashMap);
        

        myHashMap = new HashMap<>();
        myHashMap.put("Name","MD YASIN");
        myHashMap.put("Phone","01845464034");
        myArrayList.add(myHashMap);
        
        myHashMap = new HashMap<>();
        myHashMap.put("Name","NURE HAFSA");
        myHashMap.put("Phone","01845464033");
        myArrayList.add(myHashMap);

        
        
    }
	
	
	// Custom Adapter Creation-------
	
	
	private class MyAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;

		@Override
		public int getCount() {
			return myArrayList.size();
		}

		@Override
		public Object getItem(int p1) {
			return null;
		}

		@Override
		public long getItemId(int p1) {
			return 0;
		}

		@Override
		public View getView(final int p1, View p2, ViewGroup p3) {
			layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item,p3, false);
            
            ImageView  imageView = myView.findViewById(R.id.itemImageView1);
            TextView tvName = myView.findViewById(R.id.itemTextView1);
            TextView tvPhone = myView.findViewById(R.id.itemTextView2);
            
            HashMap <String, String> myHashMaplist =myArrayList.get(p1);
            final String name = myHashMaplist.get("Name");
            String phone =myHashMaplist.get("Phone");
            //----OR
            //tvName.setText(myHashMaplist.get("Name"));
            // tvPhone.setText(myHashMaplist.get("Phone"));
           tvName.setText(name);
           tvPhone.setText(phone);
            
            
            
            imageView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"My Name is: "+name, Toast.LENGTH_SHORT).show();
                    }
                });
            
            
            return myView;
		}
	};
	
} 
