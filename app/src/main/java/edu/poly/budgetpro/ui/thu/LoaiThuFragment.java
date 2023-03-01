package edu.poly.budgetpro.ui.thu;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.poly.budgetpro.R;
import edu.poly.budgetpro.adapter.LoaiThuRecyclerviewAdapter;
import edu.poly.budgetpro.entity.LoaiThu;

public class LoaiThuFragment extends Fragment {
    private RecyclerView mRv;
    private LoaiThuRecyclerviewAdapter mAdapter;
    private LoaiThuViewModel mViewModel;

    public static LoaiThuFragment newInstance() {
        return new LoaiThuFragment();
    }

    public LoaiThuViewModel getViewModel(){
        return mViewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loai_thu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = view.findViewById(R.id.recyclerView);
        mAdapter = new LoaiThuRecyclerviewAdapter(getActivity());
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiThuViewModel.class);
        mViewModel.getAllLoaiThu().observe(getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu> loaiThus) {
                mAdapter.setList(loaiThus);
            }
        });
    }
}