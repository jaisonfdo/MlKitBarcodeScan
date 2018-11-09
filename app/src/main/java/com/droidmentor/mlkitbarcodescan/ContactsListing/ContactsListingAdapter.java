package com.droidmentor.mlkitbarcodescan.ContactsListing;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.droidmentor.mlkitbarcodescan.ListingSetup.CustomItemClickListener;
import com.droidmentor.mlkitbarcodescan.ListingSetup.CustomRecyclerViewAdapter;
import com.droidmentor.mlkitbarcodescan.LocalData.ContactDetail;
import com.droidmentor.mlkitbarcodescan.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jaison.
 */
public class ContactsListingAdapter extends CustomRecyclerViewAdapter {

    String TAG = "ContactsListingAdapter";

    Context context;
    ArrayList<ContactDetail> contactDetailArrayList;
    CustomItemClickListener customItemClickListener;


    public ContactsListingAdapter(Activity activity, ArrayList<ContactDetail> contactsData,
                                  CustomItemClickListener customItemClickListener) {
        super(activity, contactsData, customItemClickListener);
        this.context = activity;
        this.contactDetailArrayList = contactsData;
        this.customItemClickListener = customItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts_list, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(mView);
        mView.setOnClickListener(v -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(v, mViewHolder.getAdapterPosition());
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder type_item = (ViewHolder) holder;
        final ContactDetail contactDetail = getListing().get(position);

        setText(type_item.tvName,contactDetail.getName());
        setText(type_item.tvMobileNumber,contactDetail.getPhoneNumber());
        setText(type_item.tvAddress,contactDetail.getAddress());
        setText(type_item.tvMail,contactDetail.getEmailID());
        setText(type_item.tvName,contactDetail.getName());

        setDrawable(type_item.ivCall,contactDetail.getPhoneNumber(),1);
        setDrawable(type_item.ivMail,contactDetail.getEmailID(),2);
        setDrawable(type_item.ivWeb,contactDetail.getWebLink(),3);
        setDrawable(type_item.ivDelete,"enable_delete",4);

        setAvatarBackground(type_item.cvProfile,position);

        type_item.ivDelete.setColorFilter(ContextCompat.getColor(context,R.color.cl_delete_drawable_color));

        // Redirects the user'sclick action to the respective callbacks

        type_item.cvDetails.setOnClickListener(view -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(view, type_item.getAdapterPosition());
        });

        type_item.ivCall.setOnClickListener(view -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(view, type_item.getAdapterPosition(),ActionItem.CALL);
        });

        type_item.ivMail.setOnClickListener(view -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(view, type_item.getAdapterPosition(),ActionItem.MAIL);
        });

        type_item.ivWeb.setOnClickListener(view -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(view, type_item.getAdapterPosition(),ActionItem.WEB);
        });

        type_item.ivDelete.setOnClickListener(view -> {
            if (customItemClickListener != null)
                customItemClickListener.onItemClick(view, type_item.getAdapterPosition(),ActionItem.DELETE);
        });
    }

    public void setText(TextView tvSelectedControl, String textValue)
    {
        if(TextUtils.isEmpty(textValue))
            tvSelectedControl.setVisibility(View.GONE);
        else
        {
            tvSelectedControl.setVisibility(View.VISIBLE);
            tvSelectedControl.setText(textValue);
            Log.d(TAG, "setText: "+textValue);
        }
    }

    private void setDrawable(ImageView imageView, String value, int index)
    {
        String activeColor[]={"","#65AC58","#FF8B00","#0492FF","#EA0404"};
        String inActiveColor[]={"","#D1D1D1","#D1D1D1","#D1D1D1","#EA0404"};

        if(TextUtils.isEmpty(value))
        {
            imageView.setClickable(false);
            imageView.setColorFilter(Color.parseColor(inActiveColor[index]));

        }
        else
        {
            imageView.setClickable(true);
            imageView.setColorFilter(Color.parseColor(activeColor[index]));

        }
    }

    private void setAvatarBackground(CardView cvDetails, int pos)
    {
        String colorCodes[]={"#19BC9C","#2ECC71","#3398DB","#9B59B6","#34495E","#F1C40E","#E67E21","#E74C3C","#27969F","#716359"};

      /*  Random rand = new Random();
        int index = rand.nextInt(colorCodes.length);*/

        int index=pos%colorCodes.length;

        Log.d(TAG, "setAvatarBackground: "+index);

        cvDetails.setCardBackgroundColor(Color.parseColor(colorCodes[index]));
    }

    public enum ActionItem
    {
        CALL, MAIL, WEB, DELETE
    }
    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    public ArrayList<ContactDetail> getListing() {
        return super.getListing();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivThumb)
        ImageView ivThumb;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvMobileNumber)
        TextView tvMobileNumber;
        @BindView(R.id.tvAddress)
        TextView tvAddress;
        @BindView(R.id.tvMail)
        TextView tvMail;
        @BindView(R.id.ivCall)
        ImageView ivCall;
        @BindView(R.id.ivMail)
        ImageView ivMail;
        @BindView(R.id.ivWeb)
        ImageView ivWeb;
        @BindView(R.id.ivDelete)
        ImageView ivDelete;
        @BindView(R.id.cvDetails)
        CardView cvDetails;
        @BindView(R.id.cvProfile)
        CardView cvProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
