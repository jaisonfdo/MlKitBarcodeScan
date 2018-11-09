package com.droidmentor.mlkitbarcodescan.ListingSetup;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jaison.
 */
public class CustomRecyclerViewAdapter<T> extends RecyclerView.Adapter {

    String TAG="CustomRecyclerViewAdapter";

    Context context;
    Activity activity;
    ArrayList<T> itemsList = new ArrayList<>();
    CustomItemClickListener customItemClickListener;

    public CustomRecyclerViewAdapter(Activity activity, ArrayList<T> itemsList, CustomItemClickListener customItemClickListener) {
        this.context = activity;
        this.activity=activity;
        this.itemsList = itemsList;
        this.customItemClickListener = customItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+itemsList.size());
        return itemsList.size();
    }

    public CustomItemClickListener getCustomClickListener()
    {
        return customItemClickListener;
    }

    public void updateListing(ArrayList<T> itemsList) {

        this.itemsList = itemsList;
        Log.d(TAG, "updateListing: "+this.itemsList.size());
    }

    public ArrayList<T> getListing() {
        return itemsList;
    }

    public void notifyData(ArrayList<T> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.itemsList = myList;
        notifyDataSetChanged();
    }

    public void add(T item, int position) {
        Log.d(TAG, "add: ");
        itemsList.add(position, item);
        notifyItemInserted(position);
    }


    public void replace(T item,int position)
    {
        itemsList.set(position,item);
        notifyItemChanged(position);
    }


    public void remove(T item) {
        Log.d(TAG, "remove: ");
        int position = itemsList.indexOf(item);
        itemsList.remove(position);
        notifyItemRemoved(position);
    }

    public void addItems(ArrayList<T> items, int beginPosition) {
        Log.d(TAG, "addItems: ");
        itemsList.addAll(items);
        notifyItemRangeInserted(beginPosition, items.size());
    }
}
