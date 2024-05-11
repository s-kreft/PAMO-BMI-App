package com.example.lab2.ui.ProductsList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.Product;
import com.example.lab2.R;
import com.example.lab2.databinding.FragmentProductsListBinding;
import com.example.lab2.RecyclerAdapter;

import java.util.ArrayList;

public class ProductsListFragment extends Fragment {
    public RecyclerAdapter shoppingListAdapter;
    private FragmentProductsListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentProductsListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        shoppingListAdapter = new RecyclerAdapter(new ArrayList<>());
        shoppingListAdapter.addTodo(new Product("Ogórek", false));
        shoppingListAdapter.addTodo(new Product("Ogórek", false));
        shoppingListAdapter.addTodo(new Product("Ogórek", false));
        shoppingListAdapter.addTodo(new Product("Ogórek", false));
        RecyclerView rvTodoItems = (RecyclerView) root.findViewById(R.id.rvTodoItems);
        rvTodoItems.setAdapter(shoppingListAdapter);
        rvTodoItems.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));

        return root;
    }
}
