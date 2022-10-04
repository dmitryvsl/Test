package com.example.test.presentation.stub;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.test.App;
import com.example.test.databinding.ActivityStubBinding;
import com.example.test.domain.model.SportNew;
import com.example.test.presentation.stub.viewmodel.StubViewModel;
import com.example.test.presentation.stub.viewmodel.StubViewModelFactory;
import com.example.test.presentation.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StubActivity extends AppCompatActivity {

    ActivityStubBinding binding;
    StubViewModel viewModel;
    RecyclerViewAdapter adapter;

    @Inject
    StubViewModelFactory factory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((App) getApplicationContext()).getComponent().inject(this);

        viewModel = new ViewModelProvider(this, factory).get(StubViewModel.class);
        viewModel.getNews();

        setListeners();
        initRecyclerView();
    }

    void initRecyclerView(){
        adapter = new RecyclerViewAdapter(this, new ArrayList<>());

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(24));
    }


    void setListeners(){
        viewModel.sportNews.observe(this, newsObserver);
        viewModel.loading.observe(this, loadingObserver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
        viewModel.cancelCalls();
    }

    Observer<List<SportNew>> newsObserver = sportNews -> {
        if (sportNews != null){
            adapter.setItems(sportNews);
        }
    };

    Observer<Boolean> loadingObserver = new Observer<Boolean>() {
        @Override
        public void onChanged(Boolean isLoading) {
            if (isLoading){
                binding.recyclerView.setVisibility(View.GONE);
                binding.progressCircular.setVisibility(View.VISIBLE);
            }
            else{
                binding.progressCircular.setVisibility(View.GONE);
                binding.recyclerView.setVisibility(View.VISIBLE);
            }
        }
    };
}

