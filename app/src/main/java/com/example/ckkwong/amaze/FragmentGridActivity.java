package com.example.ckkwong.amaze;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ckkwong.amaze.GridView.ItemObjects;
import com.example.ckkwong.amaze.GridView.SolventRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ckkwong on 7/15/16.
 */
public class FragmentGridActivity extends Fragment {
    private static final String TAG = "chelseaMsg";
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private List<ItemObjects> gaggeredList;
    private Context gridContext;
    SolventRecyclerViewAdapter rcAdapter;
    FragmentActivity listener;

    @Override
    public void onAttach(Context context){
        Log.i(TAG, "on attach");
        super.onAttach(context);
        gridContext = context;
        if (context instanceof Activity){
            this.listener = (FragmentActivity) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "on create");
        super.onCreate(savedInstanceState);
        gaggeredList = getListItemData();
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        rcAdapter = new SolventRecyclerViewAdapter(this.gridContext, this.gaggeredList);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "on create view");
        View rootView = inflater.inflate(R.layout.grid_view, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Log.i(TAG, "on view created");
        Log.i(TAG, gaggeredGridLayoutManager.toString());
        Log.i(TAG, rcAdapter.toString());
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        Log.i(TAG, "recycler view is found");
        recyclerView.setHasFixedSize(true);
        Log.i(TAG, "recylcer view set has fixed size");
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        Log.i(TAG, "layout manager is set");
        recyclerView.setAdapter(rcAdapter);
        Log.i(TAG, "adapter is set");
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
    @Override
    public void onStop(){
        super.onStop();
        Log.i(TAG, "on stop");
        Log.i(TAG, this.gridContext.toString());
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Ethane", R.drawable.two));
        listViewItems.add(new ItemObjects("Alkyne", R.drawable.three));
        listViewItems.add(new ItemObjects("Benzene", R.drawable.four));
        listViewItems.add(new ItemObjects("Amide", R.drawable.one));
        listViewItems.add(new ItemObjects("Amino Acid", R.drawable.two));
        listViewItems.add(new ItemObjects("Phenol", R.drawable.three));
        listViewItems.add(new ItemObjects("Carbonxylic", R.drawable.four));
        listViewItems.add(new ItemObjects("Nitril", R.drawable.one));
        listViewItems.add(new ItemObjects("Ether", R.drawable.two));
        listViewItems.add(new ItemObjects("Ester", R.drawable.three));
        listViewItems.add(new ItemObjects("Alcohol", R.drawable.four));

        return listViewItems;
    }
}
