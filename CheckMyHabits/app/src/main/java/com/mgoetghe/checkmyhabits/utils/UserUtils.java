package com.mgoetghe.checkmyhabits.utils;

import com.mgoetghe.checkmyhabits.R;
import com.mgoetghe.checkmyhabits.models.User;

import java.util.ArrayList;

/**
 * Created by mgoet on 03-09-17.
 */

public class UserUtils {
    private static UserUtils mINSTANCE = null;
    private ArrayList<User> mUsersList;

    public static UserUtils getInstance() {
        if(mINSTANCE == null) {
            mINSTANCE = new UserUtils();
        }
        return mINSTANCE;
    }

    private UserUtils () {
        initDefaultUsersList();
    }

    private void initDefaultUsersList() {
        mUsersList = new ArrayList<User>();
        mUsersList.add(new User("Bender", R.drawable.bender));
        mUsersList.add(new User("Fry", R.drawable.fry));
        mUsersList.add(new User("Leela", R.drawable.leela));
        mUsersList.add(new User("Zoidberg", R.drawable.zoidberg));
    }

    public void createUser(User newUser) {
        if(newUser != null) {
            mUsersList.add(newUser);
        }
    }

    public ArrayList<User> getUsersList() {
        return mUsersList;
    }
}
