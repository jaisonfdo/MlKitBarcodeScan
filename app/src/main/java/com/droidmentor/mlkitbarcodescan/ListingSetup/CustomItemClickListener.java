package com.droidmentor.mlkitbarcodescan.ListingSetup;

import android.view.View;

import com.droidmentor.mlkitbarcodescan.ContactsListing.ContactsListingAdapter;

/**
 * Created by Jaison.
 */
public interface CustomItemClickListener {
     void onItemClick(View v, int position);
     void onItemClick(View v, int position,ContactsListingAdapter.ActionItem actionItem);
}
