package com.uv.ggnore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Riyadh on 1/29/2016.
 */
public class ChampionsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Champion> champions;
    private LayoutInflater inflater;

    public ChampionsAdapter(Context context, ArrayList<Champion> champions)   {
        this.context = context;
        this.champions = champions;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return champions.size();
    }

    @Override
    public Object getItem(int position) {
        return champions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChampionItem championItem;

        if(convertView == null)    {
            championItem = new ChampionItem();
            convertView = inflater.inflate(R.layout.navigation_item, null);
            championItem.name = (TextView) convertView.findViewById(R.id.champion_name);
            convertView.setTag(championItem);
        }
        else    {
            championItem = (ChampionItem) convertView.getTag();
        }

        Champion champion = (Champion) getItem(position);
        championItem.name.setText(champion.getName());

        return convertView;
    }

    class ChampionItem  {
        private ImageView image;
        private TextView name;
    }
}
