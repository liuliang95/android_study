package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,false);
            viewHolder = new ViewHolder();
            ImageView fruitImage = view.findViewById(R.id.fruit_image);
            TextView fruitName = view.findViewById(R.id.fruit_name);
            viewHolder.fruitImage = fruitImage;
            viewHolder.fruitName = fruitName;
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }

    private class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }

}
