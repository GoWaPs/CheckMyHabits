package com.mgoetghe.checkmyhabits.models;

import com.mgoetghe.checkmyhabits.R;

import java.util.Random;

/**
 * Created by mgoet on 03-09-17.
 */

public class User {
    private String mName;
    private int mIconId;

    public User(String name) {
        if(name != null) {
            mName = name;
        }
        randomSelectIcon();
    }

    public User(String name, int iconId) {
        if(name != null) {
            mName = name;
        }
        mIconId = iconId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        if(name != null) {
            mName = name;
        }
    }

    public int getIconId() {
        return mIconId;
    }

    public void setIconId(int iconId) {
        mIconId = iconId;
    }

    private void randomSelectIcon() {
        Random rand = new Random();
        // We only have 4 images to randomly choose from
        int randNumber = rand.nextInt(4);
        switch(randNumber) {
            case 0:
                mIconId = R.drawable.bender;
                break;
            case 1:
                mIconId = R.drawable.fry;
                break;
            case 2:
                mIconId = R.drawable.leela;
                break;
            case 3:
                mIconId = R.drawable.zoidberg;
                break;
        }
    }
 }
