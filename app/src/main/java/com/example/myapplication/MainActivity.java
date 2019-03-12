package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.weather_10, "수원", "18도"));
        weatherList.add(new Weather(R.drawable.weather_03, "안양", "18도"));
        weatherList.add(new Weather(R.drawable.weather_05, "서울", "18도"));
        weatherList.add(new Weather(R.drawable.weather_04, "부산", "18도"));
        weatherList.add(new Weather(R.drawable.weather_08, "광주", "18도"));
        weatherList.add(new Weather(R.drawable.weather_08, "대전", "18도"));
        weatherList.add(new Weather(R.drawable.weather_09, "평양", "18도"));
        weatherList.add(new Weather(R.drawable.weather_10, "제주", "18도"));
        weatherList.add(new Weather(R.drawable.weather_10, "도쿄", "18도"));

        // 어댑터
        WeatherRecyclerAdapter adapter = new WeatherRecyclerAdapter();
        adapter.addItems(weatherList);

        //
        RecyclerView recyclerView = findViewById(R.id.weatherList);

        recyclerView.setAdapter(adapter);
    }


    private static class WeatherRecyclerAdapter extends RecyclerView
            .Adapter<WeatherRecyclerAdapter.WeatherViewHolder> {

        private List<Weather> mItems = new ArrayList<>();

        @NonNull
        @Override
        public WeatherViewHolder onCreateViewHolder(
                @NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater
                    .from(viewGroup.getContext())
                    .inflate(R.layout.item_weather, viewGroup, false);
            return new WeatherViewHolder(view);
        }

        @Override
        public void onBindViewHolder(
                @NonNull WeatherViewHolder weatherViewHolder, int i) {
            Weather weather = mItems.get(i);

            weatherViewHolder.weatherImageView
                    .setImageResource(weather.getImageRes());
            weatherViewHolder.cityTextView.setText(weather.getCity());
            weatherViewHolder.tempTextView.setText(weather.getTemp());
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public void addItems(List<Weather> items) {
            mItems.addAll(items);
        }

        public static class WeatherViewHolder extends RecyclerView.ViewHolder {
            public ImageView weatherImageView;
            public TextView cityTextView;
            public TextView tempTextView;

            public WeatherViewHolder(View view) {
                super(view);

                weatherImageView = view.findViewById(R.id.weatherImageView);
                cityTextView = view.findViewById(R.id.cityTextView);
                tempTextView = view.findViewById(R.id.tempTextView);
            }
        }
    }
}
