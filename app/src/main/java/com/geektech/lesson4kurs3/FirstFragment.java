package com.geektech.lesson4kurs3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lesson4kurs3.databinding.FragmentFirstBinding;

import java.util.AbstractList;
import java.util.ArrayList;

public class FirstFragment extends Fragment implements OnItemClick{

    private FragmentFirstBinding binding;
    private ArrayList<Country> countryList = new ArrayList<>();
    private CountryAdapter countryAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentFirstBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();
        countryAdapter=new CountryAdapter(countryList,this);
        binding.rvCountry.setAdapter(countryAdapter);
        
    }

    private void loadData() {
        countryList.add(new Country("Kyrgyzstan","Bishkek","https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Flag_of_Kyrgyzstan.svg/383px-Flag_of_Kyrgyzstan.svg.png"));
        countryList.add(new Country("Kazakhstan","Astana","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Flag_of_Kazakhstan.svg/383px-Flag_of_Kazakhstan.svg.png"));
        countryList.add(new Country("USA","Washington",""));
        countryList.add(new Country("Great Britany","London",""));
        countryList.add(new Country("Russia","Moscow",""));
        countryList.add(new Country("Nigeria","Abuja",""));
        countryList.add(new Country("Kyrgyzstan","Bishkek",""));
        countryList.add(new Country("Kyrgyzstan","Bishkek",""));
        countryList.add(new Country("Kyrgyzstan","Bishkek",""));
        countryList.add(new Country("Kyrgyzstan","Bishkek",""));
        countryList.add(new Country("Kyrgyzstan","Bishkek",""));

    }

    @Override
    public void onClick(int position) {

       // Log.d("Ray", String.valueOf(position));
        Country country=countryList.get(position);
        //Log.d("Ray",country.getCapital()+country.getName()+country.getFlag());

        Bundle bundle=new Bundle();
        bundle.putSerializable("country",country);
        Fragment fragment=new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,
                fragment).addToBackStack(null).commit();
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }
}