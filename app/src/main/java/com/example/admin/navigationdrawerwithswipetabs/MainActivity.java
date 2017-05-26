package com.example.admin.navigationdrawerwithswipetabs;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.support.v4.app.FragmentManager;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Page02.OnFragmentInteractionListener,Page01.OnFragmentInteractionListener,Page03.OnFragmentInteractionListener,List_Donors.OnFragmentInteractionListener,Register.OnFragmentInteractionListener,Details.OnFragmentInteractionListener,Contact.OnFragmentInteractionListener,Help.OnFragmentInteractionListener,AboutUs.OnFragmentInteractionListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentmanager;
    FragmentTransaction fragmenttransaction;

    Handler handler = new Handler();
    Runnable refresh;


    FloatingActionButton btnRegister;
    boolean doubleBackToExitPressedOnce = false;  //to make double backpress

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        btnRegister = (FloatingActionButton)findViewById(R.id.btn_register);
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Register register = new Register();
//
//                fragmentmanager = getSupportFragmentManager();
//                fragmenttransaction = getSupportFragmentManager().beginTransaction();
//                fragmenttransaction.add(R.id.containerView,register);
//            }
//        });



        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        navigationView= (NavigationView) findViewById(R.id.slider);

        navigationView.setItemIconTintList(null);

        fragmentmanager= getSupportFragmentManager();
        fragmenttransaction= fragmentmanager.beginTransaction();
        fragmenttransaction.replace(R.id.containerView, new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {




            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawers();
                int id = item.getItemId();

                if (id == R.id.apos) {


//                    Toast.makeText(MainActivity.this, "apos", Toast.LENGTH_LONG).show();


                    Bundle apos_data = new Bundle();
                    apos_data.putString("clicked_id", "apos");
                    // set Fragmentclass Arguments
                        List_Donors list_donors = new List_Donors();
                        list_donors.setArguments(apos_data);


                        fragmentmanager = getSupportFragmentManager();
                        fragmenttransaction = getSupportFragmentManager().beginTransaction();

                        fragmenttransaction.replace(R.id.containerView, list_donors);
                        fragmenttransaction.commit();

                        refresh = new Runnable() {
                            public void run() {
                                // Do something
                                handler.postDelayed(refresh, 5000);
                            }
                        };


                    // Handle the camera action
                } else if (id == R.id.aneg) {

//                    Toast.makeText(MainActivity.this, "aneg", Toast.LENGTH_LONG).show();


                    Bundle aneg_data = new Bundle();
                    aneg_data.putString("clicked_id", "aneg");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(aneg_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                } else if (id == R.id.bpos) {

//                    Toast.makeText(MainActivity.this, "bpos", Toast.LENGTH_LONG).show();


                    Bundle bpos_data = new Bundle();
                    bpos_data.putString("clicked_id", "bpos");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(bpos_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                } else if (id == R.id.bneg) {
//                    Toast.makeText(MainActivity.this, "bneg", Toast.LENGTH_LONG).show();


                    Bundle bneg_data = new Bundle();
                    bneg_data.putString("clicked_id", "bneg");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(bneg_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };

                } else if (id == R.id.opos) {
//                    Toast.makeText(MainActivity.this, "opos", Toast.LENGTH_LONG).show();


                    Bundle opos = new Bundle();
                    opos.putString("clicked_id", "opos");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(opos);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };

                } else if (id == R.id.oneg) {
//                    Toast.makeText(MainActivity.this, "oneg", Toast.LENGTH_LONG).show();


                    Bundle oneg_data = new Bundle();
                    oneg_data.putString("clicked_id", "oneg");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(oneg_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };

                } else if (id == R.id.abpos) {
//                    Toast.makeText(MainActivity.this, "abpos", Toast.LENGTH_LONG).show();


                    Bundle abpos_data = new Bundle();
                    abpos_data.putString("clicked_id", "abpos");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(abpos_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };

                } else if (id == R.id.abneg) {
//                    Toast.makeText(MainActivity.this, "abneg", Toast.LENGTH_LONG).show();


                    Bundle abneg_data = new Bundle();
                    abneg_data.putString("clicked_id", "abneg");
                    // set Fragmentclass Arguments
                    List_Donors list_donors = new List_Donors();

                    list_donors.setArguments(abneg_data);
                    fragmentmanager = getSupportFragmentManager();

                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, list_donors);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };

                } else if (id == R.id.nav_home) {


                    TabFragment tabFragment = new TabFragment();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, tabFragment);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };
                }else if (id == R.id.nav_reg) {


                    Register register = new Register();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, register);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                }else if (id == R.id.contact) {


                    Contact contact = new Contact();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, contact);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                }else if (id == R.id.contact) {


                    Contact contact = new Contact();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, contact);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                }else if (id == R.id.help) {


                    Help help = new Help();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, help);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                }else if (id == R.id.developers) {


                    AboutUs aboutus = new AboutUs();

                    fragmentmanager = getSupportFragmentManager();
                    fragmenttransaction = getSupportFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.containerView, aboutus);

                    fragmenttransaction.commit();

                    refresh = new Runnable() {
                        public void run() {
                            // Do something
                            handler.postDelayed(refresh, 5000);
                        }
                    };


                }

                return true;
            }


            });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
            }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);



        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }
            MainActivity.this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            MainActivity.this.finish();

        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onFragmentInteraction(DonorModel bundle) {

        Details details = new Details().newInstance(bundle);
        fragmentmanager.beginTransaction().replace(R.id.containerView, details).commit();


    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
