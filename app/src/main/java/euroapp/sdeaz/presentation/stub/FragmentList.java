package euroapp.sdeaz.presentation.stub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import euroapp.sdeaz.App;
import euroapp.sdeaz.R;
import euroapp.sdeaz.databinding.FragmentListBinding;
import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.presentation.stub.viewmodel.StubViewModel;
import euroapp.sdeaz.presentation.stub.viewmodel.StubViewModelFactory;
import euroapp.sdeaz.presentation.utils.VerticalSpaceItemDecoration;

public class FragmentList extends Fragment implements OnRecyclerViewItemClick{

    public static FragmentList newInstance() {

        Bundle args = new Bundle();

        FragmentList fragment = new FragmentList();
        fragment.setArguments(args);
        return fragment;
    }

    StubViewModel viewModel;
    RecyclerViewAdapter adapter;

    FragmentListBinding binding;

    @Inject
    StubViewModelFactory factory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ((App) requireContext().getApplicationContext()).getComponent().inject(this);

        viewModel = new ViewModelProvider(this, factory).get(StubViewModel.class);

        return  view;
    }

    void initRecyclerView(){
        adapter = new RecyclerViewAdapter(requireContext(),new ArrayList<>(), this);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(24));
    }


    void setListeners(){
        viewModel.sportNews.observe(getViewLifecycleOwner(), newsObserver);
        viewModel.loading.observe(getViewLifecycleOwner(), loadingObserver);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewModel.getNews();
        setListeners();
        initRecyclerView();
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

    @Override
    public void onClick(SportNew sportNew) {
        FragmentListDirections.ActionFragmentListToFragmentDetail action = FragmentListDirections.actionFragmentListToFragmentDetail();
        action.setImgurl(sportNew.getImgUrl());
        action.setTitle(sportNew.getTitle());
        action.setDescription(sportNew.getDescription());
        Navigation.findNavController(requireView()).navigate(action);
    }
}
