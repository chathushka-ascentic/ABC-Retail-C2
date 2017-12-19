package com.example.admin.abcfashions.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.abcfashions.Database.DatabaseHandler;
import com.example.admin.abcfashions.Fragment.ItemFragment.OnListFragmentInteractionListener;
import com.example.admin.abcfashions.Fragment.dummy.DummyContent.DummyItem;
import com.example.admin.abcfashions.Model.Item;
import com.example.admin.abcfashions.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mValues;
    private final OnListFragmentInteractionListener mListener;
    private Context mContext;

    public MyItemRecyclerViewAdapter(List<Item> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Log.e("Name",mValues.get(position).getName());

        holder.mItem = mValues.get(position);
        holder.name.setText(mValues.get(position).getName());
        holder.price.setText(mValues.get(position).getPrice());
        holder.quantity.setText(mValues.get(position).getQuantity());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView price;
        public final TextView quantity;
      //  public final Button delete;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            quantity = view.findViewById(R.id.quantity);
         //  delete = (Button) view.findViewById(R.id.delete);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + price.getText() + "'";
        }
    }
}
