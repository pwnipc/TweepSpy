package com.chalie.tweepspy;

import android.content.Context;
import android.widget.ArrayAdapter;

public class TweepSpyListAdapter extends ArrayAdapter {
    private String[] mTweetedCves;
    private String[] mProduct;
    private String[] mCveInfo;

    public TweepSpyListAdapter(Context context, int resource, String[] mTweetedCves, String[] mProduct, String[] mCveInfo) {
        super(context, resource);
        this.mTweetedCves = mTweetedCves;
        this.mProduct = mProduct;
        this.mCveInfo = mCveInfo;
    }

    @Override
    public Object getItem(int position){
        String tweetedCve = mTweetedCves[position];
        String product = mProduct[position];
        String cveInfo = mCveInfo[position];
        return String.format("CVE ID : %s \nAffected Product : %S", tweetedCve, product);
    }


    @Override
    public int getCount(){
        return mTweetedCves.length;
    }
}
