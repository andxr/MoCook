package es.deusto.androidapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.firebase.auth.FirebaseUser;

import es.deusto.androidapp.fragments.CreatedRecipesFragment;
import es.deusto.androidapp.fragments.UserAccountFragment;

public class UserPagerAdapter extends FragmentStateAdapter {

    private static final int SIZE = 2;

    private FirebaseUser user;

    public UserPagerAdapter(Fragment fragment, FirebaseUser user){
        super(fragment);
        this.user = user;
    }

    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = UserAccountFragment.newInstance(user);
                break;
            default:
                fragment = CreatedRecipesFragment.newInstance(user);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return SIZE;
    }

}
