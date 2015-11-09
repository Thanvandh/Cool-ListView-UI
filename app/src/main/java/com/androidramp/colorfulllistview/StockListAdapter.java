package com.androidramp.colorfulllistview;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StockListAdapter extends ArrayAdapter<StockList> {

    ArrayList<StockList> actorList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;
    Context cc;

    public StockListAdapter(Context context, int resource, ArrayList<StockList> objects) {
        super(context, resource, objects);
        cc = context;
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Resource = resource;
        actorList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);

            holder.tvName = (TextView) v.findViewById(R.id.likes_list_name);
            holder.ivImage = (ImageView) v.findViewById(R.id.likes_list_image);

            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        holder.tvName.setText(actorList.get(position).getName());
        holder.ivImage.setImageDrawable(cc.getResources().getDrawable(actorList.get(position).getImageId()));

        AppController.Forte(holder.tvName);
        Color(holder.tvName, position);

        return v;
    }

    static class ViewHolder {
        public TextView tvName;
        public ImageView ivImage;

    }

    private void Color(TextView tv, int position) {

        int mod = position % 3;

        switch (mod) {
            case 0:
                GradientColor(tv, GetColor(R.color.list_color_1), GetColor(R.color.list_color_1a));
                holder.ivImage.setColorFilter(cc.getResources().getColor(R.color.list_color_1), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 1:
                GradientColor(tv, GetColor(R.color.list_color_2), GetColor(R.color.list_color_2a));
                holder.ivImage.setColorFilter(cc.getResources().getColor(R.color.list_color_2), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            case 2:
                GradientColor(tv, GetColor(R.color.list_color_3), GetColor(R.color.list_color_3a));
                holder.ivImage.setColorFilter(cc.getResources().getColor(R.color.list_color_3), android.graphics.PorterDuff.Mode.MULTIPLY);
                break;
            default:
                break;
        }
    }

    private void GradientColor(TextView tv, int color1, int color2) {
        Shader shader = new LinearGradient(
                0, 0, 0, tv.getTextSize(),
                color1, color2, Shader.TileMode.CLAMP);
        tv.getPaint().setShader(shader);
    }

    private int GetColor(int id) {
        return cc.getResources().getColor(id);
    }

}