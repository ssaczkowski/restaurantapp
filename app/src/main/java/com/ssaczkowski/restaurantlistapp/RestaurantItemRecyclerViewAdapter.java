package com.ssaczkowski.restaurantlistapp;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;


public class RestaurantItemRecyclerViewAdapter extends RecyclerView.Adapter<RestaurantItemRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurant> mValues;
    private final RestaurantItemFragment.OnListFragmentInteractionListener mListener;
    private final Context ctx;

    public RestaurantItemRecyclerViewAdapter(Context context, List<Restaurant> items,
                                             RestaurantItemFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mDirection.setText(mValues.get(position).getDirection());
        holder.mName.setText(mValues.get(position).getName());
        holder.mPunctuation.setRating(mValues.get(position).getPunctuation());

        Glide.with(ctx).load(holder.mItem.getUrlPhoto()).centerCrop().into(holder.mPhoto);

        holder.mView.setOnClickListener(view -> {
            if(null != mListener){
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mName;
        public final TextView mDirection;
        public final ImageView mPhoto;
        public final RatingBar mPunctuation;
        public Restaurant mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mName = (TextView) view.findViewById(R.id.textViewName);
            mDirection = (TextView) view.findViewById(R.id.textViewDirection);
            mPhoto = (ImageView) view.findViewById(R.id.imageViewPhoto);
            mPunctuation = (RatingBar) view.findViewById(R.id.ratingBar);
        }

    }
}