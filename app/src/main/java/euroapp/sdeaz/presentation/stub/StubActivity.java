package euroapp.sdeaz.presentation.stub;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.navigation.NavigationView;

import euroapp.sdeaz.App;
import euroapp.sdeaz.R;
import euroapp.sdeaz.databinding.ActivityStubBinding;
import euroapp.sdeaz.domain.model.SportNew;
import euroapp.sdeaz.presentation.stub.viewmodel.StubViewModel;
import euroapp.sdeaz.presentation.stub.viewmodel.StubViewModelFactory;
import euroapp.sdeaz.presentation.utils.VerticalSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StubActivity extends AppCompatActivity {

    ActivityStubBinding binding;

    private static final String TAG_FRAGMENT_LIST = "fragment_list";
    private static final String TAG_FRAGMENT_DETAIL = "fragment_list";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStubBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }





}

