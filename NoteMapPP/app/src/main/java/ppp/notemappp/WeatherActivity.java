package ppp.notemappp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import ppp.notemappp.models.Main;


public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Button button = (Button) findViewById(R.id.return_button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(WeatherActivity.this, MapsActivity.class));
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        String lat = getIntent().getExtras().getString("lat");
        String lon = getIntent().getExtras().getString("long");
        if (lat.length() > 6) {
            lat = lat.substring(0 , 6);}
        if (lon.length() > 6) {
            lon = lon.substring(0 , 6);}
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=19272d3c444e0e204c5f2dfdfb13ccd2&units=metric&lang=fr";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(String response) {

                        Main main = new Gson().fromJson(response, Main.class);
                        TextView textView = (TextView) findViewById(R.id.realTemp);
                        textView.setText("Temperature :" + main.getMain().getTemp());
                        TextView textView2 = (TextView) findViewById(R.id.feelTemp);
                        textView2.setText("Feeled :" + main.getMain().getFeels_like());
                        TextView textView3 = (TextView) findViewById(R.id.pressure);
                        textView3.setText("Pressure :" + main.getMain().getPressure());
                        TextView textView4 = (TextView) findViewById(R.id.humidity);
                        textView4.setText("Humidity :" + main.getMain().getHumidity());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String json = new String(error.networkResponse.data);
                Log.e("volley", json);
            }
        });
        queue.add(stringRequest);
    }
}