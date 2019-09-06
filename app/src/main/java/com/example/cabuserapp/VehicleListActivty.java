package com.example.cabuserapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cabuserapp.Model.UserDatails;
import com.example.cabuserapp.Model.View_Recycler_Adapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class VehicleListActivty extends AppCompatActivity {
    private Modelclass carviewModel;
    private DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Modelclass, View_Recycler_Adapter> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Modelclass> options;
    RecyclerView recyclerView;
    Toolbar toolcarviewpage;


    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list_activty);

        recyclerView=findViewById(R.id.recyclercarview);
        toolcarviewpage=findViewById(R.id.toolcarviewpage);
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        setSupportActionBar(toolcarviewpage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String Id=user.getUid();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Admin");
        databaseReference.keepSynced(true);

        options= new FirebaseRecyclerOptions.Builder<Modelclass>().setQuery(databaseReference,Modelclass.class).build();


        firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Modelclass, View_Recycler_Adapter>(options) {

            @Override
            protected void onBindViewHolder(@NonNull View_Recycler_Adapter view_recycler_adapter, int i, @NonNull Modelclass modelclass) {
                final String Key=getRef(i).getKey();
                view_recycler_adapter.txtviewcarname.setText(String.valueOf(modelclass.getName()));
                view_recycler_adapter.txtviewcarmodel.setText(String.valueOf(modelclass.getModel()));


                Picasso.with(VehicleListActivty.this).load(modelclass.getImage()).into(view_recycler_adapter.Carviewimages);

                
                view_recycler_adapter.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(VehicleListActivty.this,DetailActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("key",Key);
                        intent.putExtras(bundle);

                        startActivity(intent);

                    }
                });

            }



            @NonNull
            @Override
            public View_Recycler_Adapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vehiclelist_recycler_item,parent,false);

                return new View_Recycler_Adapter(view);
            }
        };
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        firebaseRecyclerAdapter.startListening();
        recyclerView.setAdapter(firebaseRecyclerAdapter);



    }



    @Override
    protected void onStart() {
        super.onStart();
        if (firebaseRecyclerAdapter!=null){

            firebaseRecyclerAdapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.stopListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (firebaseRecyclerAdapter!=null){

            firebaseRecyclerAdapter.startListening();
        }
    }
}
