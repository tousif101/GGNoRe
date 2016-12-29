package com.uv.ggnore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Riyadh on 1/28/2016.
 */
public class NavigationAdapter extends BaseAdapter {

    private Context context;
    private String[] navigationItems;
    private LayoutInflater inflater;

    public NavigationAdapter(Context context, String[] navigationItems)  {
        this.context = context;
        this.navigationItems = navigationItems;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return navigationItems.length;
    }

    @Override
    public Object getItem(int position) {
        return navigationItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NavigationItem navigationItem;

        if(convertView == null)    {
            navigationItem = new NavigationItem();
            convertView = inflater.inflate(R.layout.navigation_item, null);
            navigationItem.text = (TextView) convertView.findViewById(R.id.navigation_item_text);
            convertView.setTag(navigationItem);
        }
        else    {
            navigationItem = (NavigationItem) convertView.getTag();
        }

        String text = (String) getItem(position);
        navigationItem.text.setText(text);

        return convertView;
    }

    class NavigationItem    {
        private TextView text;
    }
}
