package ca.lambtoncollege.easycart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by ramandeepsingh on 2017-08-09.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {

    private ArrayList<Products> infoList = new ArrayList<>();
    private LayoutInflater mInflater;
    Context context;
    Products currentItem;
    int pos=0;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context=context;
    }

    public void setData(ArrayList<Products> list,Boolean b) {
        this.infoList = list;
        //update the adapter to reflect the new set of movies
        notifyDataSetChanged();
    }


    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.myrow, parent, false);
        MyviewHolder viewHolder = new MyviewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder holder, final int position) {
        currentItem = infoList.get(position);
        holder.rname.setText(currentItem.getProduct_name());
        holder.icon.setImageResource(R.drawable.fan);


    }


    @Override
    public int getItemCount() {
        return infoList.size();
    }
    public String getCount() {
        String count= Integer.toString(infoList.size());
        return count;
    }

    static class MyviewHolder extends RecyclerView.ViewHolder {

        TextView rname;
        ImageView icon;


        public MyviewHolder(View itemView) {
            super(itemView);
            rname = (TextView) itemView.findViewById(R.id.rname);
            icon= (ImageView) itemView.findViewById(R.id.rimageView);

        }
    }
}