package com.example.android.physicscalculator;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Viraj Joshi on 12/25/2016.
 */

public class PhysicsAdapter extends ArrayAdapter<Calculator> {

    public PhysicsAdapter(Activity context, ArrayList<Calculator> c){
        super(context,0,c);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Calculator current = getItem(position);



        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        iconView.setImageResource(current.getImageResourceId());

        listItemView.findViewById(R.id.list_item_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ListView)parent).performItemClick(v,position,0);
            }
        });


        return listItemView;
    }


}
