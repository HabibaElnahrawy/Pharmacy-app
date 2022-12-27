package com.example.pharmacyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pharmacyapp.model.Category;
import com.example.pharmacyapp.model.Product;
import com.example.pharmacyapp.pre.pre;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pharmacyapp.databinding.MainNavBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class main_nav extends AppCompatActivity implements RecyclerViewInterface{

    private AppBarConfiguration mAppBarConfiguration;
    private MainNavBinding binding;


    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterCategory myAdaptercat;
    ArrayList<Category> cat_list;

    /*ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<Category>list;
    ArrayAdapter<Category>adapter;
    Category category;*/


   /* FirebaseDatabase database;
    DatabaseReference category;
    RecyclerView recycler_View;
    RecyclerView.LayoutManager layoutManager;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
///////////////////////////////////////////////////////////////
       /* category= new Category();
        listView=(ListView)findViewById(R.id.listView);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("category");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<Category>(this,R.layout.category_info,R.id.category_info,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren())
                {
                    category=ds.getValue(Category.class);
                    list.add(category);
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });*/


        recyclerView=findViewById(R.id.category_list);
        database= FirebaseDatabase.getInstance().getReference("category");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cat_list=new ArrayList<>();
        myAdaptercat=new MyAdapterCategory(this,cat_list,this);
        recyclerView.setAdapter(myAdaptercat);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //fetch all the data inside product node
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    Category cat=dataSnapshot.getValue(Category.class);
                    cat_list.add(cat);
                }
                myAdaptercat.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
////////////////////////////////////////////////////////
      /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0)
                {
                    //categ 1
                    startActivity(new Intent(main_nav.this,Products.class));
                }
                else if(i==1)
                {
                    //categ 2
                }
                else if(i==2)
                {
                    //categ 3
                }
                else if(i==3)
                {
                    //categ 4
                }
                else
                {

                }
            }
        });*/

        //////////////////////////////////////////////////////////
        setSupportActionBar(binding.appBarMainNav.toolbar);
        binding.appBarMainNav.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

            //ba5ali el name of the user yzharlo
          View header_view=navigationView.getHeaderView(0);
          TextView username=header_view.findViewById(R.id.username);
          username.setText(pre.currentOnlineUser.getName());
            //load menu
       /* recycler_View= (RecyclerView) findViewById(R.id.recycler_View);
        recycler_View.setHasFixedSize(true);
        layoutManager =new LinearLayoutManager(this);
        recycler_View.setLayoutManager(layoutManager);*/


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_nav, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_nav);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onItemClick(int position) {
        if (position == 0)
        {
            //categ 1
            startActivity(new Intent(main_nav.this,Products.class));
        }
        else if(position==1)
        {
            //categ 2
            startActivity(new Intent(main_nav.this,LoginMainActivity.class));
        }
        else if(position==2)
        {
            //categ 3
        }
        else if(position==3)
        {
            //categ 4
        }
        else
        {

        }
    }
}