package com.studio.nn.episode3.app;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.studio.nn.episode3.adapter.FriendsPostsAdapter;
import com.studio.nn.episode3.models.PostItem;

import java.util.ArrayList;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class ListFriendsFeedFragment extends Fragment {

    private static final String POSTS = "posts";
    public ArrayList<PostItem> posts;

    private FriendsPostsAdapter adapter;
    private ListView mListView;

    public ListFriendsFeedFragment() {
        // Required empty public constructor
    }

    public static ListFriendsFeedFragment newInstance(ArrayList<PostItem> posts) {
        ListFriendsFeedFragment fragment = new ListFriendsFeedFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("posts", posts);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            posts = getArguments().getParcelableArrayList("posts");
            if(posts == null || posts.size() == 0){
                for (int i = 0; i < 15; i++)
                    posts.add(new PostItem());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_friends_feed, container, false);
        if(adapter == null){
            adapter = new FriendsPostsAdapter(getActivity().getApplicationContext(), this.posts);
        }
        mListView = (ListView) view .findViewById(R.id.list_posts);
        mListView.setAdapter(adapter);
        return view;
    }

}
