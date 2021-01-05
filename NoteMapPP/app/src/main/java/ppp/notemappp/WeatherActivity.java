package ppp.notemappp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

        final TextView textView = (TextView) findViewById(R.id.testAPI);
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String lat = "48.8566";
        String lon = "2.3522";
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=19272d3c444e0e204c5f2dfdfb13ccd2&units=metric&lang=fr";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.e("volley", response.toString());

                        Main main = new Gson().fromJson(response, Main.class);
                        //System.out.println(main.getMain().getTemp());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String json = new String(error.networkResponse.data);

                Log.e("volley", json);
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}