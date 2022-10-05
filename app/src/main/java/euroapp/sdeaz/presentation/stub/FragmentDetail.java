package euroapp.sdeaz.presentation.stub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import java.util.List;

import euroapp.sdeaz.databinding.FragmentDetailBinding;
import euroapp.sdeaz.domain.model.SportNew;

public class FragmentDetail extends Fragment {

    private static final String BUNDLE_UMG_URL = "img_url";
    private static final String BUNDLE_TITLE = "title";
    private static final String BUNDLE_DESCRIPTION = "description";


    public static FragmentDetail newInstance(SportNew sportNew) {

        Bundle args = new Bundle();

        args.putString(BUNDLE_UMG_URL, sportNew.getImgUrl());
        args.putString(BUNDLE_TITLE, sportNew.getTitle());
        args.putString(BUNDLE_DESCRIPTION, sportNew.getDescription());

        FragmentDetail fragment = new FragmentDetail();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        String imgUrl = FragmentDetailArgs.fromBundle(getArguments()).getImgurl();
        String title = FragmentDetailArgs.fromBundle(getArguments()).getTitle();
        String description = FragmentDetailArgs.fromBundle(getArguments()).getDescription();

        setValuesToViews(imgUrl, title, description);
        binding.back.setOnClickListener(onBackClickListener);
        super.onViewCreated(view, savedInstanceState);
    }

    FragmentDetailBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void setValuesToViews(String imgUrl, String title, String description) {
        Glide
                .with(this)
                .load(imgUrl)
                .centerCrop()
                .into(binding.imageView);

        binding.title.setText(title);
        binding.description.setText(description);
    }

    View.OnClickListener onBackClickListener = view -> requireActivity().onBackPressed();
}
