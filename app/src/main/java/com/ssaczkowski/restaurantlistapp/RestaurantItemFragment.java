package com.ssaczkowski.restaurantlistapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 */
public class RestaurantItemFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private RecyclerView recyclerView;
    private OnListFragmentInteractionListener mListener;
    private RestaurantItemRecyclerViewAdapter mAdapter;
    private ArrayList<Restaurant> mRestaurantList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantItemFragment() {
    }

    @SuppressWarnings("unused")
    public static RestaurantItemFragment newInstance(int columnCount) {
        RestaurantItemFragment fragment = new RestaurantItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // TODO : BD integration
            mRestaurantList = new ArrayList<>();
            mRestaurantList.add(new Restaurant("Pizzeria Carlos","https://www.gstatic.com/bfe/apps/website/img/h/87450465-pizza-1440.jpg", 4.0f,"Madrid, España"));
            mRestaurantList.add(new Restaurant("Hamburguecería Rápida","https://www.hola.com/imagenes/cocina/noticiaslibros/20200528168887/hamburguesas-recetas-dia-internacional/0-828-951/dia-hamburguesa-m.jpg", 3.0f,"México, DF"));


            mAdapter = new RestaurantItemRecyclerViewAdapter(getActivity(),mRestaurantList,mListener);
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener)
            mListener = (OnListFragmentInteractionListener) context;
        else
            throw  new RuntimeException(context.toString() + "must implement OnListFragmentInteractionListener");
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Restaurant item);
    }
}