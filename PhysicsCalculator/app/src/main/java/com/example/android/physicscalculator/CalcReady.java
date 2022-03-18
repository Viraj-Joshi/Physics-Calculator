package com.example.android.physicscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CalcReady extends AppCompatActivity {
    private final double GRAVITY = 9.806605;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_ready);

        DecimalFormat dff=new DecimalFormat(".####");

        TextView a = (TextView) findViewById(R.id.problem_num);
        TextView acc = (TextView) findViewById(R.id.Acceleration);
        TextView Force_Normal = (TextView) findViewById(R.id.Normal_Force);
        TextView ForceApplied = (TextView) findViewById(R.id.FA);
        TextView mew = (TextView) findViewById(R.id.MEW);
        TextView FF = (TextView) findViewById(R.id.FF);
        TextView tension = (TextView) findViewById(R.id.Tension);
        TextView angle = (TextView) findViewById(R.id.angle);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //b.setText(bundle.getStringArrayList("calcs_stuff").toString());

        //Log.v("data",Integer.toString(R.id.list_item_icon));
        //Log.v("data1",Integer.toString(R.drawable.pushing_down_on_a_block_vertically));

        Log.v("Num After Submit",Integer.toString(bundle.getInt("Pos")));

        if(bundle.getInt("Pos")==0){
            a.setText(Integer.toString(bundle.getInt("Pos")));
            acc.setText("Normal Force in \"Pushing Down a Block Vertically\" is equal to m*g, in this case: "+ bundle.getStringArrayList("calcs_stuff").get(1) + " * 9.806605 = " + dff.format(Double.parseDouble(bundle.getStringArrayList("calcs_stuff").get(1))*GRAVITY));
        }

        if(bundle.getInt("Pos")==1){
            ArrayList<String> arr = bundle.getStringArrayList("calcs_stuff");
            if(weight(bundle)&&FF(bundle)) {
                if(FA(bundle)) {
                    acc.setText("The acceleration of the object is is equivalent to (Force Applied - F sub f)/Mass; in this case: (" + arr.get(4) + " - (" + arr.get(5) + " * " + arr.get(6) + "))/ " + arr.get(5) + "/9.806605 = " + dff.format((Double.parseDouble(arr.get(4)) - (Double.parseDouble(arr.get(5)) * Double.parseDouble(arr.get(6)))) / (Double.parseDouble(arr.get(5)) / GRAVITY)) + " m/s");
                    mew.setText("The coefficient of friction of a flat surface with friction on a object with weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equal to " + dff.format(Double.parseDouble(arr.get(4)) / Double.parseDouble(arr.get(5))));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case W: " + arr.get(5) + " Newtons");
                }
                else{
                    acc.setText("Acceleration is zero since the object is in equilibrium ");
                    mew.setText("Static Friction is " + arr.get(6)+ " and kinetic friction cannot be calculated");
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case W: " + arr.get(5) + " Newtons");
                }
                FF.setText("The force of friction equals the force applied. In this case: a object with a weight of " + arr.get(5) + " Newtons and coefficient of friction of " + arr.get(6) + " is equivalent to the following: F-sub f = F-sub N * mu; in this case-> " + arr.get(5) + " * " + arr.get(6) + " = " + dff.format(Double.parseDouble(arr.get(5)) * Double.parseDouble(arr.get(6))) + " Newtons");

            }
            else if(weight(bundle)){
                acc.setText("The acceleration of the object cannot be calculated without the kinetic coefficient of friction");
                mew.setText("The coefficient of static friction of a flat surface with friction on a object with weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equal to " + dff.format(Double.parseDouble(arr.get(4))/Double.parseDouble(arr.get(5))));
                Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case W: " + arr.get(5) + " Newtons" );
                FF.setText("The force of friction on a flat surface with friction on a object requires the coefficient of friction to be calculated");
            }
            else if(mass1(bundle)&&FF(bundle)) {
                if(FA(bundle)){
                    acc.setText("The acceleration of the object is is equivalent to (Force Applied - F sub f)/Mass; in this case: (" + arr.get(4) + " - (" + arr.get(1) + " * 9.806605 * " + arr.get(6) + "))/ " + arr.get(1) + " = " + dff.format((Double.parseDouble(arr.get(4)) - (Double.parseDouble(arr.get(1)) * GRAVITY * Double.parseDouble(arr.get(6)))) / (Double.parseDouble(arr.get(1)))) + " m/s");
                    mew.setText("The coefficient of static friction of a flat surface with friction on a object with mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equal to the F-sub f/F-sub N:  " + dff.format((Double.parseDouble(arr.get(4))) / (Double.parseDouble(arr.get(1)) * GRAVITY)));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case m * g: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " = " + dff.format(Double.parseDouble(arr.get(1)) * GRAVITY) + " Newtons");
                }
                else{
                    acc.setText("Acceleration is zero since the object is in equilibrium ");
                    mew.setText("Static Friction is " + arr.get(6)+ " and kinetic friction cannot be calculated");
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg  is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case m * g: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " = " + dff.format(Double.parseDouble(arr.get(1)) * GRAVITY) + " Newtons");
                }

                    FF.setText("The force of friction equals the force applied.In this case: an object with a mass of " + arr.get(1) + " kg and coefficient of friction of " + arr.get(6) + " is equivalent to the following: F-sub f = F-sub N * mu; in this case-> " + arr.get(1) + " * " + Double.toString(GRAVITY) + " * " + arr.get(6) + " = " + dff.format(Double.parseDouble(arr.get(1)) * GRAVITY * Double.parseDouble(arr.get(6))) + " Newtons");
            }
            else if(mass1(bundle)){
                acc.setText("The acceleration of the object cannot be calculated without the kinetic coefficient of friction");
                mew.setText("The coefficient of static friction of a flat surface with friction on a object with mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equal to the F-sub f/F-sub N:  " + dff.format((Double.parseDouble(arr.get(4)))/(Double.parseDouble(arr.get(1))*GRAVITY)));
                Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case m * g: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " = " + dff.format(Double.parseDouble(arr.get(1))*GRAVITY)+ " Newtons");
                FF.setText("The force of friction on a flat surface with friction on a object requires the coefficient of friction to be calculated");
            }
            else{
                acc.setText("The acceleration of the object cannot be calculated");
                mew.setText("The coefficient of friction on a flat surface with friction on a object requires weight/mass to be calculated");
                Force_Normal.setText("The Normal Force on a flat surface with friction on a object requires weight/masa to be calculated");
            }
        }

        if(bundle.getInt("Pos")==2){
            ArrayList<String> arr = bundle.getStringArrayList("calcs_stuff");
            if(weight(bundle)&&FF(bundle)) {
                if(FA(bundle)) {
                    acc.setText("The acceleration of the object is is equivalent to (Force Applied - F sub f)/Mass; in this case: (" + arr.get(4) + " - (" + arr.get(5) + " * " + arr.get(6) + "))/ " + arr.get(5) + "/9.806605 = " + dff.format((Double.parseDouble(arr.get(4)) - (Double.parseDouble(arr.get(5)) * Double.parseDouble(arr.get(6)))) / (Double.parseDouble(arr.get(5)) / GRAVITY)) + " m/s");
                    mew.setText("The coefficient of friction of a flat surface with friction on a object with weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equal to " + dff.format(Double.parseDouble(arr.get(4)) / Double.parseDouble(arr.get(5))));
                    Double Applied_Force = (Double.parseDouble(arr.get(6))*Double.parseDouble(arr.get(5)))/(Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))-Double.parseDouble(arr.get(6))*(Math.sin(Math.toRadians(Double.parseDouble(arr.get(3))))));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons is equivalent to the following: F-sub N = F-sub g(W) + F-sub A * sin(Theta); in this case: " + Double.toString(Applied_Force) + " * sin(" + arr.get(3) + ") + " + arr.get(5) + " = " +
                            dff.format((Double.parseDouble(arr.get(5))) + (Applied_Force*Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))))) + " Newtons");
                }
                else{
                    acc.setText("Acceleration is zero since the object is in equilibrium ");
                    mew.setText("Static Friction is " + arr.get(6)+ " and kinetic friction cannot be calculated");
                    Double Applied_Force = (Double.parseDouble(arr.get(6))*Double.parseDouble(arr.get(5)))/(Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))-Double.parseDouble(arr.get(6))*(Math.sin(Math.toRadians(Double.parseDouble(arr.get(3))))));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons is equivalent to the following: F-sub N = F-sub g(W) + F-sub A * sin(Theta); in this case: " + dff.format(Applied_Force) + " * sin(" + arr.get(3) + ") + " + arr.get(5) + " ) = " +
                            dff.format((Double.parseDouble(arr.get(5))) + (Applied_Force*Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))))) + " Newtons");
                    ForceApplied.setText("The force of friction equals the force applied.In this case: an object with a weight of " + arr.get(5) + " Newtons and a coefficient of friction of " + arr.get(6) + " is equivalent to the following: " +
                            dff.format((Double.parseDouble(arr.get(6))*Double.parseDouble(arr.get(5)))/(Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))-Double.parseDouble(arr.get(6))*(Math.sin(Math.toRadians(Double.parseDouble(arr.get(3))))))));
                }
                FF.setText("The force of friction equals the force applied. In this case: a object with a weight of " + arr.get(5) + " Newtons and coefficient of friction of " + arr.get(6) + " is equivalent to the following: F-sub f = F-sub N * mu; in this case-> " + arr.get(5) + " * " + arr.get(6) + " = " + dff.format(Double.parseDouble(arr.get(5)) * Double.parseDouble(arr.get(6))) + " Newtons");

            }
            else if(weight(bundle)){
                acc.setText("The acceleration of the object cannot be calculated without the kinetic coefficient of friction");
                mew.setText("The coefficient of static friction of a flat surface with friction on a object with weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equal to " + dff.format(Double.parseDouble(arr.get(4))/Double.parseDouble(arr.get(5))));
                Force_Normal.setText("Normal Force on a flat surface with friction on a object with a weight of " + arr.get(5) + " Newtons and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case W: " + arr.get(5) + " Newtons" );
                FF.setText("The force of friction on a flat surface with friction on a object requires the coefficient of friction to be calculated");
            }
            else if(mass1(bundle)&&FF(bundle)) {
                if(FA(bundle)){
                    acc.setText("The acceleration of the object is is equivalent to (Force Applied - F sub f)/Mass; in this case: (" + arr.get(4) + " - (" + arr.get(1) + " * 9.806605 * " + arr.get(6) + "))/ " + arr.get(1) + " = " + dff.format((Double.parseDouble(arr.get(4)) - (Double.parseDouble(arr.get(1)) * GRAVITY * Double.parseDouble(arr.get(6)))) / (Double.parseDouble(arr.get(1)))) + " m/s");
                    mew.setText("The coefficient of static friction of a flat surface with friction on a object with mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equal to the F-sub f/F-sub N:  " + dff.format((Double.parseDouble(arr.get(4))) / (Double.parseDouble(arr.get(1)) * GRAVITY)));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg and Force Applied Downwards of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g + F-sub A * sin(Theta) for this object" + "; in this case: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " + " + arr.get(4) + " * sin(" +arr.get(3) + ")" +
                            dff.format((Double.parseDouble(arr.get(1)) * GRAVITY) + (Double.parseDouble(arr.get(4))*Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))))) + " Newtons");
                }
                else{
                    acc.setText("Acceleration is zero since the object is in equilibrium ");
                    mew.setText("Static Friction is " + arr.get(6)+ " and kinetic friction cannot be calculated");
                    //Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg is equivalent to the following: F-sub N = F-sub g + F-sub A * sin(Theta) for this object" + "; in this case: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " + " + arr.get(4) + " * sin(" +arr.get(3) + ")" +
                            //dff.format((Double.parseDouble(arr.get(1)) * GRAVITY) + (Double.parseDouble(arr.get(4))*Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))))) + " Newtons");
                    Double Applied_Force = (Double.parseDouble(arr.get(6))*Double.parseDouble(arr.get(1))*GRAVITY)/(Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))-Double.parseDouble(arr.get(6))*(Math.sin(Math.toRadians(Double.parseDouble(arr.get(3))))));
                    Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg is equivalent to the following: F-sub N = F-sub g + F-sub A * sin(Theta); in this case: " + dff.format(Applied_Force) + " * sin(" + arr.get(3) + ") + ( " + arr.get(1) + " * " + Double.toString(GRAVITY) + " ) = " +
                            dff.format((Double.parseDouble(arr.get(1)) * GRAVITY) + (Applied_Force*Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))))) + " Newtons");
                    ForceApplied.setText("The force of friction equals the force applied.In this case: an object with a mass of " + arr.get(1) + " kg and coefficient of friction of " + arr.get(6) + " is equivalent to the following: " +
                            dff.format((Double.parseDouble(arr.get(6))*Double.parseDouble(arr.get(1))*GRAVITY)/(Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))-Double.parseDouble(arr.get(6))*(Math.sin(Math.toRadians(Double.parseDouble(arr.get(3))))))));
                }


            }
            else if(mass1(bundle)){
                acc.setText("The acceleration of the object cannot be calculated without the kinetic coefficient of friction");
                mew.setText("The coefficient of static friction of a flat surface with friction on a object with mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equal to the F-sub f/F-sub N:  " + dff.format((Double.parseDouble(arr.get(4)))/(Double.parseDouble(arr.get(1))*GRAVITY)));
                Force_Normal.setText("Normal Force on a flat surface with friction on a object with a mass of " + arr.get(1) + " kg and Force Applied of " + arr.get(4) + " Newtons is equivalent to the following: F-sub N = F-sub g for a object in equilibrium on a flat surface" + "; in this case m * g: " + arr.get(1) + " * " + Double.toString(GRAVITY) + " = " + dff.format(Double.parseDouble(arr.get(1))*GRAVITY)+ " Newtons");
                FF.setText("The force of friction on a flat surface with friction on a object requires the coefficient of friction to be calculated");
            }
            else{
                acc.setText("The acceleration of the object cannot be calculated");
                mew.setText("The coefficient of friction on a flat surface with friction on a object requires weight/mass to be calculated");
                Force_Normal.setText("The Normal Force on a flat surface with friction on a object requires weight/masa to be calculated");
            }
        }

        if(bundle.getInt("Pos")==4) {
            a.setText(Integer.toString(bundle.getInt("Pos")));
            ArrayList<String> arr = bundle.getStringArrayList("calcs_stuff");

            if (mass1(bundle)&&MEW(bundle)) {
                Force_Normal.setText("Normal Force is equivalent to m*g*cos(Theta),in this case: " + arr.get(1) + " * " + GRAVITY +" * cos(" + arr.get(3) + ") = " +  dff.format(Double.parseDouble(arr.get(1))*GRAVITY*Math.cos(Math.toRadians(Double.parseDouble(arr.get(3))))) + " Newtons");
                acc.setText("acceleration of the block is equivalent to : " +GRAVITY+" * sin("+arr.get(3)+") - " +arr.get(6) + " * 9.806605 * cos(" + arr.get(3) + ") = " + dff.format(GRAVITY * Math.sin(Math.toRadians(Double.parseDouble(arr.get(3)))) - (Double.parseDouble(arr.get(6)) * GRAVITY * Math.cos(Math.toRadians(Double.parseDouble(arr.get(6)))))) + " m/s");
            }
            else if((MEW(bundle)&&!mass1(bundle)&&!angle(bundle))||(!angle(bundle)&&MEW(bundle)&&mass1(bundle))){
                    angle.setText("The maximum angle in which the object does not slip at a coefficient of friction of "+ arr.get(6) + " is "+dff.format(Math.toDegrees(Math.atan(Double.parseDouble(arr.get(6))))) + " degrees,being derived from the equations Fnet=0;Fnet=m*g*sin(theta)-F-sub f-> 0=m*g*sin(theta)-mu(m*g*cos(theta))->g*sin(theta)=mu*g*cos(theta)->and solving for mu: mu=tan(theta)");
            }
            else
            {
                Force_Normal.setText("Normal Force is equivalent to m*g*cos(Theta); however in this case you must go back and enter a mass for this calculation!");
            }
        }

        if(bundle.getInt("Pos")==7) {
            a.setText(Integer.toString(bundle.getInt("Pos")));
            ArrayList<String> arr = bundle.getStringArrayList("calcs_stuff");
            if (!MEW(bundle)&&mass1(bundle)&&mass2(bundle)) {
                mew.setText("The system where m1 = " + arr.get(1) + " and m2 = " + arr.get(2) + " will not start above a coefficient of friction of " + dff.format(Double.parseDouble(arr.get(2)) / Double.parseDouble(arr.get(1))) + ". This is derived from Fnet=0;Fnet = T - (F-subf) - T + m2*g -> 0 = m2*g - mu(m1*g)-> mu = (m2 * g)/(m1 * g)");
            }
        }
        if(bundle.getInt("Pos")==8){
            a.setText(Integer.toString(bundle.getInt("Pos")));
            ArrayList<String> arr = bundle.getStringArrayList("calcs_stuff");
            if(mass1(bundle)&&mass2(bundle)){
                if(Double.parseDouble(arr.get(1))<Double.parseDouble(arr.get(2))){
                    acc.setText("The acceleration of the system where m1 = " + arr.get(1) + " kg and m2 = " + arr.get(2) + " kg is derived from the equations: Fnet = m*a;Fnet = T - m1*g - T + m2*g -> a = (m2*g - m1*g)/m where m is the total mass of the system excluding the pulley and rope: " +
                            dff.format(((Double.parseDouble(arr.get(2))*GRAVITY)-(Double.parseDouble(arr.get(1))*GRAVITY))/(Double.parseDouble(arr.get(1))+Double.parseDouble(arr.get(2)))) + " m/s");
                    Double acceleration1 = ((Double.parseDouble(arr.get(2))*GRAVITY)-(Double.parseDouble(arr.get(1))*GRAVITY))/(Double.parseDouble(arr.get(1))+Double.parseDouble(arr.get(2)));
                    tension.setText("The tension in the string with m1= " + arr.get(1)+ "and m2=" + arr.get(2) + "will be the same number using either of these equations: T=m1*a + m1*g or  T= m2*g - m2*a. In this case: " + dff.format((Double.parseDouble(arr.get(1))*acceleration1)+(Double.parseDouble(arr.get(1))*GRAVITY)) + " Newtons");
                }
            }
        }
        /*if(bundle.getInt("Pos")==4){
            b.setText("Acceleration of the block is: "+ dff.format(Math.tan(Math.toRadians(Double.parseDouble(bundle.getStringArrayList("calcs_stuff").get(3))))*9.8));
        }
*/
    }


    public boolean mass1(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(1).equals(""))
            return false;
        return true;
    }
    public boolean mass2(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(2).equals(""))
            return false;
        return true;
    }
    public boolean weight(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(5).equals(""))
            return false;
        return true;
    }
    public boolean FF(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(6).equals(""))
            return false;
        return true;
    }
    public boolean FA(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(4).equals(""))
            return false;
        return true;
    }
    public boolean MEW(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(6).equals(""))
            return false;
        return true;
    }
    public boolean angle(Bundle b){
        if(b.getStringArrayList("calcs_stuff").get(3).equals(""))
            return false;
        return true;
    }

}
