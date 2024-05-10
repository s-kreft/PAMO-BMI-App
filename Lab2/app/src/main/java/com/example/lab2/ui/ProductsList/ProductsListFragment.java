package com.example.lab2.ui.ProductsList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.R;
import com.example.lab2.databinding.ActivityMainBinding;
import com.example.lab2.databinding.FragmentRecipesBinding;
import com.example.lab2.products.Product;
import com.example.lab2.products.RecyclerAdapter;
import com.example.lab2.ui.Recipes.RecipesViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ProductsListFragment extends Fragment {
    private ArrayList<Product> productsList;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.listView);
        productsList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(productsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        productsList.add(new Product("Pomidor", false));
        productsList.add(new Product("Ogórek", false));
        productsList.add(new Product("Makaron", false));
    }

}
