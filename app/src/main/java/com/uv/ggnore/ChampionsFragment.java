package com.uv.ggnore;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Riyadh on 1/28/2016.
 */
public class ChampionsFragment extends Fragment {

    private GridView championsList;
    private ChampionsAdapter championsAdapter;
    private ApiWrapper server = new ApiWrapper();

    static interface TaskCallbacks  {
        void onPreExecute();

        void onProgressUpdate(int percent);

        void onCancelled();

        void onPostExecute();
    }

    class GetChampionsTask extends AsyncTask<Void, Void, Object>    {

        private ArrayList<Champion> champions;

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }

        @Override
        protected Object doInBackground(Void... params) {

            return null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_champions, container, false);
        championsList = (GridView) view.findViewById(R.id.champions_list);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity activity = (MainActivity)getActivity();
        activity.getSupportActionBar().setTitle("Champions");
    }
}
