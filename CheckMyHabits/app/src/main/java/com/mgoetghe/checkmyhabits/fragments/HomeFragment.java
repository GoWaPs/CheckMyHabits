package com.mgoetghe.checkmyhabits.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mgoetghe.checkmyhabits.R;
import com.mgoetghe.checkmyhabits.adapters.UserAdapter;
import com.mgoetghe.checkmyhabits.models.User;
import com.mgoetghe.checkmyhabits.utils.UserUtils;

import java.util.List;

/**
 * This class is reponsible for the display od the home view once the application is launched
 * Created by mgoet on 02-09-17.
 */

public class HomeFragment extends Fragment {

    private ListView mUsersListView;
    private EditText mNewUserNameEditText;
    private Button mCreateUserButton;

    private UserUtils mUserUtils;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.home_fragment, container, false);

        // Init widgets that we will need to access
        mUsersListView = (ListView) fragmentView.findViewById(R.id.users_listview);
        mNewUserNameEditText = (EditText) fragmentView.findViewById(R.id.new_user_name_edittext);
        mCreateUserButton = (Button) fragmentView.findViewById(R.id.create_user_button);
        mUserUtils = UserUtils.getInstance();
        if(mUsersListView != null && mNewUserNameEditText != null && mCreateUserButton != null) {
            initUsersListView();
            initNewUserCreationCallbacks();
        }

        return fragmentView;
    }

    private void initUsersListView() {
        List<User> users = mUserUtils.getUsersList();

        UserAdapter adapter = new UserAdapter(getActivity().getApplicationContext(), users);
        mUsersListView.setAdapter(adapter);
    }

    /**
     * This method defines callback associated to button. It creates a new user in the userList if name is not empty
     */
    private void initNewUserCreationCallbacks() {
        mCreateUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUserName = mNewUserNameEditText.getText().toString();
                if(!newUserName.isEmpty()) {
                    mUserUtils.createUser(new User(newUserName));
                    // Add users to list and refresh listview
                    Context context = getActivity().getApplicationContext();
                    CharSequence text = "Hello "+newUserName+"!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
