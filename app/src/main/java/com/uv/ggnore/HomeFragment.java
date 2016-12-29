package com.uv.ggnore;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Riyadh on 1/8/2016.
 */
public class HomeFragment extends Fragment {

    private ApiWrapper server = new ApiWrapper();

    static interface TaskCallbacks  {
        void onPreExecute();

        void onProgressUpdate(int percent);

        void onCancelled();

        void onPostExecute();
    }

    private class GetHomeTask extends AsyncTask<Void, Integer, Void>    {

        @Override
        protected Void doInBackground(Void... unused) {

            return unused[0];
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity activity = (MainActivity)getActivity();
        activity.getSupportActionBar().setTitle("Home");
    }
}
