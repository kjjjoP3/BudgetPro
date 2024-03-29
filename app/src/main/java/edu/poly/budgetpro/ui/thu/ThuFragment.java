package edu.poly.budgetpro.ui.thu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.poly.budgetpro.R;
import edu.poly.budgetpro.adapter.ChiViewPager2Adapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThuFragment extends Fragment {

    private ViewPager2 mVp;
    private TabLayout mTl;

    public ThuFragment() {
        // Required empty public constructor
    }


    public static ThuFragment newInstance(String param1, String param2) {
        ThuFragment fragment = new ThuFragment();

        return fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mVp = view.findViewById(R.id.viewPager2);
        mTl =  view.findViewById(R.id.tabLayout);

        ChiViewPager2Adapter adapter = new ChiViewPager2Adapter(getActivity());
        mVp.setAdapter(adapter);

        new TabLayoutMediator(mTl, mVp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Khoan Thu");
                    tab.setIcon(R.drawable.ic_menu_camera);
                }
                else {
                    tab.setText("Loai Khoan Thu");
                    tab.setIcon(R.drawable.ic_menu_camera);
                }
            }
        }).attach();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thu, container, false);
    }
}