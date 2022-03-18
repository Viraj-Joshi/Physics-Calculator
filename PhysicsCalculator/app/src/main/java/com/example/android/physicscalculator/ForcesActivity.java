package com.example.android.physicscalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ForcesActivity extends Activity implements AdapterView.OnItemClickListener{
    private Bundle next;
    private ArrayList<String> num;
    private EditText acceleration,mass1,mass2,mew,angle,applied_force,weight;
    private Button b;
    private ListView listView;
    private PhysicsAdapter p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imagelist);

        num=new ArrayList<String>();
        ArrayList<Calculator> images = new ArrayList<Calculator>();
        //GetResourceId g = new GetResourceId();

        images.add(new Calculator(R.drawable.pushing_down_on_a_block_vertically));
        images.add(new Calculator(R.drawable.pulling_on_a_block_with_friction));
        images.add(new Calculator(R.drawable.pulling_on_a_block_at_a_downward_angle_with_friction));
        images.add(new Calculator(R.drawable.pulling_on_a_block_at_a_upward_angle_with_friction));
        images.add(new Calculator(R.drawable.block_on_incline_with_friction));
        images.add(new Calculator(R.drawable.pulling_on_a_block_parallel_to_and_up_the_incline_with_friction));
        images.add(new Calculator(R.drawable.pulling_on_a_block_at_a_angle_up_the_incline_with_friction));
        images.add(new Calculator(R.drawable.pulley_and_table_with_friction));
        images.add(new Calculator(R.drawable.atwood_pulley));
        images.add(new Calculator(R.drawable.block_on_a_table));

        p = new PhysicsAdapter(this,images);

        listView = (ListView) findViewById(R.id.sdfs);

        listView.setAdapter(p);
        listView.setOnItemClickListener(this);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view,  int position, long id) {
        long viewId=view.getId();
        if(viewId==R.id.list_item_icon){
            Toast.makeText(this,"Clicked Image",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"ListView Clicked: " + id, Toast.LENGTH_SHORT).show();
        }

        /*ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(R.drawable.pushing_down_on_a_block_vertically);
        ids.add(R.drawable.pulling_on_a_block_with_friction);
        ids.add(R.drawable.pulling_on_a_block_at_a_downward_angle_with_friction);
        ids.add(R.drawable.pulling_on_a_block_at_a_upward_angle_with_friction);
        ids.add(R.drawable.pulling_on_a_block_at_a_angle_up_the_incline_with_friction);
        ids.add(R.drawable.pulling_on_a_block_parallel_to_and_up_the_incline_with_friction);
        ids.add(R.drawable.pulling_on_a_block_at_a_angle_up_the_incline_with_friction);
        ids.add(R.drawable.pulley_and_table_with_friction);
        ids.add(R.drawable.atwood_pulley);
*/
       Log.v("Num0",Integer.toString(position));
       /* Log.v("Data2",Integer.toString(view.getId()));
        Log.v("data",Integer.toString(R.id.list_item_icon));
        Log.v("data1",Integer.toString(R.drawable.atwood_pulley));
*/
        switch(position){
            case 0:
                //Test: Toast.makeText(this,"pushing_down_on_a_block_vertically",Toast.LENGTH_SHORT).show();
                listView = (ListView) findViewById(R.id.sdfs);
        b=(Button) listView.findViewById(R.id.Submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View v1;
                Log.v("HI",Integer.toString(listView.getChildCount()));
                for (int i = 0; i < listView.getChildCount(); i++) {
                    v=listView.getChildAt(i);

                    //Log.v("data",acceleration.getText().toString());

                    acceleration=(EditText) v.findViewById(R.id.acceleration);
                    mass1=(EditText) v.findViewById(R.id.mass1);
                    mass2=(EditText) v.findViewById(R.id.mass2);
                    applied_force=(EditText) v.findViewById(R.id.applied_force);
                    mew=(EditText) v.findViewById(R.id.mew);
                    angle=(EditText) v.findViewById(R.id.Angle);
                    weight=(EditText) v.findViewById(R.id.weight);

                    //Log.v("data2",mass1.getText().toString());

                    //Adding to the arrayList
                    num.add(acceleration.getText().toString());
                    num.add(mass1.getText().toString());
                    num.add(mass2.getText().toString());
                    num.add(angle.getText().toString());
                    num.add(applied_force.getText().toString());
                    num.add(weight.getText().toString());
                    num.add(mew.getText().toString());
                }


                //Log.v("datac",num.get(0));
                //Log.v("datac2",num.get(1));

                //new activity
                Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                calc.putExtra("calcs_stuff",num);
                calc.putExtra("Pos",0);
                startActivity(calc);
                num.clear();
            }

        });
                break;
            case 1:
                //Test: Toast.makeText(this,"pushing_down_on_a_block_vertically",Toast.LENGTH_SHORT).show();
                listView = (ListView) findViewById(R.id.sdfs);
                b=(Button) listView.findViewById(R.id.Submit);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View v1;
                        Log.v("HI",Integer.toString(listView.getChildCount()));
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            v=listView.getChildAt(i);

                            //Log.v("data",acceleration.getText().toString());

                            acceleration=(EditText) v.findViewById(R.id.acceleration);
                            mass1=(EditText) v.findViewById(R.id.mass1);
                            mass2=(EditText) v.findViewById(R.id.mass2);
                            applied_force=(EditText) v.findViewById(R.id.applied_force);
                            mew=(EditText) v.findViewById(R.id.mew);
                            angle=(EditText) v.findViewById(R.id.Angle);
                            weight=(EditText) v.findViewById(R.id.weight);

                            //Log.v("data2",mass1.getText().toString());

                            //Adding to the arrayList
                            num.add(acceleration.getText().toString());
                            num.add(mass1.getText().toString());
                            num.add(mass2.getText().toString());
                            num.add(angle.getText().toString());
                            num.add(applied_force.getText().toString());
                            num.add(weight.getText().toString());
                            num.add(mew.getText().toString());
                        }


                        //Log.v("datac",num.get(0));
                        //Log.v("datac2",num.get(1));

                        //new activity
                        Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                        calc.putExtra("calcs_stuff",num);
                        calc.putExtra("Pos",1);
                        startActivity(calc);
                        num.clear();
                    }

                });
                break;
            case 2:
                //Test: Toast.makeText(this,"pushing_down_on_a_block_vertically",Toast.LENGTH_SHORT).show();
                listView = (ListView) findViewById(R.id.sdfs);
                b=(Button) listView.findViewById(R.id.Submit);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View v1;
                        Log.v("HI",Integer.toString(listView.getChildCount()));
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            v=listView.getChildAt(i);

                            //Log.v("data",acceleration.getText().toString());

                            acceleration=(EditText) v.findViewById(R.id.acceleration);
                            mass1=(EditText) v.findViewById(R.id.mass1);
                            mass2=(EditText) v.findViewById(R.id.mass2);
                            applied_force=(EditText) v.findViewById(R.id.applied_force);
                            mew=(EditText) v.findViewById(R.id.mew);
                            angle=(EditText) v.findViewById(R.id.Angle);
                            weight=(EditText) v.findViewById(R.id.weight);

                            //Log.v("data2",mass1.getText().toString());

                            //Adding to the arrayList
                            num.add(acceleration.getText().toString());
                            num.add(mass1.getText().toString());
                            num.add(mass2.getText().toString());
                            num.add(angle.getText().toString());
                            num.add(applied_force.getText().toString());
                            num.add(weight.getText().toString());
                            num.add(mew.getText().toString());
                        }


                        //Log.v("datac",num.get(0));
                        //Log.v("datac2",num.get(1));

                        //new activity
                        Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                        calc.putExtra("calcs_stuff",num);
                        calc.putExtra("Pos",2);
                        startActivity(calc);
                        num.clear();
                    }

                });
                break;
            case 4:
                b=(Button) listView.findViewById(R.id.Submit);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View v1;
                        Log.v("HI",Integer.toString(listView.getChildCount()));
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            v=listView.getChildAt(i);

                            //Log.v("data",acceleration.getText().toString());

                            acceleration=(EditText) v.findViewById(R.id.acceleration);
                            mass1=(EditText) v.findViewById(R.id.mass1);
                            mass2=(EditText) v.findViewById(R.id.mass2);
                            applied_force=(EditText) v.findViewById(R.id.applied_force);
                            mew=(EditText) v.findViewById(R.id.mew);
                            angle=(EditText) v.findViewById(R.id.Angle);
                            weight=(EditText) v.findViewById(R.id.weight);

                            //Log.v("data2",mass1.getText().toString());

                            //Adding to the arrayList
                            num.add(acceleration.getText().toString());
                            num.add(mass1.getText().toString());
                            num.add(mass2.getText().toString());
                            num.add(angle.getText().toString());
                            num.add(applied_force.getText().toString());
                            num.add(weight.getText().toString());
                            num.add(mew.getText().toString());
                        }

                        //Log.v("datac",num.get(0));
                        //Log.v("datac2",num.get(1));

                        //new activity
                        Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                        calc.putExtra("calcs_stuff",num);
                        calc.putExtra("Pos",4);
                        startActivity(calc);
                        num.clear();
                    }

                });
                break;
            case 7:
                b=(Button) listView.findViewById(R.id.Submit);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View v1;
                        Log.v("HI",Integer.toString(listView.getChildCount()));
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            v=listView.getChildAt(i);

                            //Log.v("data",acceleration.getText().toString());

                            acceleration=(EditText) v.findViewById(R.id.acceleration);
                            mass1=(EditText) v.findViewById(R.id.mass1);
                            mass2=(EditText) v.findViewById(R.id.mass2);
                            applied_force=(EditText) v.findViewById(R.id.applied_force);
                            mew=(EditText) v.findViewById(R.id.mew);
                            angle=(EditText) v.findViewById(R.id.Angle);
                            weight=(EditText) v.findViewById(R.id.weight);

                            //Log.v("data2",mass1.getText().toString());

                            //Adding to the arrayList
                            num.add(acceleration.getText().toString());
                            num.add(mass1.getText().toString());
                            num.add(mass2.getText().toString());
                            num.add(angle.getText().toString());
                            num.add(applied_force.getText().toString());
                            num.add(weight.getText().toString());
                            num.add(mew.getText().toString());
                        }


                        //Log.v("datac",num.get(0));
                        //Log.v("datac2",num.get(1));

                        //new activity
                        Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                        calc.putExtra("calcs_stuff",num);
                        calc.putExtra("Pos",7);
                        startActivity(calc);
                        num.clear();
                    }

                });
                break;
            case 8:
                b=(Button) listView.findViewById(R.id.Submit);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View v1;
                        Log.v("HI",Integer.toString(listView.getChildCount()));
                        for (int i = 0; i < listView.getChildCount(); i++) {
                            v=listView.getChildAt(i);

                            //Log.v("data",acceleration.getText().toString());

                            acceleration=(EditText) v.findViewById(R.id.acceleration);
                            mass1=(EditText) v.findViewById(R.id.mass1);
                            mass2=(EditText) v.findViewById(R.id.mass2);
                            applied_force=(EditText) v.findViewById(R.id.applied_force);
                            mew=(EditText) v.findViewById(R.id.mew);
                            angle=(EditText) v.findViewById(R.id.Angle);
                            weight=(EditText) v.findViewById(R.id.weight);

                            //Log.v("data2",mass1.getText().toString());

                            //Adding to the arrayList
                            num.add(acceleration.getText().toString());
                            num.add(mass1.getText().toString());
                            num.add(mass2.getText().toString());
                            num.add(angle.getText().toString());
                            num.add(applied_force.getText().toString());
                            num.add(weight.getText().toString());
                            num.add(mew.getText().toString());
                        }


                        //Log.v("datac",num.get(0));
                        //Log.v("datac2",num.get(1));

                        //new activity
                        Intent calc = new Intent(ForcesActivity.this,CalcReady.class);
                        calc.putExtra("calcs_stuff",num);
                        calc.putExtra("Pos",8);
                        startActivity(calc);
                        num.clear();
                    }

                });
                break;

        }




    }
   /* public int getID(String name) {
        int id = getResources().getIdentifier(name,"drawable",this.getPackageName());
        Log.v("ForcesActivity", Integer.toString(id));
        return id;
    }
*/

}
