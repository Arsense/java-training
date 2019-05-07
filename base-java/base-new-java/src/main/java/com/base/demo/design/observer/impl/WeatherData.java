package com.base.demo.design.observer.impl;

import com.base.demo.design.observer.Observer;
import com.base.demo.design.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangwei
 * @date 2019/3/6 19:38
 */
public class WeatherData implements Subject {

    private List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    private float temperature;//温度
    private float humidity;//湿度
    private float pressure;//气压
    private List<Float> forecastTemperatures;//未来几天的温度


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
    public void setMeasurements(float temperature, float humidity,
                                float pressure, List<Float> forecastTemperatures) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        measurementsChanged();
    }



    /**
     * 温度发生了变化
     */
    public void measurementsChanged() {
        notifyObserver();
    }


    public List<Observer> getObservers() {
        return observers;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public List<Float> getForecastTemperatures() {
        return forecastTemperatures;
    }
}
